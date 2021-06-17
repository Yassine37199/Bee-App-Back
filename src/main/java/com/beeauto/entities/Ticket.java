package com.beeauto.entities;

import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private long idTicket;
    private String statut;
    private String sujet;
    private String type;
    private String severite;
    private LocalDateTime dateResolution;
    private LocalDateTime dateCreation;
    private String statutN2;
    private String AgentN2;
    private String AgentResolution;
    private LocalDateTime dateEscalade;

    public Ticket() {
    }

    public Ticket(long idTicket,
                  String statut,
                  String sujet,
                  String type,
                  String severite,
                  LocalDateTime dateResolution,
                  LocalDateTime dateCreation, String statutN2, String agentN2, String agentResolution, LocalDateTime dateEscalade) {
        this.idTicket = idTicket;
        this.statut = statut;
        this.sujet = sujet;
        this.type = type;
        this.severite = severite;
        this.dateResolution = dateResolution;
        this.dateCreation = dateCreation;
        this.statutN2 = statutN2;
        AgentN2 = agentN2;
        AgentResolution = agentResolution;
        this.dateEscalade = dateEscalade;
    }

    public Ticket(String statut,
                  String sujet,
                  String type,
                  String severite,
                  LocalDateTime dateResolution,
                  LocalDateTime dateCreation, String statutN2,
                  String agentN2, String agentResolution, LocalDateTime dateEscalade) {
        this.statut = statut;
        this.sujet = sujet;
        this.type = type;
        this.severite = severite;
        this.dateResolution = dateResolution;
        this.dateCreation = dateCreation;
        this.statutN2 = statutN2;
        AgentN2 = agentN2;
        AgentResolution = agentResolution;
        this.dateEscalade = dateEscalade;
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

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
    }

    public LocalDateTime getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(LocalDateTime dateResolution) {
        this.dateResolution = dateResolution;
    }

    public String getStatutN2() {
        return statutN2;
    }

    public void setStatutN2(String statutN2) {
        this.statutN2 = statutN2;
    }

    public String getAgentN2() {
        return AgentN2;
    }

    public void setAgentN2(String agentN2) {
        AgentN2 = agentN2;
    }

    public String getAgentResolution() {
        return AgentResolution;
    }

    public void setAgentResolution(String agentResolution) {
        AgentResolution = agentResolution;
    }

    public LocalDateTime getDateEscalade() {
        return dateEscalade;
    }

    public void setDateEscalade(LocalDateTime dateEscalade) {
        this.dateEscalade = dateEscalade;
    }

    //Relation Ticket / Abonnement
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



    // Relation Ticket / User
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



}




