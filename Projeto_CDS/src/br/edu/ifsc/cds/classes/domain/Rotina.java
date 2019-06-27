package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Rotina que pode conter {@link Refeicao} e {@link Exercicio}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Rotina implements Serializable {
	private static final long serialVersionUID = 1L;

//	A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	banco. E a notação @GeneratedValue indica que o valor será gerado.
//	automaticamente pelo banco.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

//	A notação @ManyToMany representa uma relação muitos para muitos, 
//  que foi referenciada pelo atributo "listaRefRotina"
	@ManyToMany(mappedBy = "listaRefRotina")
	private List<Refeicao> listaRefeicao;

//	A notação @ManyToMany representa uma relação muitos para muitos, 
//  que foi referenciada pelo atributo "listaExRotina"
	@ManyToMany(mappedBy = "listaExRotina")
	private List<Exercicio> listaExercicio;

//  A notação @OneToOne representa uma relação um para um 
//	com outra tabela, e referenciada pelo atributo "rotina"
	@OneToOne(mappedBy = "rotina")
	private Pessoa pessoa;

	/**
	 * Cria uma {@link Rotina} sem adicionar nenhum valor a seus atributos
	 */
	public Rotina() {
	}

	/**
	 * Cria um {@link Rotina} adicionando cada um de seus atributos
	 * 
	 * @param id     Número de Id da Rotina
	 * @param titulo Titulo da Rotina
	 */
	public Rotina(Integer id, String titulo, List<Refeicao> listaRefeicao, List<Exercicio> listaExercicio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.listaRefeicao = listaRefeicao;
		this.listaExercicio = listaExercicio;
	}

	/**
	 * Retorna o valor do id da {@link Rotina}.
	 * 
	 * @return Valor atual do id da Rotina.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id da {@link Rotina} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id da Rotina.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do titulo da {@link Rotina}.
	 * 
	 * @return Valor atual do titulo da Rotina.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Altera o valor do titulo da {@link Rotina} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param titulo Novo titulo da Rotina.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna o valor da {@link List} de {@link Refeicao} da {@link Rotina}.
	 * 
	 * @return Valor atual da lista de refeicoes da Rotina.
	 */
	public List<Refeicao> getListaRefeicao() {
		return listaRefeicao;
	}

	/**
	 * Altera o valor da {@link List} de {@link Refeicao} da {@link Rotina} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param listaRefeicao Nova lista de refeicoes da Rotina.
	 */
	public void setListaRefeicao(List<Refeicao> listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	/**
	 * Retorna o valor da {@link List} de {@link Exercicio} da {@link Rotina}.
	 * 
	 * @return Valor atual da lista de exercicios da Rotina.
	 */
	public List<Exercicio> getListaExercicio() {
		return listaExercicio;
	}

	/**
	 * Altera o valor da {@link List} de {@link Exercicio} da {@link Rotina} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param listaExercicio Nova lista de exercicios da Rotina.
	 */
	public void setListaExercicio(List<Exercicio> listaExercicio) {
		this.listaExercicio = listaExercicio;
	}

}
