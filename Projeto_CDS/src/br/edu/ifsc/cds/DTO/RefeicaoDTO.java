package br.edu.ifsc.cds.DTO;

import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.classes.domain.Alimento;
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
	private String unidadeMedida;
	private Date horarioInicio;
	private Date horarioFim;
	private String diaSemana;
	private Float calorias;

	/**
	 * Cria um {@link RefeicaoDTO} sem adicionar valores aos seus atributos
	 */
	public RefeicaoDTO() {

	}

	/**
	 * 
	 * @param titulo         Título da RefeicaoDTO.
	 * @param listaAlimentos {@link List} de {@link Alimento} presentes na refeicao.
	 * @param unidadeMedida  Unidade de medida(kg,g..etc) da refeicaoDTO.
	 * @param quantidade     Quantidade da RefeicaoDTO.
	 * @param horarioInicio  Horário de início da RefeicaoDTO.
	 * @param horarioFim     Horário de Fim da RefeicaoDTO.
	 * @param diaSemana      Dia especíco da semana em que a Refeicao vai se
	 *                       encontrar.
	 * @param calorias       Calorias totais da RefeicaoDTO.
	 */
	public RefeicaoDTO(String titulo, String listaAlimentos, String unidadeMedida, String quantidade,
			Date horarioInicio, Date horarioFim, String diaSemana, Float calorias) {
		this.titulo = titulo;
		this.listaAlimento = listaAlimentos;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaSemana = diaSemana;
		this.calorias = calorias;
	}

	/**
	 * Retorna o valor do titulo da {@link Refeicao}.
	 * 
	 * @return Valor atual do titulo da Refeicao.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Altera o valor do titulo da {@link RefeicaoDTO} para o novo valor recebido
	 * como parâmetro.
	 * 
	 * @param titulo Novo titulo da RefeicaoDTO.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna o valor da {@link List} de {@link Alimento} da {@link RefeicaoDTO}.
	 * 
	 * @return Valor atual da lista de alimentos da RefeicaoDTO.
	 */
	public String getListaAlimento() {
		return listaAlimento;
	}

	/**
	 * Altera o valor da {@link List} de {@link Alimento} da {@link RefeicaoDTO}
	 * para o novo valor recebido como parâmetro.
	 * 
	 * @param listaAlimento Nova lista de alimentos da RefeicaoDTO.
	 */
	public void setListaAlimento(String listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	/**
	 * Retorna as calorias totais da {@link RefeicaoDTO}.
	 * 
	 * @return Quantidade de calorias ganhas.
	 */
	public Float getCalorias() {
		return calorias;
	}

	/**
	 * Altera as calorias totais da {@link RefeicaoDTO} para o novo valor repassado
	 * como parâmetro.
	 * 
	 * @param calorias Valor total das calorias da RefeicaoDTO.
	 */
	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}

	/**
	 * Retorna o horário de início da {@link RefeicaoDTO}.
	 * 
	 * @return Horário de início da RefeicaoDTO.
	 */
	public Date getHorarioInicio() {
		return horarioInicio;
	}

	/**
	 * Altera o horário de início da {@link RefeicaoDTO} para o novo valor repassado
	 * como parâmetro.
	 * 
	 * @param horarioInicio Novo valor de início da RefeicaoDTO.
	 */
	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	/**
	 * Retorna o horário de fim da {@link RefeicaoDTO}.
	 * 
	 * @return Horário de fim da RefeicaoDTO.
	 */
	public Date getHorarioFim() {
		return horarioFim;
	}

	/**
	 * Altera o horário de término da {@link RefeicaoDTO} para o novo valor
	 * repassado como parâmetro.
	 * 
	 * @param horarioFim Novo horário de término da RefeicaoDTO.
	 */
	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	/**
	 * Retorna a quantidade da {@link RefeicaoDTO}
	 * 
	 * @return Valor da quantidade da RefeicaoDTO
	 */
	public String getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a quantidade da {@link RefeicaoDTO} para o novo valor repassado como
	 * parâmetro.
	 * 
	 * @param quantidade Nova quantidade da RefeicaoDTO.
	 */
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna a Unidade de Medida da {@link RefeicaoDTO}
	 * 
	 * @return Tipo da Unidade de Medida da RefeicaoDTO.
	 */
	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * Altera o tipo de Unidade de Medida da {@link RefeicaoDTO} para o novo valor repassado como
	 * parâmetro.
	 * 
	 * @param unidadeMedida Nova Unidade de Medida da RefeicaoDTO.
	 */
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	/**
	 * Retorna o dia da semana onde a {@link RefeicaoDTO} se encontra
	 * 
	 * @return Dia da semana da RefeicaoDTO
	 */
	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * Altera o dia da semana da {@link RefeicaoDTO} para o novo valor repassado como
	 * parâmetro.
	 * 
	 * @param diaSemana Novo dia da semana da RefeicaoDTO
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * A partir dos Alimento na base de dados, cria uma lista observável pelas
	 * {@link TableView}
	 * 
	 */
	public ObservableList<RefeicaoDTO> geraListaRefeicao() {
		List<RefeicaoDTO> refeicao = RotinaController.getListaRefeicao();
		return FXCollections.observableArrayList(refeicao);
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

}
