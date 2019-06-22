package br.edu.ifsc.cds.DAO.Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMagerFactorySingleton {
	public static EntityManagerFactory emf;

	private EntityMagerFactorySingleton() {

	}

	public static EntityManagerFactory getFactory() {
		if (emf == null) {
			synchronized (EntityMagerFactorySingleton.class) {
				if (emf == null) {
					emf = Persistence.createEntityManagerFactory("cds-jpa");
				}
			}
		}
		return emf;
	}

}
