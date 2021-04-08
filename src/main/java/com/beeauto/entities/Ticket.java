package com.beeauto.entities;

import com.beeauto.entites.DemandeAbonnement;
import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long idTicket;
    private String statut;
    private String sujet;
    private String type;
    private String severite;
    @Transient
    private Date dateCreation;
    private Date dateResolution;
    private String statutN2;


    public Ticket() {
    }

    public Ticket(long idTicket,
                  String statut,
                  String sujet,
                  String type,
                  String severite,
                  Date dateResolution,
                  String statutN2) {
        this.idTicket = idTicket;
        this.statut = statut;
        this.sujet = sujet;
        this.type = type;
        this.severite = severite;
        this.dateResolution = dateResolution;
        this.statutN2 = statutN2;
    }

    public Ticket(String statut,
                  String sujet,
                  String type,
                  String severite,
                  Date dateResolution,
                  String statutN2) {
        this.statut = statut;
        this.sujet = sujet;
        this.type = type;
        this.severite = severite;
        this.dateResolution = dateResolution;
        this.statutN2 = statutN2;
    }

    public long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(long idTicket) {
        this.idTicket = idTicket;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverite() {
        return severite;
    }

    public void setSeverite(String severite) {
        this.severite = severite;
    }

    public Date getDateCreation() {
        return Date.valueOf(LocalDate.now());
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(Date dateResolution) {
        this.dateResolution = dateResolution;
    }

    public String getStatutN2() {
        return statutN2;
    }

    public void setStatutN2(String statutN2) {
        this.statutN2 = statutN2;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDemandeAbonnement", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private DemandeAbonnement demande;

    public DemandeAbonnement getDemande() {
        return demande;
    }

    public void setDemande(DemandeAbonnement demande) {
        this.demande = demande;
    }

}
