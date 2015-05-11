package fr.soprasteria.gestionHotel.metier;

import java.math.BigDecimal;
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
	@Table(name = "produit")
	public class Produit {
		@Id
		@Column(name = "PRODUIT_ID", nullable = false)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int PRODUIT_ID;


		@Column(name = "NOM_PRODUIT", length = 30, nullable = false, unique = true)
		private String NOM_PRODUIT;

		@Column(name = "PRIX_BASE_PRODUIT", length = 30, nullable = false, unique = true)
		private BigDecimal PRIX_BASE_PRODUIT;

		@OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
		private Set<LigneFacture> ligne_facture = new HashSet<LigneFacture>();

		public String toString() {
			return String.format("[%d,%d,%s]", getPRODUIT_ID(),
					getNOM_PRODUIT(), getPRIX_BASE_PRODUIT());
		}

		public Produit() {
		}

		public Produit(String NOM_PRODUIT, BigDecimal PRIX_BASE_PRODUIT) {
			this.NOM_PRODUIT = NOM_PRODUIT;
			this.PRIX_BASE_PRODUIT = PRIX_BASE_PRODUIT;
		}

		public int getPRODUIT_ID() {
			return PRODUIT_ID;
		}

		public void setPRODUIT_ID(int pRODUIT_ID) {
			PRODUIT_ID = pRODUIT_ID;
		}

		public String getNOM_PRODUIT() {
			return NOM_PRODUIT;
		}

		public void setNOM_PRODUIT(String nOM_PRODUIT) {
			NOM_PRODUIT = nOM_PRODUIT;
		}

		public BigDecimal getPRIX_BASE_PRODUIT() {
			return PRIX_BASE_PRODUIT;
		}

		public void setPRIX_BASE_PRODUIT(BigDecimal pRIX_BASE_PRODUIT) {
			PRIX_BASE_PRODUIT = pRIX_BASE_PRODUIT;
		}




}
