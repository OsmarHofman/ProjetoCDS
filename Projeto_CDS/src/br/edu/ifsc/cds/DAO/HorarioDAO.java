package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IHorarioDAO;
import br.edu.ifsc.cds.classes.domain.Horario;

public class HorarioDAO implements IHorarioDAO{

	protected EntityManager em;

	@Override
	public void create(Horario horario) {
		// TODO Auto-generated method stub
		try {
			em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
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
		// TODO Auto-generated method stub
		List<Horario> horarios = new ArrayList<>();
		em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Admin");
		horarios = query.getResultList();
		em.close();
		return horarios;
	}

	@Override
	public Horario retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Horario horario= em.find(Horario.class, id);
		em.close();
		return horario;
	}

	@Override
	public void update(Horario horario) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
