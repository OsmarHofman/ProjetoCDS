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

	public AtividadeFisicaDTO() {

	}

	public AtividadeFisicaDTO(Integer id, String nome, Float gastoCaloria, Float met) {
		super();
		this.id = id;
		this.nome = nome;
		this.gastoCaloria = gastoCaloria;
		this.met = met;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getGastoCaloria() {
		return gastoCaloria;
	}

	public void setGastoCaloria(Float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	public Float getMet() {
		return met;
	}

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
