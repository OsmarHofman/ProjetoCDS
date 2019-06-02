package br.edu.ifsc.cds.classes.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.ifsc.cds.classes.abstracts.Horario;
import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

@Entity
public class Refeicao extends Horario implements AlteracaoDados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

	@OneToMany(mappedBy = "refeicao")
	private List<Alimento> listaAlimentos = new ArrayList<Alimento>();

	@ManyToOne
	@JoinColumn(name = "rotina_id")
	private Rotina rotina;

	public Refeicao() {
	}

	public Refeicao(Date periodoInicio, Date periodoFim, Date diaSemana, Integer id, String titulo, Rotina rotina,
			List<Alimento> listaAlimentos) {
		super(periodoInicio, periodoFim, diaSemana);
		this.id = id;
		this.titulo = titulo;
		this.setRotina(rotina);
		this.listaAlimentos = listaAlimentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Rotina getRotina() {
		return rotina;
	}

	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
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
