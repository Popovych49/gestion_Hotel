package fr.soprasteria.gestionHotel.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@Column(name = "HOTEL_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer HOTEL_ID;


	@Column(name = "NOM_HOTEL", length = 30, nullable = false, unique = true)
	private String NOM_HOTEL;

	@Column(name = "VILLE_ID", length = 30, nullable = false, unique = true)
	private int VILLE_ID;

	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	private Set<Reservation> reservation = new HashSet<Reservation>();

	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY)
	private Set<Facture> facture = new HashSet<Facture>();

	public String toString() {
		return String.format("[%d,%d,%s,%d]", getHOTEL_ID(),
				getNOM_HOTEL(), getVILLE_ID());
	}

	public Hotel() {
	}

	public Hotel(String NOM_HOTEL, int VILLE_ID) {
		this.NOM_HOTEL = NOM_HOTEL;
		this.VILLE_ID = VILLE_ID;
	}

	public Integer getHOTEL_ID() {
		return HOTEL_ID;
	}

	public void setHOTEL_ID(Integer hOTEL_ID) {
		HOTEL_ID = hOTEL_ID;
	}

	public String getNOM_HOTEL() {
		return NOM_HOTEL;
	}

	public void setNOM_HOTEL(String nOM_HOTEL) {
		NOM_HOTEL = nOM_HOTEL;
	}

	public int getVILLE_ID() {
		return VILLE_ID;
	}

	public void setVILLE_ID(int vILLE_ID) {
		VILLE_ID = vILLE_ID;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Set<Facture> getFacture() {
		return facture;
	}

	public void setFacture(Set<Facture> facture) {
		this.facture = facture;
	}

	

}
