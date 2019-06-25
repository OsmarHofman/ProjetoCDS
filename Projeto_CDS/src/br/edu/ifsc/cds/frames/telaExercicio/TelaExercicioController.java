package br.edu.ifsc.cds.frames.telaExercicio;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.DTO.AlimentoDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaExercicioController implements Initializable {

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
	private ChoiceBox<String> boxDiaSemana;

	@FXML
	private ChoiceBox<String> boxExercicios;

	@FXML
	private JFXButton btnOK;

	@FXML
	void confirmaExercicio(ActionEvent event) {
		Exercicio exe = new Exercicio();
		boxExercicios.setItems(exe.geraListaExercicio());
	}

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

}
