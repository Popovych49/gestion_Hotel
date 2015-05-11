package fr.soprasteria.gestionHotel.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="pays")

public class Pays {

	@Id
	@Column(name = "PAYS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pays_id;
	
	
	@Column(name="NOM_PAYS")
	protected String nom_pays;
	
	@OneToMany(mappedBy = "pays",cascade=CascadeType.ALL) 
	private Set<Region> regions = new HashSet<Region>(); 

	public Pays(){
	}
	
	public Pays(String nom){
		setNom_pays(nom);
	}
	
	// toString 
	public String toString() {
		return String.format("[%d,%s]", getPays_id(), getNom_pays());
	}

	public Integer getPays_id() {
		return pays_id;
	}

	public void setPays_id(Integer pays_id) {
		this.pays_id = pays_id;
	}

	public String getNom_pays() {
		return nom_pays;
	}

	public void setNom_pays(String nom_pays) {
		this.nom_pays = nom_pays;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}
	
	
}
