package br.edu.ifsc.cds.frames.telaAlimento.telaMeusAlimentos;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MeusAlimentosController implements Initializable{

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnexcluirAlimento;

	@FXML
	private JFXButton btneditarAlimento;

	@FXML
	private Pane pnlOverview;

	@FXML
	private JFXButton btnaddAlimento;

	@FXML
	void voltar(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		btnaddAlimento.setDisable(true);
	}

}
