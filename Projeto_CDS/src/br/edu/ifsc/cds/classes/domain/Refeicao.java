package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Classe que representa uma Refeicao dentro de uma {@link Rotina} que contém
 * {@link Alimento} e um {@link Horario}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Refeicao implements Serializable {
	private static final long serialVersionUID = 1L;

//	A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	banco. E a notação @GeneratedValue indica que o valor será gerado.
//	automaticamente pelo banco.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

//	A notação @ManyToMany e @JoinTable representa uma relação muitos para muitos 
//  e a junção com a tabela Rotina, a qual cria uma nova tabela intermediária 
//	chamada "Refeicao_Rotina" que liga as duas tabelas.
	@ManyToMany
	@JoinTable(name = "Refeicao_Rotina", joinColumns = @JoinColumn(name = "refeicao_id"), inverseJoinColumns = @JoinColumn(name = "rotina_id"))
	private List<Rotina> listaRefRotina = new ArrayList<>();

//	A notação @JoinTable representa uma junção com a tabela Rotina, a qual cria uma
//	nova tabela intermediária e que foi referenciada pelo atributo "listaRefeicao".
	@ManyToMany(mappedBy = "listaRefeicao")
	private List<Alimento> listaAlimento = new ArrayList<>();

//	A notação @JoinColumn representa uma atributo "horarioId" que realiza a
//	junção com outra tabela. A notação @OneToOne representa uma relação um para um 
//	com outra tabela.
	@JoinColumn(name = "horarioId")
	@OneToOne
	private Horario horarioRef;

	/**
	 * Cria uma {@link Refeicao} sem adicionar nenhum valor a seus atributos
	 */
	public Refeicao() {
	}

	/**
	 * Cria um {@link Refeicao} adicionando cada um de seus atributos
	 * 
	 * @param id             Número de id da Refeicao
	 * @param titulo         Título da Refeicao
	 * @param listaAlimentos {@link List} de {@link Alimento} presentes na refeicao
	 * @param horario        {@link Horario} que acontecerá a refeicao
	 */
	public Refeicao(Integer id, String titulo, List<Alimento> listaAlimentos, Horario horario) {
		this.id = id;
		this.titulo = titulo;
		this.listaAlimento = listaAlimentos;
		this.horarioRef = horario;
	}

	/**
	 * Retorna o valor do id da {@link Refeicao}.
	 * 
	 * @return Valor atual do id da Refeicao.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id da {@link Refeicao} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id da Refeicao.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do titulo da {@link Refeicao}.
	 * 
	 * @return Valor atual do titulo da Refeicao.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Altera o valor do titulo da {@link Refeicao} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param titulo Novo titulo da Refeicao.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna o valor da {@link List} de {@link Alimento} da {@link Refeicao}.
	 * 
	 * @return Valor atual da lista de alimentos da Refeicao.
	 */
	public ArrayList<Alimento> getListaAlimento() {
		return (ArrayList<Alimento>) listaAlimento;
	}

	/**
	 * Altera o valor da {@link List} de {@link Alimento} da {@link Refeicao} para o
	 * novo valor recebido como parâmetro.
	 * 
	 * @param listaAlimento Nova lista de alimentos da Refeicao.
	 */
	public void setListaAlimento(List<Alimento> listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	/**
	 * Retorna o valor do horario da {@link Refeicao}.
	 * 
	 * @return Valor atual do horario da Refeicao.
	 */
	public Horario getHorarioRef() {
		return horarioRef;
	}

	/**
	 * Altera o valor do {@link Horario} da {@link Refeicao} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param horarioRed Novo Horario da Refeicao.
	 */
	public void setHorarioRef(Horario horarioRef) {
		this.horarioRef = horarioRef;
	}

	/**
	 * Calcula o total de calorias da {@link Refeicao} a patir de uma {@link List}
	 * de {@link Alimento}
	 * 
	 * @param alimentos Lista de alimentos da refeicao
	 * @return total de calorias presente em uma refeicao
	 */
	public float totalGanhoCalorico(ArrayList<Alimento> alimentos) {
		float total = 0;
		for (Alimento ali : alimentos) {
			total += ali.getInfoNutri().getCaloria();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Refeicao))
			return false;
		Refeicao other = (Refeicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
