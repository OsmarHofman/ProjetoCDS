package br.edu.ifsc.cds.classes.domain;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public class InfoNutricional implements AlteracaoDados {

	private int id;
	private float caloria;
	private float carboidrato;
	private float proteinas;
	private float gorduras_totais;
	private float gorduras_saturadas;
	private float gorduras_trans;
	private float fibras;
	private float sodio;
	private float totalCalorias;

	public InfoNutricional() {
	}

	public InfoNutricional(int id, float caloria, float carboidrato, float proteinas, float gorduras_totais,
			float gorduras_saturadas, float gorduras_trans, float fibras, float sodio, float totalCalorias) {
		this.id = id;
		this.caloria = caloria;
		this.carboidrato = carboidrato;
		this.proteinas = proteinas;
		this.gorduras_totais = gorduras_totais;
		this.gorduras_saturadas = gorduras_saturadas;
		this.gorduras_trans = gorduras_trans;
		this.fibras = fibras;
		this.sodio = sodio;
		this.totalCalorias = totalCalorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return gorduras_totais;
	}

	public void setGorduras_totais(float gorduras_totais) {
		this.gorduras_totais = gorduras_totais;
	}

	public float getGorduras_saturadas() {
		return gorduras_saturadas;
	}

	public void setGorduras_saturadas(float gorduras_saturadas) {
		this.gorduras_saturadas = gorduras_saturadas;
	}

	public float getGorduras_trans() {
		return gorduras_trans;
	}

	public void setGorduras_trans(float gorduras_trans) {
		this.gorduras_trans = gorduras_trans;
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
	public <T> void editarInfo(T classe) {
		InfoNutricional novoInfo = (InfoNutricional) classe;
		this.caloria = novoInfo.getCaloria();
		this.carboidrato = novoInfo.getCarboidrato();
		this.proteinas = novoInfo.getProteinas();
		this.gorduras_totais = novoInfo.getGorduras_totais();
		this.gorduras_saturadas = novoInfo.getGorduras_saturadas();
		this.gorduras_trans = novoInfo.getGorduras_trans();
		this.fibras = novoInfo.getFibras();
		this.sodio = novoInfo.getSodio();
		this.totalCalorias = novoInfo.getTotalCalorias();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
