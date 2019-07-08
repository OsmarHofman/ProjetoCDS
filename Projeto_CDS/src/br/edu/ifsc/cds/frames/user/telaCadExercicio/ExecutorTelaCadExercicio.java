package br.edu.ifsc.cds.frames.user.telaCadExercicio;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Executor da tela de cadstro de exercicios pelo {@link Pessoa}.
 */
public class ExecutorTelaCadExercicio extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaCadExercicio.fxml"));
			Scene scene = new Scene(root, 680, 437);
			scene.getStylesheets().add(getClass().getResource("TelaCadExercicio.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
