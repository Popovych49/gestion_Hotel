package fr.soprasteria.gestionHotel.metier;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_facture")
public class LigneFacture {

//Définition des différentes colonnes de la table
	@Id
	@Column(name = "LIGNE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ligne_facture_id;
	
	//Récupération de la colonne ID_Facture de la table Facture
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FACTURE_ID", unique = false, nullable = false)
	private Hotel hotel;

	//Récupération de la colonne ID_Produit de la table Produit
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_ID", unique = false, nullable = false)
	private Produit produit;

	@Column(name = "QUANTITE", length = 30, nullable = false, unique = true)
	private short QUANTITE;

	public String toString() {
		return String.format("[%d,%d,%s,%d]", getHotel().getHOTEL_ID(),
				getProduit().getPRODUIT_ID(), getQUANTITE());
	}

	public LigneFacture() {
	}


	public LigneFacture(Hotel hotel, Produit produit, short QUANTITE) {
		this.hotel = hotel;
		this.produit = produit;
		this.QUANTITE = QUANTITE;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQUANTITE() {
		return QUANTITE;
	}

	public void setQUANTITE(short qUANTITE) {
		QUANTITE = qUANTITE;
	}

}
