package br.edu.ifsc.cds.frames.telaRotina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecutorRotina extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("TelaRotina.fxml"));
			primaryStage.setMaximized(true);
			primaryStage.setTitle("CDS - Controle de Dieta e Saúde");
			Scene scene = new Scene(root, 1045, 500);
			scene.getStylesheets().add(getClass().getResource("layoutRotina.css").toExternalForm());
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
