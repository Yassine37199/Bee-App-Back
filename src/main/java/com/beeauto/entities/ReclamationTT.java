package com.beeauto.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ReclamationTT {
	
	
	@Id
	@SequenceGenerator(
			name = "reclamation_sequence",
			sequenceName = "reclamation_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "reclamation_sequence"
	)
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


	//Relation Reclamation / Abonnement
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "idAbonnement" , nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Abonnement abonnement;

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}



	// Relation Reclamation / User
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "idUser" , nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "ReclamationTT [idReclamation=" + idReclamation + ", telADSL=" + telADSL + ", dateReclamation="
				+ dateReclamation + ", objet=" + objet + ", etat=" + etat + ", dateEtat=" + dateEtat + "]";
	};


	
	
	
	
	
}
