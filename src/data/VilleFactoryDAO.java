package data;

public class VilleFactoryDAO {

	/**
	 * Classe de création de DAO de Villes
	 */

	// Instanciation
	private static VilleFactoryDAO instance;

	public static VilleFactoryDAO getInstance() {
		if (instance == null) {
			instance = new VilleFactoryDAO();
		}
		return instance;
	}

	// Récupérer un nouveau VilleDAO
	public IDAO getVilleDAO() {
		IDAO r = new VilleDAO();
		return r;
	}

	// Récupérer un nouveau ClientDAO
	public IDAO getClientDAO() {
		IDAO r = new ClientDAO();
		return r;
	}

	// Récupérer un nouveau FactureDAO
	public IDAO getfactureAO() {
		IDAO r = new FactureDAO();
		return r;
	}

	// Récupérer un nouveau HotelDAO
	public IDAO getHotelDAO() {
		IDAO r = new HotelDAO();
		return r;
	}

	// Récupérer un nouveau LigneFactureDAO
	public IDAO getLigneFactureDAO() {
		IDAO r = new LigneFactureDAO();
		return r;
	}

	// Récupérer un nouveau OperateurDAO
	public IDAO getOperateurDAO() {
		IDAO r = new OperateurDAO();
		return r;
	}

	// Récupérer un nouveau PaysDAO
	public IDAO getPaysDAO() {
		IDAO r = new PaysDAO();
		return r;
	}

	// Récupérer un nouveau ProduitDAO
	public IDAO getProduitDAO() {
		IDAO r = new ProduitDAO();
		return r;
	}

	// Récupérer un nouveau RegionDAO
	public IDAO getRegionDAO() {
		IDAO r = new RegionDAO();
		return r;
	}

	// Récupérer un nouveau ReservationDAO
	public IDAO getReservationDAO() {
		IDAO r = new ReservationDAO();
		return r;
	}

}
