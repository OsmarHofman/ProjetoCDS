package br.edu.ifsc.cds.frames.telaCadRefeicao;

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
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaCadRotina.CadRotinaController;
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
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnOK;

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
	void salvarRefeicao(ActionEvent event) throws ParseException {
		String titulo = txtTitulo.getText();
		List<String> nomesAlimentos = new ArrayList<>();
		float caloria = 0;
		for (AlimentoDTO alimentoDTO : tbvAlimento.getItems()) {
			nomesAlimentos.add(alimentoDTO.getNome());
			caloria = caloria + alimentoDTO.getCalorias();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = sdf.parse(txtInicio.getText());
		Date horarioFim = sdf.parse(txtFim.getText());
		RefeicaoDTO dto = new RefeicaoDTO(titulo, nomesAlimentos, caloria, horarioInicio, horarioFim);
		CadRotinaController.addListaRefeicao(dto);
		JOptionPane.showMessageDialog(null, "Refeição Cadastrada com sucesso");
		ControleComponente.fechaBotao(btnSalvar);
	}

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
