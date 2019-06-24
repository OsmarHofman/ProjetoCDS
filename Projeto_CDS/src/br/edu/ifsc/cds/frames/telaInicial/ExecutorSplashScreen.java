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
	 * Esta tela ser� utilizada como uma tela inicial e desaparecer� depois de 4
	 * segundos
	 */
	SplashScreenController splashScreen = new SplashScreenController();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CDS");
		splashScreen.showWindow();
		PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(4));
		// ir� iniciar o entity manager, para otimizar as outras opera��es no banco
		EntityManager em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		em.close();
		// ap�s o delay de 4 segundos, ir� chamar a tela de login
		splashScreenDelay.setOnFinished(f -> {
			splashScreen.hideWindow();
			ExecutorLogin telaRotina = new ExecutorLogin();
			Stage novaTela = new Stage();
			novaTela.setTitle("CDS");
			telaRotina.start(novaTela);
		});
		splashScreenDelay.playFromStart();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
