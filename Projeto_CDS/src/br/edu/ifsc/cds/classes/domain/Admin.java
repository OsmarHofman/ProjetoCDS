package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

/**
 * 
 * Classe que Representa um Usuário Administrador. Herdada da classe
 * {@link Usuario}.
 *
 */

// A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
// tabela do Banco de Dados.
@Entity
public class Admin extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String endereco;
	private String telefone;

	/**
	 * Cria um {@link Admin} sem adicionar nenhum valor a seus atributos
	 */
	public Admin() {
	}

	/**
	 * Cria um {@link Admin} adicionando cada um de seus atributos
	 * 
	 * @param id       Número de id do Admin
	 * @param nome     Nome do Admin
	 * @param email    Email do Admin
	 * @param senha    Senha do Admin
	 * @param cpf      Número de CPF do Admin
	 * @param endereco Endereco do Admin
	 * @param telefone Telefone do Admin
	 */
	public Admin(Integer id, String nome, String email, String senha, String cpf, String endereco, String telefone) {
		super(id, nome, email, senha);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	/**
	 * Retorna o valor do cpf do {@link Admin}.
	 * 
	 * @return Valor atual do cpf do Admin.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Altera o valor do cpf do {@link Admin} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param cpf Novo cpf do Usuario.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o valor atual do endereco do {@link Admin}.
	 * 
	 * @return Valor atual do endereco do Admin.
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Altera o valor do endereco do {@link Admin} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param endereco Novo endereco do Usuario.
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o valor do telefone do {@link Admin}.
	 * 
	 * @return Valor atual do telefone do Admin.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Altera o valor do telefone do {@link Admin} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param telefone Novo telefone do Usuario.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
