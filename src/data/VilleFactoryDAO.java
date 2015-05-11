package data;


public class VilleFactoryDAO {
	
	/**
	 * Classe de création de DAO de Villes
	 */
	
	//Instanciation
	private static VilleFactoryDAO instance;

	public static VilleFactoryDAO getInstance() {
		if (instance == null) {
			instance = new VilleFactoryDAO();
		}
		return instance;
	}

	//Récupérer un nouveau VilleDAO
	public IVilleDAO getIVilleDAO() {
		IVilleDAO r = new VilleDAO();
		return r;
	}

	

}
