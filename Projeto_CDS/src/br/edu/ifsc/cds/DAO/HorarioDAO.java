package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IHorarioDAO;
import br.edu.ifsc.cds.classes.domain.Horario;

/**
 * 
 * Classe que implementa a interface {@link IHorarioDAO} para as operações no
 * banco
 *
 */
public class HorarioDAO implements IHorarioDAO {

	protected EntityManager em;

	@Override
	public void create(Horario horario) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(horario);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Horario> retrieveAll() {
		List<Horario> horarios = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Horario");
		horarios = query.getResultList();
		em.close();
		return horarios;
	}

	@Override
	public Horario retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Horario horario = em.find(Horario.class, id);
		em.close();
		return horario;
	}

	@Override
	public void update(Horario horario) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(horario);
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
			Horario horario = em.find(Horario.class, id);
			em.getTransaction().begin();
			em.remove(horario);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
