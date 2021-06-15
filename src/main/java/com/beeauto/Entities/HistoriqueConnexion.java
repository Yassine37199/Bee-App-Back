package com.beeauto.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class HistoriqueConnexion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idHistorique;

    private String userName;
    private String type;
    private Date startTime;
    private Date stopTime;
    private Integer sessionTime;
    private Integer telAdsl;

    public HistoriqueConnexion() {
    }

    public HistoriqueConnexion(long idHistorique,
                               String userName,
                               String type,
                               Date startTime,
                               Date stopTime,
                               Integer sessionTime,
                               Integer telAdsl) {
        this.idHistorique = idHistorique;
        this.userName = userName;
        this.type = type;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.sessionTime = sessionTime;
        this.telAdsl = telAdsl;
    }

    public long getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(long idHistorique) {
        this.idHistorique = idHistorique;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Integer sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Integer getTelAdsl() {
        return telAdsl;
    }

    public void setTelAdsl(Integer telAdsl) {
        this.telAdsl = telAdsl;
    }


}

