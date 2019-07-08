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
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.domain.Horario;
import br.edu.ifsc.cds.classes.security.ControleComponente;
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

/**
 * Controller da tela de cadastro de refeições do {@link Pessoa}.
 */
public class CadRefeicaoController implements Initializable {

	private String uniMed = "";

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
	 * @param event Clique do botão
	 */
	@FXML
	void salvarRefeicao(ActionEvent event) {
		// pega os dados da interface gráfica
		String titulo = txtTitulo.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = new Date();
		Date horarioFim = new Date();
		try {
			horarioInicio = sdf.parse(txtInicio.getText());
			horarioFim = sdf.parse(txtFim.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Data Inválida");
		}
		String diaSemana = boxDiaSemana.getValue();

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
		RefeicaoDTO dto = new RefeicaoDTO(titulo, nomesAlimentos, uniMed, quantidades, horarioInicio, horarioFim,
				diaSemana, caloria);

		// Verifica se o horário pretendido está disponível
		Horario horario = new Horario();
		if (horario.verificaRefeicaoHorario(horarioInicio, horarioFim, diaSemana)) {
			RotinaController.addListaRefeicao(dto);
			JOptionPane.showMessageDialog(null, "Refeição Cadastrada com sucesso");
			ControleComponente controle = new ControleComponente();
			controle.fechaBotao(btnSalvar);
		} else {
			JOptionPane.showMessageDialog(null, "Data de Inicio/Fim inválido(s)");
		}

	}

	/**
	 * Adiciona o Alimento na tabela para visualização
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void confirmaPorcao(ActionEvent event) {
		// pega os dados dos campos da tela
		String nomeAlimento = boxAlimentos.getValue();
		Float quantidade = Float.parseFloat(txtQtd.getText());
		RadioButton botao = (RadioButton) opcoes.getSelectedToggle();
		String unidadeMedida = botao.getText();
		this.uniMed = uniMed + unidadeMedida + "\n";

		// a partir dos dados, gera um AlimentoDTO que então adiciona na tabela
		AlimentoDTO dto = new AlimentoDTO().geraAlimentoDTO(nomeAlimento, quantidade, unidadeMedida);
		tbvAlimento.getItems().add(dto);

	}

	/**
	 * Fecha a tela atual e abre a tela de Cadastro de Rotina novamente
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		// fecha a tela
		controle.fechaBotao(btnVoltar);
	}

	/**
	 * Inicializa os dias da semana e os alimentos nas {@link ChoiceBox}
	 * respectivas. Além disso também cria e ajusta as células da tabela para o tipo
	 * de dados que irão mostrar
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boxDiaSemana.getItems().add("Segunda-Feira");
		boxDiaSemana.getItems().add("Terça-Feira");
		boxDiaSemana.getItems().add("Quarta-Feira");
		boxDiaSemana.getItems().add("Quinta-Feira");
		boxDiaSemana.getItems().add("Sexta-Feira");
		boxDiaSemana.getItems().add("Sábado");
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
