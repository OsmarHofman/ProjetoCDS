package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Classe que representa uma Refeicao dentro de uma {@link Rotina} que contém
 * {@link Alimento} e um {@link Horario}
 *
 */
@Entity
public class Refeicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

	@ManyToMany
	@JoinTable(name = "Refeicao_Rotina", joinColumns = @JoinColumn(name = "refeicao_id"), inverseJoinColumns = @JoinColumn(name = "rotina_id"))
	private List<Rotina> listaRefRotina = new ArrayList<>();

	@ManyToMany(mappedBy = "listaRefeicao")
	private List<Alimento> listaAlimento = new ArrayList<>();

	@JoinColumn(name = "horarioId")
	@OneToOne
	private Horario horarioRef;

	public Refeicao() {
	}

	public Refeicao(Integer id, String titulo, List<Alimento> listaAlimentos, Horario horario) {
		this.id = id;
		this.titulo = titulo;
		this.listaAlimento = listaAlimentos;
		this.horarioRef = horario;
	}
	
	/**
	 * gets e sets padrão
	 * 
	 */

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

	public List<Rotina> getListaRefRotina() {
		return listaRefRotina;
	}

	public void setListaRefRotina(List<Rotina> listaRefRotina) {
		this.listaRefRotina = listaRefRotina;
	}

	public ArrayList<Alimento> getListaAlimento() {
		return (ArrayList<Alimento>) listaAlimento;
	}

	public void setListaAlimento(List<Alimento> listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	public Horario getHorarioRef() {
		return horarioRef;
	}

	public void setHorarioRef(Horario horarioRef) {
		this.horarioRef = horarioRef;
	}

	// Metodos
	public float totalGanhoCalorico(ArrayList<Alimento> alimentos) {
		float total = 0;
		for (Alimento ali : alimentos) {
			total += ali.getInfoNutri().getCaloria();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Refeicao))
			return false;
		Refeicao other = (Refeicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
