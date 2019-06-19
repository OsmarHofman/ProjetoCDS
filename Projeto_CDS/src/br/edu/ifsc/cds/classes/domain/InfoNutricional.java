package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private float totalCalorias;

	@OneToOne(mappedBy = "infoNutri")
	private Alimento alimento;

	public InfoNutricional() {
	}

	public InfoNutricional(Integer id, float caloria, float carboidrato, float proteinas, float gorduras_totais,
			float gorduras_saturadas, float gorduras_trans, float fibras, float sodio, float totalCalorias) {
		this.id = id;
		this.caloria = caloria;
		this.carboidrato = carboidrato;
		this.proteinas = proteinas;
		this.gordurasTotais = gorduras_totais;
		this.gordurasSaturadas = gorduras_saturadas;
		this.gordurasTrans = gorduras_trans;
		this.fibras = fibras;
		this.sodio = sodio;
		this.totalCalorias = totalCalorias;
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

	public float getTotalCalorias() {
		return totalCalorias;
	}

	public void setTotalCalorias(float totalCalorias) {
		this.totalCalorias = totalCalorias;
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
