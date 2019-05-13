package classes;

import java.util.List;

import abstratas.Horario;
import interfaces.AlteracaoDados;

public class AtividadeFisica extends Horario implements AlteracaoDados {
	private String titulo;
	private List<Exercicio> listaExercicio;
	private float gastoCaloria;

	public AtividadeFisica(String titulo, List<Exercicio> listaExercicio, float gastoCaloria) {
		super();
		this.titulo = titulo;
		this.listaExercicio = listaExercicio;
		this.gastoCaloria = gastoCaloria;
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
