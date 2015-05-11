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
	@Table(name = "facture")
	public class Facture {
		@Id
		@Column(name = "FACTURE_ID", nullable = false)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer FACTURE_ID;

//		@Column(name = "DATE_DEB_SEJOUR", nullable = false)
		@Temporal(TemporalType.DATE)
		private Date DATE_DEB_SEJOUR;

		@Column(name = "NBNUITS_SEJOUR", length = 30, nullable = false, unique = true)
		private int NBNUITS_SEJOUR;

		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "HOTEL_ID", unique = false, nullable = false)
		private Hotel hotel;

		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "CLIENT_ID", unique = false, nullable = false)
		private Client client;

		public String toString() {
			return String.format("[%d,%s,%d,%s]", getFacture_id(),
					new SimpleDateFormat("dd/MM/yyyy")
							.format(getDate_deb_sejour()), getNbnuits_sejour());
		}

		public Facture() {
		}

		public Facture(Date DATE_DEB_SEJOUR, int NBNUITS_SEJOUR, Client client, Hotel hotel) {
			this.DATE_DEB_SEJOUR = DATE_DEB_SEJOUR;
			this.NBNUITS_SEJOUR =NBNUITS_SEJOUR;
			this.client = client;
			this.hotel = hotel;
		}

		public Integer getFacture_id() {
			return FACTURE_ID;
		}

		public void setFacture_id(Integer facture_id) {
			this.FACTURE_ID = facture_id;
		}

		public Date getDate_deb_sejour() {
			return DATE_DEB_SEJOUR;
		}

		public void setDate_deb_sejour(Date date_deb_sejour) {
			this.DATE_DEB_SEJOUR = date_deb_sejour;
		}

		public int getNbnuits_sejour() {
			return NBNUITS_SEJOUR;
		}

		public void setNbnuits_sejour(int nbnuits_sejour) {
			this.NBNUITS_SEJOUR = nbnuits_sejour;
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

	}

