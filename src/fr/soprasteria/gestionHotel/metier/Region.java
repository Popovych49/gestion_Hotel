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
@Table(name="region")

public class Region {

	@Id
	@Column(name = "REGION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer region_id;
	
	@Column(name="NOM_REGION")
	protected String nom_region;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn (name="PAYS_ID",nullable=false)
	private Pays pays;
	
	@OneToMany(mappedBy = "regions",cascade=CascadeType.ALL) 
	private Set<Ville> villes = new HashSet<Ville>(); 
	
	public Region(){
		
	}
	
	public Region(String nom) {
		setNom_region(nom);
	}

	// toString 
	public String toString() {
		return String.format("[%d,%s,%d]", getRegion_id(), getNom_region(),pays.getPays_id());
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public String getNom_region() {
		return nom_region;
	}

	public void setNom_region(String nom_region) {
		this.nom_region = nom_region;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	
	
}
