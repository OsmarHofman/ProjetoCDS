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

	public PessoaDTO() {

	}

	public PessoaDTO(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	/**
	 * gets e sets padrão
	 * 
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

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
