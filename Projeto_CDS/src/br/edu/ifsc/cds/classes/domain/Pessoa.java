package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

/**
 * Classe que representa um Usuário comum ao sistema. Herda da Classe
 * {@link Usuario}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Pessoa extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private float pesoInicial;
	private float altura;

//	A notação @JoinColumn representa uma atributo "info_nutri_id" que realiza a
//	junção com outra tabela. A notação @OneToOne representa uma relação um para um 
//	com outra tabela.
	@JoinColumn(name = "rotina_id")
	@OneToOne
	private Rotina rotina;

	/**
	 * Cria uma {@link Pessoa} sem adicionar nenhum valor a seus atributos
	 */
	public Pessoa() {
	}

	/**
	 * Cria um {@link Pessoa} adicionando cada um de seus atributos
	 * 
	 * @param id           Número de id do Pessoa
	 * @param nome         Nome do Pessoa
	 * @param email        Email do Pessoa
	 * @param senha        Senha do Pessoa
	 * @param peso_inicial Peso da Pessoa
	 * @param altura       Altura da Pessoa
	 * @param rotina       Rotina da Pessoa
	 */
	public Pessoa(Integer id, String nome, String email, String senha, float peso_inicial, float altura,
			Rotina rotina) {
		super(id, nome, email, senha);
		this.pesoInicial = peso_inicial;
		this.altura = altura;
		this.rotina = rotina;
	}

	/**
	 * Retorna o valor do peso da {@link Pessoa}.
	 * 
	 * @return Valor atual do peso da Pessoa.
	 */
	public float getPeso_inicial() {
		return pesoInicial;
	}

	/**
	 * Altera o valor do peso da {@link Pessoa} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param peso_inicial Novo peso da Pessoa.
	 */
	public void setPeso_inicial(float peso_inicial) {
		this.pesoInicial = peso_inicial;
	}

	/**
	 * Retorna o valor d altura da {@link Pessoa}.
	 * 
	 * @return Valor atual da altura da Pessoa.
	 */
	public float getAltura() {
		return altura;
	}

	/**
	 * Altera o valor da altura da {@link Pessoa} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param altura Nova altura da Pessoa.
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}

	/**
	 * Retorna a {@link Rotina} da {@link Pessoa}.
	 * 
	 * @return Valor atual da rotina da Pessoa.
	 */
	public Rotina getRotina() {
		return rotina;
	}

	/**
	 * Altera o valor da {@link Rotina} da {@link Pessoa} para o novo valor recebido
	 * como parâmetro.
	 * 
	 * @param rotina Nova rotina da Pessoa.
	 */
	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
	}

}
