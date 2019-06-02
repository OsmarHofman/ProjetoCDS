package br.edu.ifsc.cds.classes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

@Entity
public class Alimento implements AlteracaoDados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float quantidade;
	private String unidade_medida;
	private InfoNutricional info_nutri;

	@ManyToOne
	@JoinColumn(name = "refeicao_id")
	private Refeicao refeicao;

	public Alimento() {
	}

	public Alimento(Integer id, String nome, float quantidade, String unidade_medida, InfoNutricional info_nutri) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade_medida = unidade_medida;
		this.info_nutri = info_nutri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public <T> void editarInfo(T classe) {
		Alimento novoAlimento = (Alimento) classe;
		this.info_nutri = novoAlimento.getInfo_nutri();
		this.nome = novoAlimento.getNome();
		this.quantidade = novoAlimento.getQuantidade();
		this.unidade_medida = novoAlimento.getUnidade_medida();
	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub

	}

}
