package classes;

import java.util.ArrayList;
import java.util.List;

import abstratas.Horario;
import interfaces.AlteracaoDados;

public class Refeicao extends Horario implements AlteracaoDados {

	private String titulo;
	private List<Alimento> listaAlimentos = new ArrayList<Alimento>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Alimento> getAlimentos() {
		return listaAlimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.listaAlimentos = alimentos;
	}

	// Métodos
	public float totalGanhoCalorico(ArrayList<Alimento> alimentos) {
		float total = 0;
		for (Alimento ali : alimentos) {
			total += ali.getInfo_nutri().getTotalCalorias();
		}
		return total;
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
