package br.edu.ifsc.cds.frames.telaRotina;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.frames.telaAlimento.telaMeusAlimentos.ExecutorMeusAlimentos;
import br.edu.ifsc.cds.frames.telaCadExercicio.ExecutorCadExercicio;
import br.edu.ifsc.cds.frames.telaDados.ExecutorDados;
import br.edu.ifsc.cds.frames.telaExercicio.telaMeusExercicios.ExecutorMeusExercicios;
import br.edu.ifsc.cds.frames.telaHistorico.ExecutorHistorico;
import br.edu.ifsc.cds.frames.telaLogin.ExecutorLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RotinaController implements Initializable {

	public static Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		RotinaController.pessoa = pessoa;
	}

	@FXML
	private JFXButton btnAlimentos;

	@FXML
	private JFXButton btnRefeicoes;

	@FXML
	private JFXButton btnExercicios;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnDados;

	@FXML
	private Button BtnNovoAlimento;

	@FXML
	void mostraExercicios(ActionEvent event) throws Exception {
		ExecutorMeusExercicios exe = new ExecutorMeusExercicios();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exe.start(stage);
	}

	@FXML
	void mostraRefeicoes(ActionEvent event) {

	}

	@FXML
	void mostraAlimentos(ActionEvent event) {
		ExecutorMeusAlimentos ali = new ExecutorMeusAlimentos();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		ali.start(stage);
	}

	@FXML
	void mostraDados(ActionEvent event) {
		ExecutorDados exeDados = new ExecutorDados();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeDados.start(stage);
	}

	@FXML
	void mostraHistorico(ActionEvent event) {
		ExecutorHistorico exeHistorico = new ExecutorHistorico();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeHistorico.start(stage);
	}

	@FXML
	public void novoAlimento(ActionEvent event) {
		ExecutorCadExercicio exeExercicio = new ExecutorCadExercicio();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeExercicio.start(stage);
	}

	@FXML
	void voltar(ActionEvent event) {
		ExecutorLogin login = new ExecutorLogin();
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
		Stage novaTela = new Stage();
		login.start(novaTela);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
