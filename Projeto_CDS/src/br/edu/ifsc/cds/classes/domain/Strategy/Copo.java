package br.edu.ifsc.cds.classes.domain.Strategy;

public class Copo implements UnidadeMedida{
	
	public Copo() {
		
	}
	
	public float Totalcalorias(int qtd, float calorias) {
		// TODO Auto-generated method stub
		return  (qtd * 200) + calorias;
	}

}
