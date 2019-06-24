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
@Entity
public class InfoNutricional implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private float caloriasInfo;

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
		private float totalCalorias = 0;

		public Builder(Integer id) {
			this.id = id;
		}

		public Builder caloria(float cal) {
			caloria = cal;
			return this;
		}

		public Builder carboidrato(float carb) {
			carboidrato = carb;
			return this;
		}

		public Builder proteinas(float prot) {
			proteinas = prot;
			return this;
		}

		public Builder gordurasTotais(float gordTot) {
			gordurasTotais = gordTot;
			return this;
		}

		public Builder gordurasSaturadas(float gordSat) {
			gordurasSaturadas = gordSat;
			return this;
		}

		public Builder gordurasTrans(float gordTran) {
			gordurasTrans = gordTran;
			return this;
		}

		public Builder fibras(float fib) {
			fibras = fib;
			return this;
		}

		public Builder sodio(float sod) {
			sodio = sod;
			return this;
		}

		public Builder totalCalorias(float totCal) {
			totalCalorias = totCal;
			return this;
		}

		public InfoNutricional build() {
			return new InfoNutricional(this);
		}
	}
	// Fim da Implementação do Padrão Builder

	public InfoNutricional() {
	}

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
		this.caloriasInfo = builder.totalCalorias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public float getGorduras_totais() {
		return gordurasTotais;
	}

	public void setGorduras_totais(float gorduras_totais) {
		this.gordurasTotais = gorduras_totais;
	}

	public float getGorduras_saturadas() {
		return gordurasSaturadas;
	}

	public void setGorduras_saturadas(float gorduras_saturadas) {
		this.gordurasSaturadas = gorduras_saturadas;
	}

	public float getGorduras_trans() {
		return gordurasTrans;
	}

	public void setGorduras_trans(float gorduras_trans) {
		this.gordurasTrans = gorduras_trans;
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

	public float getCaloriasInfo() {
		return caloriasInfo;
	}

	public void setCaloriasInfo(float caloriasInfo) {
		this.caloriasInfo = caloriasInfo;
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

	@Override
	public String toString() {
		return "InfoNutricional [id=" + id + ", caloria=" + caloria + ", carboidrato=" + carboidrato + ", proteinas="
				+ proteinas + ", gordurasTotais=" + gordurasTotais + ", gordurasSaturadas=" + gordurasSaturadas
				+ ", gordurasTrans=" + gordurasTrans + ", fibras=" + fibras + ", sodio=" + sodio + ", alimento="
				+ alimento + "]";
	}

}
