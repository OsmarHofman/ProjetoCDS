package br.edu.ifsc.cds.classes.domain;

import java.util.Date;

import br.edu.ifsc.cds.classes.abstracts.Horario;
import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public class Exercicio extends Horario implements AlteracaoDados {

	private Integer id;
	private String nome;
	private String intensidade;
	private float met;
	private float gastoCaloria;

	public Exercicio(Integer id, String nome, String intensidade, float met, float gastoCaloria, Date periodoInicio,
			Date periodoFim, Date diaSemana) {
		super(periodoInicio, periodoFim, diaSemana);
		this.id = id;
		this.nome = nome;
		this.intensidade = intensidade;
		this.met = met;
		this.gastoCaloria = gastoCaloria;
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

	public String getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}

	public float getMet() {
		return met;
	}

	public void setMet(float met) {
		this.met = met;
	}

	public float getGastoCaloria() {
		return gastoCaloria;
	}

	public void setGastoCaloria(float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	@Override
	public <T> void editarInfo(T classe) {
		Exercicio novoExercicio = (Exercicio) classe;
		this.nome = novoExercicio.getNome();
		this.intensidade = novoExercicio.getIntensidade();
		this.met = novoExercicio.getMet();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
