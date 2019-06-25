package br.edu.ifsc.cds.classes.domain.Strategy;

/**
 * 
 * Interface que representa uma unidade de medida e calcula a sua caloria de
 * acordo com o tipo da unidade
 *
 */
public interface UnidadeMedida {

	/**
	 * Calcula o total de calorias existentes, dependendo da unidade de media,
	 * quantidade e as calorias base
	 * 
	 * @param qtd      é a quantidade aquele alimento
	 * @param calorias são as calorias base do alimento
	 * @return o total de colorias do alimento
	 */
	public float Totalcalorias(int qtd, float calorias);
}
