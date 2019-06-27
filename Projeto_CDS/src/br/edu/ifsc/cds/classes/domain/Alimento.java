package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Classe que representa um Alimento que pode estar presente em uma
 * {@link Refeicao} e que contém {@link InfoNutricional}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;

//	A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	banco. E a notação @GeneratedValue indica que o valor será gerado.
//	automaticamente pelo banco.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float quantidade;
	private String unidadeMedida;
	private float caloriaTotal;

//	A notação @JoinColumn representa uma atributo "info_nutri_id" que realiza a
//	junção com outra tabela. A notação @OneToOne representa uma relação um para um 
//	com outra tabela, a qual caso seja deletada, realiza uma deleção em cascata.
	@JoinColumn(name = "info_nutri_id")
	@OneToOne(cascade = CascadeType.ALL)
	private InfoNutricional infoNutri;

//	A notação @ManyToMany e @JoinTable representa uma relação muitos para muitos 
//  e a junção com a tabela Refeicao, a qual cria uma nova tabela intermediária 
//	chamada "Alimento_Refeicao" que liga as duas tabelas.
	@ManyToMany
	@JoinTable(name = "Alimento_Refeicao", joinColumns = @JoinColumn(name = "alimento_id"), inverseJoinColumns = @JoinColumn(name = "refeicao_id"))
	private List<Refeicao> listaRefeicao = new ArrayList<>();

	/**
	 * Cria um {@link Alimento} sem adicionar nenhum valor a seus atributos
	 */
	public Alimento() {
	}

	/**
	 * Cria um {@link Alimento} adicionando cada um de seus atributos
	 * 
	 * @param id             Número de id do Alimento
	 * @param nome           Nome do Alimento
	 * @param quantidade     Quantidade do Alimento
	 * @param unidade_medida Unidade de medida do Alimento
	 * @param infoNutri      Informação Nutricional do Alimento
	 * @param caloriaTotal   Número total de calorias do Alimento
	 */
	public Alimento(Integer id, String nome, float quantidade, String unidade_medida, InfoNutricional infoNutri,
			float caloriaTotal) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidade_medida;
		this.infoNutri = infoNutri;
		this.caloriaTotal = infoNutri.getCaloria();
	}

	/**
	 * Retorna o valor do id da {@link Alimento}.
	 * 
	 * @return Valor atual do id do Alimento.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link Alimento} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id do Alimento.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do nome do {@link Alimento}.
	 * 
	 * @return Valor atual do nome do Alimento.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome do {@link Alimento} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param nome Novo nome do Alimento.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor da quantidade do {@link Alimento}.
	 * 
	 * @return Valor atual da quantidade do Alimento.
	 */
	public float getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera o valor da quantidade do {@link Alimento} para o novo valor recebido
	 * como parâmetro.
	 * 
	 * @param quantidade Nova quantidade do Alimento.
	 */
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o valor da unidade de medida do {@link Alimento}.
	 * 
	 * @return Valor atual da unidade de medida do Alimento.
	 */
	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * Altera o valor da unidadeMedida do {@link Alimento} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param unidadeMedida Nova unidade de medida do Alimento.
	 */
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	/**
	 * Retorna o valor da informação nutricional da classe {@link Alimento}.
	 * 
	 * @return Valor atual da informação nutricional do Alimento.
	 */
	public InfoNutricional getInfoNutri() {
		return infoNutri;
	}

	/**
	 * Altera o valor da informação nutricional do {@link Alimento} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param infoNutri Nova informação nutricional do Alimento.
	 */
	public void setInfoNutri(InfoNutricional infoNutri) {
		this.infoNutri = infoNutri;
	}

	/**
	 * Retorna o valor do total de calorias do {@link Alimento}.
	 * 
	 * @return Valor atual do total de calorias do Alimento.
	 */
	public float getCaloriaTotal() {
		return caloriaTotal;
	}

	/**
	 * Altera o valor do total de calorias do {@link Alimento} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param total Novo total de calorias do Alimento.
	 */
	public void setCaloriaTotal(float total) {
		this.caloriaTotal = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alimento))
			return false;
		Alimento other = (Alimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
