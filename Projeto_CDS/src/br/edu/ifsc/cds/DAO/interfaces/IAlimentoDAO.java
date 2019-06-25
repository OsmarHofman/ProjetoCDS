package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Alimento;

public interface IAlimentoDAO {
	/**
	 * Cria um {@link Alimento} no banco de dados
	 * 
	 * @param alimento Alimento que deseja ser feita a inser��o
	 * 
	 */
	public void create(Alimento alimento);

	/**
	 * Retorna todos os alimentos no banco de dados
	 * 
	 */
	public List<Alimento> retrieveAll();

	/**
	 * Retorna um Alimento do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do Alimento que deseja ser feita a sele��o
	 * 
	 */
	public Alimento retrieve(Integer id);

	/**
	 * Atualiza os dados de um Alimento do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Alimento que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Alimento alimento);

	/**
	 * Deleta um Alimento do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do Alimento que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);

}
