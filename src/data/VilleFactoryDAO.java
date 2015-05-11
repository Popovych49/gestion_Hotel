package data;

public class VilleFactoryDAO {

	/**
	 * Classe de cr�ation de DAO de Villes
	 */

	// Instanciation
	private static VilleFactoryDAO instance;

	public static VilleFactoryDAO getInstance() {
		if (instance == null) {
			instance = new VilleFactoryDAO();
		}
		return instance;
	}

	// R�cup�rer un nouveau VilleDAO
	public IDAO getVilleDAO() {
		IDAO r = new VilleDAO();
		return r;
	}

	// R�cup�rer un nouveau ClientDAO
	public IDAO getClientDAO() {
		IDAO r = new ClientDAO();
		return r;
	}

	// R�cup�rer un nouveau FactureDAO
	public IDAO getfactureAO() {
		IDAO r = new FactureDAO();
		return r;
	}

	// R�cup�rer un nouveau HotelDAO
	public IDAO getHotelDAO() {
		IDAO r = new HotelDAO();
		return r;
	}

	// R�cup�rer un nouveau LigneFactureDAO
	public IDAO getLigneFactureDAO() {
		IDAO r = new LigneFactureDAO();
		return r;
	}

	// R�cup�rer un nouveau OperateurDAO
	public IDAO getOperateurDAO() {
		IDAO r = new OperateurDAO();
		return r;
	}

	// R�cup�rer un nouveau PaysDAO
	public IDAO getPaysDAO() {
		IDAO r = new PaysDAO();
		return r;
	}

	// R�cup�rer un nouveau ProduitDAO
	public IDAO getProduitDAO() {
		IDAO r = new ProduitDAO();
		return r;
	}

	// R�cup�rer un nouveau RegionDAO
	public IDAO getRegionDAO() {
		IDAO r = new RegionDAO();
		return r;
	}

	// R�cup�rer un nouveau ReservationDAO
	public IDAO getReservationDAO() {
		IDAO r = new ReservationDAO();
		return r;
	}

}
