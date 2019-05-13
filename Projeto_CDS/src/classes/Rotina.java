package classes;

import java.util.List;

import interfaces.AlteracaoDados;

public class Rotina implements AlteracaoDados {
	private String titulo;
	private List<String> listaDias;
	private List<Refeicao> listaRefeicao;
	private List<AtividadeFisica> listaAtividade;

	public Rotina(String titulo, List<String> listaDias, List<Refeicao> listaRefeicao,
			List<AtividadeFisica> listaAtividade) {

		super();
		this.titulo = titulo;
		this.listaDias = listaDias;
		this.listaRefeicao = listaRefeicao;
		this.listaAtividade = listaAtividade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getListaDias() {
		return listaDias;
	}

	public void setListaDias(List<String> listaDias) {
		this.listaDias = listaDias;
	}

	public List<Refeicao> getListaRefeicao() {
		return listaRefeicao;
	}

	public void setListaRefeicao(List<Refeicao> listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	public List<AtividadeFisica> getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(List<AtividadeFisica> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}

	@Override
	public <T> void editarInfo(T classe) {
		Rotina novoRotina = (Rotina) classe;
		this.titulo = novoRotina.getTitulo();
		this.listaDias = novoRotina.getListaDias();
		this.listaRefeicao = novoRotina.getListaRefeicao();
		this.listaAtividade = novoRotina.getListaAtividade();
		
	}

	@Override
	public void excluirInfo() {
		// TODO Auto-generated method stub
	}

}
