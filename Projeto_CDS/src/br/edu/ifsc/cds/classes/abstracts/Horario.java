package br.edu.ifsc.cds.classes.abstracts;

import java.util.Date;

public abstract class Horario {
	private Date periodoInicio;
	private Date periodoFim;
	private Date diaSemana;

	public Horario() {

	}

	public Horario(Date periodoInicio, Date periodoFim, Date diaSemana) {
		super();
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.diaSemana = diaSemana;
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

	public Date getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Date diaSemana) {
		this.diaSemana = diaSemana;
	}

}
