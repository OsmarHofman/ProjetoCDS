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
 * Classe que representa o per�odo de in�cio, fim (formato de hora:minuto) e o
 * dia da semana (Segunda-feira, Ter�a-Feira, etc.) de uma a��o
 * 
 *
 */

//A nota��o @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

//	A nota��o @Id indica que o atributo {@link #id} ser� uma chave prim�ria no
//	banco.
	@Id
	private Integer id;
	private Date periodoInicio;
	private Date periodoFim;
	private String diaSemana;

//	A nota��o @OneToOne representa uma rela��o um para um 
//	com outra tabela, que tem o atributo "horarioEx".
	@OneToOne(mappedBy = "horarioEx")
	private Exercicio exercicio;

//	A nota��o @OneToOne representa uma rela��o um para um 
//	com outra tabela, que tem o atributo "horarioRef".
	@OneToOne(mappedBy = "horarioRef")
	private Refeicao refeicao;

	/**
	 * Cria um {@link Horario} sem adicionar nenhum valor a seus atributos
	 */
	public Horario() {

	}

	/**
	 * Cria um {@link Horario} adicionando cada um de seus atributos
	 * 
	 * @param id            N�mero do id do Hor�rio
	 * @param periodoInicio Hora e minuto de inicio da a��o, no formato Date
	 * @param periodoFim    Hora e minuto do fim da a��o, no formato Date
	 * @param diaSemana     Nome do dia da Semana da a��o
	 */
	public Horario(Integer id, Date periodoInicio, Date periodoFim, String diaSemana) {
		super();
		this.id = id;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.diaSemana = diaSemana;
	}

	/**
	 * Retorna o valor do id do {@link Horario}.
	 * 
	 * @return Valor atual do id do Horario.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do id do {@link Horario} para o novo valor recebido como
	 * par�metro.
	 * 
	 * @param id Novo id do Horario.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do periodo de inicio (Horas e Minutos - HH:mm) de alguma
	 * a��o.
	 * 
	 * @return Valor atual do Horario de inicio da a��o.
	 */
	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	/**
	 * Altera o valor do periodo de inicio do {@link Horario}, para o novo valor
	 * recebido como par�metro.
	 * 
	 * @param periodoInicio Novo periodo de inicio do Horario.
	 */
	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	/**
	 * Retorna o valor do periodo de fim (Horas e Minutos - HH:mm) de alguma a��o.
	 * 
	 * @return Valor atual do Horario de fim da a��o.
	 */
	public Date getPeriodoFim() {
		return periodoFim;
	}

	/**
	 * Altera o valor do periodo de fim do {@link Horario}, para o novo valor
	 * recebido como par�metro.
	 * 
	 * @param periodoFim Novo periodo de Fim do Horario.
	 */
	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	/**
	 * Retorna o valor do dia da semana (Ex.: Segunda-feira, Ter�a-Feira, etc.) de
	 * alguma a��o.
	 * 
	 * @return Valor atual do dia da semana da a��o.
	 */
	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * Altera o valor do dia da semana do {@link Horario}, para o novo valor
	 * recebido como par�metro.
	 * 
	 * @param diaSemana Novo dia da semana do Horario.
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * Retorna o valor do {@link Exercicio} relacionado a esse hor�rio.
	 * 
	 * @return Valor atual do Exercicio presente neste horario.
	 */
	public Exercicio getExercicio() {
		return exercicio;
	}

	/**
	 * Altera o valor do {@link Exercicio} presente no {@link Horario}, para o novo
	 * valor recebido como par�metro.
	 * 
	 * @param exercicio Novo exercicio do Horario.
	 */
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	/**
	 * Retorna o valor da {@link Refeicao} relacionada a esse hor�rio.
	 * 
	 * @return Valor atual da Refeicao presente neste horario.
	 */
	public Refeicao getRefeicao() {
		return refeicao;
	}

	/**
	 * Altera o valor da {@link Refeicao} presente no {@link Horario}, para o novo
	 * valor recebido como par�metro.
	 * 
	 * @param refeicao Nova refeicao do Horario.
	 */
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
					if (inicio.equals(refeicao.getHorarioInicio())
							|| (inicio.after(refeicao.getHorarioInicio()) && inicio.before(refeicao.getHorarioFim()))) {
						// caso estiver ocupado, retorna falso
						return false;
					}

					// verifica se o fim da Refeicao est� num horario j� ocupado
					if (fim.equals(refeicao.getHorarioFim())
							|| (fim.after(refeicao.getHorarioInicio()) && fim.before(refeicao.getHorarioFim()))) {
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
