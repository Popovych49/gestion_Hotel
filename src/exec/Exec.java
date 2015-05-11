package exec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Exec {

	public static void main(String[] args) {
		// récupérer un EntityManagerFactory à  partir de l'unité de persistance

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("basehotel");

		// récupérer un EntityManager à  partir de l'EntityManagerFactory

		EntityManager em = emf.createEntityManager();

		// début transaction

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		System.out.println("[VILLE]");
		for (Object pa : em
				.createQuery(
						"select v from Ville v")
				.getResultList()) {
			System.out.println(pa);
		}


		// fin transaction
		tx.commit();

		// fin EntityManager
		em.close();

		// fin EntityManagerFactory
		emf.close();
	}

}
