package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.intefaces.IPessoaDAO;
import br.edu.ifsc.cds.classes.domain.Executora;
import br.edu.ifsc.cds.classes.domain.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	protected EntityManager em;

	@Override
	public void create(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Pessoa> retrieveAll() {
		// TODO Auto-generated method stub
		List<Pessoa> pessoas = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Admin");
		pessoas = query.getResultList();
		em.close();
		Executora.emf.close();
		return pessoas;
	}

	@Override
	public Pessoa retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.close();
		Executora.emf.close();
		return pessoa;
	}

	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(pessoa);
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
			Pessoa adm = em.find(Pessoa.class, id);
			em.getTransaction().begin();
			em.remove(adm);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
