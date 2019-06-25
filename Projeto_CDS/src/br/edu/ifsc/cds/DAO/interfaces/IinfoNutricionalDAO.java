package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.InfoNutricional;

public interface IinfoNutricionalDAO {
	/**
	 * Cria um {@link InfoNutricional} no banco de dados
	 * 
	 * @param alimento InfoNutricional que deseja ser feita a inserção
	 * 
	 */
	public void create(InfoNutricional infnutri);

	/**
	 * Retorna todos os InfoNutricional no banco de dados
	 * 
	 */
	public List<InfoNutricional> retrieveAll();

	/**
	 * Retorna um InfoNutricional do banco, através de seu campo id no banco de
	 * dados
	 * 
	 * @param id Número de Id do InfoNutricional que deseja ser feita a seleção
	 * 
	 */
	public InfoNutricional retrieve(Integer id);

	/**
	 * Atualiza os dados de um InfoNutricional do banco, através de seus novos dados
	 * 
	 * @param alimento Objeto InfoNutricional que tem os dados para serem
	 *                 atualizados no banco de dados
	 * 
	 */
	public void update(InfoNutricional infnutri);

	/**
	 * Deleta um InfoNutricional do banco, através de seu campo id
	 * 
	 * @param id Número de Id do InfoNutricional que deseja ser feita a deleção
	 * 
	 */
	public void delete(Integer id);
}
