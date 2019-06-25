package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Horario;

public interface IHorarioDAO {

	/**
	 * Cria um {@link Horario} no banco de dados
	 * 
	 * @param alimento Horario que deseja ser feita a inser��o
	 * 
	 */
	public void create(Horario horario);

	/**
	 * Retorna todos os Horario no banco de dados
	 * 
	 */
	public List<Horario> retrieveAll();

	/**
	 * Retorna um Horario do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do Horario que deseja ser feita a sele��o
	 * 
	 */
	public Horario retrieve(Integer id);

	/**
	 * Atualiza os dados de um Horario do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Horario que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Horario horario);

	/**
	 * Deleta um Horario do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do Horario que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);
}
