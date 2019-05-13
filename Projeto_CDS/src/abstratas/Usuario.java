package abstratas;

import interfaces.AlteracaoDados;

public abstract class Usuario implements AlteracaoDados {
	int id;
	String nome;
	String email;
	String senha;

	void cadastro(Usuario usuario) {
		// TODO
	}

}
