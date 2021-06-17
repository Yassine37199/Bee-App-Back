package com.beeauto.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Offre {

	@Id
	@SequenceGenerator(
			name = "offre_sequence",
			sequenceName = "offre_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "offre_sequence"
	)
	private long idOffre;
	
	@NotBlank(message="labelle is mandotory")
	@Column(name="labelle")
	private String labelle;
	
	@Min(value = 0, message = "cin should not be more than 0")
	@Column(name="debit")
	private int debit;

	private boolean isActive;



	public long getIdOffre() {
		return idOffre;
	}


	public void setIdOffre(long idOffre) {
		this.idOffre = idOffre;
	}


	public String getlabelle() {
		return labelle;
	}


	public void setlabelle(String labelle) {
		this.labelle = labelle;
	}


	public int getDebit() {
		return debit;
	}


	public void setDebit(int debit) {
		this.debit = debit;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", labelle=" + labelle + ", debit=" + debit + "]";
	};
	
	
	
}
