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

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Classe que representa um Exercício dentro de uma {@link Rotina} e que contém
 * um {@link Horario}
 *
 */
@Entity
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float met;
	private float gastoCaloria;

	@ManyToMany
	@JoinTable(name = "Exercicio_Rotina", joinColumns = @JoinColumn(name = "exercicio_id"), inverseJoinColumns = @JoinColumn(name = "rotina_id"))
	private List<Rotina> listaExRotina = new ArrayList<>();

	@JoinColumn(name = "horario_id")
	@OneToOne
	private Horario horarioEx;

	public Exercicio() {

	}

	public Exercicio(Integer id, String nome, float met, float gastoCaloria, Horario horario) {
		this.id = id;
		this.nome = nome;
		this.met = met;
		this.gastoCaloria = gastoCaloria;
		this.horarioEx = horario;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMet() {
		return met;
	}

	public void setMet(float met) {
		this.met = met;
	}

	public float getGastoCaloria() {
		return gastoCaloria;
	}

	public void setGastoCaloria(float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	public List<Rotina> getListaExRotina() {
		return listaExRotina;
	}

	public void setListaExRotina(List<Rotina> listaExRotina) {
		this.listaExRotina = listaExRotina;
	}

	public Horario getHorarioEx() {
		return horarioEx;
	}

	public void setHorarioEx(Horario horarioEx) {
		this.horarioEx = horarioEx;
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
		if (!(obj instanceof Exercicio))
			return false;
		Exercicio other = (Exercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ObservableList<String> geraListaExercicio() {
		List<Exercicio> exercicios = new ExercicioDAO().retrieveAll();
		List<String> nomes = new ArrayList<>();
		for (Exercicio exercicio : exercicios) {
			nomes.add(exercicio.getNome());
		}
		return FXCollections.observableArrayList(nomes);
	}

}
