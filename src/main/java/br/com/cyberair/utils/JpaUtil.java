package br.com.cyberair.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
