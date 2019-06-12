package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.interfaces.IExercicioDAO;
import br.edu.ifsc.cds.classes.domain.Executora;
import br.edu.ifsc.cds.classes.domain.Exercicio;

public class ExercicioDAO implements IExercicioDAO{

	protected EntityManager em;

	@Override
	public void create(Exercicio exercicio) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(exercicio);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Exercicio> retrieveAll() {
		// TODO Auto-generated method stub
		List<Exercicio> exercicios = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Admin");
		exercicios = query.getResultList();
		em.close();
		Executora.emf.close();
		return exercicios;
	}

	@Override
	public Exercicio retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		Exercicio exercicio = em.find(Exercicio.class, id);
		em.close();
		Executora.emf.close();
		return exercicio;
	}

	@Override
	public void update(Exercicio exercicio) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(exercicio);
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
			Exercicio exercicio = em.find(Exercicio.class, id);
			em.getTransaction().begin();
			em.remove(exercicio);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
