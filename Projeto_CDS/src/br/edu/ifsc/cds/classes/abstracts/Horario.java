package br.edu.ifsc.cds.classes.abstracts;

import java.util.Date;

public abstract class Horario {
	Date periodoInicio;
	Date periodoFim;
	Date diaSemana;

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
