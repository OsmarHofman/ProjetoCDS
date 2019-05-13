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

	@Override
	public void editarInfo() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
