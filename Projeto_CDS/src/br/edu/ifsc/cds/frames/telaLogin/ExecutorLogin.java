package br.edu.ifsc.cds.frames.telaLogin;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ExecutorLogin extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root, 880, 440);
			scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			// confirmação para sair da tela
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					int op = JOptionPane.showConfirmDialog(null, "            Deseja sair?");
					fechar(op, we);
					EntityMagerFactorySingleton.emf.close();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void fechar(int op, WindowEvent we) {
		if (op == 1 || op == 2) {
			we.consume();
		} else {
			EntityMagerFactorySingleton.closeFactory();
		}
	}

}
