package br.edu.ifsc.cds.DTO;

import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.Strategy.ColherCha;
import br.edu.ifsc.cds.classes.domain.Strategy.ColherSopa;
import br.edu.ifsc.cds.classes.domain.Strategy.Copo;
import br.edu.ifsc.cds.classes.domain.Strategy.Unidade;
import br.edu.ifsc.cds.classes.domain.Strategy.UnidadeMedida;
import br.edu.ifsc.cds.classes.domain.Strategy.XicaraCha;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Alimento} para incluir os
 * elementos na interface gráfica
 *
 */
public class AlimentoDTO {
	private Integer id;
	private String nome;
	private Float calorias;
	private Float quantidade;

	/**
	 * Cria um {@link AlimentoDTO } sem adicionar nenhum valor a seus atributos
	 */
	public AlimentoDTO() {

	}

	/**
	 * Cria um {@link AlimentoDTO } adicionando cada um de seus atributos oriundos do {@link Alimento}
	 * 
	 * @param id Número de id do {@link Alimento} que virá do programa
	 * @param nome Nome do {@link Alimento} 
	 * @param calorias Calorias do {@link Alimento}
	 * @param quantidade Quantidade existente do {@link Alimento}
	 */
	public AlimentoDTO(Integer id, String nome, Float calorias, Float quantidade) {
		this.id = id;
		this.nome = nome;
		this.calorias = calorias;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o id do {@link AlimentoDTO}
	 * 
	 * @return Valor do id do {@link AlimentoDTO}
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link AlimentoDTO} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id do AlimentoDTO
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do {@link AlimentoDTO}
	 * 
	 * @return Valor atual do nome do AlimentoDTO
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome do {@link AlimentoDTO} para o novo valor recebido como
	 * parâmetro
	 * 
	 * @param nome Novo nome do AlimentoDTO
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna  as calorias do {@link AlimentoDTO} 
	 * 
	 * @return Valor atual de calorias do AlimentoDTO
	 */
	public Float getCalorias() {
		return calorias;
	}

	/**
	 * Altera o valor das calorias do {@link AlimentoDTO} para o novo valor recebido como
	 * parâmetro
	 * 
	 * @param calorias Novo valor de calorias do AlimentoDTO
	 */
	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}

	/**
	 * Retorna a quantidade de alimentos do {@link AlimentoDTO}
	 * 
	 * @return Valor da quantidade de alimentos do AlimentoDTO específico
	 */
	public Float getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera o valor da quantidade do {@link AlimentoDTO} para o novo valor recebido como 
	 * parâmetro
	 * 
	 * @param quantidade Nova quantidade de alimentos
	 */
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Converte um Alimento em um AlimentoDTO
	 * 
	 * @param alimento Alimento a ser convertido
	 * @return um AlimentoDTO baseado no Alimento dado
	 */
	private AlimentoDTO converteAlimento(Alimento alimento) {
		return new AlimentoDTO(alimento.getId(), alimento.getNome(), alimento.getCaloriaTotal(),
				alimento.getQuantidade());
	}

	/**
	 * Transforma um Alimento não instanciado, em um AlimentoDTO.
	 * 
	 * @param nomeAlimento  Nome do Alimento a ser transformado
	 * @param quantidade    Quantidade relacionada a Unidade de Medida
	 * @param unidadeMedida Unidade de medida que o Alimento será utilizado
	 * @return AlimentoDTO com seus atributos calculados
	 */
	public AlimentoDTO geraAlimentoDTO(String nomeAlimento, Float quantidade, String unidadeMedida) {
		List<Alimento> alimentos = new AlimentoDAO().retrieveAll();
		AlimentoDTO alimentoDTO = new AlimentoDTO();
		// verifica os alimentos presentes no banco até achar um correspondente
		for (Alimento alimento : alimentos) {
			if (nomeAlimento.equals(alimento.getNome())) {
				alimentoDTO = converteAlimento(alimento);
				alimentoDTO.setQuantidade(quantidade);
			}
		}
		// verifica a unidade de medida selecionada pelo usuário e a instancia
		// corretamente
		UnidadeMedida unidade;
		if (unidadeMedida.equals("Unidade")) {
			unidade = new Unidade();
		} else if (unidadeMedida.equals("Copo")) {
			unidade = new Copo();
		} else if (unidadeMedida.equals("Xícara de chá")) {
			unidade = new XicaraCha();
		} else if (unidadeMedida.equals("Colher de Chá")) {
			unidade = new ColherCha();
		} else if (unidadeMedida.equals("Colher de Sopa")) {
			unidade = new ColherSopa();
		} else {
			unidade = null;
		}

		// calcula as calorias totais com base na quantidade e nas calorias do próprio
		// Alimento
		if (unidade != null) {
			alimentoDTO.setCalorias(unidade.Totalcalorias(quantidade, alimentoDTO.getCalorias()));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma unidade de medida!");
			return null;
		}
		return alimentoDTO;

	}

}
