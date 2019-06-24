package br.edu.ifsc.cds.classes.security;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControleComponente {
	public static void fechaJanela(int op, WindowEvent we) {
		if (op == 1 || op == 2) {
			we.consume();
		} else {
			EntityMagerFactorySingleton.closeFactory();
		}
	}

	public static void fechaBotao(JFXButton botao) {
		Stage telaAtual = (Stage) botao.getScene().getWindow();
		telaAtual.close();
	}

}
