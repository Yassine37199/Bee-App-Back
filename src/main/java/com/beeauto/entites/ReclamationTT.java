package com.beeauto.entites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ReclamationTT {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReclamation;
	
	@Min(value = 9999999, message = "telADSL should not be less than 9999999")
	@Column(name="telADSL")
	private int telADSL;
	
	@NotNull(message="dateReclamation is mandotory")
	@Column(name="dateReclamation")
	private Date dateReclamation;
	
	
	@NotBlank(message="objet is mandotory")
	@Column(name="objet")
	private String objet;
	
	
	@NotBlank(message="etat is mandotory")
	@Column(name="etat")
	private String etat;
	
	@NotNull(message="dateEtat is mandotory")
	@Column(name="dateEtat")
	private Date dateEtat;
	
	
	public ReclamationTT() {}


	public ReclamationTT(long idReclamation,int telADSL,
						Date dateReclamation,String objet,
						String etat, Date dateEtat) {
		this.idReclamation = idReclamation;
		this.telADSL = telADSL;
		this.dateReclamation = dateReclamation;
		this.objet = objet;
		this.etat = etat;
		this.dateEtat = dateEtat;
	}


	public long getIdReclamation() {
		return idReclamation;
	}


	public void setIdReclamation(long idReclamation) {
		this.idReclamation = idReclamation;
	}


	public int getTelADSL() {
		return telADSL;
	}


	public void setTelADSL(int telADSL) {
		this.telADSL = telADSL;
	}


	public Date getDateReclamation() {
		return dateReclamation;
	}


	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Date getDateEtat() {
		return dateEtat;
	}


	public void setDateEtat(Date dateEtat) {
		this.dateEtat = dateEtat;
	}


	@Override
	public String toString() {
		return "ReclamationTT [idReclamation=" + idReclamation + ", telADSL=" + telADSL + ", dateReclamation="
				+ dateReclamation + ", objet=" + objet + ", etat=" + etat + ", dateEtat=" + dateEtat + "]";
	};
	
	
	
	
	
	
}
