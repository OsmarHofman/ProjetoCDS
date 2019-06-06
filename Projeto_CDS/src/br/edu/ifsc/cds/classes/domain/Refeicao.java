package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

@Entity
public class Refeicao extends Horario implements AlteracaoDados, Serializable {
	private static final long serialVersionUID = 1L;

	private String titulo;

	@OneToMany(mappedBy = "refeicao")
	private List<Alimento> listaAlimentos = new ArrayList<Alimento>();

	@ManyToOne
	@JoinColumn(name = "rotina_id")
	private Rotina rotina_refeicao;

	@JoinColumn(name = "horario_id")
	@OneToOne
	private Horario horario_ref;

	public Refeicao() {
	}

	public Refeicao(Integer id, Date periodoInicio, Date periodoFim, Date diaSemana, String titulo,
			List<Alimento> listaAlimentos) {
		super(id, periodoInicio, periodoFim, diaSemana);
		this.titulo = titulo;
		this.listaAlimentos = listaAlimentos;
	}

	public List<Alimento> getListaAlimentos() {
		return listaAlimentos;
	}

	public void setListaAlimentos(List<Alimento> listaAlimentos) {
		this.listaAlimentos = listaAlimentos;
	}

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

	// M�todos
	public float totalGanhoCalorico(ArrayList<Alimento> alimentos) {
		float total = 0;
		for (Alimento ali : alimentos) {
			total += ali.getInfo_nutri().getTotalCalorias();
		}
		return total;
	}

	@Override
	public <T> void editarInfo(T classe) {
		Refeicao novaRefeicao = (Refeicao) classe;
		this.titulo = novaRefeicao.getTitulo();
		this.listaAlimentos = novaRefeicao.getAlimentos();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
