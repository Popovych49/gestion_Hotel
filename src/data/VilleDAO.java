package data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.soprasteria.gestionHotel.metier.Region;
import fr.soprasteria.gestionHotel.metier.Ville;

public class VilleDAO implements IVilleDAO {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	private static VilleDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * @return l'instance unique du DAO
	 */
	public static VilleDAO getInstance() {
		if (instance == null) {
			instance = new VilleDAO();
		}
		return instance;
	}

	/**
	 * Constructeur du DAO
	 * Il initialise le contexte de persistance
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
	 * @param nom
	 * @param prenom
	 * @param datenaissance
	 * @param marie
	 * @param nbenfants
	 * @return la personne créée
	 */
	public Ville getVille(String nom, Region region) {
		Ville v = new Ville(nom, region);
		em.persist(v);
		return v;
	}
	
	/**
	 * Synchronise le context de persistance avec la base de donnée.
	 * En fait un commit est effectué et une nouvelle transaction débutée
	 */
	public void commit(){
		tx.commit();
		tx.begin();
	}
	
	
	/**
	 * efface une ville
	 * @param v  La ville
	 */
	public void remove(Ville v){
		em.remove(v);
	}
	
	
	
	/*
	 * Retourne le contenu de la table
	 */
	public List<Ville> getAll(){
		return em.createQuery("select v from Ville v order by v.nom_ville asc").getResultList();
	}
	
	/**
	 * Retourne une ville selectionnée par son id
	 * @param id l'id de la ville recherchée
	 * @return la ville
	 */
	public Ville getFromId(int id){
		return em.find(Ville.class, id);
	}
	
	/**
	 * recherche une liste de villes à partir d'une clause Where
	 * @param whereClause La clause where
	 * @return la liste de villes
	 */
	public List<Ville> getWhere(String whereClause){
		return em.createQuery("select v from Ville v where "+ whereClause +" order by v.nom_ville asc").getResultList();
	}
	
	/**
	 * Construit un bloc de texte affichant le contenu de la table
	 * @return le contenu de la table
	 */
	public String tableToString(){
		StringBuffer result = new StringBuffer();
		result.append("[ETAT DE LA TABLE]\n");
		for (Object v : em.createQuery("select v from Ville v order by v.nom_ville asc").getResultList()) {
			result.append(v);
			result.append("\n");
		}
		
		return result.toString();
	}
}
