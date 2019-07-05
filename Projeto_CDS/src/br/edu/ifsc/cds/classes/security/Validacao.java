package br.edu.ifsc.cds.classes.security;

import java.util.List;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * 
 * Classe que realiza diferentes valida��es e verifica��es a dados
 *
 */
public class Validacao {
	/**
	 * Cria Validadores para campos do tipo TextField. Estes validadores verificam
	 * que o campo n�o foi preenchido e perdeu seu foco. Assim, simbol�zam ao
	 * usu�rio que o campo n�o est� preenchido.
	 * 
	 * @param campoTela lista de Campos que deseja-se criar os validadores
	 */
	public static void criaValidadorTxtField(List<JFXTextField> campoTela) {
		for (JFXTextField campo : campoTela) {
			// pra cada campo, cria um validador e adiciona ao campo
			RequiredFieldValidator validador = new RequiredFieldValidator();
			campo.getValidators().add(validador);

			// Mensagem caso n�o seja preenchido
			validador.setMessage("Campo " + campo.getPromptText() + " Obrigat�rio");
			// Cria um Listener sobre perca do foco
			campo.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// Se n�o h� um valor preenchido, ele chama a mensagem de valida��o
					if (!newValue) {
						campo.validate();
					}
				}

			});

		}

	}

	/**
	 * Cria Validadores para campos do tipo PasswordField. Implementa��o
	 * praticamente identica ao m�todo {@link #criaValidadorTxtField(List)}.
	 * 
	 * @see Para mais informa��es das opera��es, veja o m�todo
	 *      {@link #criaValidadorTxtField(List)}
	 * @param campoTela
	 */
	public static void criaValidadorPassField(List<JFXPasswordField> campoTela) {
		for (JFXPasswordField campo : campoTela) {
			RequiredFieldValidator validador = new RequiredFieldValidator();
			campo.getValidators().add(validador);
			validador.setMessage("Campo " + campo.getPromptText() + " Obrigat�rio");
			campo.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						campo.validate();
					}
				}

			});
		}

	}

	/**
	 * Verifica se as Strings tem algum conte�do. Para cada uma das Strings, �
	 * verificado se s�o nulas ou tem texto vazio, assim � retornado falso caso
	 * alguma das Strings n�o tenha texto, e verdadeiro caso haja algum texto em
	 * todas as Strings.
	 * 
	 * @param listaCampos lista das Strings para se verificar o conte�do
	 * @return true Se todas as Strings tiverem algum texto e false se alguma das
	 *         Strings n�o tem texto, ou � nula
	 */
	public static boolean verificaString(String... listaCampos) {
		for (String campos : listaCampos) {
			if (campos.equals("") || campos.equals(null)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Verifica se os Floats tem valor menos ou igual a 0. Mesmo processo de an�lise
	 * do m�todo {@link Validacao#verificaString(String...)}.
	 * 
	 * @see m�todo {@link Validacao#verificaString(String...)} � semelhante
	 * @param listaCampos lista de Floatas para verificar o conte�do
	 * @return true Se todos os Floats tem valores maiores que 0 ou false Se houver
	 *         algum campo com valor igual ou menor a 0.
	 */

	public static boolean verificaFloat(float... listaCampos) {
		for (float campos : listaCampos) {
			if (campos <= 0) {
				JOptionPane.showMessageDialog(null, campos + " n�o � um valor v�lido!");
				return false;
			}
		}
		return true;
	}
}
