package br.edu.ifsc.cds.services;

import br.edu.ifsc.cds.DAO.AlimentoDAO;
import br.edu.ifsc.cds.DAO.interfaces.IAlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;

public class AlimentoService {

	IAlimentoDAO dao = new AlimentoDAO();

	/**
	 *
	 * Insere um alimento no Banco de dados.
	 * 
	 * @param alimento Alimento a ser inserido no Banco
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
}
