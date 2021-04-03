package com.beeauto.entites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DemandeAbonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDemandeAbonnement;
	
	@NotBlank(message="offre is mandotory")
	@Column(name="offre")
	private String offre;
	
	@NotBlank(message="debit is mandotory")
	@Column(name="debit")
	private String debit;
	
	@NotBlank(message="frequencePaiement is mandotory")
	@Column(name="frequencePaiement")
	private String frequencePaiement;
	
	@NotBlank(message="adresseInstallation is mandotory")
	@Column(name="adresseInstallation")
	private String adresseInstallation;
	
	@NotBlank(message="ville is mandotory")
	@Column(name="ville")
	private String ville;
	
	@NotBlank(message="gouvernorat is mandotory")
	@Column(name="gouvernorat")
	private String gouvernorat;
	
	@NotNull(message="dateCreation is mandotory")
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@NotBlank(message="agenceCreation is mandotory")
	@Column(name="agenceCreation")
	private String agenceCreation;
	
	@NotBlank(message="etat is mandotory")
	@Column(name="etat")
	private String etat;
	
	@Min(value = 9999999, message = "telADSL should not be less than 9999999")
	@Column(name="telADSL")
	private int telADSL;
	
	@NotBlank(message="typeDemande is mandotory")
	@Column(name="typeDemande")
	private String typeDemande;
	
	
	public DemandeAbonnement() {};

	public DemandeAbonnement(long idDemandeAbonnement,String offre,String debit,
								String frequencePaiement,String adresseInstallation,String ville,
								String gouvernorat, Date dateCreation,String agenceCreation,
								String etat,int telADSL,String typeDemande) {
		
		this.idDemandeAbonnement = idDemandeAbonnement;
		this.offre = offre;
		this.debit = debit;
		this.frequencePaiement = frequencePaiement;
		this.adresseInstallation = adresseInstallation;
		this.ville = ville;
		this.gouvernorat = gouvernorat;
		this.dateCreation = dateCreation;
		this.agenceCreation = agenceCreation;
		this.etat = etat;
		this.telADSL = telADSL;
		this.typeDemande = typeDemande;
	}

	public long getIdDemandeAbonnement() {
		return idDemandeAbonnement;
	}

	public void setIdDemandeAbonnement(long idDemandeAbonnement) {
		this.idDemandeAbonnement = idDemandeAbonnement;
	}

	public String getOffre() {
		return offre;
	}

	public void setOffre(String offre) {
		this.offre = offre;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getFrequencePaiement() {
		return frequencePaiement;
	}

	public void setFrequencePaiement(String frequencePaiement) {
		this.frequencePaiement = frequencePaiement;
	}

	public String getAdresseInstallation() {
		return adresseInstallation;
	}

	public void setAdresseInstallation(String adresseInstallation) {
		this.adresseInstallation = adresseInstallation;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAgenceCreation() {
		return agenceCreation;
	}

	public void setAgenceCreation(String agenceCreation) {
		this.agenceCreation = agenceCreation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getTelADSL() {
		return telADSL;
	}

	public void setTelADSL(int telADSL) {
		this.telADSL = telADSL;
	}

	public String getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}

	@Override
	public String toString() {
		return "DemandeAbonnement [idDemandeAbonnement=" + idDemandeAbonnement + ", offre=" + offre + ", debit=" + debit
				+ ", frequencePaiement=" + frequencePaiement + ", adresseInstallation=" + adresseInstallation
				+ ", ville=" + ville + ", gouvernorat=" + gouvernorat + ", dateCreation=" + dateCreation
				+ ", agenceCreation=" + agenceCreation + ", etat=" + etat + ", telADSL=" + telADSL + ", typeDemande="
				+ typeDemande + "]";
	}
	
	
	
	
}
