package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Classe que representa a unidade de Medida Copo
 *
 */

public class Copo implements UnidadeMedida {

	public Copo() {

	}

	public float Totalcalorias(int qtd, float calorias) {
		return (qtd * 200) + calorias;
	}

}
