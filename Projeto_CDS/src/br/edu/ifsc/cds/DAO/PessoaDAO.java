package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IPessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	protected EntityManager em;

	@Override
	public void create(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
			em.close();
			// Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Pessoa> retrieveAll() {
		// TODO Auto-generated method stub
		List<Pessoa> pessoas = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Pessoa");
		pessoas = query.getResultList();
		em.close();
		return pessoas;
	}

	@Override
	public Pessoa retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.close();
		return pessoa;
	}

	@Override
	public Pessoa retrieveCount(String user, String password) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query consulta = em.createQuery(
				"SELECT p FROM Usuario u INNER JOIN Pessoa p ON u.id = p.id WHERE u.email = ?1 AND u.senha = ?2")
				.setParameter(1, user).setParameter(2, password);
		return (Pessoa) consulta.getSingleResult();
	}

	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(pessoa);
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
			Pessoa adm = em.find(Pessoa.class, id);
			em.getTransaction().begin();
			em.remove(adm);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
