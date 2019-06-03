package br.edu.ifsc.cds.classes.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

@Entity
public class Rotina implements AlteracaoDados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

	@OneToMany(mappedBy = "rotina_refeicao")
	private List<Refeicao> listaRefeicao;

	@OneToMany(mappedBy = "rotina_exercicio")
	private List<Exercicio> listaExercicio;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Rotina() {
	}

	public Rotina(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
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
		this.listaRefeicao = novoRotina.getListaRefeicao();
		this.listaExercicio = novoRotina.getListaExercicio();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub
	}

}
