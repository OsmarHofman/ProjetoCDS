package br.edu.ifsc.cds.frames.user.telaRotina;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.classes.security.ControleComponente;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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

			// confirmação para sair da tela
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					int op = JOptionPane.showConfirmDialog(null, "            Deseja sair?");
					ControleComponente controle = new ControleComponente();
					controle.fechaJanela(op, we);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
