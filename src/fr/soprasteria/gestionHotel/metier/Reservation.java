package fr.soprasteria.gestionHotel.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "RESERVATION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RESERVATION_ID;

	@Column(name = "DATE_DEB_RESERVATION", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date DATE_DEB_RESERVATION;

	@Column(name = "NBNUITS_RESERVATION", length = 30, nullable = false, unique = true)
	private byte NBNUITS_RESERVATION;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID", unique = false, nullable = false)
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "HOTEL_ID", unique = false, nullable = false)
	private Hotel hotel;

	public String toString() {
		return String.format("[%d,%s,%d,%s]", getRESERVATION_ID(),
				new SimpleDateFormat("dd/MM/yyyy")
						.format(getDATE_DEB_RESERVATION()),
				getNBNUITS_RESERVATION());
	}

	public Reservation() {
	}

	public Reservation(Date DATE_DEB_RESERVATION, byte NBNUITS_RESERVATION, Client client, Hotel hotel) {
		this.DATE_DEB_RESERVATION = DATE_DEB_RESERVATION;
		this.NBNUITS_RESERVATION = NBNUITS_RESERVATION;
		this.client = client;
		this.hotel = hotel;
	}

	public int getRESERVATION_ID() {
		return RESERVATION_ID;
	}

	public void setRESERVATION_ID(int rESERVATION_ID) {
		RESERVATION_ID = rESERVATION_ID;
	}

	public Date getDATE_DEB_RESERVATION() {
		return DATE_DEB_RESERVATION;
	}

	public void setDATE_DEB_RESERVATION(Date dATE_DEB_RESERVATION) {
		DATE_DEB_RESERVATION = dATE_DEB_RESERVATION;
	}

	public byte getNBNUITS_RESERVATION() {
		return NBNUITS_RESERVATION;
	}

	public void setNBNUITS_RESERVATION(byte nBNUITS_RESERVATION) {
		NBNUITS_RESERVATION = nBNUITS_RESERVATION;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
