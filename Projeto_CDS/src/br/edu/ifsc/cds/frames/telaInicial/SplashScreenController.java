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
 * This class contains the SplashScreen of the Application
 *
 */
public class SplashScreenController extends StackPane {

	private Logger logger = Logger.getLogger(getClass().getName());

	/**
	 * The Window of the Splash Screen
	 */
	Stage window = new Stage();

	/**
	 * Constructor.
	 */
	public SplashScreenController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreenController.fxml"));
		loader.setController(this);
		loader.setRoot(this);

		try {
			loader.load();
		} catch (IOException ex) {
			logger.log(Level.SEVERE, "", ex);
		}

		// Window
		window.setTitle("Splash Screen");
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(new Scene(this));

	}

	/**
	 * Shows the window of the SplashScreen
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
