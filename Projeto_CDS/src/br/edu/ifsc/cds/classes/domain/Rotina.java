package br.edu.ifsc.cds.classes.domain;

import java.util.List;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public class Rotina implements AlteracaoDados {

	private Integer id;
	private String titulo;
	private List<String> listaDias;
	private List<Refeicao> listaRefeicao;
	private List<Exercicio> listaExercicio;

	public Rotina() {
	}

	public Rotina(Integer id, String titulo, List<String> listaDias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.listaDias = listaDias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getListaDias() {
		return listaDias;
	}

	public void setListaDias(List<String> listaDias) {
		this.listaDias = listaDias;
	}

	public List<Refeicao> getListaRefeicao() {
		return listaRefeicao;
	}

	public void setListaRefeicao(List<Refeicao> listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	public List<Exercicio> getListaExercicio() {
		return listaExercicio;
	}

	public void setListaExercicio(List<Exercicio> listaExercicio) {
		this.listaExercicio = listaExercicio;
	}

	@Override
	public <T> void editarInfo(T classe) {
		Rotina novoRotina = (Rotina) classe;
		this.titulo = novoRotina.getTitulo();
		this.listaDias = novoRotina.getListaDias();
		this.listaRefeicao = novoRotina.getListaRefeicao();
		this.listaExercicio = novoRotina.getListaExercicio();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub
	}

}
