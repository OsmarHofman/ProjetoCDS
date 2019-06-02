package br.edu.ifsc.cds.classes.domain;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

public class Pessoa extends Usuario {

	private float peso_inicial;
	private float altura;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String email, String senha, float peso_inicial, float altura) {
		super(id, nome, email, senha);
		this.peso_inicial = peso_inicial;
		this.altura = altura;
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
	public <T> void editarInfo(T classe) {
		Pessoa novaPessoa = (Pessoa) classe;
		this.peso_inicial = novaPessoa.getPeso_inicial();
		this.altura = novaPessoa.getAltura();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
