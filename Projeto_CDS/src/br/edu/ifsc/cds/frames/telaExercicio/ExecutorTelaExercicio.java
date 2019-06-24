package br.edu.ifsc.cds.frames.telaExercicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExecutorTelaExercicio extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaExercicio.fxml"));
		Scene scene = new Scene(root, 680, 697);
		scene.getStylesheets().add(getClass().getResource("TelaExercicio.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	} 

}
