package com.beeauto.entities;

import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Remarque {

    @Id
    @SequenceGenerator(
            name = "remarque_sequence",
            sequenceName = "remarque_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "remarque_sequence"
    )

    private long idRemarque;
    private String text;
    @Transient
    private Date dateCreation;

    public Remarque() {
    }

    public Remarque(long idRemarque, String text) {
        this.idRemarque = idRemarque;
        this.text = text;
    }

    public Remarque(String text) {
        this.text = text;
    }

    public long getIdRemarque() {
        return idRemarque;
    }

    public void setIdRemarque(long idRemarque) {
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

    // Relation Remarque / User
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "idUser" , nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    // Relation Remarque / Abonnement
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "idAbonnement" , nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private Abonnement abonnement;

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }


    // Relation Remarque / DemandeAbonnement
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "idDemandeAbonnement" , nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private DemandeAbonnement demandeAbonnement;

    public DemandeAbonnement getDemandeAbonnement() {
        return demandeAbonnement;
    }

    public void setDemandeAbonnement(DemandeAbonnement demandeAbonnement) {
        this.demandeAbonnement = demandeAbonnement;
    }





}




