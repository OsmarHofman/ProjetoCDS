package br.edu.ifsc.cds.classes.domain.Strategy;

public class Unidade implements UnidadeMedida{

	@Override
	public float Totalcalorias(int qtd, float calorias) {
		// TODO Auto-generated method stub
		return qtd + calorias;
	}

}
