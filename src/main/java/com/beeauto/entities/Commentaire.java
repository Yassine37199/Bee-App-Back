package com.beeauto.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idCommentaire;
    private String text;
    @Transient
    private Date dateCreation;



    public Commentaire() {
    }



    public Commentaire(int idCommentaire, String text) {
        this.idCommentaire = idCommentaire;
        this.text = text;
    }

    public Commentaire(String text) {
        this.text = text;
    }


    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
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

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "idTicket" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
