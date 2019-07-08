package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.services.ExercicioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AtividadeFisicaDTO {
	private Integer id;
	private String nome;
	private Float gastoCaloria;
	private Float met;

	/**
	 * Cria um {@link AtividadeFisicaDTO} sem adicionar nenhum valor a seus atributos
	 */
	public AtividadeFisicaDTO() {

	}

	/**
	 * Cria um {@link AtividadeFisicaDTO} adicionando valores a todos os seus atributos
	 * 
	 * @param id Valor do id da {@link AtividadeFisicaDTO}
	 * @param nome Nome da {@link AtividadeFisicaDTO}
	 * @param gastoCaloria Gasto calórico da {@link AtividadeFisicaDTO}
	 * @param met Valor do MET da {@link AtividadeFisicaDTO}
	 */
	public AtividadeFisicaDTO(Integer id, String nome, Float gastoCaloria, Float met) {
		super();
		this.id = id;
		this.nome = nome;
		this.gastoCaloria = gastoCaloria;
		this.met = met;
	}

	/**
	 * Retorna o id da {@link AtividadeFisicaDTO}
	 * 
	 * @return Valor do id da AtividadeFisicaDTO
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o id da {@link AtividadeFisicaDTO} para o novo valor recebido como
	 * parâmetro
	 * 
	 * @param Novo id da AtividadeFisicaDTO 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da {@link AtividadeFisicaDTO} 
	 * 
	 * @return Valor atual do nome do AtividadeFisicaDTO
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome da {@link AtividadeFisicaDTO} para o novo valor recebido como
	 * parâmetro
	 * 
	 * @param nome Novo nome do @link AtividadeFisicaDTO
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o gasto calórico da {@link AtividadeFisicaDTO} 
	 * 
	 * @return Valor do gasto calórico da AtividadeFisicaDTO
	 */
	public Float getGastoCaloria() {
		return gastoCaloria;
	}

	/**
	 * Altera o valor do gasto calórico da {@link AtividadeFisicaDTO} para o novo valor recebido como 
	 * parâmetro
	 * 
	 * @param gastoCaloria Novo valor do gasto calórico da AtividadeFisicaDTO
	 */
	public void setGastoCaloria(Float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	/**
	 * Retorna o valor do Met da {@link AtividadeFisicaDTO}
	 * 
	 * @return Valor atual do Met da @link AtividadeFisicaDTO
	 */
	public Float getMet() {
		return met;
	}

	/**
	 * Altera o Met da {@link AtividadeFisicaDTO} para o novo valor recebido como 
	 * parâmetro
	 * 
	 * @param met Nova Met da AtividadeFisicaDTO 
	 */
	public void setMet(Float met) {
		this.met = met;
	}

	/**
	 * Converte um Exercicio em um AtividadeFisicaDTO
	 * 
	 * @param exercicio Alimento a ser convertido
	 * @return um AlimentoDTO baseado no Alimento dado
	 */
	private AtividadeFisicaDTO converteExercicio(Exercicio exercicio) {
		return new AtividadeFisicaDTO(exercicio.getId(), exercicio.getNome(), exercicio.getGastoCaloria(),
				exercicio.getMet());
	}

	/**
	 * Transforma todos os Exercicio, em um AtividadeFisicaDTO.
	 * 
	 * @return InfoNutricionalDTO com seus atributos
	 */
	public ObservableList<AtividadeFisicaDTO> geraExercDTO() {
		ExercicioService service = new ExercicioService();
		List<Exercicio> exercicios = service.retriveAllExercicios();
		List<AtividadeFisicaDTO> exercDTO = new ArrayList<>();
		// verifica os alimentos presentes no banco até achar um correspondente
		for (Exercicio exercicio : exercicios) {
			exercDTO.add(converteExercicio(exercicio));

		}
		return FXCollections.observableArrayList(exercDTO);

	}
}
