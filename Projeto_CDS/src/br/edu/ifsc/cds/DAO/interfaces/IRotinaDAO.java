package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Rotina;

public interface IRotinaDAO {
	/**
	 * Cria um {@link Rotina} no banco de dados
	 * 
	 * @param alimento Rotina que deseja ser feita a inser��o
	 * 
	 */
	public void create(Rotina rotina);

	/**
	 * Retorna todos as Rotina no banco de dados
	 * 
	 */
	public List<Rotina> retrieveAll();

	/**
	 * Retorna um Rotina do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id da Rotina que deseja ser feita a sele��o
	 * 
	 */
	public Rotina retrieve(Integer id);

	/**
	 * Atualiza os dados de um Rotina do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Rotina que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Rotina rotina);

	/**
	 * Deleta um Rotina do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id da Rotina que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);
}
