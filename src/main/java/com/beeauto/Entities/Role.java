package com.beeauto.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Role {
	@Id
	@SequenceGenerator(
			name = "role_sequence",
			sequenceName = "role_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "role_sequence"
	)
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

