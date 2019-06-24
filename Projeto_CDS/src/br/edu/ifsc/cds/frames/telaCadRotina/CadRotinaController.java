package br.edu.ifsc.cds.frames.telaCadRotina;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaCadRefeicao.ExecutorCadRefeicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadRotinaController implements Initializable {

	@FXML
	private JFXButton btnVoltar;

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

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente.fechaBotao(btnVoltar);
	}

	@FXML
	void addEx(ActionEvent event) {
//		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL);
//		stage.setResizable(false);
//		stage.setTitle("CDS - Refeição");
//		ExecutorCadExercicio exeCadExercicio = new ExecutorCadExercicio();
//		exeCadExercicio.start(stage);
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
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Refeição");
		ExecutorCadRefeicao exeHistorico = new ExecutorCadRefeicao();
		exeHistorico.start(stage);
	}

	@FXML
	void excRef(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// desabilita alguns botoes que só tem ações que dependem de outros campos e
		// ações
		btnCadastrar.setDisable(true);
		btnEditRef.setDisable(true);
		btnExcRef.setDisable(true);
		btnEditEx.setDisable(true);
		btnExcEx.setDisable(true);
	}

}
