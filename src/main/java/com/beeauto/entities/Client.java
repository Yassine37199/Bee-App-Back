package com.beeauto.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;
	
	@NotBlank(message="name is mandotory")
	@Column(name="name")
	private String name;
	
	@Min(value = 9999999, message = "cin should not be less than 9999999")
	@Column(name="cin")
	private int cin;
	
	@Column(name="email")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message="ville is mandotory")
	@Column(name="ville")
	private String ville;
	
	@NotBlank(message="gouvernorat is mandotory")
	@Column(name="gouvernorat")
	private String gouvernorat;
	
	@NotBlank(message="adresse is mandotory")
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="codePostal")
	@Min(value = 1000, message = "codePostal should not be less than 1000")
	private int codePostal;
	
	@NotNull(message="dateNaissance is mandotory")
	@Column(name="dateNaissance")
	private Date dateNaissance;
	
	@Min(value = 9999999, message = "telephone should not be less than 9999999")
	@Column(name="telephone")
	private int telephone;

	@Transient
	@Column(name="dateCreation")
	private Date dateCreation;
	
	public Client() {};

	public Client(@NotBlank(message = "name is mandotory") String name,
				  @Min(value = 9999999, message = "cin should not be less than 9999999") int cin,
				  @Email(message = "Email should be valid") String email,
				  @NotBlank(message = "ville is mandotory") String ville,
				  @NotBlank(message = "gouvernorat is mandotory") String gouvernorat,
				  @NotBlank(message = "adresse is mandotory") String adresse,
				  @Min(value = 1000, message = "codePostal should not be less than 1000") int codePostal,
				  @NotNull(message = "dateNaissance is mandotory") Date dateNaissance,
				  @Min(value = 9999999, message = "telephone should not be less than 9999999") int telephone) {
		this.name = name;
		this.cin = cin;
		this.email = email;
		this.ville = ville;
		this.gouvernorat = gouvernorat;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
	}

	public Client(long idClient, String name, int cin, String email, String ville, String gouvernorat, String adresse, int codePostal, Date dateNaissance, int telephone) {
	
		this.idClient = idClient;
		this.name = name;
		this.cin = cin;
		this.email = email;
		this.ville = ville;
		this.gouvernorat = gouvernorat;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Date getDateCreation() {
		return Date.valueOf(LocalDate.now());
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", cin=" + cin + ", email=" + email + ", ville="
				+ ville + ", gouvernorat=" + gouvernorat + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", dateCreation=" + dateCreation
				+ "]";
	}
	
	
	
	
	
}
