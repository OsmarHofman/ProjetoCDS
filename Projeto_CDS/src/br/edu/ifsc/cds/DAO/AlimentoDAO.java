package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IAlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Alimento;

/**
 * 
 * Classe que implementa a interface {@link IAlimentoDAO} para as operações no
 * banco
 *
 */
public class AlimentoDAO implements IAlimentoDAO {

	protected EntityManager em;

	@Override
	public void create(Alimento alimento) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(alimento);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Alimento> retrieveAll() {
		List<Alimento> alimentos = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Alimento");
		alimentos = query.getResultList();
		em.close();
		return alimentos;
	}

	@Override
	public Alimento retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Alimento alimento = em.find(Alimento.class, id);
		em.close();
		return alimento;
	}

	@Override
	public void update(Alimento alimento) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(alimento);
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
			em.getTransaction().begin();
			em.remove(id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
