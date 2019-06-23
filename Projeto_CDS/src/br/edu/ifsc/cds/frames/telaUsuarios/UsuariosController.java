package br.edu.ifsc.cds.frames.telaUsuarios;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.frames.telaCadAlimento.ExecutorCadAlimento;
import br.edu.ifsc.cds.frames.telaCadExercicio.ExecutorCadExercicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UsuariosController implements Initializable {

	@FXML
	private JFXButton btnAlimentos;

	@FXML
	void mostraExercicios(ActionEvent event) {
		ExecutorCadExercicio exeCadExercicio = new ExecutorCadExercicio();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeCadExercicio.start(stage);
	}

	@FXML
	void mostraAlimentos(ActionEvent event) {
		ExecutorCadAlimento exeCadAlimento = new ExecutorCadAlimento();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeCadAlimento.start(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
