package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IRotinaDAO;
import br.edu.ifsc.cds.classes.domain.Rotina;

/**
 * 
 * Classe que implementa a interface {@link IRotinaDAO} para as operações no
 * banco
 *
 */
public class RotinaDAO implements IRotinaDAO {

	protected EntityManager em;

	@Override
	public void create(Rotina rotina) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(rotina);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Rotina> retrieveAll() {
		List<Rotina> rotinas = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Rotina");
		rotinas = query.getResultList();
		em.close();

		return rotinas;
	}

	@Override
	public Rotina retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Rotina rotina = em.find(Rotina.class, id);
		em.close();

		return rotina;
	}

	@Override
	public void update(Rotina rotina) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(rotina);
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
			Rotina rotina = em.find(Rotina.class, id);
			em.getTransaction().begin();
			em.remove(rotina);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
