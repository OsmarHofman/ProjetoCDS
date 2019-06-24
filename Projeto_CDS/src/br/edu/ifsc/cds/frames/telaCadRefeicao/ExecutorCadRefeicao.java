package br.edu.ifsc.cds.frames.telaCadRefeicao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExecutorCadRefeicao extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CadRefeicao.fxml"));
			Scene scene = new Scene(root, 748, 607);
			scene.getStylesheets().add(getClass().getResource("CadRefeicao.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
