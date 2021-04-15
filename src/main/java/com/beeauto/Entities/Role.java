package com.beeauto.Entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "role")
	@NotBlank(message="Ce champ est obligatoire")
	private String nomrole;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomrole() {
		return nomrole;
	}

	public void setNomrole(String nomrole) {
		this.nomrole = nomrole;
	}
	
	
	
}

