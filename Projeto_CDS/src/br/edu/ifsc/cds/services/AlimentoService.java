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

	public boolean atualizaAlimento(Alimento alimento) {
		try {
			dao.update(alimento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void excluirAlimento(Integer id) {
		dao.delete(id);
	}
}
