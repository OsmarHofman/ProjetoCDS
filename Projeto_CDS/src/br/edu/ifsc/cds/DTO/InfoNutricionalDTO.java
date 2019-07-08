package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.services.AlimentoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Alimento} para incluir os
 * elementos na interface gráfica
 *
 */
public class InfoNutricionalDTO {
	private Integer id;
	private String nome;
	private float caloria;
	private float carboidrato;
	private float proteinas;
	private float gordurasTotais;
	private float gordurasSaturadas;
	private float gordurasTrans;
	private float fibras;
	private float sodio;

	/**
	 * Cria uma {@link InfoNutricionalDTO} sem adicionar valores aos seus parâmetros 
	 */
	public InfoNutricionalDTO() {

	}

	/**
	 * Cria uma {@link InfoNutricionalDTO} adicionando valores a todos os seus atributos
	 * 
	 * @param id Valor do id da {@link InfoNutricionalDTO}
	 * @param nome Nome do alimento respectivo da {@link InfoNutricionalDTO}
	 * @param caloria Valor das Calorias da {@link InfoNutricionalDTO}
	 * @param carboidrato Valor dos Carboidratos da {@link InfoNutricionalDTO}
	 * @param proteinas Valor das proteinas da {@link InfoNutricionalDTO}
	 * @param gordurasTotais Valor das gorduras totais da {@link InfoNutricionalDTO}
	 * @param gordurasSaturadas Valor das gorduras saturadas da {@link InfoNutricionalDTO}
	 * @param gordurasTrans Valor das gorduras saturadas da {@link InfoNutricionalDTO}
	 * @param fibras Valor das fibras da {@link InfoNutricionalDTO}
	 * @param sodio Valor do sódio da {@link InfoNutricionalDTO}
	 */
	public InfoNutricionalDTO(Integer id, String nome, float caloria, float carboidrato, float proteinas,
			float gordurasTotais, float gordurasSaturadas, float gordurasTrans, float fibras, float sodio) {
		super();
		this.id = id;
		this.nome = nome;
		this.caloria = caloria;
		this.carboidrato = carboidrato;
		this.proteinas = proteinas;
		this.gordurasTotais = gordurasTotais;
		this.gordurasSaturadas = gordurasSaturadas;
		this.gordurasTrans = gordurasTrans;
		this.fibras = fibras;
		this.sodio = sodio;
	}


	/**
	 * Retorna o valor do id da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual do id da InformaçãoNutricionalDTO.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link InfoNutricionalDTO} para o novo valor recebido
	 * como parâmetro.
	 * 
	 * @param id Novo id da InfoNutricionalDTO.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do alimentos respectivo da {@link InfoNutricionalDTO}
	 * 
	 * @return Nome do alimento da InfoNutricionalDTO
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do alimento respctivo da {@link InfoNutricionalDTO} para o novo valor recebido como
	 * parâmetro
	 * 
	 * @param nome Novo nome do alimento da respectiva InfoNutricionalDTO
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor do total de calorias {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual do total de calorias da InfoNutricionalDTO.
	 */
	public float getCaloria() {
		return caloria;
	}

	/**
	 * Altera o valor do total de calorias da {@link InfoNutricionalDTO} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param caloria Novo total de calorias da InfoNutricionalDTO.
	 */
	public void setCaloria(float caloria) {
		this.caloria = caloria;
	}

	/**
	 * Retorna o valor dos carboidratos da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual dos carboidratos da InfoNutricionalDTO.
	 */
	public float getCarboidrato() {
		return carboidrato;
	}

	/**
	 * Altera o valor do total de carboidratos da {@link InfoNutricionalDTO} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param carboidrato Novo valor de carboidratos da InfoNutricionalDTO.
	 */
	public void setCarboidrato(float carboidrato) {
		this.carboidrato = carboidrato;
	}

	/**
	 * Retorna o valor do total de proteinas da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de carboidratos da InfoNutricionalDTO.
	 */
	public float getProteinas() {
		return proteinas;
	}

	/**
	 * Altera o valor do total de proteinas da {@link InfoNutricionalDTO} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param proteinas Novo valor de proteinas da InfoNutricionalDTO.
	 */
	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}

	/**
	 * Retorna o valor do total de gorduras totais da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de gorduras totais da InfoNutricionalDTO.
	 */
	public float getGordurasTotais() {
		return gordurasTotais;
	}

	/**
	 * Altera o valor do total de gorduras totais da {@link InfoNutricionalDTO} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_totais Novo valor de gorduras totais da Informação
	 *                        Nutricional.
	 */
	public void setGordurasTotais(float gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	/**
	 * Retorna o valor do total de gorduras saturadas da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de gorduras saturadas da InfoNutricionalDTO.
	 */
	public float getGordurasSaturadas() {
		return gordurasSaturadas;
	}

	/**
	 * Altera o valor do total de gorduras saturadas da {@link InfoNutricionalDTO} para
	 * o novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_saturadas Novo valor de gorduras saturadas da Informação
	 *                           Nutricional.
	 */
	public void setGordurasSaturadas(float gordurasSaturadas) {
		this.gordurasSaturadas = gordurasSaturadas;
	}

	/**
	 * Retorna o valor do total de gorduras trans da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de gorduras trans da InfoNutricionalDTO.
	 */
	public float getGordurasTrans() {
		return gordurasTrans;
	}

	/**
	 * Altera o valor do total de gorduras trans da {@link InfoNutricionalDTO} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_trans Novo valor de gorduras trans da InfoNutricionalDTO.
	 */
	public void setGordurasTrans(float gordurasTrans) {
		this.gordurasTrans = gordurasTrans;
	}

	/**
	 * Retorna o valor do total de fibras da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de fibras da InfoNutricionalDTO.
	 */
	public float getFibras() {
		return fibras;
	}

	/**
	 * Altera o valor do total de fribras da {@link InfoNutricionalDTO} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param fibras Novo valor de fibras da InfoNutricionalDTO.
	 */
	public void setFibras(float fibras) {
		this.fibras = fibras;
	}

	/**
	 * Retorna o valor do total de fibras da {@link InfoNutricionalDTO}.
	 * 
	 * @return Valor atual de fibras da InfoNutricionalDTO.
	 */
	public float getSodio() {
		return sodio;
	}

	/**
	 * Altera o valor do total de sodio da {@link InfoNutricionalDTO} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param sodio Novo valor de sodio da InfoNutricionalDTO.
	 */
	public void setSodio(float sodio) {
		this.sodio = sodio;
	}

	/**
	 * Converte um Alimento em um AlimentoDTO
	 * 
	 * @param alimento Alimento a ser convertido
	 * @return um AlimentoDTO baseado no Alimento dado
	 */
	private InfoNutricionalDTO converteInfo(Alimento alimento) {
		return new InfoNutricionalDTO(alimento.getId(), alimento.getNome(), alimento.getInfoNutri().getCaloria(),
				alimento.getInfoNutri().getCarboidrato(), alimento.getInfoNutri().getProteinas(),
				alimento.getInfoNutri().getGorduras_totais(), alimento.getInfoNutri().getGorduras_saturadas(),
				alimento.getInfoNutri().getGorduras_trans(), alimento.getInfoNutri().getFibras(),
				alimento.getInfoNutri().getSodio());
	}

	/**
	 * Transforma um Alimento não instanciado, em um InfoNutricionalDTO.
	 * 
	 * @return InfoNutricionalDTO com seus atributos
	 */
	public ObservableList<InfoNutricionalDTO> geraInfoDTO() {
		AlimentoService service = new AlimentoService();
		List<Alimento> alimentos = service.retornaTodos();
		List<InfoNutricionalDTO> infoDTO = new ArrayList<>();
		// verifica os alimentos presentes no banco até achar um correspondente
		for (Alimento alimento : alimentos) {
			infoDTO.add(converteInfo(alimento));

		}
		return FXCollections.observableArrayList(infoDTO);

	}

}
