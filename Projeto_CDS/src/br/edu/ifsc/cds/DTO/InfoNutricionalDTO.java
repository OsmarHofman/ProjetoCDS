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

	public InfoNutricionalDTO() {

	}

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
	 * gets e sets padrão
	 * 
	 */

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

	public float getCaloria() {
		return caloria;
	}

	public void setCaloria(float caloria) {
		this.caloria = caloria;
	}

	public float getCarboidrato() {
		return carboidrato;
	}

	public void setCarboidrato(float carboidrato) {
		this.carboidrato = carboidrato;
	}

	public float getProteinas() {
		return proteinas;
	}

	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}

	public float getGordurasTotais() {
		return gordurasTotais;
	}

	public void setGordurasTotais(float gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	public float getGordurasSaturadas() {
		return gordurasSaturadas;
	}

	public void setGordurasSaturadas(float gordurasSaturadas) {
		this.gordurasSaturadas = gordurasSaturadas;
	}

	public float getGordurasTrans() {
		return gordurasTrans;
	}

	public void setGordurasTrans(float gordurasTrans) {
		this.gordurasTrans = gordurasTrans;
	}

	public float getFibras() {
		return fibras;
	}

	public void setFibras(float fibras) {
		this.fibras = fibras;
	}

	public float getSodio() {
		return sodio;
	}

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
