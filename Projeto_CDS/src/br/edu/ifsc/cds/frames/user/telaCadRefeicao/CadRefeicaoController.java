package br.edu.ifsc.cds.frames.user.telaCadRefeicao;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.DTO.AlimentoDTO;
import br.edu.ifsc.cds.DTO.RefeicaoDTO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.Horario;
import br.edu.ifsc.cds.classes.domain.Refeicao;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.user.telaCadRotina.ExecutorCadRotina;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadRefeicaoController implements Initializable {

	@FXML
	private TextField txtQtd;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnOK;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private TextField txtTitulo;

	@FXML
	private TableView<AlimentoDTO> tbvAlimento;

	@FXML
	private TableColumn<AlimentoDTO, String> colNome;

	@FXML
	private TableColumn<AlimentoDTO, Float> colCaloria;

	@FXML
	private TableColumn<AlimentoDTO, Integer> colId;

	@FXML
	private TableColumn<AlimentoDTO, Float> colQtd;

	@FXML
	private TextField txtInicio;

	@FXML
	private TextField txtFim;

	@FXML
	private ToggleGroup opcoes;

	@FXML
	private ChoiceBox<String> boxDiaSemana;

	@FXML
	private ChoiceBox<String> boxAlimentos;

	/**
	 * A partir dos campos na tela, converte e cria um objeto {@link RefeicaoDTO}
	 * para inserir na lista de Refeicoes da Rotina
	 * 
	 * @param event Clique do bot�o
	 */
	@FXML
	void salvarRefeicao(ActionEvent event) throws ParseException {
		// pega os dados da interface gr�fica
		String titulo = txtTitulo.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = sdf.parse(txtInicio.getText());
		Date horarioFim = sdf.parse(txtFim.getText());
		String diaSemana = boxDiaSemana.getValue();
		String quantidade = txtQtd.getText();
		RadioButton radioButton = (RadioButton) opcoes.getSelectedToggle();
		String unidadeMedida = radioButton.getText();

		// Gera os campos nome do alimento, caloria e quantidade de cada alimento
		String nomesAlimentos = "";
		String quantidades = "";
		float caloria = 0;
		for (AlimentoDTO alimentoDTO : tbvAlimento.getItems()) {
			nomesAlimentos = nomesAlimentos + alimentoDTO.getNome() + "\n";
			caloria = caloria + alimentoDTO.getCalorias();
			quantidades = quantidades + String.valueOf(alimentoDTO.getQuantidade()) + "\n";
		}

		// Cria uma refeicaoDTO
		RefeicaoDTO dto = new RefeicaoDTO(titulo, nomesAlimentos, quantidades, horarioInicio, horarioFim, diaSemana,
				caloria);

		// Verifica se o hor�rio pretendido est� dispon�vel
		Horario horario = new Horario();
		if (horario.verificaRefeicaoHorario(horarioInicio, horarioFim, diaSemana)) {
			Horario horarioRefeicao = new Horario(null, horarioInicio, horarioFim, diaSemana);
			List<Refeicao> refeicaoPessoa = RotinaController.getPessoa().getRotina().getListaRefeicao();
			refeicaoPessoa.add(new Refeicao(null, titulo, null, horarioRefeicao));
			JOptionPane.showMessageDialog(null, "Refei��o Cadastrada com sucesso");
			ControleComponente controle = new ControleComponente();
			controle.fechaBotao(btnSalvar);
		} else {
			JOptionPane.showMessageDialog(null, "Data de Inicio/Fim inv�lido(s)");
		}

	}

	/**
	 * Adiciona o Alimento na tabela para visualiza��o
	 * 
	 * @param event Clique do Bot�o
	 */
	@FXML
	void confirmaPorcao(ActionEvent event) {
		// pega os dados dos campos da tela
		String nomeAlimento = boxAlimentos.getValue();
		Float quantidade = Float.parseFloat(txtQtd.getText());
		RadioButton botao = (RadioButton) opcoes.getSelectedToggle();
		String unidadeMedida = botao.getText();
		// a partir dos dados, gera um AlimentoDTO que ent�o adiciona na tabela
		AlimentoDTO dto = new AlimentoDTO().geraAlimentoDTO(nomeAlimento, quantidade, unidadeMedida);
		tbvAlimento.getItems().add(dto);

	}

	/**
	 * Fecha a tela atual e abre a tela de Cadastro de Rotina novamente
	 * 
	 * @param event Clique do Bot�o
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		// fecha a tela
		controle.fechaBotao(btnVoltar);

		// cria uma estrutura da tela
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Rotina");

		// inicia uma nova tela de Cadastro
		ExecutorCadRotina exeCadRotina = new ExecutorCadRotina();
		exeCadRotina.start(stage);
	}

	/**
	 * Inicializa os dias da semana e os alimentos nas {@link ChoiceBox}
	 * respectivas. Al�m disso tamb�m cria e ajusta as c�lulas da tabela para o tipo
	 * de dados que ir�o mostrar
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boxDiaSemana.getItems().add("Segunda-Feira");
		boxDiaSemana.getItems().add("Ter�a-Feira");
		boxDiaSemana.getItems().add("Quarta-Feira");
		boxDiaSemana.getItems().add("Quinta-Feira");
		boxDiaSemana.getItems().add("Sexta-Feira");
		boxDiaSemana.getItems().add("S�bado");
		boxDiaSemana.getItems().add("Domingo");

		AlimentoDAO dao = new AlimentoDAO();
		List<Alimento> alimentos = dao.retrieveAll();
		List<String> alimentoNome = new ArrayList<>();
		for (Alimento alimentoLista : alimentos) {
			alimentoNome.add(alimentoLista.getNome());
		}
		ObservableList<String> lista = FXCollections.observableArrayList(alimentoNome);
		boxAlimentos.setItems(lista);

		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colCaloria.setCellValueFactory(new PropertyValueFactory<>("Calorias"));
		colQtd.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));

	}

}
