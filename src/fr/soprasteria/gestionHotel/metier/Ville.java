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
@Table(name="Ville")

public class Ville {

	@Id
	@Column(name = "VILLE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ville_id;
	
	@Column(name="NOM_VILLE")
	protected String nom_ville;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn (name="REGION_ID",nullable=false)
	private Region region;
	
	@OneToMany(mappedBy = "villes",cascade=CascadeType.ALL) 
	private Set<Ville> villes = new HashSet<Ville>(); 
	
	public Ville() {

	}

	public Ville(String nom) {
		setNom_ville(nom);
	}
	
	// toString
	public String toString() {
		return String.format("[%d,%s,%d]", getVille_id(), getNom_ville(),
				region.getRegion_id());
	}

	public Integer getVille_id() {
		return ville_id;
	}

	public void setVille_id(Integer ville_id) {
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

	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}
	
}
