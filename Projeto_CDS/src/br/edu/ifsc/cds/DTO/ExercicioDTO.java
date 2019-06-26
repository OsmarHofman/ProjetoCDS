package br.edu.ifsc.cds.DTO;

import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExercicioDTO {

	private String tituloEx;
	private Float caloriasEx;
	private Date inicioEx;
	private Date fimEx;

	public ExercicioDTO() {
		// TODO Auto-generated constructor stub
	}

	public ExercicioDTO(String tituloEx, Float caloriasEx, Date inicioEx, Date fimEx) {
		super();
		this.tituloEx = tituloEx;
		this.caloriasEx = caloriasEx;
		this.inicioEx = inicioEx;
		this.fimEx = fimEx;
	}

	public String getTituloEx() {
		return tituloEx;
	}

	public void setTituloEx(String tituloEx) {
		this.tituloEx = tituloEx;
	}

	public Float getCaloriasEx() {
		return caloriasEx;
	}

	public void setCaloriasEx(Float caloriasEx) {
		this.caloriasEx = caloriasEx;
	}

	public Date getInicioEx() {
		return inicioEx;
	}

	public void setInicioEx(Date inicioEx) {
		this.inicioEx = inicioEx;
	}

	public Date getFimEx() {
		return fimEx;
	}

	public void setFimEx(Date fimEx) {
		this.fimEx = fimEx;
	}

	public ObservableList<ExercicioDTO> geraExercicioDTO() {
		List<ExercicioDTO> exercicio = RotinaController.getListaExercicio();
		return FXCollections.observableArrayList(exercicio);
	}

}
