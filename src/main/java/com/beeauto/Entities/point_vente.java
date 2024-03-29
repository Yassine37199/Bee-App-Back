package com.beeauto.entities;

import javax.persistence.*;

@Entity
public class point_vente {
	@Id
	@SequenceGenerator( name = "agence_sequence",
			sequenceName = "agence_sequence",
			allocationSize = 1)

	@GeneratedValue(    strategy = GenerationType.SEQUENCE,
			generator = "agence_sequence")

	private long idPDV;
	
	@Column(name = "type" )
	private String type;
	
	@Column(name = "Code")
	private String code; 
	
	@Column (name = "intitule")
	private String intitule;
	
	@Column(name = "contact")
	private String contact;

	
	@Column(name = "tel")
	private int tel;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "agence_mere")
	private String agence_mere;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "etat")
	private String etat;
	
	@Column(name = "details")
	private String details;

	private boolean isActive;

    public point_vente() {
    }

    public point_vente(String type, String code, String intitule, String contact, int tel,
					   String adresse, String agence_mere, String region, String etat, String details, boolean isActive) {
		this.type = type;
		this.code = code;
		this.intitule = intitule;
		this.contact = contact;
		this.tel = tel;
		this.adresse = adresse;
		this.agence_mere = agence_mere;
		this.region = region;
		this.etat = etat;
		this.details = details;
		this.isActive = isActive;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAgence_mere() {
		return agence_mere;
	}
	public void setAgence_mere(String agence_mere) {
		this.agence_mere = agence_mere;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public long getIdAgence() {
		return idPDV;
	}

	public void setIdAgence(long idAgence) {
		this.idPDV = idPDV;
	}
}
