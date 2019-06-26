package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Exercicio;

public interface IExercicioDAO {
	/**
	 * Cria um {@link Exercicio} no banco de dados
	 * 
	 * @param alimento Exercicio que deseja ser feita a inserção
	 * 
	 */
	public void create(Exercicio exercicio);

	/**
	 * Retorna todos os Exercicios no banco de dados
	 * 
	 */
	public List<Exercicio> retrieveAll();

	/**
	 * Retorna um Exercicio do banco, através de seu campo id no banco de dados
	 * 
	 * @param id Número de Id do Exercicio que deseja ser feita a seleção
	 * 
	 */
	public Exercicio retrieve(Integer id);

	/**
	 * Atualiza os dados de um Exercicio do banco, através de seus novos dados
	 * 
	 * @param alimento Objeto Exercicio que tem os dados para serem atualizados no
	 *                 banco de dados
	 * 
	 */
	public void update(Exercicio exercicio);

	/**
	 * Deleta um Exercicio do banco, através de seu campo id
	 * 
	 * @param id Número de Id do Exercicio que deseja ser feita a deleção
	 * 
	 */
	public void delete(Integer id);

	/**
	 * Recupera do banco o Exercicio pelo nome passado como parâmetro.
	 * 
	 * @param nome Nome do Exercicio que deseja ser buscado
	 * @return o Objeto Exercicio com o nome como no requisitado
	 */
	public Exercicio retrieveDadosExer(String nome);
}
