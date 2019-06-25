package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Alimento;

public interface IAlimentoDAO {
	/**
	 * Cria um {@link Alimento} no banco de dados
	 * 
	 * @param alimento Alimento que deseja ser feita a inserção
	 * 
	 */
	public void create(Alimento alimento);

	/**
	 * Retorna todos os alimentos no banco de dados
	 * 
	 */
	public List<Alimento> retrieveAll();

	/**
	 * Retorna um Alimento do banco, através de seu campo id no banco de dados
	 * 
	 * @param id Número de Id do Alimento que deseja ser feita a seleção
	 * 
	 */
	public Alimento retrieve(Integer id);

	/**
	 * Atualiza os dados de um Alimento do banco, através de seus novos dados
	 * 
	 * @param alimento Objeto Alimento que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Alimento alimento);

	/**
	 * Deleta um Alimento do banco, através de seu campo id
	 * 
	 * @param id Número de Id do Alimento que deseja ser feita a deleção
	 * 
	 */
	public void delete(Integer id);

}
