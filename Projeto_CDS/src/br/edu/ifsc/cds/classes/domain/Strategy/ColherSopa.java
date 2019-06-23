package br.edu.ifsc.cds.classes.domain.Strategy;

public class ColherSopa implements UnidadeMedida{

	public ColherSopa() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float Totalcalorias(int qtd, float calorias) {
		// TODO Auto-generated method stub
		return (qtd * 10) + calorias;
	}
	
}
