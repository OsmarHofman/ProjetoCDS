package br.edu.ifsc.cds.frames.user.telaDados;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Executora da tela de dados pessoais do {@link Pessoa}
 */
public class ExecutorDados extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dados.fxml"));
			Scene scene = new Scene(root, 340, 518);
			scene.getStylesheets().add(getClass().getResource("Dados.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}