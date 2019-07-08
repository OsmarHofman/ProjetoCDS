package br.edu.ifsc.cds.frames.admin.telaCadExercicio;

import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *Executor da tela Cadastro de {@link Exercicio} do {@link Admin}
 */
public class ExecutorCadExercicio extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CadExercicio.fxml"));
			Scene scene = new Scene(root, 378, 516);
			scene.getStylesheets().add(getClass().getResource("CadExercicio.css").toExternalForm());
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
