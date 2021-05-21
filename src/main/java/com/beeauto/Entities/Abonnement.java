package com.beeauto.entities;


import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAbonnement;

    private String refTT;

    @Transient
    private Date dateCreation;
    private  String etatTT;
    private  String agenceLivraison;

    public Abonnement(long idAbonnement,
                      String refTT,

                      String etatTT,

                      String agenceLivraison

                      ) {
        this.idAbonnement = idAbonnement;
        this.refTT = refTT;
        this.etatTT = etatTT;
        this.agenceLivraison = agenceLivraison;
    }

    public Abonnement() {
    }

    public long getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(long idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getRefTT() {
        return refTT;
    }

    public void setRefTT(String refTT) {
        this.refTT = refTT;
    }

    public Date getDateCreation() {
        return Date.valueOf(LocalDate.now());
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEtatTT() {
        return etatTT;
    }

    public void setEtatTT(String etatTT) {
        this.etatTT = etatTT;
    }

    public String getAgenceLivraison() {
        return agenceLivraison;
    }

    public void setAgenceLivraison(String agenceLivraison) {
        this.agenceLivraison = agenceLivraison;
    }

}
