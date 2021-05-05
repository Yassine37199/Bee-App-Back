package com.beeauto.entities;


import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAbonnement;

    private String refTT;
    private Date dateCreation;
    private  String etatTT;
    private  String ModemSN;
    private  String agenceLivraison;
    private  String loginAbonnement;
    private  String mdp;

    public Abonnement(long idAbonnement,
                      String refTT,
                      Date dateCreation,
                      String etatTT,
                      String modemSN,
                      String agenceLivraison,
                      String loginAbonnement,
                      String mdp) {
        this.idAbonnement = idAbonnement;
        this.refTT = refTT;
        this.dateCreation = dateCreation;
        this.etatTT = etatTT;
        this.ModemSN = modemSN;
        this.agenceLivraison = agenceLivraison;
        this.loginAbonnement = loginAbonnement;
        this.mdp = mdp;
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
        return dateCreation;
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

    public String getModemSN() {
        return ModemSN;
    }

    public void setModemSN(String modemSN) {
        ModemSN = modemSN;
    }

    public String getAgenceLivraison() {
        return agenceLivraison;
    }

    public void setAgenceLivraison(String agenceLivraison) {
        this.agenceLivraison = agenceLivraison;
    }

    public String getLoginAbonnement() {
        return loginAbonnement;
    }

    public void setLoginAbonnement(String loginAbonnement) {
        this.loginAbonnement = loginAbonnement;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
