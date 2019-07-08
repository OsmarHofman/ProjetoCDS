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
	private static EntityManagerFactory emf;

	private EntityMagerFactorySingleton() {

	}

	/**
	 * Método para verificar se um EntityManagerFactory já está criado, pois sua criação é muito custosa
	 * 
	 * @return Retorna um Entity Manager Factory para a criação de um Entity Manager nos DAO's
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
	 * Método responsável por fecgar um EntityManagerFactory para não ficar em execução
	 * no momento em que fecharmos o programa.
	 */
	public static void closeFactory() {
		if (emf != null) {
			emf.close();
		}

	}

}
