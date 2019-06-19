package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

@Entity
public class Pessoa extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private float pesoInicial;
	private float altura;

	@OneToMany(mappedBy = "pessoa")
	private List<Rotina> listaRotinas;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String email, String senha, float peso_inicial, float altura) {
		super(id, nome, email, senha);
		this.pesoInicial = peso_inicial;
		this.altura = altura;
	}

	public float getPeso_inicial() {
		return pesoInicial;
	}

	public void setPeso_inicial(float peso_inicial) {
		this.pesoInicial = peso_inicial;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public List<Rotina> getListaRotinas() {
		return listaRotinas;
	}

	public void setListaRotinas(List<Rotina> listaRotinas) {
		this.listaRotinas = listaRotinas;
	}

}
