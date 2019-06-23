package br.edu.ifsc.cds.frames.telaCadAlimento;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CadAlimentoController {

	@FXML
	private JFXButton btnVoltar;

	@FXML
	void voltar(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

}
