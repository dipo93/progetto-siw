package it.uniroma3.model;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siw-project-unit");
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}

}
