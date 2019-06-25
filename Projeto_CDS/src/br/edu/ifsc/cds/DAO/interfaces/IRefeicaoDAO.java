package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Refeicao;

public interface IRefeicaoDAO {
	/**
	 * Cria um {@link Refeicao} no banco de dados
	 * 
	 * @param alimento Refeicao que deseja ser feita a inser��o
	 * 
	 */
	public void create(Refeicao refeicao);

	/**
	 * Retorna todos os Refeicao no banco de dados
	 * 
	 */
	public List<Refeicao> retrieveAll();

	/**
	 * Retorna um Refeicao do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do Refeicao que deseja ser feita a sele��o
	 * 
	 */
	public Refeicao retrieve(Integer id);

	/**
	 * Atualiza os dados de um Refeicao do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Refeicao que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Refeicao refeicao);

	/**
	 * Deleta um Refeicao do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do Refeicao que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);
}
