package br.edu.ifsc.cds.services;

import java.util.List;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.DAO.interfaces.IAlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;

public class AlimentoService {

	IAlimentoDAO dao = new AlimentoDAO();

	/**
	 *
	 * Insere um alimento no Banco de dados.
	 * 
	 * @param nomeAntigo
	 * 
	 * @param alimento   Alimento a ser inserido no Banco
	 * @return true caso o alimento seja incluído com sucesso no banco, e false caso
	 *         contrário
	 */
	public boolean criaAlimento(Alimento alimento) {
		try {
			dao.create(alimento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Retorna todas os alimentos presentes no sistema
	 * 
	 * @return {@link List} de todas as {@link Alimento} na base de dados
	 */
	public List<Alimento> retornaTodos() {
		return dao.retrieveAll();
	}

	/**
	 * Método que irá atualizar um determinado {@link Alimento}
	 * 
	 * @param alimento Alimento com as novas informações a serem atualizadas
	 * @return Booleno que indicará true se o update foi bem sucedido ou caso contrário uma exceção.
	 */
	public boolean atualizaAlimento(Alimento alimento) {
		try {
			dao.update(alimento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Método para chamar o DAO do alimento para então realizar a exclusão do {@link Alimento}.
	 * 
	 * @param id Número do id do alimento a ser excluído.
	 */
	public void excluirAlimento(Integer id) {
		dao.delete(id);
	}
}
