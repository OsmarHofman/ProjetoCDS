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
	 * @return true caso o alimento seja inclu�do com sucesso no banco, e false caso
	 *         contr�rio
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
	 * M�todo que ir� atualizar um determinado {@link Alimento}
	 * 
	 * @param alimento Alimento com as novas informa��es a serem atualizadas
	 * @return Booleno que indicar� true se o update foi bem sucedido ou caso contr�rio uma exce��o.
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
	 * M�todo para chamar o DAO do alimento para ent�o realizar a exclus�o do {@link Alimento}.
	 * 
	 * @param id N�mero do id do alimento a ser exclu�do.
	 */
	public void excluirAlimento(Integer id) {
		dao.delete(id);
	}
}
