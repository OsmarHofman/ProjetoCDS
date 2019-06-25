package br.edu.ifsc.cds.frames.telaCadRotina;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DTO.RefeicaoDTO;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaCadRefeicao.ExecutorCadRefeicao;
import br.edu.ifsc.cds.frames.telaExercicio.ExecutorTelaExercicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadRotinaController implements Initializable {

	private static List<RefeicaoDTO> listaRefeicao;

	public static List<RefeicaoDTO> getListaRefeicao() {
		return listaRefeicao;
	}

	public static void setListaRefeicao(List<RefeicaoDTO> listaRefeicao) {
		CadRotinaController.listaRefeicao = listaRefeicao;
	}

	public static void addListaRefeicao(RefeicaoDTO refeicao) {
		CadRotinaController.listaRefeicao.add(refeicao);
	}

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnCadastrar;

	@FXML
	private JFXButton btnAddRef;

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
	 * @param Clique no bot�o
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente.fechaBotao(btnVoltar);
	}

	@FXML
	void addEx(ActionEvent event) {
		ControleComponente.fechaBotao(btnAddRef);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Refei��o");
		ExecutorTelaExercicio exeCadExercicio = new ExecutorTelaExercicio();
		exeCadExercicio.start(stage);
	}

	@FXML
	void addRef(ActionEvent event) {
		ControleComponente.fechaBotao(btnAddRef);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Refei��o");
		ExecutorCadRefeicao exeHistorico = new ExecutorCadRefeicao();
		exeHistorico.start(stage);
	}

	@FXML
	void excRef(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// desabilita alguns botoes que s� tem a��es que dependem de outros campos e
		// a��es
		listaRefeicao = new ArrayList<RefeicaoDTO>();
	}

}
