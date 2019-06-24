package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlimentoDTO {
	private Integer id;
	private String nome;
	private Float calorias;

	public AlimentoDTO() {

	}

	public AlimentoDTO(Integer id, String nome, Float calorias) {
		this.id = id;
		this.nome = nome;
		this.calorias = calorias;
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

	public Float getCalorias() {
		return calorias;
	}

	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}

	public AlimentoDTO converteAlimento(Alimento alimento) {
		return new AlimentoDTO(alimento.getId(), alimento.getNome(), alimento.getCaloriaTotal());
	}

	public ObservableList<AlimentoDTO> geraListaAlimento() {
		List<Alimento> alimentos = new AlimentoDAO().retrieveAll();
		List<AlimentoDTO> alimentosDTO = new ArrayList<>();
		for (Alimento alimentoLista : alimentos) {
			AlimentoDTO dto = new AlimentoDTO();
			alimentosDTO.add(dto.converteAlimento(alimentoLista));
		}
		return FXCollections.observableArrayList(alimentosDTO);
	}

}
