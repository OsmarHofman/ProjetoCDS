package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

	public PessoaDTO convertePessoa(Pessoa pessoa) {
		return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
	}

	public ObservableList<PessoaDTO> geraListaPessoa() {
		List<Pessoa> pessoas = new PessoaDAO().retrieveAll();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		for (Pessoa pessoaLista : pessoas) {
			PessoaDTO dto = new PessoaDTO();
			pessoasDTO.add(dto.convertePessoa(pessoaLista));
		}
		return FXCollections.observableArrayList(pessoasDTO);
	}

}
