package com.beeauto.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class DemandeAbonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDemandeAbonnement;
	
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
	
	@Transient
	private Date dateCreation;
	
	
	@NotBlank(message="etat is mandotory")
	@Column(name="etat")
	private String etat;
	
	@Min(value = 9999999, message = "telADSL should not be less than 9999999")
	@Column(name="telADSL")
	private int telADSL;
	
	@NotBlank(message="typeDemande is mandotory")
	@Column(name="typeDemande")
	private String typeDemande;

	@Nullable
	private String agentBackOffice;

	private boolean isActive;




	public long getIdDemandeAbonnement() {
		return idDemandeAbonnement;
	}

	public void setIdDemandeAbonnement(long idDemandeAbonnement) {
		this.idDemandeAbonnement = idDemandeAbonnement;
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
		return Date.valueOf(LocalDate.now());
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

	public String getAgentBackOffice() {
		return agentBackOffice;
	}

	public void setAgentBackOffice(String agentBackOffice) {
		this.agentBackOffice = agentBackOffice;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return "DemandeAbonnement [idDemandeAbonnement=" + idDemandeAbonnement +
				", frequencePaiement=" + frequencePaiement + ", adresseInstallation=" + adresseInstallation
				+ ", ville=" + ville + ", gouvernorat=" + gouvernorat + ", dateCreation=" + dateCreation
				+", etat=" + etat + ", telADSL=" + telADSL + ", typeDemande="
				+ typeDemande + "]";
	}


	
	
	
//Client-Demande 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "idClient", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	
	
	
	 private Client client;
	 
	 public Client getClient() {
		 return client;
	 }
	 
	 public void setClient (Client client) {
		 this.client=client;
	 }

	
	
//Offre-Demande
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "idOffre", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	
	
	
	 private Offre offre;
	 
	 public Offre getOffre() {
		 return offre;
	 }
	 
	 public void setOffre (Offre offre) {
		 this.offre=offre;
	 }
	 
//Agence-Demande
		 @ManyToOne(fetch = FetchType.LAZY, optional = false)
		 @JoinColumn(name = "idAgence", nullable = false)
		 @OnDelete(action = OnDeleteAction.CASCADE)
		
		
		
		 private Agence agence;
		 
		 public Agence getAgence() {
			 return agence;
		 }
		 
		 public void setAgence (Agence agence) {
			 this.agence=agence;
		 }	 
	
}
