package br.edu.ifsc.cds.frames.telaInicial;

import javax.persistence.EntityManager;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.frames.telaLogin.ExecutorLogin;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExecutorSplashScreen extends Application {

	/**
	 * This will be used as a splash screen for the application It will display some
	 * important data to the user and then disappear
	 */
	SplashScreenController spashScreen = new SplashScreenController();

	@Override
	public void start(Stage primaryStage) {
		spashScreen.showWindow();

		// I am using the code below so the Primary Stage of the application
		// doesn't appear for 2 seconds , so the splash screen is displayed
		PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(6));
		EntityManager em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		em.close();
		splashScreenDelay.setOnFinished(f -> {
			spashScreen.hideWindow();
			ExecutorLogin telaRotina = new ExecutorLogin();
			Stage novaTela = new Stage();
			telaRotina.start(novaTela);
		});
		splashScreenDelay.playFromStart();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
