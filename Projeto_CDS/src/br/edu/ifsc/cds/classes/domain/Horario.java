package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe que representa o período de início e fim de uma ação
 * 
 *
 */
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Date periodoInicio;
	private Date periodoFim;
	private int diaSemana;

	@OneToOne(mappedBy = "horarioEx")
	private Exercicio exercicio;

	@OneToOne(mappedBy = "horarioRef")
	private Refeicao refeicao;

	public Horario() {

	}

	public Horario(Integer id, Date periodoInicio, Date periodoFim, int diaSemana) {
		super();
		this.id = id;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.diaSemana = diaSemana;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
