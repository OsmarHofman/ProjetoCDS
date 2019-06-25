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
	 * Realiza a confirmação do fechamento da Janela. Se a operação for 1 ou 2, o
	 * usuário clicou em "Não" e "Cancelar", respectivamente, e assim mantem-se na
	 * tela atual. Caso contrário, ele clicou em "Sim", então a tela é fechada e o
	 * sistema, finalizado.
	 * 
	 * @param op Operação que foi gerada pelo clique no botão
	 * @param we Evento da tela que requisitou a verificação
	 */

	public void fechaJanela(int op, WindowEvent we) {
		if (op == 1 || op == 2) {
			we.consume();
		} else {
			EntityMagerFactorySingleton.closeFactory();
		}
	}

	/**
	 * Realiza o fechamento da tela no qual o botão passado como parametro, está
	 * inserido.
	 * 
	 * @param botao Botão que requisitou o fechamento da tela.
	 */
	public void fechaBotao(JFXButton botao) {
		Stage telaAtual = (Stage) botao.getScene().getWindow();
		telaAtual.close();
	}

}
