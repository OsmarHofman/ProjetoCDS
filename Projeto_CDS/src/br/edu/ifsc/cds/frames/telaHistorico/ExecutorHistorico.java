package br.edu.ifsc.cds.frames.telaHistorico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExecutorHistorico extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Historico.fxml"));
			Scene scene = new Scene(root, 928, 553);
			scene.getStylesheets().add(getClass().getResource("Historico.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//C:\Users\luana\git\ProjetoCDS\Projeto_CDS\src\br\edu\ifsc\cds\frames\telaHistorico

	public static void main(String[] args) {
		launch(args);
	}
}