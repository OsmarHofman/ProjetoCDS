package br.edu.ifsc.cds.classes.domain;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public class Exercicio implements AlteracaoDados {

	private int id;
	private String nome;
	private String intensidade;
	private float met;

	public Exercicio(int id, String nome, String intensidade, float met) {
		this.id = id;
		this.nome = nome;
		this.intensidade = intensidade;
		this.met = met;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
