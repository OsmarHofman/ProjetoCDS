package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float quantidade;
	private String unidadeMedida;
	private float caloriaTotal;

	@JoinColumn(name = "info_nutri_id")
	@OneToOne(cascade = CascadeType.ALL)
	private InfoNutricional infoNutri;

	@ManyToMany
	@JoinTable(name = "Alimento_Refeicao", joinColumns = @JoinColumn(name = "alimento_id"), inverseJoinColumns = @JoinColumn(name = "refeicao_id"))
	private List<Refeicao> listaRefeicao = new ArrayList<>();

	public Alimento() {
	}

	public Alimento(Integer id, String nome, float quantidade, String unidade_medida, InfoNutricional infoNutri,
			float caloriaTotal) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidade_medida;
		this.infoNutri = infoNutri;
		this.caloriaTotal = caloriaTotal;
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

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public InfoNutricional getInfoNutri() {
		return infoNutri;
	}

	public void setInfoNutri(InfoNutricional infoNutri) {
		this.infoNutri = infoNutri;
	}

	public List<Refeicao> getListaRefeicao() {
		return listaRefeicao;
	}

	public void setListaRefeicao(List<Refeicao> listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	public float getCaloriaTotal() {
		return caloriaTotal;
	}

	public void setCaloriaTotal(float quantidade, String unidade_medida, float caloriasInfo) {
		if (unidade_medida.equals("Unidade")) {
			this.caloriaTotal = quantidade + caloriasInfo;
		} else if (unidade_medida.equals("Xicara de chá")) {
			this.caloriaTotal = quantidade * 200 + caloriasInfo;
		} else if (unidade_medida.equals("Copo")) {
			this.caloriaTotal = quantidade * 200 + caloriasInfo;
		} else if (unidade_medida.equals("Colher de Sopa")) {
			this.caloriaTotal = quantidade * 10 + caloriasInfo;
		} else if (unidade_medida.equals("Colher de chá")) {
			this.caloriaTotal = quantidade * 5 + caloriasInfo;
		} else {
			this.caloriaTotal = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alimento))
			return false;
		Alimento other = (Alimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
