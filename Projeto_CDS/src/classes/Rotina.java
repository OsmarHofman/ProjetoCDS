package classes;

import java.util.List;

import interfaces.AlteracaoDados;

public class Rotina implements AlteracaoDados {

	private int id;
	private String titulo;
	private List<String> listaDias;
	private Refeicao listaRefeicao;
	private AtividadeFisica listaAtividade;

	public Rotina() {
	}

	public Rotina(int id, String titulo, List<String> listaDias, Refeicao listaRefeicao,
			AtividadeFisica listaAtividade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.listaDias = listaDias;
		this.listaRefeicao = listaRefeicao;
		this.listaAtividade = listaAtividade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Refeicao getListaRefeicao() {
		return listaRefeicao;
	}

	public void setListaRefeicao(Refeicao listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	public AtividadeFisica getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(AtividadeFisica listaAtividade) {
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
