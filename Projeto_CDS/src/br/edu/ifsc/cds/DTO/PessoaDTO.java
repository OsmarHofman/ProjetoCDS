package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.services.PessoaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Pessoa} para incluir os
 * elementos na interface gráfica
 *
 */
public class PessoaDTO {
	private Integer id;
	private String nome;
	private String email;

	/**
	 * Cria uma {@link PessoaDTO} sem adicionar valores aos seus atributos
	 */
	public PessoaDTO() {

	}

	/**
	 * Cria um {@link PessoaDTO} adicionando cada um de seus atributos
	 * 
	 * @param id           Número de id da {@link PessoaDTO}
	 * @param nome         Nome da {@link PessoaDTO}
	 * @param email        Email da {@link PessoaDTO}
	 */
	public PessoaDTO(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	/**
	 * Retorna o valor do id do {@link PessoaDTO}.
	 * 
	 * @return Valor atual do id da PessoaDTO.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link PessoaDTO} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param id Novo id do PessoaDTO.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do nome do {@link PessoaDTO}.
	 * 
	 * @return Valor atual do nome do PessoaDTO.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o valor do nome do {@link PessoaDTO} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param nome Novo nome do PessoaDTO.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor do email do {@link PessoaDTO}.
	 * 
	 * @return Valor atual do email do PessoaDTO.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o valor do id do {@link PessoaDTO} para o novo valor recebido como
	 * parâmetro.
	 * 
	 * @param email Novo email do PessoaDTO.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Converte uma Pessoa em uma PessoaDTO
	 * 
	 * @param pessoa Pessoa a ser convertido
	 * @return uma PessoaDTO baseado na pessoa dado
	 */
	public PessoaDTO convertePessoa(Pessoa pessoa) {
		return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
	}

	/**
	 * A partir de Pessoa na base de dados, cria uma lista observável pelas
	 * {@link TableView}
	 * 
	 */
	public ObservableList<PessoaDTO> geraListaPessoa() {
		PessoaService service = new PessoaService();
		List<Pessoa> pessoas = service.retornaTodos();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		for (Pessoa pessoaLista : pessoas) {
			PessoaDTO dto = new PessoaDTO();
			pessoasDTO.add(dto.convertePessoa(pessoaLista));
		}
		return FXCollections.observableArrayList(pessoasDTO);
	}

}
