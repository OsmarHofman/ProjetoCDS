package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Pessoa;

public interface IPessoaDAO {
	/**
	 * Cria um {@link Pessoa} no banco de dados
	 * 
	 * @param alimento Pessoa que deseja ser feita a inser��o
	 * 
	 */
	public void create(Pessoa pessoa);

	/**
	 * Retorna todos os Pessoa no banco de dados
	 * 
	 */
	public List<Pessoa> retrieveAll();

	/**
	 * Retorna um Pessoa do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do Pessoa que deseja ser feita a sele��o
	 * 
	 */
	public Pessoa retrieve(Integer id);

	/**
	 * Retorna um Pessoa do banco, atrav�s de seu email e senha, para via de Login
	 * no sistema
	 * 
	 * @param user     Email da Pessoa que deseja recuperar a conta
	 * @param password Email da Pessoa que deseja recuperar a conta
	 * 
	 */
	public Pessoa retrieveCount(String user, String password);

	/**
	 * Atualiza os dados de um Pessoa do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Pessoa que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Pessoa pessoa);

	/**
	 * Deleta um Pessoa do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do Pessoa que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);
}
