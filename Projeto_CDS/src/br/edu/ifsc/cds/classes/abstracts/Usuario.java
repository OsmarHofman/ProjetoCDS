package br.edu.ifsc.cds.classes.abstracts;

import br.edu.ifsc.cds.classes.interfaces.AlteracaoDados;

public abstract class Usuario implements AlteracaoDados {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	void cadastro(Usuario usuario) {
		// TODO
	}

}
