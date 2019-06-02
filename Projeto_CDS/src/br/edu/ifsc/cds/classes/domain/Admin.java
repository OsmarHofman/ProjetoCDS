package br.edu.ifsc.cds.classes.domain;

import br.edu.ifsc.cds.classes.abstracts.Usuario;

public class Admin extends Usuario {

	private String cpf;
	private String endereco;
	private String telefone;

	public Admin() {
	}

	public Admin(String cpf, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
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

	@Override
	public <T> void editarInfo(T classe) {
		Admin novoAdmin = (Admin) classe;
		this.cpf = novoAdmin.getCpf();
		this.endereco = novoAdmin.getEndereco();
		this.telefone = novoAdmin.getTelefone();

	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub
	}

}
