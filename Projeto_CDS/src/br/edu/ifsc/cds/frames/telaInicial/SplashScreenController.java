package br.edu.ifsc.cds.frames.telaInicial;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Essa classe é a Tela Inicial (Splash Screen)
 *
 */
public class SplashScreenController extends StackPane {

	private Logger logger = Logger.getLogger(getClass().getName());

	/**
	 * A Janela
	 */
	Stage window = new Stage();

	public SplashScreenController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreenController.fxml"));
		loader.setController(this);
		loader.setRoot(this);

		try {
			loader.load();
		} catch (IOException ex) {
			logger.log(Level.SEVERE, "", ex);
		}

		// Altera o titulo da Janela e a coloca na cena
		window.setTitle("CDS");
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(new Scene(this));

	}

	/**
	 * mostra a janela na Tela Inicial
	 */
	public void showWindow() {
		window.show();
	}

	public void hideWindow() {
		window.hide();
	}

	public static double getScreenWidth() {
		return Screen.getPrimary().getBounds().getWidth();
	}

	public static double getVisualScreenHeight() {
		return Screen.getPrimary().getVisualBounds().getHeight();
	}

}
