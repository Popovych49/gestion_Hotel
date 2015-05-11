package data;


public class VilleFactoryDAO {
	
	/**
	 * Classe de cr�ation de DAO de Villes
	 */
	
	//Instanciation
	private static VilleFactoryDAO instance;

	public static VilleFactoryDAO getInstance() {
		if (instance == null) {
			instance = new VilleFactoryDAO();
		}
		return instance;
	}

	//R�cup�rer un nouveau VilleDAO
	public IDAO getVilleDAO() {
		IDAO r = new VilleDAO();
		return r;
	}
}
