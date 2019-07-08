package br.edu.ifsc.cds.DAO.Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que ir� criar e gerenciar o {@link EntityManagerFactory} para realizar
 * todas as opera��es no banco de dados
 *
 */
public class EntityMagerFactorySingleton {
	private static EntityManagerFactory emf;

	private EntityMagerFactorySingleton() {

	}

	/**
	 * M�todo para verificar se um EntityManagerFactory j� est� criado, pois sua cria��o � muito custosa
	 * 
	 * @return Retorna um Entity Manager Factory para a cria��o de um Entity Manager nos DAO's
	 */
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

	/**
	 * M�todo respons�vel por fecgar um EntityManagerFactory para n�o ficar em execu��o
	 * no momento em que fecharmos o programa.
	 */
	public static void closeFactory() {
		if (emf != null) {
			emf.close();
		}

	}

}
