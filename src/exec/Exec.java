package exec;


import java.util.List;

import data.IDAO;
import data.VilleDAO;
import data.VilleFactoryDAO;
import fr.soprasteria.gestionHotel.metier.Util;

public class Exec {

	public static void main(String[] args) {
		// récupérer un EntityManagerFactory à  partir de l'unité de persistance

		VilleFactoryDAO vfd = VilleFactoryDAO.getInstance();
		IDAO id = vfd.getVilleDAO();
		
		Util.afficher(id.tableToString("Ville"));
		
		List<Object> f= id.getWhere("v.region = 30");
		for (Object ville : f){
			System.out.println(ville);
		}
		
		VilleDAO.getInstance().commit();

		VilleDAO.getInstance().closeAll();
	}
}
