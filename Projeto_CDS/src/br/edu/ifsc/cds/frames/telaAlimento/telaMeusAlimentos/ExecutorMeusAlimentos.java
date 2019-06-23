package br.edu.ifsc.cds.frames.telaAlimento.telaMeusAlimentos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExecutorMeusAlimentos extends Application{

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MeusAlimentos.fxml"));
			Scene scene = new Scene(root, 1130, 657);
			scene.getStylesheets().add(getClass().getResource("MeusAlimentos.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
}
