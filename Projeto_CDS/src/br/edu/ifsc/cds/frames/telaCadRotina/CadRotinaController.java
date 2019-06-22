package br.edu.ifsc.cds.frames.telaCadRotina;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class CadRotinaController implements Initializable {

	@FXML
	private JFXButton btnCancelar;

	@FXML
	private JFXButton btnCadastrar;

	@FXML
	private JFXButton btnEditRef;

	@FXML
	private JFXButton btnExcRef;

	@FXML
	private JFXButton btnEditEx;

	@FXML
	private JFXButton btnExcEx;

	@FXML
	void cadastrar(ActionEvent event) {

	}

	@FXML
	void cancelar(ActionEvent event) {
		Stage telaAtual = (Stage) btnCancelar.getScene().getWindow();
		telaAtual.close();
	}

	@FXML
	void addEx(ActionEvent event) {

	}

	@FXML
	void editEx(ActionEvent event) {

	}

	@FXML
	void excEx(ActionEvent event) {

	}

	@FXML
	void editRef(ActionEvent event) {

	}

	@FXML
	void addRef(ActionEvent event) {

	}

	@FXML
	void excRef(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCadastrar.setDisable(true);
		btnEditRef.setDisable(true);
		btnExcRef.setDisable(true);
		btnEditEx.setDisable(true);
		btnExcEx.setDisable(true);
	}

}
