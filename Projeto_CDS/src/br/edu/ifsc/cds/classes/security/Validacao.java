package br.edu.ifsc.cds.classes.security;

import java.util.List;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Validacao {
	public static void criaValidadorTxtField(List<JFXTextField> campoTela) {
		for (JFXTextField campo : campoTela) {
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

	public static boolean verificaString(String... listaCampos) {
		for (String campos : listaCampos) {
			if (campos.equals("") || campos.equals(null)) {
				return false;
			}
		}
		return true;
	}

	public static boolean verificaFloat(float... listaCampos) {
		for (float campos : listaCampos) {
			if (campos <= 0) {
				return false;
			}
		}
		return true;
	}
}
