package br.edu.ifsc.cds.services;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DAO.AdminDAO;
import br.edu.ifsc.cds.DAO.interfaces.IAdminDAO;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.frames.admin.telaUsuarios.UsuariosController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminService {
	IAdminDAO dao = new AdminDAO();

	/**
	 * Realiza as verifica��es e o login de um {@link Admin} ao sistema. Verifica se
	 * os campos est�o vazios, tenta recuperar o Admin presente no banco, ent�o
	 * fecha a tela atual, inicia a tela de Rotina, passando o Admin que realizou o
	 * login
	 * 
	 * @see loginUsuario para mais informa��es das opera��es do m�todo
	 * 
	 * @param user      email do usu�rio para realizar login
	 * @param password  senha do usu�rio para realizar logina
	 * @param telaAtual tela que solicitou o login (para ser fechada)
	 * 
	 * @exception Exception Caso n�o encontre um Administrador, ir� informar que o
	 *                      Usu�rio n�o existe no Banco
	 */
	public void loginAdmin(String user, String password, Stage telaAtual) {
		try {
			Admin admin = dao.retrieveCount(user, password);
			JOptionPane.showMessageDialog(null, "Login Admin Efetuado com Sucesso!");

			telaAtual.close();

			try {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("../frames/admin/telaUsuarios/Usuarios.fxml"));
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
