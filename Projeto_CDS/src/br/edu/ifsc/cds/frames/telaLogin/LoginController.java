package br.edu.ifsc.cds.frames.telaLogin;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

	@FXML
	private JFXPasswordField txtSenha;

	@FXML
	private JFXTextField txtPesoCad;

	@FXML
	private JFXTextField txtEmailCad;

	@FXML
	private JFXButton btnMSignUp;

	@FXML
	private JFXButton btnSignUp;

	@FXML
	private JFXButton btnMSignin;

	@FXML
	private JFXPasswordField txtxSenhaCad;

	@FXML
	private JFXTextField txtAlturaCad;

	@FXML
	private JFXButton txtSignin;

	@FXML
	private JFXTextField txtUsuario;

	@FXML
	private JFXTextField txtNomeCad;

	@FXML
	private AnchorPane anchorSignIn;

	@FXML
	private AnchorPane anchorSignUp;

	// Métodos

	@FXML
	void signUp(ActionEvent event) {
		anchorSignUp.setVisible(true);
		String nome_pessoa = txtNomeCad.getText();
		String senha_pessoa = txtxSenhaCad.getText();
		String email_pessoa = txtEmailCad.getText();
		Float peso_pessoa = Float.parseFloat(txtPesoCad.getText());
		Float altura_pessoa = Float.parseFloat(txtAlturaCad.getText());
		Pessoa pessoa = new Pessoa(null, nome_pessoa, email_pessoa, senha_pessoa, peso_pessoa, altura_pessoa);
		PessoaDAO dao = new PessoaDAO();
		if (verificaValidade(nome_pessoa, email_pessoa, senha_pessoa, txtPesoCad.getText(), txtAlturaCad.getText())) {
			dao.create(pessoa);
			JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
		}

	}

	@FXML
	void signin(ActionEvent event) {

	}

	@FXML
	void mSignin(ActionEvent event) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
	}

	@FXML
	void mSignUp(ActionEvent event) {
		anchorSignIn.setVisible(false);
		anchorSignUp.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
		validadoresTela();

	}

	private void validadoresTela() {
		criaValidador(txtUsuario);
		criaValidador(txtSenha);
		criaValidador(txtNomeCad);
		criaValidador(txtEmailCad);
		criaValidador(txtPesoCad);
		criaValidador(txtAlturaCad);
		criaValidador(txtxSenhaCad);
	}

	public boolean criaValidador(JFXTextField campo) {
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

	public void criaValidador(JFXPasswordField campo) {
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
