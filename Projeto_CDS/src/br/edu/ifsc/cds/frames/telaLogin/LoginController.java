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
import br.edu.ifsc.cds.frames.admin.telaUsuarios.UsuariosController;
import br.edu.ifsc.cds.frames.user.telaRotina.ExecutorRotina;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
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

	// Métodos

	/**
	 * Cadastro de {@link Pessoa}, no qual recebe os valores das caixas de texto,
	 * verifica se essas caixas estão preenchidas e não tem valores negativos, monta
	 * uma Pessoa com os dados, e persiste no banco de dados. Caso o cadastro seja
	 * realizado, o usuário já é direcionado a tela principal de
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

		// Verifica se as caixas de texto estão vazias ou com valor nulo
		if (Validacao.verificaString(nome_pessoa, senha_pessoa, email_pessoa, txtPesoCad.getText(),
				txtAlturaCad.getText())) {
			float peso_pessoa = Float.parseFloat(txtPesoCad.getText());
			float altura_pessoa = Float.parseFloat(txtAlturaCad.getText());

			// Verifica se os valores numéricos são válidos (não negativos)
			if (Validacao.verificaFloat(peso_pessoa, altura_pessoa)) {
				Pessoa pessoa = new Pessoa(null, nome_pessoa, email_pessoa, senha_pessoa, peso_pessoa, altura_pessoa,
						null);
				PessoaDAO dao = new PessoaDAO();

				// Tenta persistir a pessoa no banco de dados
				try {
					dao.create(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
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
		this.loginUsuario(user, password, telaAtual);

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
			String user = txtUsuario.getText();
			String password = txtSenha.getText();
			Stage telaAtual = (Stage) txtSignin.getScene().getWindow();
			this.loginUsuario(user, password, telaAtual);
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
					JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
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

	/**
	 * Realiza as verificações e o login de uma {@link Pessoa} ao sistema. Verifica
	 * se os campos estão vazios, tenta recuperar a Pessoa presente no banco, então
	 * fecha a tela atual, inicia a tela de Rotina {@link ExecutorRotina}, passando
	 * a Pessoa que realizou o login
	 * 
	 * @param user      email do usuário para realizar login
	 * @param password  senha do usuário para realizar logina
	 * @param telaAtual tela que solicitou o login (para ser fechada)
	 * 
	 * @exception Exception Caso não encontre uma Pessoa, irá verificar se o usuário
	 *                      é um Administrador, caso contrário irá informar que o
	 *                      Usuário não existe no Banco
	 */
	public void loginUsuario(String user, String password, Stage telaAtual) {
		if (Validacao.verificaString(user, password)) {
			try {
				PessoaDAO pessoaDao = new PessoaDAO();

				// Tenta recuperar a conta da Pessoa na base de dados
				Pessoa usuario = pessoaDao.retrieveCount(user, password);
				JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso!");

				telaAtual.close();

				// Tenta Iniciar a nova tela de Rotina
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../user/telaRotina/TelaRotina.fxml"));
					Parent root = (Parent) loader.load();

					// Obtem o controller relacionado a tela, e passar o objeto Pessoa para a
					// mesma
					RotinaController ctrl_rotina = loader.getController();
					System.out.println(usuario.getNome());
					ctrl_rotina.setPessoa(usuario);

					// Contrói a nova tela
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setMaximized(true);
					stage.setTitle("CDS");
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Caso não encontre a Pessoa na base de dados, tenta encontrar um Administrador
			} catch (Exception ex) {
				loginAdmin(user, password, telaAtual);
			}
		}
	}

	/**
	 * Realiza as verificações e o login de um {@link Admin} ao sistema. Verifica se
	 * os campos estão vazios, tenta recuperar o Admin presente no banco, então
	 * fecha a tela atual, inicia a tela de Rotina, passando o Admin que realizou o
	 * login
	 * 
	 * @see loginUsuario para mais informações das operações do método
	 * 
	 * @param user      email do usuário para realizar login
	 * @param password  senha do usuário para realizar logina
	 * @param telaAtual tela que solicitou o login (para ser fechada)
	 * 
	 * @exception Exception Caso não encontre um Administrador, irá informar que o
	 *                      Usuário não existe no Banco
	 */
	public void loginAdmin(String user, String password, Stage telaAtual) {
		try {
			AdminDAO adminDao = new AdminDAO();
			Admin admin = adminDao.retrieveCount(user, password);
			JOptionPane.showMessageDialog(null, "Login Admin Efetuado com Sucesso!");

			telaAtual.close();

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../admin/telaUsuarios/Usuarios.fxml"));
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
			JOptionPane.showMessageDialog(null, "Usuário/Senha Incorreto");
		}
	}

}
