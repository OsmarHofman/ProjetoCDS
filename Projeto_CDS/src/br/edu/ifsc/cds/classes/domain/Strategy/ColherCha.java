package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Classe que representa a unidade de Medida Colher de Chá
 *
 */
public class ColherCha implements UnidadeMedida {

	public ColherCha() {
	}

	@Override
	public float Totalcalorias(int qtd, float calorias) {
		return (qtd * 5) + calorias;
	}

}
