package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.intefaces.IAlimentoDAO;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.Executora;

public class AlimentoDAO implements IAlimentoDAO {

	protected EntityManager em;

	@Override
	public void create(Alimento alimento) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(alimento);
			em.getTransaction().commit();
			em.close();
			Executora.emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Alimento> retrieveAll() {
		// TODO Auto-generated method stub
		List<Alimento> alimentos = new ArrayList<>();
		em = Executora.emf.createEntityManager();
		Query query = em.createQuery("FROM Alimentos");
		alimentos = query.getResultList();
		em.close();
		Executora.emf.close();
		return alimentos;
	}

	@Override
	public Alimento retrieve(Integer id) {
		// TODO Auto-generated method stub
		em = Executora.emf.createEntityManager();
		Alimento alimento = em.find(Alimento.class, id);
		em.close();
		Executora.emf.close();
		return alimento;
	}

	@Override
	public void update(Alimento alimento) {
		// TODO Auto-generated method stub
		try {
			em = Executora.emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(alimento);
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
			Admin adm = em.find(Admin.class, id);
			em.getTransaction().begin();
			em.remove(adm);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
