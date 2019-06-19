package br.edu.ifsc.cds.frames.telaHistorico;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HistoricoController implements Initializable {

	@FXML
	private JFXButton btnExercicios;

	@FXML
	private TableColumn<?, ?> tituloRotina;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private TableColumn<?, ?> tituloRotina1;

	@FXML
	private Pane pnlOverview;

	@FXML
	private TableView<?> tbvRotina;

	@FXML
	private JFXButton btnaddRotina;

	@FXML
	private JFXButton btnRotinas;

	@FXML
	private JFXButton btnHistorico;

	@FXML
	void voltarTela(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnaddRotina.setDisable(true);
	}

}
