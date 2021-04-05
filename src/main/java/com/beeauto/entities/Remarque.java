package com.beeauto.entities;


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
}
