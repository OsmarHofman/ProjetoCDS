package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.intefaces.IRotinaDAO;
import br.edu.ifsc.cds.classes.domain.Executora;
import br.edu.ifsc.cds.classes.domain.Rotina;

public class RotinaDAO implements IRotinaDAO{

	protected EntityManager em;

	@Override
	public void create(Rotina rotina) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(rotina);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Rotina> retrieveAll() {
		// TODO Auto-generated method stub
		List<Rotina> rotinas = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Admin");
		rotinas = query.getResultList();
		em.close();
		Executora.emf.close();
		return rotinas;
	}

	@Override
	public Rotina retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		Rotina rotina = em.find(Rotina.class, id);
		em.close();
		Executora.emf.close();
		return rotina;
	}

	@Override
	public void update(Rotina rotina) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(rotina);
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
			Rotina rotina = em.find(Rotina.class, id);
			em.getTransaction().begin();
			em.remove(rotina);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
