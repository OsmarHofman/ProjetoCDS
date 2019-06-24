package br.edu.ifsc.cds.frames.telaLogin;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DAO.AdminDAO;
import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.Validacao;
import br.edu.ifsc.cds.frames.telaRotina.ExecutorRotina;
import br.edu.ifsc.cds.frames.telaRotina.RotinaController;
import br.edu.ifsc.cds.frames.telaUsuarios.UsuariosController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

	// M�todos

	/**
	 * Cadastro de pessoas, no qual recebe os valores das caixas de texto, verifica
	 * se essas caixas est�o preenchidas e n�o tem valores negativos, monta uma
	 * Pessoa com os dados, e persiste no banco de dados. Caso o cadastro seja
	 * realizado, o usu�rio j� � direcionado a tela principal de Rotinas.
	 * 
	 * @param Evento de clique do bot�o de Cadastro
	 * 
	 * @exception Caso haja uma caixa de texto vazia ser� informado na interface
	 *                 gr�fica qual a caixa n�o preenchida. E caso haja um valor
	 *                 num�rico negativo ser� informado tal.
	 * 
	 */
	@FXML
	void signUp(ActionEvent event) {
		anchorSignUp.setVisible(true);
		String nome_pessoa = txtNomeCad.getText();
		String senha_pessoa = txtxSenhaCad.getText();
		String email_pessoa = txtEmailCad.getText();

		// Verifica se as caixas de texto est�o vazias ou com valor nulo
		if (Validacao.verificaString(nome_pessoa, senha_pessoa, email_pessoa, txtPesoCad.getText(),
				txtAlturaCad.getText())) {
			float peso_pessoa = Float.parseFloat(txtPesoCad.getText());
			float altura_pessoa = Float.parseFloat(txtAlturaCad.getText());

			// Verifica se os valores num�ricos s�o v�lidos (n�o negativos)
			if (Validacao.verificaFloat(peso_pessoa, altura_pessoa)) {
				Pessoa pessoa = new Pessoa(null, nome_pessoa, email_pessoa, senha_pessoa, peso_pessoa, altura_pessoa,
						null);
				PessoaDAO dao = new PessoaDAO();

				// Tenta persistir a pessoa no banco de dados
				try {
					dao.create(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastro conclu�do com sucesso!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar Cadastrar");
				}

				// Fecha a tela atual
				Stage telaAtual = (Stage) btnSignUp.getScene().getWindow();
				telaAtual.close();

				// Abre a tela de Rotina
				ExecutorRotina telaRotina = new ExecutorRotina();
				telaRotina.start(new Stage());
			} else {
				JOptionPane.showMessageDialog(null, "Digite somente valores maiores que 0 nos campos Peso e Altura");
			}
		}

	}

	/**
	 * Login no sistema, no qual atrav�s de um usu�rio, senha e a tela atual, o
	 * m�todo loginUsuario faz a verifica��o de que tipo de usu�rio est� tentando
	 * logar (Pessoa ou Administrador) e redireciona para a tela correta.
	 * 
	 * @param Evento de clique do bot�o de Login
	 * 
	 */
	@FXML
	void signin(ActionEvent event) {
		String user = txtUsuario.getText();
		String password = txtSenha.getText();
		Stage telaAtual = (Stage) txtSignin.getScene().getWindow();
		this.loginUsuario(user, password, telaAtual);

	}

	/**
	 * Este m�todo implementa as fun��es do m�todo signIn quando a tecla enter �
	 * pressionada.
	 * 
	 * @see M�todo signIn desta classe
	 * 
	 * @param Bot�o Enter pressionado
	 */

	@FXML
	void teclaEnterEntrar(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			String user = txtUsuario.getText();
			String password = txtSenha.getText();
			Stage telaAtual = (Stage) txtSignin.getScene().getWindow();
			this.loginUsuario(user, password, telaAtual);
		}
	}

	/**
	 * Este m�todo implementa as fun��es do m�todo signUp quando a tecla enter �
	 * pressionada.
	 * 
	 * @see M�todo signUp desta classe
	 * 
	 * @param Bot�o Enter pressionado
	 */
	@FXML
	void teclaEnterCadastrar(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			anchorSignUp.setVisible(true);
			String nome_pessoa = txtNomeCad.getText();
			String senha_pessoa = txtxSenhaCad.getText();
			String email_pessoa = txtEmailCad.getText();
			float peso_pessoa = Float.parseFloat(txtPesoCad.getText());
			float altura_pessoa = Float.parseFloat(txtAlturaCad.getText());
			if (Validacao.verificaString(txtNomeCad.getText(), txtxSenhaCad.getText(), txtEmailCad.getText(),
					txtPesoCad.getText(), txtAlturaCad.getText())) {
				if (Validacao.verificaFloat(peso_pessoa, altura_pessoa)) {
					Pessoa pessoa = new Pessoa(null, nome_pessoa, email_pessoa, senha_pessoa, peso_pessoa,
							altura_pessoa, null);
					PessoaDAO dao = new PessoaDAO();
					dao.create(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastro conclu�do com sucesso!");
					ExecutorRotina telaRotina = new ExecutorRotina();
					Stage telaAtual = (Stage) btnSignUp.getScene().getWindow();
					telaAtual.close();
					Stage novaTela = new Stage();
					telaRotina.start(novaTela);
				} else {
					JOptionPane.showMessageDialog(null,
							"Digite somente valores maiores que 0 nos campos Peso e Altura");
				}
			}

		}
	}

	/**
	 * Mostra os campos e op��o para o Login quando clicado no bot�o
	 * 
	 * @param Clique no bot�o
	 */
	@FXML
	void mSignin(ActionEvent event) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
	}

	/**
	 * Mostra os campos e op��o para Cadastro quando clicado no bot�o
	 * 
	 * @param Clique no bot�o
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

	public void loginUsuario(String user, String password, Stage telaAtual) {
		if (Validacao.verificaString(user, password)) {
			try {
				PessoaDAO pessoaDao = new PessoaDAO();
				Pessoa usuario = pessoaDao.retrieveCount(user, password);
				JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso!");

				telaAtual.close();

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../telaRotina/TelaRotina.fxml"));
					Parent root = (Parent) loader.load();

					RotinaController ctrl_rotina = loader.getController();
					ctrl_rotina.setPessoa(usuario);

					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setMaximized(true);
					stage.show();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}

			} catch (Exception ex) {
				loginAdmin(user, password, telaAtual);
			}
		}
	}

	public void loginAdmin(String user, String password, Stage telaAtual) {
		try {
			AdminDAO adminDao = new AdminDAO();
			Admin admin = adminDao.retrieveCount(user, password);
			JOptionPane.showMessageDialog(null, "Login Admin Efetuado com Sucesso!");

			telaAtual.close();

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../telaUsuarios/Usuarios.fxml"));
				Parent root = (Parent) loader.load();

				UsuariosController ctrl_users = loader.getController();
				ctrl_users.setAdmin(admin);

				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setMaximized(false);
				stage.setTitle("CDS");
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Usu�rio/Senha Incorreto");
		}
	}

}
