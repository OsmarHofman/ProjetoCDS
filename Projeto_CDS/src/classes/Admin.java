package classes;

import abstratas.Usuario;

public class Admin extends Usuario {

	private String cpf;
	private String endereco;
	private String telefone;

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
	public void editarInfo() {
		// TODO Auto-generated method stub
	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub
	}
	

}
