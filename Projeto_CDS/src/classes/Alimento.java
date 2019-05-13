package classes;

import interfaces.AlteracaoDados;

public class Alimento implements AlteracaoDados {

	private String nome;
	private float quantidade;
	private String unidade_medida;
	private InfoNutricional info_nutri;

	public Alimento(String nome, float quantidade, String unidade_medida, InfoNutricional info_nutri) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade_medida = unidade_medida;
		this.info_nutri = info_nutri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

	public InfoNutricional getInfo_nutri() {
		return info_nutri;
	}

	public void setInfo_nutri(InfoNutricional info_nutri) {
		this.info_nutri = info_nutri;
	}

	public void addNovoAlimento(Alimento alimento, InfoNutricional info) {
		// TODO
	}


	@Override
	public void editarInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

	



}
