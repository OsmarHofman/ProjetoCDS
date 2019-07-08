package br.edu.ifsc.cds.frames.user.telaCadRefeicao;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Executor da tela de cadastro de refeições da {@link Pessoa}.
 * @author luana
 *
 */
public class ExecutorCadRefeicao extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CadRefeicao.fxml"));
			Scene scene = new Scene(root, 680, 753);
			scene.getStylesheets().add(getClass().getResource("CadRefeicao.css").toExternalForm());
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
