package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IAdminDAO;
import br.edu.ifsc.cds.classes.domain.Admin;

/**
 * 
 * Classe que implementa a interface {@link IAdminDAO} para as operações no
 * banco
 *
 */
public class AdminDAO implements IAdminDAO {

	protected EntityManager em;

	@Override
	public void create(Admin admin) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			// começa uma transação para garantir que será persistido no banco
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
		List<Admin> adm = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Admin");
		adm = query.getResultList();
		em.close();

		return adm;
	}

	@Override
	public Admin retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Admin adm = em.find(Admin.class, id);
		em.close();

		return adm;
	}

	@Override
	public void update(Admin admin) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
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
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			Admin adm = em.find(Admin.class, id);
			em.getTransaction().begin();
			em.remove(adm);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Admin retrieveCount(String user, String password) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query consulta = em
				.createQuery(
						"SELECT a FROM Usuario u INNER JOIN Admin a ON u.id = a.id WHERE u.email = ?1 AND u.senha = ?2")
				.setParameter(1, user).setParameter(2, password);
		return (Admin) consulta.getSingleResult();
	}

}
