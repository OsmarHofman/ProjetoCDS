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
	 * Esta tela será utilizada como uma tela inicial e desaparecerá depois de 4
	 * segundos
	 */
	SplashScreenController splashScreen = new SplashScreenController();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CDS");
		splashScreen.showWindow();
		PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(4));
		// irá iniciar o entity manager, para otimizar as outras operações no banco
		EntityManager em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		em.close();
		// após o delay de 4 segundos, irá chamar a tela de login
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
