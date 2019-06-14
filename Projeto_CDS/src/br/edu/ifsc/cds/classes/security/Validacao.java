package br.edu.ifsc.cds.classes.security;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Validacao {
	public static boolean criaValidador(JFXTextField campo) {
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
		return campo.focusedProperty().getValue();
	}

	public static void criaValidador(JFXPasswordField campo) {
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

	public static boolean verificaValidade(String... listaCampos) {
		for (String campos : listaCampos) {
			if (campos.equals("") || campos.equals(null)) {
				return false;
			}
		}
		return true;
	}
}
