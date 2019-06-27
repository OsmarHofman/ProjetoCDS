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
 * Classe que representa o período de início, fim (formato de hora:minuto) e o
 * dia da semana (Segunda-feira, Terça-Feira, etc.) de uma ação
 * 
 *
 */

//A notação @Entity realiza o mapeamento Objeto Relacional da classe para uma
//tabela do Banco de Dados.
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

//	A notação @Id indica que o atributo {@link #id} será uma chave primária no
//	banco.
	@Id
	private Integer id;
	private Date periodoInicio;
	private Date periodoFim;
	private String diaSemana;

//	A notação @OneToOne representa uma relação um para um 
//	com outra tabela, que tem o atributo "horarioEx".
	@OneToOne(mappedBy = "horarioEx")
	private Exercicio exercicio;

//	A notação @OneToOne representa uma relação um para um 
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
	 * @param id            Número do id do Horário
	 * @param periodoInicio Hora e minuto de inicio da ação, no formato Date
	 * @param periodoFim    Hora e minuto do fim da ação, no formato Date
	 * @param diaSemana     Nome do dia da Semana da ação
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
	 * parâmetro.
	 * 
	 * @param id Novo id do Horario.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o valor do periodo de inicio (Horas e Minutos - HH:mm) de alguma
	 * ação.
	 * 
	 * @return Valor atual do Horario de inicio da ação.
	 */
	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	/**
	 * Altera o valor do periodo de inicio do {@link Horario}, para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param periodoInicio Novo periodo de inicio do Horario.
	 */
	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	/**
	 * Retorna o valor do periodo de fim (Horas e Minutos - HH:mm) de alguma ação.
	 * 
	 * @return Valor atual do Horario de fim da ação.
	 */
	public Date getPeriodoFim() {
		return periodoFim;
	}

	/**
	 * Altera o valor do periodo de fim do {@link Horario}, para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param periodoFim Novo periodo de Fim do Horario.
	 */
	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	/**
	 * Retorna o valor do dia da semana (Ex.: Segunda-feira, Terça-Feira, etc.) de
	 * alguma ação.
	 * 
	 * @return Valor atual do dia da semana da ação.
	 */
	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * Altera o valor do dia da semana do {@link Horario}, para o novo valor
	 * recebido como parâmetro.
	 * 
	 * @param diaSemana Novo dia da semana do Horario.
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * Retorna o valor do {@link Exercicio} relacionado a esse horário.
	 * 
	 * @return Valor atual do Exercicio presente neste horario.
	 */
	public Exercicio getExercicio() {
		return exercicio;
	}

	/**
	 * Altera o valor do {@link Exercicio} presente no {@link Horario}, para o novo
	 * valor recebido como parâmetro.
	 * 
	 * @param exercicio Novo exercicio do Horario.
	 */
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	/**
	 * Retorna o valor da {@link Refeicao} relacionada a esse horário.
	 * 
	 * @return Valor atual da Refeicao presente neste horario.
	 */
	public Refeicao getRefeicao() {
		return refeicao;
	}

	/**
	 * Altera o valor da {@link Refeicao} presente no {@link Horario}, para o novo
	 * valor recebido como parâmetro.
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
	 * Verifica se o horario pretendido está disponível. Também verifica se o
	 * período de fim está antes do período de inicio.
	 * 
	 * @param inicio    Horario que a Refeicao irá começar
	 * @param fim       Horario que a Refeicao irá terminar
	 * @param diaSemana Dia da semana que acontecerá o Exercicio ou Refeicao
	 * @return true se o horário está vago, ou false se o horário estiver ocupado
	 */
	public boolean verificaRefeicaoHorario(Date inicio, Date fim, String diaSemana) {
		if (inicio.before(fim)) {
			new RotinaController();

			// for das iterações da lista de Refeicoes
			for (RefeicaoDTO refeicao : RotinaController.getListaRefeicao()) {

				// verifica se o dia da semana que foi inserido é o mesmo que de alguma refeicao
				if (refeicao.getDiaSemana().equals(diaSemana)) {

					// verifica se o inicio da Refeicao está num horario já ocupado
					if (inicio.equals(refeicao.getHorarioInicio())
							|| (inicio.after(refeicao.getHorarioInicio()) && inicio.before(refeicao.getHorarioFim()))) {
						// caso estiver ocupado, retorna falso
						return false;
					}

					// verifica se o fim da Refeicao está num horario já ocupado
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
			JOptionPane.showMessageDialog(null, "Fim não pode ser antes do Inicio");
			return false;
		}
	}

}
