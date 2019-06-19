package br.edu.ifsc.cds.frames.telaRotina;

import br.edu.ifsc.cds.frames.telaExercicio.ExecutorExercicio;
import br.edu.ifsc.cds.frames.telaHistorico.ExecutorHistorico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorRotina {

	@FXML
	private Button BtnNovoAlimento;

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

}
