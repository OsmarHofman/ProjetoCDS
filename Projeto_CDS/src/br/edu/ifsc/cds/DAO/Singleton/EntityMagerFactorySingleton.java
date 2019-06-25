package br.edu.ifsc.cds.DAO.Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que irá criar e gerenciar o {@link EntityManagerFactory} para realizar
 * todas as operações no banco de dados
 *
 */
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

	public static void closeFactory() {
		if (emf != null) {
			emf.close();
		}

	}

}
