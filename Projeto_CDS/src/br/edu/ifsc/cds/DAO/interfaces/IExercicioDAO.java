package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Exercicio;

public interface IExercicioDAO {
	/**
	 * Cria um {@link Exercicio} no banco de dados
	 * 
	 * @param alimento Exercicio que deseja ser feita a inser��o
	 * 
	 */
	public void create(Exercicio exercicio);

	/**
	 * Retorna todos os Exercicios no banco de dados
	 * 
	 */
	public List<Exercicio> retrieveAll();

	/**
	 * Retorna um Exercicio do banco, atrav�s de seu campo id no banco de dados
	 * 
	 * @param id N�mero de Id do Exercicio que deseja ser feita a sele��o
	 * 
	 */
	public Exercicio retrieve(Integer id);

	/**
	 * Atualiza os dados de um Exercicio do banco, atrav�s de seus novos dados
	 * 
	 * @param alimento Objeto Exercicio que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Exercicio exercicio);

	/**
	 * Deleta um Exercicio do banco, atrav�s de seu campo id
	 * 
	 * @param id N�mero de Id do Exercicio que deseja ser feita a dele��o
	 * 
	 */
	public void delete(Integer id);

	/**
	 * Recupera do banco o Exercicio pelo nome passado como par�metro.
	 * 
	 * @param nome Nome do Exercicio que deseja ser buscado
	 * @return o Objeto Exercicio com o nome como no requisitado
	 */
	public Exercicio retrieveDadosExer(String nome);
}
