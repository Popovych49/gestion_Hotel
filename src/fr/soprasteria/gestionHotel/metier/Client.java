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
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "CLIENT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String client_id;

	@Column(name = "NOM_CLIENT")
	protected String nom_client;

	@Column(name = "PRENOM_CLIENT")
	protected String prenom_client;

	@Column(name = "ADRESSE_RUE_CLIENT")
	protected String adresse_rue_client;

	@Column(name = "TEL_CLIENT")
	protected String tel_client;

	@Column(name = "PARRAIN_ID")
	protected Operateur parrain_id;

	@Column(name = "AGE")
	protected short age;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLE_ID", nullable = false)
	private Ville ville;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "OPERATEUR_ID", nullable = false)
	private Operateur operateur;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Reservation> reservation = new HashSet<Reservation>();

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Facture> facture = new HashSet<Facture>();

	public Client(String nom_client, String prenom_client,
			String adresse_rue_client, String tel_client, Operateur parrain_id,
			short age, Ville ville, Operateur operateur) {
		super();
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.adresse_rue_client = adresse_rue_client;
		this.tel_client = tel_client;
		this.parrain_id = parrain_id;
		this.age = age;
		this.ville = ville;
		this.operateur = operateur;
	}

	public Client() {
	}

	// toString
	public String toString() {
		return String.format("[%s,%s,%s,%s,%s,%s,%d]", getClient_id(),
				getNom_client(), getPrenom_client(), getAdresse_rue_client(),
				getTel_client(), getParrain_id(), getAge());
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getAdresse_rue_client() {
		return adresse_rue_client;
	}

	public void setAdresse_rue_client(String adresse_rue_client) {
		this.adresse_rue_client = adresse_rue_client;
	}

	public String getTel_client() {
		return tel_client;
	}

	public void setTel_client(String tel_client) {
		this.tel_client = tel_client;
	}

	public Operateur getParrain_id() {
		return parrain_id;
	}

	public void setParrain_id(Operateur parrain_id) {
		this.parrain_id = parrain_id;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public Set<Reservation> getReservations() {
		return reservation;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservation = reservations;
	}

	public Set<Facture> getFactures() {
		return facture;
	}

	public void setFactures(Set<Facture> factures) {
		this.facture = factures;
	}

}
