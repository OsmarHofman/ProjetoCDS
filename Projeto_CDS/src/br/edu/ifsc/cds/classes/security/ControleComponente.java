package br.edu.ifsc.cds.classes.security;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.domain.Refeicao;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	/**
	 * Realiza a formata��o do campo inicio e termino da {@link Refeicao} e do {@link Exercicio}
	 * da uma tabela que utilize esses dois campos.
	 * 
	 * @param <T> objeto do tipo generico para poder ser usado em diferentes casos
	 * @param coluna local a ser editado do tipo RefeicaoDTO/ExercicioDTO na tabela
	 */
	public <T> void setCellFactory(TableColumn<T, Date> coluna) {

		coluna.setCellFactory((TableColumn<T, Date> column) -> {
			return new TableCell<T, Date>() {
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						setText(sdf.format((item)));
					}
				}
			};
		});
	}

	
	/**
	 * realiza a verifica��o da sele��o de componentes na tabela
	 * 
	 * @param <T> paramentro do tipo generico para poder ser usado em diferentes casos
	 * @param table tabela a ser verificada se est� selecionada
	 * @param botao componente que se tornar� habilitado quando o item da tabela ser selecionado
	 */
	public <T> void isSelecionado(TableView<T> table, JFXButton botao) {
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				botao.setDisable(false);
			}
		});
	}

}
