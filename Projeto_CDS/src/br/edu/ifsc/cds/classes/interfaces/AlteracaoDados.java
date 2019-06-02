package br.edu.ifsc.cds.classes.interfaces;

public interface AlteracaoDados {
	
	<T> void editarInfo(T classe);

	void excluirInfo();
}
