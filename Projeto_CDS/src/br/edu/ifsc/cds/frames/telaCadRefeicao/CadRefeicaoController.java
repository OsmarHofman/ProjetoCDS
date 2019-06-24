package br.edu.ifsc.cds.frames.telaCadRefeicao;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.DTO.AlimentoDTO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadRefeicaoController implements Initializable {

	@FXML
	private TextField txtQtd;

	@FXML
	private JFXButton btnOK;

	@FXML
	private TableView<AlimentoDTO> tbvAlimento;

	@FXML
	private TableColumn<AlimentoDTO, String> colNome;

	@FXML
	private TableColumn<AlimentoDTO, Float> colCaloria;

	@FXML
	private TableColumn<AlimentoDTO, Integer> colId;

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

	@FXML
	void confirmaPorcao(ActionEvent event) {
		AlimentoDTO dto = new AlimentoDTO();
		tbvAlimento.setItems(dto.geraListaAlimento());
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

	}

}
