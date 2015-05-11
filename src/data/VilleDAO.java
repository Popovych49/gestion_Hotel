package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VilleDAO implements IDAO {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	private static VilleDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * 
	 * @return l'instance unique du DAO
	 */
	public static VilleDAO getInstance() {
		if (instance == null) {
			instance = new VilleDAO();
		}
		return instance;
	}

	/**
	 * Constructeur du DAO Il initialise le contexte de persistance
	 */
	public VilleDAO() {
		emf = Persistence.createEntityManagerFactory("basehotel");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Ferme la factory d'entity manager et l'entity manager
	 */
	public void closeAll() {
		em.close();
		emf.close();
	}

	/**
	 * Créer une instance de Ville et l'ajoute au contexte de persistance.
	 * 
	 * public Ville getVille(String nom, Region region) { Ville v = new
	 * Ville(nom, region); em.persist(v); return v; }
	 */
	/**
	 * Synchronise le context de persistance avec la base de donnée. En fait un
	 * commit est effectué et une nouvelle transaction débutée
	 */
	public void commit() {
		tx.commit();
		tx.begin();
	}

	/**
	 * efface une ville
	 * 
	 * @param v
	 *            La ville
	 * 
	 *            public void remove(Ville v) { em.remove(v); }
	 */
	/*
	 * Retourne le contenu de la table
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getAll() {
		return em.createQuery("select v from Ville v order by v.nom_ville asc")
				.getResultList();
	}

	/**
	 * recherche une liste de villes à partir d'une clause Where
	 * 
	 * @param whereClause
	 *            La clause where
	 * @return la liste de villes
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getWhere(String whereClause) {
		return em.createQuery("select v from Ville v where " + whereClause)
				.getResultList();
	}

	/**
	 * Construit un bloc de texte affichant le contenu de la table
	 * 
	 * @return le contenu de la table
	 */
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
