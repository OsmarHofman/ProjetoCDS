package br.edu.ifsc.cds.classes.domain.Strategy;

public class XicaraCha implements UnidadeMedida{

	public XicaraCha() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float Totalcalorias(int qtd, float calorias) {
		// TODO Auto-generated method stub
		return (qtd * 200) + calorias;
	}

}
