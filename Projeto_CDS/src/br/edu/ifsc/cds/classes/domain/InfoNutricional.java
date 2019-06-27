package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * Classe que representa as Informações Nutricionais de um {@link Alimento}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class InfoNutricional implements Serializable {
	private static final long serialVersionUID = 1L;

//	 A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	  banco. E a notação @GeneratedValue indica que o valor será gerado.
//	  automaticamente pelo banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private float caloria;
	private float carboidrato;
	private float proteinas;
	private float gordurasTotais;
	private float gordurasSaturadas;
	private float gordurasTrans;
	private float fibras;
	private float sodio;

//	A notação @OneToOne representa uma relação um para um 
//	com outra tabela, que tem o atributo "infoNutri".
	@OneToOne(mappedBy = "infoNutri")
	private Alimento alimento;

	// Implementação do Padrão Builder
	public static class Builder {
		private Integer id;
		private float caloria = 0;
		private float carboidrato = 0;
		private float proteinas = 0;
		private float gordurasTotais = 0;
		private float gordurasSaturadas = 0;
		private float gordurasTrans = 0;
		private float fibras = 0;
		private float sodio = 0;

		/**
		 * Construtor do objeto através do padrão Builder, inicializando o atributo id
		 * 
		 * @param id Número de Id da informação nutricional
		 */
		public Builder(Integer id) {
			this.id = id;
		}

		/**
		 * Inicializa o atributo caloria a um {@link InfoNutricional}
		 * 
		 * @param cal Quantidade de calorias da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder caloria(float cal) {
			caloria = cal;
			return this;
		}

		/**
		 * Inicializa o atributo carboidrato a um {@link InfoNutricional}
		 * 
		 * @param carb Quantidade de carboidratos da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder carboidrato(float carb) {
			carboidrato = carb;
			return this;
		}

		/**
		 * Inicializa o atributo proteinas a um {@link InfoNutricional}
		 * 
		 * @param prot Quantidade de proteinas da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder proteinas(float prot) {
			proteinas = prot;
			return this;
		}

		/**
		 * Inicializa o atributo gorduras totais a um {@link InfoNutricional}
		 * 
		 * @param gordTot Quantidade de gorduras totais da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder gordurasTotais(float gordTot) {
			gordurasTotais = gordTot;
			return this;
		}

		/**
		 * Inicializa o atributo gorduras saturadas a um {@link InfoNutricional}
		 * 
		 * @param gordSat Quantidade de gorduras saturadas da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder gordurasSaturadas(float gordSat) {
			gordurasSaturadas = gordSat;
			return this;
		}

		/**
		 * Inicializa o atributo gorduras trans a um {@link InfoNutricional}
		 * 
		 * @param gordTran Quantidade de gorduras trans da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder gordurasTrans(float gordTran) {
			gordurasTrans = gordTran;
			return this;
		}

		/**
		 * Inicializa o atributo fibras a um {@link InfoNutricional}
		 * 
		 * @param fib Quantidade de gorduras trans da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder fibras(float fib) {
			fibras = fib;
			return this;
		}

		/**
		 * Inicializa o atributo sodio a um {@link InfoNutricional}
		 * 
		 * @param sod Quantidade de sodio da Informação Nutricional.
		 * @return Um Objeto do tipo Builder
		 */
		public Builder sodio(float sod) {
			sodio = sod;
			return this;
		}

		/**
		 * Retorna uma nova {@link InfoNutricional} a partir dos dados passados ao
		 * Builder
		 * 
		 * @return um objeto InfoNutricional com as informações armazenadas no
		 *         {@link Builder}
		 */
		public InfoNutricional build() {
			return new InfoNutricional(this);
		}
	}
	// Fim da Implementação do Padrão Builder

	/**
	 * Cria um {@link Horario} sem adicionar nenhum valor a seus atributos
	 */
	public InfoNutricional() {
	}

	/**
	 * Cria um {@link InfoNutricional} adicionando cada um de seus atributos através
	 * do {@link Builder}
	 */
	public InfoNutricional(Builder builder) {
		this.id = builder.id;
		this.caloria = builder.caloria;
		this.carboidrato = builder.carboidrato;
		this.proteinas = builder.proteinas;
		this.gordurasTotais = builder.gordurasTotais;
		this.gordurasSaturadas = builder.gordurasSaturadas;
		this.gordurasTrans = builder.gordurasTrans;
		this.fibras = builder.fibras;
		this.sodio = builder.sodio;
	}

	/**
	 * Retorna o valor do id da {@link InfoNutricional}.
	 * 
	 * @return Valor atual do id da Informação Nutricional.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link InfoNutricional} para o novo valor recebido
	 * como parâmetro.
	 * 
	 * @param id Novo id da Informação Nutricional.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do total de calorias {@link InfoNutricional}.
	 * 
	 * @return Valor atual do total de calorias da Informação Nutricional.
	 */
	public float getCaloria() {
		return caloria;
	}

	/**
	 * Altera o valor do total de calorias da {@link InfoNutricional} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param caloria Novo total de calorias da Informação Nutricional.
	 */
	public void setCaloria(float caloria) {
		this.caloria = caloria;
	}

	/**
	 * Retorna o valor dos carboidratos da {@link InfoNutricional}.
	 * 
	 * @return Valor atual dos carboidratos da Informação Nutricional.
	 */
	public float getCarboidrato() {
		return carboidrato;
	}

	/**
	 * Altera o valor do total de carboidratos da {@link InfoNutricional} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param carboidrato Novo valor de carboidratos da Informação Nutricional.
	 */
	public void setCarboidrato(float carboidrato) {
		this.carboidrato = carboidrato;
	}

	/**
	 * Retorna o valor do total de proteinas da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de carboidratos da Informação Nutricional.
	 */
	public float getProteinas() {
		return proteinas;
	}

	/**
	 * Altera o valor do total de proteinas da {@link InfoNutricional} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param proteinas Novo valor de proteinas da Informação Nutricional.
	 */
	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}

	/**
	 * Retorna o valor do total de gorduras totais da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de gorduras totais da Informação Nutricional.
	 */
	public float getGorduras_totais() {
		return gordurasTotais;
	}

	/**
	 * Altera o valor do total de gorduras totais da {@link InfoNutricional} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_totais Novo valor de gorduras totais da Informação
	 *                        Nutricional.
	 */
	public void setGorduras_totais(float gorduras_totais) {
		this.gordurasTotais = gorduras_totais;
	}

	/**
	 * Retorna o valor do total de gorduras saturadas da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de gorduras saturadas da Informação Nutricional.
	 */
	public float getGorduras_saturadas() {
		return gordurasSaturadas;
	}

	/**
	 * Altera o valor do total de gorduras saturadas da {@link InfoNutricional} para
	 * o novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_saturadas Novo valor de gorduras saturadas da Informação
	 *                           Nutricional.
	 */
	public void setGorduras_saturadas(float gorduras_saturadas) {
		this.gordurasSaturadas = gorduras_saturadas;
	}

	/**
	 * Retorna o valor do total de gorduras trans da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de gorduras trans da Informação Nutricional.
	 */
	public float getGorduras_trans() {
		return gordurasTrans;
	}

	/**
	 * Altera o valor do total de gorduras trans da {@link InfoNutricional} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param gorduras_trans Novo valor de gorduras trans da Informação Nutricional.
	 */
	public void setGorduras_trans(float gorduras_trans) {
		this.gordurasTrans = gorduras_trans;
	}

	/**
	 * Retorna o valor do total de fibras da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de fibras da Informação Nutricional.
	 */
	public float getFibras() {
		return fibras;
	}

	/**
	 * Altera o valor do total de fribras da {@link InfoNutricional} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param fibras Novo valor de fibras da Informação Nutricional.
	 */
	public void setFibras(float fibras) {
		this.fibras = fibras;
	}

	/**
	 * Retorna o valor do total de fibras da {@link InfoNutricional}.
	 * 
	 * @return Valor atual de fibras da Informação Nutricional.
	 */
	public float getSodio() {
		return sodio;
	}

	/**
	 * Altera o valor do total de sodio da {@link InfoNutricional} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param sodio Novo valor de sodio da Informação Nutricional.
	 */
	public void setSodio(float sodio) {
		this.sodio = sodio;
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
		if (getClass() != obj.getClass())
			return false;
		InfoNutricional other = (InfoNutricional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
