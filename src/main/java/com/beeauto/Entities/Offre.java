package com.beeauto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idOffre;
	
	@NotBlank(message="labelle is mandotory")
	@Column(name="labelle")
	private String labelle;
	
	@Min(value = 0, message = "cin should not be more than 0")
	@Column(name="debit")
	private int debit;
	
	
	public Offre() {}
	


	public Offre(long idOffre, String labelle,int debit) {
		this.idOffre = idOffre;
		this.labelle = labelle;
		this.debit = debit;
	}




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



	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", labelle=" + labelle + ", debit=" + debit + "]";
	};
	
	
	
}
