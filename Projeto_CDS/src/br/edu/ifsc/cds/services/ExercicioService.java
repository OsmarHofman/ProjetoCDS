package br.edu.ifsc.cds.services;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.DAO.interfaces.IExercicioDAO;
import br.edu.ifsc.cds.DTO.ExercicioDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.domain.Horario;
import br.edu.ifsc.cds.classes.domain.Rotina;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;

public class ExercicioService {
	IExercicioDAO dao = new ExercicioDAO();

	/**
	 *
	 * Insere um Exercicio no Banco de dados.
	 * 
	 * @param exercicio Exercicio a ser inserido no Banco
	 * @return true caso o exercicio seja incluído com sucesso no banco, e false
	 *         caso contrário
	 */
	public boolean criaExercicio(Exercicio exercicio) {
		try {
			dao.create(exercicio);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Retorna um objeto {@link Exercicio} a partir de seu nome
	 * 
	 * @param nome Nome do objeto a ser buscado
	 * @return o {@link Exercicio} desejado
	 */
	public Exercicio retornaExercicio(String nome) {
		try {
			return dao.retrieveDadosExer(nome);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Verifica e insere o exercício na {@link Rotina} do Usuário
	 * 
	 * @param titulo        Título do Exercicio a ser inserido
	 * @param diaSemana     Dia da semana que será praticado o Exercicio
	 * @param horarioInicio Horario de Inicio do Exercicio
	 * @param horarioFim    Horario de Fim do Exercicio
	 * @return true se o exercicio foi inserido na Rotina com sucesso, ou false caso
	 *         contrário
	 */
	public boolean addRotina(String titulo, String diaSemana, Date horarioInicio, Date horarioFim) {
		// consulta no banco a partir do nome do exercicio, para recuperar seu
		// gastoCaloria
		ExercicioService service = new ExercicioService();
		Exercicio exercicioEscolhido = service.retornaExercicio(titulo);
		if (!exercicioEscolhido.equals(null)) {
			float gastocalorias = exercicioEscolhido.getGastoCaloria();

			// constroi o objeto ExercicioDTO
			ExercicioDTO dt = new ExercicioDTO(titulo, gastocalorias, horarioInicio, horarioFim);
			Horario horario = new Horario();
			// compara o horario para verificar se há alguma refeicao no mesmo horario
			if (horario.verificaRefeicaoHorario(horarioInicio, horarioFim, diaSemana)) {
				RotinaController.addListaExercicio(dt);
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Data de Inicio/Fim inválido(s)");
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Retorna todos os exercícios presentes no sistema
	 * 
	 * @return {@link List} de todas os {@link Exercicio} na base de dados
	 */
	public List<Exercicio> retriveAllExercicios() {
		try {
			return dao.retrieveAll();
		} catch (Exception ex) {
			return null;
		}
	}
}
