package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Admin;

/**
 * 
 * Interface que implementa as fun��es no banco de dados da classe {@link Admin}
 *
 */
public interface IAdminDAO {
	/**
	 * Cria um usu�rio {@link Admin} no banco de dados
	 * 
	 * @param admin Administrador que deseja ser feita a inser��o
	 * 
	 */
	public void create(Admin admin);

	/**
	 * Retorna todos os usu�rios administradores no banco de dados
	 * 
	 */
	public List<Admin> retrieveAll();

	/**
	 * Retorna um administrador do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do administrador que deseja ser feita a sele��o
	 * 
	 */
	public Admin retrieve(Integer id);

	/**
	 * Retorna um administrador do banco, atrav�s de seu email e senha, para via de
	 * Login no sistema
	 * 
	 * @param user     Email do administrador que deseja recuperar a conta
	 * @param password Email do administrador que deseja recuperar a conta
	 * 
	 */
	public Admin retrieveCount(String user, String password);

	/**
	 * Atualiza os dados de um administrador do banco, atrav�s de seus novos dados
	 * 
	 * @param admin Objeto Admin que tem os dados para serem atualizados no banco de
	 *              dados
	 * 
	 */
	public void update(Admin admin);

	/**
	 * Deleta um administrador do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do administrador que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);

}
