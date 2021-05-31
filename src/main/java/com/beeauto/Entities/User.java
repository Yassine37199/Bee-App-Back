package com.beeauto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;
	
	@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "nom")
	private String nom;
	
	@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "prenom")
	private String prenom;
	
	@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "motdepasse")
	private String password;
	
	@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "email")
	private String email;
	
	//@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "tel")
	//@Length(min= 8, message = "Taper 8 chiffres")
	private int tel;

	@NotBlank(message="Ce champ est obligatoire")
	@Column(name = "active")
	private String active;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}


	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "roleId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
private Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole (Role role) {
		this.role=role;
	}
	
}
