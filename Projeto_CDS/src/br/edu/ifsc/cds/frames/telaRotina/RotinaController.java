package br.edu.ifsc.cds.frames.telaRotina;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.frames.telaDados.ExecutorDados;
import br.edu.ifsc.cds.frames.telaExercicio.ExecutorExercicio;
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
		this.pessoa = pessoa;
	}

	@FXML
    private JFXButton btnVoltar;
	
	@FXML
	private JFXButton btnDados;

	@FXML
	private Button BtnNovoAlimento;

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
		ExecutorExercicio exeExercicio = new ExecutorExercicio();
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
