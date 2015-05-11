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
@Table(name="ville")

public class Ville {

	@Id
	@Column(name = "VILLE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short ville_id;
	
	@Column(name="NOM_VILLE")
	protected String nom_ville;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn (name="REGION_ID",nullable=false)
	private Region region;
	
	@OneToMany(mappedBy = "ville",cascade=CascadeType.ALL) 
	private Set<Hotel> hotel = new HashSet<Hotel>(); 
	
	@OneToMany(mappedBy = "ville",cascade=CascadeType.ALL) 
	private Set<Client> client = new HashSet<Client>(); 
	
	public Ville() {

	}

	public Ville(String nom_ville, Region region) {
		super();
		this.nom_ville = nom_ville;
		this.region = region;
	}

	// toString
	public String toString() {
		return String.format("[%d,%s,%d]", getVille_id(), getNom_ville(),
				region.getRegion_id());
	}

	public short getVille_id() {
		return ville_id;
	}

	public void setVille_id(short ville_id) {
		this.ville_id = ville_id;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


}
