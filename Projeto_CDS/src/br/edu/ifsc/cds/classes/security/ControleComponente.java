package br.edu.ifsc.cds.classes.security;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * Classe que implementa o controle de fechamento de alguns componentes
 *
 */
public class ControleComponente {

	/**
	 * Realiza a confirma��o do fechamento da Janela. Se a opera��o for 1 ou 2, o
	 * usu�rio clicou em "N�o" e "Cancelar", respectivamente, e assim mantem-se na
	 * tela atual. Caso contr�rio, ele clicou em "Sim", ent�o a tela � fechada e o
	 * sistema, finalizado.
	 * 
	 * @param op Opera��o que foi gerada pelo clique no bot�o
	 * @param we Evento da tela que requisitou a verifica��o
	 */

	public void fechaJanela(int op, WindowEvent we) {
		if (op == 1 || op == 2) {
			we.consume();
		} else {
			EntityMagerFactorySingleton.closeFactory();
		}
	}

	/**
	 * Realiza o fechamento da tela no qual o bot�o passado como parametro, est�
	 * inserido.
	 * 
	 * @param botao Bot�o que requisitou o fechamento da tela.
	 */
	public void fechaBotao(JFXButton botao) {
		Stage telaAtual = (Stage) botao.getScene().getWindow();
		telaAtual.close();
	}

}
