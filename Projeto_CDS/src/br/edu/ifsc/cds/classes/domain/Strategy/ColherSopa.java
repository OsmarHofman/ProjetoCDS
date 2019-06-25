package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Classe que representa a unidade de Medida Colher de Sopa
 *
 */
public class ColherSopa implements UnidadeMedida {

	public ColherSopa() {
	}

	@Override
	public float Totalcalorias(float qtd, float calorias) {
		return (qtd * 10) + calorias;
	}

}
