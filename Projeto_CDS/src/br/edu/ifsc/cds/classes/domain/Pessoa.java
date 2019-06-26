package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

/**
 * Classe que representa um Usu�rio comum ao sistema. Herda da Classe
 * {@link Usuario}
 *
 */
@Entity
public class Pessoa extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private float pesoInicial;
	private float altura;

	@JoinColumn(name = "rotina_id")
	@OneToOne
	private Rotina rotina;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String email, String senha, float peso_inicial, float altura,
			Rotina rotina) {
		super(id, nome, email, senha);
		this.pesoInicial = peso_inicial;
		this.altura = altura;
		this.rotina = rotina;
	}
	
	/**
	 * gets e sets padr�o
	 * 
	 */
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

	public Rotina getRotina() {
		return rotina;
	}

	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
	}

}
