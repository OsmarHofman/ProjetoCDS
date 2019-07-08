package br.edu.ifsc.cds.DTO;

import java.util.Date;
import java.util.List;

import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Objeto de Transferência de Dados da classe {@link Exercicio} para incluir os
 * elementos na interface gráfica
 *
 */
public class ExercicioDTO {

	private String tituloEx;
	private Float caloriasEx;
	private Date inicioEx;
	private Date fimEx;

	/**
	 * Cria um {@link ExercicioDTO} sem adicionar nenhum valor aos seus atributos
	 */
	public ExercicioDTO() {
	}

	/**
	 * Cria um {@link ExercicioDTO} adicionando valores a todos os seus atributos
	 * 
	 * @param tituloEx   Título do {@link ExercicioDTO}
	 * @param caloriasEx Calorias do {@link ExercicioDTO}
	 * @param inicioEx   Início do {@link ExercicioDTO}
	 * @param fimEx      Fim do {@link ExercicioDTO}
	 */
	public ExercicioDTO(String tituloEx, Float caloriasEx, Date inicioEx, Date fimEx) {
		super();
		this.tituloEx = tituloEx;
		this.caloriasEx = caloriasEx;
		this.inicioEx = inicioEx;
		this.fimEx = fimEx;
	}

	/**
	 * Retorna o título do {@link ExercicioDTO}
	 * 
	 * @return Valor do título do ExercicioDTO
	 */
	public String getTituloEx() {
		return tituloEx;
	}

	/**
	 * Altera o valor do título do {@link ExercicioDTO} para o novo valor recebido como parâmetro
	 * 
	 * @param tituloEx Novo título do ExercicioDTO
	 */
	public void setTituloEx(String tituloEx) {
		this.tituloEx = tituloEx;
	}

	/**
	 * Retorna o valor do gasto calorico total do {@link ExercicioDTO} 
	 * 
	 * @return Valor das calorias gastas do {@link ExercicioDTO}
	 */
	public Float getCaloriasEx() {
		return caloriasEx;
	}

	/**
	 * Altera o valor das calorias gastas do {@link ExercicioDTO} para o novo valor recebido como 
	 * parâmetro
	 * 
	 * @param caloriasEx Nova caloria total gasta do ExercicioDTO
	 */
	public void setCaloriasEx(Float caloriasEx) {
		this.caloriasEx = caloriasEx;
	}

	/**
	 * Retorna o período de Início do {@link ExercicioDTO}
	 * 
	 * @return Horario de início do @link ExercicioDTO
	 */
	public Date getInicioEx() {
		return inicioEx;
	}

	/**
	 * Altera o período de início do {@link ExercicioDTO} para o novo valor passado como
	 * parâmetro
	 * 
	 * @param inicioEx Novo valor de início do @link ExercicioDTO
	 */
	public void setInicioEx(Date inicioEx) {
		this.inicioEx = inicioEx;
	}

	/**
	 * Retorna o período de fim do {@link ExercicioDTO}
	 * 
	 * @return Horario de término do ExercicioDTO
	 */
	public Date getFimEx() {
		return fimEx;
	}

	/**
	 * Altera o período de fim do {@link ExercicioDTO}
	 * 
	 * @param fimEx Novo valor de termino do @link ExercicioDTO
	 */
	public void setFimEx(Date fimEx) {
		this.fimEx = fimEx;
	}

	/**
	 * Transforma um Exercicio, em um ExercicioDTO.
	 * 
	 * @return ExercicioDTO com ses atributos calculados
	 */

	public ObservableList<ExercicioDTO> geraExercicioDTO() {
		List<ExercicioDTO> exercicio = RotinaController.getListaExercicio();
		return FXCollections.observableArrayList(exercicio);
	}

}
