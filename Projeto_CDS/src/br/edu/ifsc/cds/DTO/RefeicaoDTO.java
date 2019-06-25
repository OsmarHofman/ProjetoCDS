package br.edu.ifsc.cds.DTO;

import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.classes.domain.Refeicao;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Refeicao} para incluir os
 * elementos na interface gráfica
 *
 */
public class RefeicaoDTO {

	private String titulo;
	private String listaAlimento;
	private String quantidade;
	private Date horarioInicio;
	private Date horarioFim;
	private String diaSemana;
	private Float calorias;

	public RefeicaoDTO() {

	}

	public RefeicaoDTO(String titulo, String listaAlimentos, String quantidade, Date horarioInicio, Date horarioFim,
			String diaSemana, Float calorias) {
		this.titulo = titulo;
		this.listaAlimento = listaAlimentos;
		this.quantidade = quantidade;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaSemana = diaSemana;
		this.calorias = calorias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

//	/**
//	 * Converte uma Refeicao em uma RefeicaoDTO
//	 * 
//	 * @param alimento Alimento a ser convertido
//	 * @return um AlimentoDTO baseado no Alimento dado
//	 */
//	private RefeicaoDTO converteAlimento(Refeicao refeicao) {
//		String listaAlimentos = "";
//		String listaQuantidade = "";
//		for (Alimento alimento : refeicao.getListaAlimento()) {
//			listaAlimentos = listaAlimentos + alimento.getNome() + "\n";
//			listaQuantidade = listaQuantidade + alimento.getQuantidade() + "\n";
//		}
//		return new RefeicaoDTO(refeicao.getTitulo(), listaAlimentos, listaQuantidade,
//				refeicao.getHorarioRef().getPeriodoInicio(), refeicao.getHorarioRef().getPeriodoFim(),
//				refeicao.getHorarioRef().getDiaSemana(), refeicao.totalGanhoCalorico(refeicao.getListaAlimento()));
//	}

	/**
	 * A partir dos Alimento na base de dados, cria uma lista observável pelas
	 * {@link TableView}
	 * 
	 */
	public ObservableList<RefeicaoDTO> geraListaRefeicao() {
		List<RefeicaoDTO> refeicao = RotinaController.getListaRefeicao();
		return FXCollections.observableArrayList(refeicao);
	}

}
