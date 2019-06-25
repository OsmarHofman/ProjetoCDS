package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Classe que representa a unidade de Medida Xicara de Chá
 *
 *
 */
public class XicaraCha implements UnidadeMedida {

	public XicaraCha() {
	}

	@Override
	public float Totalcalorias(int qtd, float calorias) {
		return (qtd * 200) + calorias;
	}

}
