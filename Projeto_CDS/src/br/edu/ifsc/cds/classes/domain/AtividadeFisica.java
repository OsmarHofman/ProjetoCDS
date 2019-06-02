package br.edu.ifsc.cds.classes.domain;

import java.util.List;

import br.edu.ifsc.cds.classes.abstracts.Horario;
import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public class AtividadeFisica extends Horario implements AlteracaoDados {

	private int id;
	private String titulo;
	private List<Exercicio> listaExercicio;
	private float gastoCaloria;

	public AtividadeFisica() {
	}

	public AtividadeFisica(int id, String titulo, List<Exercicio> listaExercicio, float gastoCaloria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.listaExercicio = listaExercicio;
		this.gastoCaloria = gastoCaloria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Exercicio> getListaExercicio() {
		return listaExercicio;
	}

	public void setListaExercicio(List<Exercicio> listaExercicio) {
		this.listaExercicio = listaExercicio;
	}

	public float getGastoCaloria() {
		return gastoCaloria;
	}

	public void setGastoCaloria(float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	@Override
	public <T> void editarInfo(T classe) {
		AtividadeFisica novaAtividade = (AtividadeFisica) classe;
		this.titulo = novaAtividade.getTitulo();
		this.listaExercicio = novaAtividade.getListaExercicio();
		this.gastoCaloria = novaAtividade.getGastoCaloria();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
