package com.beeauto.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	
	@Id
	@SequenceGenerator(
			name = "client_sequence",
			sequenceName = "client_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "client_sequence"
	)
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

	@Column(name="dateCreation")
	private LocalDateTime dateCreation;

	private Boolean isActive;


	
	public Client() {};

	public Client(@NotBlank(message = "name is mandotory") String name,
				  int cin,
				  @Email(message = "Email should be valid") String email,
				  @NotBlank(message = "ville is mandotory") String ville,
				  @NotBlank(message = "gouvernorat is mandotory") String gouvernorat,
				  @NotBlank(message = "adresse is mandotory") String adresse,
				  int codePostal,
				  @NotNull(message = "dateNaissance is mandotory") Date dateNaissance,
				  int telephone,
				  LocalDateTime dateCreation,
				  Boolean isActive) {
		this.name = name;
		this.cin = cin;
		this.email = email;
		this.ville = ville;
		this.gouvernorat = gouvernorat;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.dateCreation = dateCreation;
		this.isActive = isActive;
	}

	public Client(long idClient,
				  String name,
				  int cin,
				  String email,
				  String ville,
				  String gouvernorat,
				  String adresse,
				  int codePostal,
				  Date dateNaissance,
				  int telephone,
				  LocalDateTime dateCreation, Boolean isActive) {

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
		this.dateCreation = dateCreation;
		this.isActive = isActive;
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

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", cin=" + cin + ", email=" + email + ", ville="
				+ ville + ", gouvernorat=" + gouvernorat + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", dateCreation=" + dateCreation
				+ "]";
	}
	
	
	
	
	
}
