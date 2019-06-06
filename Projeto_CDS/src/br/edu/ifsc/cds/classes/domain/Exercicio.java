package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

@Entity
public class Exercicio extends Horario implements AlteracaoDados, Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String intensidade;
	private float met;
	private float gastoCaloria;

	@ManyToOne
	@JoinColumn(name = "rotina_id")
	private Rotina rotina_exercicio;

	@JoinColumn(name = "horario_id")
	@OneToOne
	private Horario horario_ex;

	public Exercicio(Integer id, String nome, String intensidade, float met, float gastoCaloria, Date periodoInicio,
			Date periodoFim, Date diaSemana) {
		super(id, periodoInicio, periodoFim, diaSemana);
		this.nome = nome;
		this.intensidade = intensidade;
		this.met = met;
		this.gastoCaloria = gastoCaloria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
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

	@Override
	public <T> void editarInfo(T classe) {
		Exercicio novoExercicio = (Exercicio) classe;
		this.nome = novoExercicio.getNome();
		this.intensidade = novoExercicio.getIntensidade();
		this.met = novoExercicio.getMet();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
