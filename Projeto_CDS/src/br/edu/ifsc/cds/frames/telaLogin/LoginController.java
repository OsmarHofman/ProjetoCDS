package br.edu.ifsc.cds.frames.telaLogin;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.classes.security.Validacao;
import br.edu.ifsc.cds.frames.user.telaRotina.ExecutorRotina;
import br.edu.ifsc.cds.services.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

	ControleComponente ctrlComp = new ControleComponente();

	// Métodos

	/**
	 * Cadastro de {@link Pessoa}, no qual recebe os valores das caixas de
	 * texto,monta uma Pessoa com os dados, e persiste no banco de dados. Caso o
	 * cadastro seja realizado, o usuário é direcionado a tela principal de
	 * {@link ExecutorRotina}.
	 * 
	 * @param Evento de clique do botão de Cadastro
	 * 
	 * @exception Exception Caso haja uma caixa de texto vazia será informado na
	 *                      interface gráfica qual a caixa não preenchida. E caso
	 *                      haja um valor numérico negativo será informado tal.
	 * 
	 */
	@FXML
	void signUp(ActionEvent event) {
		anchorSignUp.setVisible(true);
		String nome_pessoa = txtNomeCad.getText();
		String senha_pessoa = txtxSenhaCad.getText();
		String email_pessoa = txtEmailCad.getText();
		float peso_pessoa = Float.parseFloat(txtPesoCad.getText());
		float altura_pessoa = Float.parseFloat(txtAlturaCad.getText());

		// instancia uma pessoa que tentará ser inserida ao banco
		Pessoa nova_pessoa = new Pessoa(null, nome_pessoa, email_pessoa, senha_pessoa, peso_pessoa, altura_pessoa,
				null);
		PessoaService service = new PessoaService();

		// armazena o resultado da tentativa de cadastro da Pessoa
		boolean insercao_pessoa = service.criaPessoa(nova_pessoa);

		// caso a pessoa seja criada com sucesso
		if (insercao_pessoa) {
			// Fecha a tela atual
			ctrlComp.fechaBotao(btnSignUp);

			// Abre a tela de Rotina
			ExecutorRotina telaRotina = new ExecutorRotina();
			telaRotina.start(new Stage());

		}

	}

	/**
	 * Login no sistema, no qual através de um usuário, senha e a tela atual, o
	 * método {@link #loginUsuario} faz a verificação de que tipo de usuário está
	 * tentando logar ({@link Pessoa} ou {@link Admin}) e redireciona para a tela
	 * correta.
	 * 
	 * @param Evento de clique do botão de Login
	 * 
	 */
	@FXML
	void signin(ActionEvent event) {
		String user = txtUsuario.getText();
		String password = txtSenha.getText();
		Stage telaAtual = (Stage) txtSignin.getScene().getWindow();
		PessoaService service = new PessoaService();
		service.loginUsuario(user, password, telaAtual);

	}

	/**
	 * Este método implementa as funções do método signin quando a tecla Enter é
	 * pressionada.
	 * 
	 * @see Método {@link #signin} desta classe
	 * 
	 * @param Botão Enter pressionado
	 */

	@FXML
	void teclaEnterEntrar(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			this.signin(new ActionEvent());
		}
	}

	/**
	 * Este método implementa as funções do método signUp quando a tecla enter é
	 * pressionada.
	 * 
	 * @see Método {@link #signUp} desta classe
	 * 
	 * @param Botão Enter pressionado
	 */
	@FXML
	void teclaEnterCadastrar(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			this.signUp(new ActionEvent());
		}
	}

	/**
	 * Mostra os campos e opção para o Login quando clicado no botão
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void mSignin(ActionEvent event) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
	}

	/**
	 * Mostra os campos e opção para Cadastro quando clicado no botão
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void mSignUp(ActionEvent event) {
		anchorSignIn.setVisible(false);
		anchorSignUp.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
		// inicia os validadores dos Text Field da tela
		Validacao.criaValidadorTxtField(Arrays.asList(txtUsuario, txtNomeCad, txtEmailCad, txtPesoCad, txtAlturaCad));
		// inicia os validadores dos Password Field da tela
		Validacao.criaValidadorPassField(Arrays.asList(txtSenha, txtxSenhaCad));
	}

}
