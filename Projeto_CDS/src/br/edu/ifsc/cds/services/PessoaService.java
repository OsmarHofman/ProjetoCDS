package br.edu.ifsc.cds.services;

import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.DAO.interfaces.IPessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.Validacao;
import br.edu.ifsc.cds.frames.user.telaRotina.ExecutorRotina;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Classe responsável pela Camada de Serviço da classe {@link Pessoa}
 *
 */
public class PessoaService {

	private IPessoaDAO dao = new PessoaDAO();

	/**
	 * Verificar os dados e insere a pessoa no Banco de dados.
	 * 
	 * @param pessoa Nova pessoa a ser inserida no banco
	 * @return true caso a pessoa seja incluída com sucesso no banco, e false caso
	 *         contrário
	 */
	public boolean criaPessoa(Pessoa pessoa) {

		// Verifica se as atributos estão vazios ou com valor nulo
		if (Validacao.verificaString(pessoa.getNome(), pessoa.getSenha(), pessoa.getEmail(),
				String.valueOf(pessoa.getPeso_inicial()), String.valueOf(pessoa.getAltura()))) {

			// Verifica se os valores numéricos são válidos (não negativos)
			if (Validacao.verificaFloat(pessoa.getPeso_inicial(), pessoa.getAltura())) {

				// Tenta persistir a pessoa no banco de dados
				try {
					dao.create(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
					return true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar Cadastrar");
				}
			}
		}
		return false;
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

				// Tenta recuperar a conta da Pessoa na base de dados
				Pessoa usuario = dao.retrieveCount(user, password);
				JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso!");

				telaAtual.close();

				// Tenta Iniciar a nova tela de Rotina
				try {
					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("../frames/user/telaRotina/TelaRotina.fxml"));
					Parent root = (Parent) loader.load();

					System.setProperty("id", String.valueOf(usuario.getId()));
					System.setProperty("altura", String.valueOf(usuario.getAltura()));
					System.setProperty("peso", String.valueOf(usuario.getPeso_inicial()));

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
				AdminService service = new AdminService();
				service.loginAdmin(user, password, telaAtual);
			}
		}
	}

	/**
	 * Retorna todas as pessoas presentes no sistema
	 * 
	 * @return {@link List} de todas as {@link Pessoa} na base de dados
	 */
	public List<Pessoa> retornaTodos() {
		return dao.retrieveAll();
	}

	/**
	 * Retorna todas a pessoa com o id correspondente
	 * 
	 * @return {@link List} de todas as {@link Pessoa} na base de dados
	 */
	public Pessoa retornaPessoa(Integer id) {
		return dao.retrieve(id);
	}

	/**
	 * Realiza a atualização do usuário logado no sistema
	 * 
	 * @param usuario dados atualizados do usuario
	 */
	public void editarUsuario(Pessoa usuario) {
		dao.update(usuario);
	}

}
