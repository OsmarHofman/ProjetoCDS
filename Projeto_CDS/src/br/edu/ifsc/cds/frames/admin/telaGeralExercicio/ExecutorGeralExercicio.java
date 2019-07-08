package br.edu.ifsc.cds.frames.admin.telaGeralExercicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Exercicio;

/**
 * Executora da tela geral de {@link Exercicio} vizualizada pelo {@link Admin}.
 */
public class ExecutorGeralExercicio extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GeralExercicio.fxml"));
			Scene scene = new Scene(root, 437, 610);
			scene.getStylesheets().add(getClass().getResource("GeralExercicio.css").toExternalForm());
			primaryStage.setScene(scene);
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
