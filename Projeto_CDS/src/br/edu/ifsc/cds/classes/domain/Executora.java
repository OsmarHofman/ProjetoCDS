package br.edu.ifsc.cds.classes.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Executora {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cds-jpa");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}

}
