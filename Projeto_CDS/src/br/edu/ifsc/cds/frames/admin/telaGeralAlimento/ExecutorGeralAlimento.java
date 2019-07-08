package br.edu.ifsc.cds.frames.admin.telaGeralAlimento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import br.edu.ifsc.cds.classes.domain.Admin;

/**
 * Executor da tela Geral de Alimentos vizualizada pelo {@link Admin}
 */
public class ExecutorGeralAlimento extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GeralAlimento.fxml"));
			Scene scene = new Scene(root, 905, 610);
			scene.getStylesheets().add(getClass().getResource("GeralAlimento.css").toExternalForm());
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
