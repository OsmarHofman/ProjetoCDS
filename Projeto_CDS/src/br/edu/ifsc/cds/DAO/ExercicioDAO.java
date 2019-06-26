package br.edu.ifsc.cds.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsc.cds.DAO.Singleton.EntityMagerFactorySingleton;
import br.edu.ifsc.cds.DAO.interfaces.IExercicioDAO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.domain.Pessoa;

/**
 * 
 * Classe que implementa a interface {@link IExercicioDAO} para as operações no
 * banco
 *
 */
public class ExercicioDAO implements IExercicioDAO {

	protected EntityManager em;

	@Override
	public void create(Exercicio exercicio) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(exercicio);
			em.getTransaction().commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Exercicio> retrieveAll() {
		List<Exercicio> exercicios = new ArrayList<>();
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query query = em.createQuery("FROM Exercicio");
		exercicios = query.getResultList();
		em.close();
		return exercicios;
	}

	@Override
	public Exercicio retrieve(Integer id) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Exercicio exercicio = em.find(Exercicio.class, id);
		em.close();
		return exercicio;
	}

	@Override
	public void update(Exercicio exercicio) {
		try {
			em = EntityMagerFactorySingleton.getFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(exercicio);
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
			Exercicio exercicio = em.find(Exercicio.class, id);
			em.getTransaction().begin();
			em.remove(exercicio);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Exercicio retrieveDadosExer(String nome) {
		em = EntityMagerFactorySingleton.getFactory().createEntityManager();
		Query consulta = em.createQuery(
				"SELECT e FROM Exercicio e WHERE e.nome = ?1")
				.setParameter(1, nome);
		return (Exercicio) consulta.getSingleResult();
	}
}
