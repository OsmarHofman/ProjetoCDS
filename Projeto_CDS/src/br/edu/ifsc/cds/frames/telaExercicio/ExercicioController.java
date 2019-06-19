package br.edu.ifsc.cds.frames.telaExercicio;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ExercicioController implements Initializable {

	@FXML
	private JFXButton btnVoltar;

	@FXML
	void cancelar(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
