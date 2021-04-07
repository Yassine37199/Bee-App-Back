package com.beeauto.entities;

import com.beeauto.entites.DemandeAbonnement;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Remarque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idRemarque;
    private String text;
    @Transient
    private Date dateCreation;

    public Remarque() {
    }

    public Remarque(int idRemarque, String text) {
        this.idRemarque = idRemarque;
        this.text = text;
    }

    public Remarque(String text) {
        this.text = text;
    }

    public int getIdRemarque() {
        return idRemarque;
    }

    public void setIdRemarque(int idRemarque) {
        this.idRemarque = idRemarque;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateCreation() {
        return Date.valueOf(LocalDate.now());
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDemandeAbonnement", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DemandeAbonnement demande;

    public DemandeAbonnement getDemande() {
        return demande;
    }

    public void setDemande(DemandeAbonnement demande) {
        this.demande = demande;
    }



}
