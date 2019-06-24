package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.DAO.RefeicaoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.Refeicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RefeicaoDTO {
	private String titulo;
	private List<String> listaAlimento;
	private Float calorias;
	private Date horarioInicio;
	private Date horarioFim;

	public RefeicaoDTO() {

	}

	public RefeicaoDTO(String titulo, List<String> listaAlimentos, Float calorias, Date horarioInicio,
			Date horarioFim) {
		this.titulo = titulo;
		this.listaAlimento = listaAlimentos;
		this.calorias = calorias;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getListaAlimento() {
		return listaAlimento;
	}

	public void setListaAlimento(List<String> listaAlimento) {
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

	public RefeicaoDTO converteRefeicao(Refeicao refeicao) {
		List<String> nomeAlimentos = new ArrayList<>();
		for (Alimento alimento : refeicao.getListaAlimento()) {
			nomeAlimentos.add(alimento.getNome());
		}
		return new RefeicaoDTO(refeicao.getTitulo(), nomeAlimentos,
				refeicao.totalGanhoCalorico(refeicao.getListaAlimento()), refeicao.getHorarioRef().getPeriodoInicio(),
				refeicao.getHorarioRef().getPeriodoInicio());
	}

	public ObservableList<RefeicaoDTO> geraListRefeicao() {
		List<Refeicao> refeicoes = new RefeicaoDAO().retrieveAll();
		List<RefeicaoDTO> refeicoesDTO = new ArrayList<>();
		for (Refeicao refeicaoLista : refeicoes) {
			RefeicaoDTO dto = new RefeicaoDTO();
			refeicoesDTO.add(dto.converteRefeicao(refeicaoLista));
		}
		return FXCollections.observableArrayList(refeicoesDTO);
	}

}
