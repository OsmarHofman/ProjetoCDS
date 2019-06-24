package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

/**
 * 
 * Classe que Representa um Usuário Administrador. Herdada da classe
 * {@link Usuario}
 *
 */
@Entity
public class Admin extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String endereco;
	private String telefone;

	public Admin() {
	}

	public Admin(Integer id, String nome, String email, String senha, String cpf, String endereco, String telefone) {
		super(id, nome, email, senha);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
