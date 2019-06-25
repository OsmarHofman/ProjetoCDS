package br.edu.ifsc.cds.frames.user.telaCadExercicio;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.DTO.AlimentoDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.user.telaCadRotina.ExecutorCadRotina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadExercicioController implements Initializable {

	@FXML
	private TableColumn<AlimentoDTO, String> colNome;

	@FXML
	private TableColumn<AlimentoDTO, Float> colCaloria;

	@FXML
	private TableColumn<AlimentoDTO, Integer> colId;

	@FXML
	private TableColumn<AlimentoDTO, Date> colInicio;

	@FXML
	private TableColumn<AlimentoDTO, Date> colFim;

	@FXML
	private TableView<String> tbvExercicio;

	@FXML
	private ChoiceBox<String> boxDiaSemana;

	@FXML
	private ChoiceBox<String> boxExercicios;

	@FXML
	private JFXButton btnOK;

	@FXML
	private JFXButton btnVoltar;

	/**
	 * Adiciona o Alimento na tabela para visualização
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void confirmaExercicio(ActionEvent event) {
		Exercicio exe = new Exercicio();
		tbvExercicio.setItems(exe.geraListaExercicio());
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
		colInicio.setCellValueFactory(new PropertyValueFactory<>("PeriodoInicio"));
		colFim.setCellValueFactory(new PropertyValueFactory<>("PeriodoFim"));

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
