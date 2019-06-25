package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Rotina;

public interface IRotinaDAO {
	/**
	 * Cria um {@link Rotina} no banco de dados
	 * 
	 * @param alimento Rotina que deseja ser feita a inserção
	 * 
	 */
	public void create(Rotina rotina);

	/**
	 * Retorna todos as Rotina no banco de dados
	 * 
	 */
	public List<Rotina> retrieveAll();

	/**
	 * Retorna um Rotina do banco, através de seu campo id no banco de dados
	 * 
	 * @param id Número de Id da Rotina que deseja ser feita a seleção
	 * 
	 */
	public Rotina retrieve(Integer id);

	/**
	 * Atualiza os dados de um Rotina do banco, através de seus novos dados
	 * 
	 * @param alimento Objeto Rotina que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Rotina rotina);

	/**
	 * Deleta um Rotina do banco, através de seu campo id
	 * 
	 * @param id Número de Id da Rotina que deseja ser feita a deleção
	 * 
	 */
	public void delete(Integer id);
}
