package com.beeauto.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;



@Entity
public class Abonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAbonnement;
	
	
	@Column(name = "refTT")
	@NotBlank(message = "refTT is mandatory")
	private String refTT;
	
	
	@Column(name = "date Creation")
	@NotBlank(message = "date Creation is mandatory")
	private  Date dateCreation;
	

	@Column(name = "etatTT")
	@NotBlank(message = "etatTT is mandatory")
	private  String etatTT;
	
	@Column(name = "modemSN")
	@NotBlank(message = "ModemSN is mandatory")
	private  String ModemSN;
	
	@Column(name = "agence Livraison")
	@NotBlank(message = "agenceLivraison is mandatory")
	private  String agenceLivraison;
	
	@Column(name = "login Abonnement")
	@NotBlank(message = "login Abonnement is mandatory")
	private  String loginAbonnement;
	
	@Column(name = "mdp abonnement")
	@NotBlank(message = "mdp abonnement is mandatory")
	private  String mdp;

	public long getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(long idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public String getRefTT() {
		return refTT;
	}

	public void setRefTT(String refTT) {
		this.refTT = refTT;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEtatTT() {
		return etatTT;
	}

	public void setEtatTT(String etatTT) {
		this.etatTT = etatTT;
	}

	public String getModemSN() {
		return ModemSN;
	}

	public void setModemSN(String modemSN) {
		ModemSN = modemSN;
	}

	public String getAgenceLivraison() {
		return agenceLivraison;
	}

	public void setAgenceLivraison(String agenceLivraison) {
		this.agenceLivraison = agenceLivraison;
	}
  
	public String getLoginAbonnement() {
		return loginAbonnement;
	}

	public void setLoginAbonnement(String loginAbonnement) {
		this.loginAbonnement = loginAbonnement;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Abonnement() {
	}

	public Abonnement(long idAbonnement, @NotBlank(message = "refTT is mandatory") String refTT,
					  @NotBlank(message = "date Creation is mandatory") Date dateCreation,
					  @NotBlank(message = "etatTT is mandatory") String etatTT,
					  @NotBlank(message = "ModemSN is mandatory") String modemSN,
					  @NotBlank(message = "agenceLivraison is mandatory") String agenceLivraison,
					  @NotBlank(message = "loginAbonnement is mandatory") String loginAbonnement,
					  @NotBlank(message = "mdp abonnement is mandatory") String mdp) {
		super();
		this.idAbonnement = idAbonnement;
		this.refTT = refTT;
		this.dateCreation = dateCreation;
		this.etatTT = etatTT;
		ModemSN = modemSN;
		this.agenceLivraison = agenceLivraison;
		this.loginAbonnement = loginAbonnement;
		this.mdp = mdp;
	}
	
	
	
}
