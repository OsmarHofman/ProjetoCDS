package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.interfaces.IinfoNutricionalDAO;
import br.edu.ifsc.cds.classes.domain.Executora;
import br.edu.ifsc.cds.classes.domain.InfoNutricional;

public class InfoNutricionalDAO implements IinfoNutricionalDAO{

	protected EntityManager em;

	@Override
	public void create(InfoNutricional infnutri) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(infnutri);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<InfoNutricional> retrieveAll() {
		// TODO Auto-generated method stub
		List<InfoNutricional> infonutris = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Admin");
		infonutris = query.getResultList();
		em.close();
		Executora.emf.close();
		return infonutris;
	}

	@Override
	public InfoNutricional retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		InfoNutricional infonutri = em.find(InfoNutricional.class, id);
		em.close();
		Executora.emf.close();
		return infonutri;
	}

	@Override
	public void update(InfoNutricional infonutri) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(infonutri);
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
			InfoNutricional infonutri = em.find(InfoNutricional.class, id);
			em.getTransaction().begin();
			em.remove(infonutri);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
