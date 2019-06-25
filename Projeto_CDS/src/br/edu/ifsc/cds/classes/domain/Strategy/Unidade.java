package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Classe que representa a unidade de Medida Unidade
 *
 */

public class Unidade implements UnidadeMedida {

	@Override
	public float Totalcalorias(int qtd, float calorias) {
		return qtd + calorias;
	}

}
