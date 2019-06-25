package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IinfoNutricionalDAO;
import br.edu.ifsc.cds.classes.domain.InfoNutricional;

/**
 * 
 * Classe que implementa a interface {@link IinfoNutricionalDAO} para as
 * operações no banco
 *
 */
public class InfoNutricionalDAO implements IinfoNutricionalDAO {

	protected EntityManager em;

	@Override
	public void create(InfoNutricional infnutri) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(infnutri);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<InfoNutricional> retrieveAll() {
		List<InfoNutricional> infonutris = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM infoNutricional");
		infonutris = query.getResultList();
		em.close();
		return infonutris;
	}

	@Override
	public InfoNutricional retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		InfoNutricional infonutri = em.find(InfoNutricional.class, id);
		em.close();
		return infonutri;
	}

	@Override
	public void update(InfoNutricional infonutri) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(infonutri);
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
			InfoNutricional infonutri = em.find(InfoNutricional.class, id);
			em.getTransaction().begin();
			em.remove(infonutri);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
