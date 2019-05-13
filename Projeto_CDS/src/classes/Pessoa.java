package classes;

import abstratas.Usuario;

public class Pessoa extends Usuario {

	private String nome;
	private float peso_inicial;
	private float altura;

	public Pessoa(String nome, float peso_inicial, float altura) {
		super();
		this.nome = nome;
		this.peso_inicial = peso_inicial;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso_inicial() {
		return peso_inicial;
	}

	public void setPeso_inicial(float peso_inicial) {
		this.peso_inicial = peso_inicial;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public void editarInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
