package br.edu.ifsc.cds.frames.user.telaCadRotina;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.user.telaCadExercicio.ExecutorTelaCadExercicio;
import br.edu.ifsc.cds.frames.user.telaCadRefeicao.ExecutorCadRefeicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadRotinaController implements Initializable {

	ControleComponente controle = new ControleComponente();

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnAddRef;

	@FXML
	private JFXButton btnAddEx;

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
		controle.fechaBotao(btnVoltar);
	}

	/**
	 * Abre a tela de Cadastro de Exercício e fecha a tela atual
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void addEx(ActionEvent event) {
		// fecha a tela
		controle.fechaBotao(btnAddEx);

		// cria uma estrutura da tela
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Refeição");

		// inicia uma nova tela de Exercicio
		ExecutorTelaCadExercicio exeCadExercicio = new ExecutorTelaCadExercicio();
		exeCadExercicio.start(stage);
	}

	/**
	 * Abre a tela de Cadastro de Refeicao e fecha a tela atual
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void addRef(ActionEvent event) {

		// fecha a tela
		controle.fechaBotao(btnVoltar);

		// cria uma estrutura da tela
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Refeição");

		// inicia uma nova tela de Exercicio
		ExecutorCadRefeicao exeHistorico = new ExecutorCadRefeicao();
		exeHistorico.start(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
