package br.edu.ifsc.cds.DTO;

import java.util.Date;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.classes.domain.Exercicio;

public class ExercicioDTO {
	
	private Integer id;
	private String nome;
	private Float calorias;
	private Date inicio;
	private Date fim;
	
	public ExercicioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ExercicioDTO(Integer id, String nome, Float calorias, Date inicio, Date fim) {
		this.id = id;
		this.nome = nome;
		this.calorias = calorias;
		this.inicio = inicio;
		this.fim = fim;
	}


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
	public Float getCalorias() {
		return calorias;
	}
	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
	public ExercicioDTO geraExercicioDTO(String nomeExercicio,Date inicio, Date fim) {
		Exercicio exercicio = new ExercicioDAO().retrieveDadosExer(nomeExercicio);
		ExercicioDTO exercicioDTO = new ExercicioDTO(exercicio.getId(),exercicio.getNome(),exercicio.getGastoCaloria(),inicio,fim);
		return exercicioDTO;
	}

}
