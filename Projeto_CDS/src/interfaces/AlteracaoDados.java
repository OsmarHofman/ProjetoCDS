package interfaces;

public interface AlteracaoDados {
	
	<T> void editarInfo(T classe);

	void excluirInfo();
}
