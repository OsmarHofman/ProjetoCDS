package classes;

import interfaces.AlteracaoDados;

public class Exercicio implements AlteracaoDados {

	public Exercicio(String nome, String intensidade, float met) {
		super();
		this.nome = nome;
		this.intensidade = intensidade;
		this.met = met;
	}

	private String nome;
	private String intensidade;
	private float met;

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
		this.nome= novoExercicio.getNome();
		this.intensidade = novoExercicio.getIntensidade();
		this.met = novoExercicio.getMet();
		
	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
