package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IRefeicaoDAO;
import br.edu.ifsc.cds.classes.domain.Refeicao;

/**
 * 
 * Classe que implementa a interface {@link IRefeicaoDAO} para as operações no
 * banco
 *
 */
public class RefeicaoDAO implements IRefeicaoDAO {

	protected EntityManager em;

	@Override
	public void create(Refeicao refeicao) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(refeicao);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Refeicao> retrieveAll() {
		List<Refeicao> refeicoes = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Refeicao");
		refeicoes = query.getResultList();
		em.close();
		return refeicoes;
	}

	@Override
	public Refeicao retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Refeicao refeicao = em.find(Refeicao.class, id);
		em.close();
		return refeicao;
	}

	@Override
	public void update(Refeicao admin) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(admin);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			Refeicao refeicao = em.find(Refeicao.class, id);
			em.getTransaction().begin();
			em.remove(refeicao);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
