package classes;

import abstratas.Usuario;

public class Admin extends Usuario {

	String cpf;
	String endereco;
	String telefone;

	public Admin(String cpf, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.endereco = endereco;
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
