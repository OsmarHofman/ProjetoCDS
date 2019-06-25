package br.edu.ifsc.cds.classes.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DTO.RefeicaoDTO;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;

/**
 * Classe que representa o per�odo de in�cio e fim de uma a��o
 * 
 *
 */
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Date periodoInicio;
	private Date periodoFim;
	private String diaSemana;

	@OneToOne(mappedBy = "horarioEx")
	private Exercicio exercicio;

	@OneToOne(mappedBy = "horarioRef")
	private Refeicao refeicao;

	public Horario() {

	}

	public Horario(Integer id, Date periodoInicio, Date periodoFim, String diaSemana) {
		super();
		this.id = id;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.diaSemana = diaSemana;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Verifica se o horario pretendido est� dispon�vel. Tamb�m verifica se o
	 * per�odo de fim est� antes do per�odo de inicio.
	 * 
	 * @param inicio    Horario que a Refeicao ir� come�ar
	 * @param fim       Horario que a Refeicao ir� terminar
	 * @param diaSemana Dia da semana que acontecer� o Exercicio ou Refeicao
	 * @return true se o hor�rio est� vago, ou false se o hor�rio estiver ocupado
	 */
	public boolean verificaRefeicaoHorario(Date inicio, Date fim, String diaSemana) {
		if (inicio.before(fim)) {
			new RotinaController();

			// for das itera��es da lista de Refeicoes
			for (RefeicaoDTO refeicao : RotinaController.getListaRefeicao()) {

				// verifica se o dia da semana que foi inserido � o mesmo que de alguma refeicao
				if (refeicao.getDiaSemana().equals(diaSemana)) {

					// verifica se o inicio da Refeicao est� num horario j� ocupado
					if (inicio.after(refeicao.getHorarioInicio()) && inicio.before(refeicao.getHorarioFim())) {
						// caso estiver ocupado, retorna falso
						return false;
					}

					// verifica se o fim da Refeicao est� num horario j� ocupado
					if (fim.after(refeicao.getHorarioInicio()) && fim.before(refeicao.getHorarioFim())) {
						// caso estiver ocupado, retorna falso
						return false;
					}
				}

			}
			// caso nao estiver ocupado, retorna verdadeiro
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Fim n�o pode ser antes do Inicio");
			return false;
		}
	}

}
