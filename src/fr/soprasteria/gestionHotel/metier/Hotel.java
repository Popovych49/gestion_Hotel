package fr.soprasteria.gestionHotel.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@Column(name = "HOTEL_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int HOTEL_ID;


	@Column(name = "NOM_HOTEL", length = 30, nullable = false, unique = true)
	private String NOM_HOTEL;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLE_ID", nullable = false)
	private Ville ville;

	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
	private Set<Reservation> reservation = new HashSet<Reservation>();

	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
	private Set<Facture> facture = new HashSet<Facture>();

	public String toString() {
		return String.format("[%d,%d,%s,%d]", getHOTEL_ID(),
				getNOM_HOTEL(), getVille().getVille_id());
	}

	public Hotel() {
	}

	public Hotel(String NOM_HOTEL, Ville ville) {
		this.NOM_HOTEL = NOM_HOTEL;
		this.ville = ville;
	}

	public int getHOTEL_ID() {
		return HOTEL_ID;
	}

	public void setHOTEL_ID(int hOTEL_ID) {
		HOTEL_ID = hOTEL_ID;
	}

	public String getNOM_HOTEL() {
		return NOM_HOTEL;
	}

	public void setNOM_HOTEL(String nOM_HOTEL) {
		NOM_HOTEL = nOM_HOTEL;
	}


	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	

}
