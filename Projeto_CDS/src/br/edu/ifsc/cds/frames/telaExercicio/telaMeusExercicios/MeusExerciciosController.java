package br.edu.ifsc.cds.frames.telaExercicio.telaMeusExercicios;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MeusExerciciosController implements Initializable {

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnExcluirExercicio;

	@FXML
	private JFXButton btneditarExercicio;

	@FXML
	private Pane pnlOverview;

	@FXML
	private JFXButton btnaddExercicio;

	@FXML
	void voltar(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		btnaddExercicio.setDisable(true);
	}

}
