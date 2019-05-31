package classes;

public class DadosPessoa {

	private int id;
	private String nome;
	private float peso_inicial;
	private float altura;

	public DadosPessoa() {
	}

	public DadosPessoa(int id, String nome, float peso_inicial, float altura) {
		this.id = id;
		this.nome = nome;
		this.peso_inicial = peso_inicial;
		this.altura = altura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso_inicial() {
		return peso_inicial;
	}

	public void setPeso_inicial(float peso_inicial) {
		this.peso_inicial = peso_inicial;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

}
