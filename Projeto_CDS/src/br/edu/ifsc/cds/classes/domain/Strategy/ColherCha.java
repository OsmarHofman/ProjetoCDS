package br.edu.ifsc.cds.classes.domain.Strategy;

public class ColherCha implements UnidadeMedida{

	public ColherCha() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float Totalcalorias(int qtd, float calorias) {
		// TODO Auto-generated method stub
		return (qtd *5) + calorias;
	}

}
