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
 * Classe que realiza diferentes validações e verificações a dados
 *
 */
public class Validacao {
	/**
	 * Cria Validadores para campos do tipo TextField. Estes validadores verificam
	 * que o campo não foi preenchido e perdeu seu foco. Assim, simbolízam ao
	 * usuário que o campo não está preenchido.
	 * 
	 * @param campoTela lista de Campos que deseja-se criar os validadores
	 */
	public static void criaValidadorTxtField(List<JFXTextField> campoTela) {
		for (JFXTextField campo : campoTela) {
			// pra cada campo, cria um validador e adiciona ao campo
			RequiredFieldValidator validador = new RequiredFieldValidator();
			campo.getValidators().add(validador);

			// Mensagem caso não seja preenchido
			validador.setMessage("Campo " + campo.getPromptText() + " Obrigatório");
			// Cria um Listener sobre perca do foco
			campo.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// Se não há um valor preenchido, ele chama a mensagem de validação
					if (!newValue) {
						campo.validate();
					}
				}

			});

		}

	}

	/**
	 * Cria Validadores para campos do tipo PasswordField. Implementação
	 * praticamente identica ao método {@link #criaValidadorTxtField(List)}.
	 * 
	 * @see Para mais informações das operações, veja o método
	 *      {@link #criaValidadorTxtField(List)}
	 * @param campoTela
	 */
	public static void criaValidadorPassField(List<JFXPasswordField> campoTela) {
		for (JFXPasswordField campo : campoTela) {
			RequiredFieldValidator validador = new RequiredFieldValidator();
			campo.getValidators().add(validador);
			validador.setMessage("Campo " + campo.getPromptText() + " Obrigatório");
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
	 * Verifica se as Strings tem algum conteúdo. Para cada uma das Strings, é
	 * verificado se são nulas ou tem texto vazio, assim é retornado falso caso
	 * alguma das Strings não tenha texto, e verdadeiro caso haja algum texto em
	 * todas as Strings.
	 * 
	 * @param listaCampos lista das Strings para se verificar o conteúdo
	 * @return true Se todas as Strings tiverem algum texto e false se alguma das
	 *         Strings não tem texto, ou é nula
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
	 * Verifica se os Floats tem valor menos ou igual a 0. Mesmo processo de análise
	 * do método {@link Validacao#verificaString(String...)}.
	 * 
	 * @see método {@link Validacao#verificaString(String...)} é semelhante
	 * @param listaCampos lista de Floatas para verificar o conteúdo
	 * @return true Se todos os Floats tem valores maiores que 0 ou false Se houver
	 *         algum campo com valor igual ou menor a 0.
	 */

	public static boolean verificaFloat(float... listaCampos) {
		for (float campos : listaCampos) {
			if (campos <= 0) {
				JOptionPane.showMessageDialog(null, campos + " não é um valor válido!");
				return false;
			}
		}
		return true;
	}
}
