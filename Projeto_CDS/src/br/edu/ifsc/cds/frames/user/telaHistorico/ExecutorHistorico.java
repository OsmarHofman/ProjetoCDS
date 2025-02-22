package br.edu.ifsc.cds.frames.user.telaHistorico;

import br.edu.ifsc.cds.classes.domain.Rotina;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Executora da tela de historico da {@link Rotina}.
 */
public class ExecutorHistorico extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Historico.fxml"));
			Scene scene = new Scene(root, 746, 553);
			scene.getStylesheets().add(getClass().getResource("Historico.css").toExternalForm());
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