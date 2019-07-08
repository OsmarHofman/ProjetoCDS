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

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Classe que representa um Exercício dentro de uma {@link Rotina} e que contém
 * um {@link Horario}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

//	A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	banco. E a notação @GeneratedValue indica que o valor será gerado.
//	automaticamente pelo banco.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float met;
	private float gastoCaloria;

//	A notação @ManyToMany e @JoinTable representa uma relação muitos para muitos 
//  e a junção com a tabela Rotina, a qual cria uma nova tabela intermediária 
//	chamada "Exercicio_Rotina" que liga as duas tabelas.
	@ManyToMany
	@JoinTable(name = "Exercicio_Rotina", joinColumns = @JoinColumn(name = "exercicio_id"), inverseJoinColumns = @JoinColumn(name = "rotina_id"))
	private List<Rotina> listaExRotina = new ArrayList<>();

//	A notação @JoinColumn representa uma atributo "horario_id" que realiza a
//	junção com outra tabela. A notação @OneToOne representa uma relação um para um 
//	com outra tabela.
	@JoinColumn(name = "horario_id")
	@OneToOne
	private Horario horarioEx;

	/**
	 * Cria um {@link Exercicio} sem adicionar nenhum valor a seus atributos
	 */
	public Exercicio() {
	}

	/**
	 * Cria um {@link Exercicio} adicionando cada um de seus atributos
	 * 
	 * @param id           Número de id do Exercicio
	 * @param nome         Nome do Exercicio
	 * @param met          Valor de Met do Exercicio
	 * @param gastoCaloria Número do gasto calórico total do Exercicio
	 * @param horario      Horario que o Exercicio sera realizado
	 */
	public Exercicio(Integer id, String nome, float met, float gastoCaloria, Horario horario) {
		this.id = id;
		this.nome = nome;
		this.met = met;
		this.gastoCaloria = gastoCaloria;
		this.horarioEx = horario;
	}

	/**
	 * Retorna o valor do id do {@link Exercicio}.
	 * 
	 * @return Valor atual do id do Exercicio.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link Exercicio} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id do Exercicio.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do nome do {@link Exercicio}.
	 * 
	 * @return Valor atual do nome do Exercicio.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome do {@link Exercicio} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param nome Novo nome do Alimento.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor da met do {@link Exercicio}.
	 * 
	 * @return Valor atual da met do Exercicio.
	 */
	public float getMet() {
		return met;
	}

	/**
	 * Altera o valor da met do {@link Exercicio} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param met Nova met do Exercicio.
	 */
	public void setMet(float met) {
		this.met = met;
	}

	/**
	 * Retorna o valor do gasto total de calorias do {@link Exercicio}.
	 * 
	 * @return Valor atual do gasto total de calorias do Exercicio.
	 */
	public float getGastoCaloria() {
		return gastoCaloria;
	}

	/**
	 * Altera o valor do gasto total de calorias do {@link Exercicio} para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param gastoCaloria Novo valor do gasto total de calorias do Alimento.
	 */
	public void setGastoCaloria(float gastoCaloria) {
		this.gastoCaloria = gastoCaloria;
	}

	/**
	 * Retorna o valor do {@link Horario} do {@link Exercicio}.
	 * 
	 * @return Valor atual do Horario do Exercicio.
	 */
	public Horario getHorarioEx() {
		return horarioEx;
	}

	/**
	 * Altera o valor do {@link Horario} do {@link Exercicio} para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param horarioEx Novo Horario do Alimento.
	 */
	public void setHorarioEx(Horario horarioEx) {
		this.horarioEx = horarioEx;
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
		if (!(obj instanceof Exercicio))
			return false;
		Exercicio other = (Exercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Gera uma {@link ObservableList} para inserção nas tabelas, dos nomes dos
	 * exercícios presentes no banco de dados
	 * 
	 * @return ObservableList com o nome de todos os exercícios do sistema
	 */
	public ObservableList<String> geraListaExercicio() {
		List<Exercicio> exercicios = new ExercicioDAO().retrieveAll();
		List<String> nomes = new ArrayList<>();
		for (Exercicio exercicio : exercicios) {
			nomes.add(exercicio.getNome());
		}
		return FXCollections.observableArrayList(nomes);
	}

}
