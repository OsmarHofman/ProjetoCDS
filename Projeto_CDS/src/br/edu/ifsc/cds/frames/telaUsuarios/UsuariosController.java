package br.edu.ifsc.cds.frames.telaUsuarios;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.frames.telaCadAlimento.ExecutorCadAlimento;
import br.edu.ifsc.cds.frames.telaCadExercicio.ExecutorCadExercicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UsuariosController implements Initializable {

	public static Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		UsuariosController.admin = admin;
	}

	@FXML
	private JFXButton btnAlimentos;

	@FXML
	void mostraExercicios(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro de Exercícios");
		ExecutorCadExercicio exeCadExercicio = new ExecutorCadExercicio();
		exeCadExercicio.start(stage);
	}

	@FXML
	void mostraAlimentos(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro de Alimentos");
		ExecutorCadAlimento exeCadAlimento = new ExecutorCadAlimento();
		exeCadAlimento.start(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
