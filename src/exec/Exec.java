package exec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Exec {

	public static void main(String[] args) {
		// r�cup�rer un EntityManagerFactory � partir de l'unit� de persistance

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("basehotel");

		// r�cup�rer un EntityManager � partir de l'EntityManagerFactory

		EntityManager em = emf.createEntityManager();

		// d�but transaction

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
