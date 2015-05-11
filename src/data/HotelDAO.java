package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HotelDAO implements IDAO {//Cf VilleDAO pour la description de toutes les méthodes

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	private static HotelDAO instance;

	public static HotelDAO getInstance() {
		if (instance == null) {
			instance = new HotelDAO();
		}
		return instance;
	}


	public HotelDAO() {
		emf = Persistence.createEntityManagerFactory("basehotel");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	public void closeAll() {
		em.close();
		emf.close();
	}


	public void commit() {
		tx.commit();
		tx.begin();
	}


	@SuppressWarnings("unchecked")
	public List<Object> getAll() {
		return em.createQuery("select v from Hotel v ")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Object> getWhere(String whereClause) {
		return em.createQuery("select v from Hotel v where " + whereClause)
				.getResultList();
	}

	
	public String tableToString(String NomTable) {
		StringBuffer result = new StringBuffer();
		result.append("[ETAT DE LA TABLE]\n");
		for (Object v : em.createQuery("select v from " + NomTable + " v")
				.getResultList()) {
			result.append(v);
			result.append("\n");
		}

		return result.toString();
	}

}
