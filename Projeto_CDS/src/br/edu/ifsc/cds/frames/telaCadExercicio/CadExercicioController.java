package br.edu.ifsc.cds.frames.telaCadExercicio;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class CadExercicioController implements Initializable {

	@FXML
	private JFXButton btnVoltar;

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
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
