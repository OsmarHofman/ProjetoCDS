package br.edu.ifsc.cds.frames.user.telaCadExercicio;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.DTO.ExercicioDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.domain.Horario;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.user.telaCadRotina.ExecutorCadRotina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadExercicioController implements Initializable {

	@FXML
	private JFXButton btnSalvarExercicio;

	@FXML
	private TableColumn<ExercicioDTO, String> colNome;

	@FXML
	private TableColumn<ExercicioDTO, Float> colCaloria;

	@FXML
	private TableColumn<ExercicioDTO, Integer> colId;

	@FXML
	private TableColumn<ExercicioDTO, Date> colInicio;

	@FXML
	private TableColumn<ExercicioDTO, Date> colFim;

	@FXML
	private TableView<ExercicioDTO> tbvExercicio;

	@FXML
	private ChoiceBox<String> boxDiaSemana;

	@FXML
	private ChoiceBox<String> boxExercicios;

	@FXML
	private JFXButton btnOK;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private TextField txtInicio;

	@FXML
	private TextField txtFim;

	/**
	 * A partir dos campos na tela, converte e cria um objeto {@link ExercicioDTO}
	 * para inserir na lista de Exercicios da Rotina
	 * 
	 * @param event Clique do botão
	 * @throws ParseException
	 */

	@FXML
	void salvarExercicio(ActionEvent event) throws ParseException {
		String nomeExercicios = boxExercicios.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = sdf.parse(txtInicio.getText());
		Date horarioFim = sdf.parse(txtFim.getText());
		String diaSemana = boxDiaSemana.getValue();
		float gastocalorias = 0;
		Integer id = 0;
		for (ExercicioDTO exer : tbvExercicio.getItems()) {
			gastocalorias = exer.getCalorias();
			id = Integer.parseInt(tbvExercicio.getId());
		}

		ExercicioDTO dt = new ExercicioDTO(id, nomeExercicios, gastocalorias, horarioInicio, horarioFim);
		Horario horario = new Horario();
		if (horario.verificaRefeicaoHorario(horarioInicio, horarioFim, diaSemana)) {
			// RotinaController.addListaExercicio(dt);
			JOptionPane.showMessageDialog(null, "Exercicio Cadastrado com sucesso");
			ControleComponente controle = new ControleComponente();
			controle.fechaBotao(btnSalvarExercicio);
		} else {
			JOptionPane.showMessageDialog(null, "Data de Inicio/Fim inválido(s)");
		}

	}

	/**
	 * Adiciona o Exercicio na tabela para visualização
	 * 
	 * @param event Clique do Botão
	 * @throws ParseException
	 */
	@FXML
	void confirmaExercicio(ActionEvent event) throws ParseException {
		String nome = boxExercicios.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = sdf.parse(txtInicio.getText());
		Date horarioFim = sdf.parse(txtFim.getText());
		ExercicioDTO dt = new ExercicioDTO().geraExercicioDTO(nome, horarioInicio, horarioFim);
		tbvExercicio.getItems().add(dt);
	}

	/**
	 * Inicializa os dias da semana e os exercicios nas {@link ChoiceBox}
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

		ExercicioDAO dao = new ExercicioDAO();
		List<Exercicio> exercicios = dao.retrieveAll();
		List<String> exerciciosNome = new ArrayList<>();
		for (Exercicio alimentoLista : exercicios) {
			exerciciosNome.add(alimentoLista.getNome());
		}
		ObservableList<String> lista = FXCollections.observableArrayList(exerciciosNome);
		boxExercicios.setItems(lista);

		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colCaloria.setCellValueFactory(new PropertyValueFactory<>("Calorias"));
		colInicio.setCellValueFactory(new PropertyValueFactory<>("Inicio"));
		colFim.setCellValueFactory(new PropertyValueFactory<>("Fim"));

		// formata a coluna do Inicio, para a data ficar com o formato "HH:mm"
		colInicio.setCellFactory((TableColumn<ExercicioDTO, Date> column) -> {
			return new TableCell<ExercicioDTO, Date>() {
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						setText(sdf.format((item)));
					}
				}
			};
		});

		// formata a coluna do Fim, para a data ficar com o formato "HH:mm"
		colFim.setCellFactory((TableColumn<ExercicioDTO, Date> column) -> {
			return new TableCell<ExercicioDTO, Date>() {
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						setText(sdf.format((item)));
					}
				}
			};
		});

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

		// cria uma estrutura da tela
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Rotina");

		// inicia uma nova tela de Cadastro
		ExecutorCadRotina exeCadRotina = new ExecutorCadRotina();
		exeCadRotina.start(stage);
	}

}
