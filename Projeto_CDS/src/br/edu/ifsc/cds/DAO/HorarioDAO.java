package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.intefaces.IHorarioDAO;
import br.edu.ifsc.cds.classes.domain.Executora;
import br.edu.ifsc.cds.classes.domain.Horario;

public class HorarioDAO implements IHorarioDAO{

	protected EntityManager em;

	@Override
	public void create(Horario horario) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(horario);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Horario> retrieveAll() {
		// TODO Auto-generated method stub
		List<Horario> horarios = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Admin");
		horarios = query.getResultList();
		em.close();
		Executora.emf.close();
		return horarios;
	}

	@Override
	public Horario retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		Horario horario= em.find(Horario.class, id);
		em.close();
		Executora.emf.close();
		return horario;
	}

	@Override
	public void update(Horario horario) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(horario);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			Horario horario = em.find(Horario.class, id);
			em.getTransaction().begin();
			em.remove(horario);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
