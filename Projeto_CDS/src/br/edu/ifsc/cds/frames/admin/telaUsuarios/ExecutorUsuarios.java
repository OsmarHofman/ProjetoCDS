package br.edu.ifsc.cds.frames.admin.telaUsuarios;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Executor da tela geral de {@link Pessoa} do sistema vizualidas pelo {@link Admin}.
 */
public class ExecutorUsuarios extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Usuarios.fxml"));
			Scene scene = new Scene(root, 914, 546);
			scene.getStylesheets().add(getClass().getResource("Usuarios.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
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
