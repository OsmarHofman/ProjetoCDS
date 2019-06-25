package br.edu.ifsc.cds.DTO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Alimento} para incluir os
 * elementos na interface gráfica
 *
 */
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

	/**
	 * Converte um Alimento em um AlimentoDTO
	 * 
	 * @param alimento Alimento a ser convertido
	 * @return um AlimentoDTO baseado no Alimento dado
	 */
	public AlimentoDTO converteAlimento(Alimento alimento) {
		return new AlimentoDTO(alimento.getId(), alimento.getNome(), alimento.getCaloriaTotal());
	}

	/**
	 * A partir dos Alimento na base de dados, cria uma lista observável pelas
	 * {@link TableView}
	 * 
	 */
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
