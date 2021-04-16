package com.beeauto.entities;

import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long idCommentaire;
    private String text;
    @Transient
    private Date dateCreation;



    public Commentaire() {
    }



    public Commentaire(long idCommentaire, String text) {
        this.idCommentaire = idCommentaire;
        this.text = text;
    }

    public Commentaire(String text) {
        this.text = text;
    }


    public long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(long idCommentaire) {
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
    @JoinColumn(name = "idTicket" , nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
