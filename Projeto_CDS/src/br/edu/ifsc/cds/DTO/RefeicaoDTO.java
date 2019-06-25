package br.edu.ifsc.cds.DTO;

import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.frames.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RefeicaoDTO {

	private String listaAlimento;
	private Float quantidade;
	private String unidadeMedida;
	private Date horarioInicio;
	private Date horarioFim;
	private String diaSemana;
	private Float calorias;

	public RefeicaoDTO() {

	}

	public RefeicaoDTO(String listaAlimentos, Float quantidade, String unidadeMedida, Date horarioInicio,
			Date horarioFim, String diaSemana, Float calorias) {

		this.listaAlimento = listaAlimentos;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaSemana = diaSemana;
		this.calorias = calorias;
	}

	public String getListaAlimento() {
		return listaAlimento;
	}

	public void setListaAlimento(String listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	public Float getCalorias() {
		return calorias;
	}

	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public ObservableList<RefeicaoDTO> geraListaRefeicao() {
		List<RefeicaoDTO> lista = RotinaController.getListaRefeicao();
		return FXCollections.observableArrayList(lista);
	}

}
