package br.edu.ifsc.cds.frames.telarotina;

import br.edu.ifsc.cds.frames.telaExercicio.ExecutorExercicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorRotina {

	@FXML
	private Button BtnNovoAlimento;

	@FXML
	public void novoAlimento(ActionEvent event) {
		ExecutorExercicio exeExercicio = new ExecutorExercicio();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		exeExercicio.start(stage);
	}

}
