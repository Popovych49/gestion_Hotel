package fr.soprasteria.gestionHotel.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class LigneFacture {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FACTURE_ID", unique = false, nullable = false)
	private Hotel hotel;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_ID", unique = false, nullable = false)
	private Produit produit;

	@Column(name = "QUANTITE", length = 30, nullable = false, unique = true)
	private int QUANTITE;

	public String toString() {
		return String.format("[%d,%d,%s,%d]", getHotel().getHOTEL_ID(),
				getProduit().getPRODUIT_ID(), getQUANTITE());
	}

	public LigneFacture() {
	}

	public LigneFacture(int QUANTITE) {
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

	public void setQUANTITE(int qUANTITE) {
		QUANTITE = qUANTITE;
	}

}
