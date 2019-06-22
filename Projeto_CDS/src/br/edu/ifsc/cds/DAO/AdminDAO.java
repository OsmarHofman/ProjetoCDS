package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IAdminDAO;
import br.edu.ifsc.cds.classes.domain.Admin;

public class AdminDAO implements IAdminDAO {

	protected EntityManager em;

	@Override
	public void create(Admin admin) {
		// TODO Auto-generated method stub
		try {
			em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(admin);
			em.getTransaction().commit();
			em.close();
			

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Admin> retrieveAll() {
		// TODO Auto-generated method stub
		List<Admin> adm = new ArrayList<>();
		em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Admin");
		adm = query.getResultList();
		em.close();
		
		return adm;
	}

	@Override
	public Admin retrieve(Integer id) {
		// TODO Auto-generated method stub
		em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
		Admin adm = em.find(Admin.class, id);
		em.close();
		
		return adm;
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		try {
			em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
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
		// TODO Auto-generated method stub
		try {
			em =  EntityMagerFactorySingleton.getFactory().createEntityManager();
			Admin adm = em.find(Admin.class, id);
			em.getTransaction().begin();
			em.remove(adm);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
