package com.beeauto.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Abonnement {
    @Id
    @SequenceGenerator( name = "abonnement_sequence",
                        sequenceName = "abonnement_sequence",
                        allocationSize = 1)

    @GeneratedValue(    strategy = GenerationType.SEQUENCE,
                        generator = "abonnement_sequence")

    private long idAbonnement;

    private String refTT;
    private Date dateCreation;
    private  String etatTT;
    private  String agenceLivraison;
    private boolean isActive;

    public Abonnement(long idAbonnement,
                      String refTT,
                      Date dateCreation,
                      String etatTT,
                      String agenceLivraison, boolean isActive) {
        this.idAbonnement = idAbonnement;
        this.refTT = refTT;
        this.dateCreation = dateCreation;
        this.etatTT = etatTT;
        this.agenceLivraison = agenceLivraison;
        this.isActive = isActive;
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

    public String getAgenceLivraison() {
        return agenceLivraison;
    }

    public void setAgenceLivraison(String agenceLivraison) {
        this.agenceLivraison = agenceLivraison;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    //Abonnement-Demande
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDemandeAbonnement", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)



    private DemandeAbonnement demandeAbonnement;

    public DemandeAbonnement getDemandeAbonnement() {
        return demandeAbonnement;
    }

    public void setDemandeAbonnement(DemandeAbonnement demandeAbonnement) {
        this.demandeAbonnement = demandeAbonnement;
    }
}
