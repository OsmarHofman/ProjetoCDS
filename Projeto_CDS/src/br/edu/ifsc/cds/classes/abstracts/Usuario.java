package br.edu.ifsc.cds.classes.abstracts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Pessoa;

/**
 * 
 * Classe que representa o Usuário, no qual é herdada pelas Classes
 * {@link Admin} e {@link Pessoa}
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
// tabela do Banco de Dados. E a notação @Inheritance indica que a classe possui
// uma relação de herança com outras classes.
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

//	 A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	  banco. E a notação @GeneratedValue indica que o valor será gerado.
//	  automaticamente pelo banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/**
	 * Retorna o valor do id do {@link Usuario}.
	 * 
	 * @return Valor atual do id do Usuario.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link Usuario} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id do Usuario.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do nome do {@link Usuario}.
	 * 
	 * @return Valor atual do nome do Usuario.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome do {@link Usuario} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param nome Novo nome do Usuario.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor do email do {@link Usuario}.
	 * 
	 * @return Valor atual do email do Usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o valor do id do {@link Usuario} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param email Novo email do Usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o valor da senha do {@link Usuario}.
	 * 
	 * @return Valor atual da senha do Usuario.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Altera o valor da senha do {@link Usuario} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param senha Nova senha do Usuario.
	 */
	public void setSenha(String senha) {
		this.senha = senha;
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
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
