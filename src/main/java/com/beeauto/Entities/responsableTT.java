package com.beeauto.entities;

import javax.persistence.*;

@Entity
public class responsableTT {

    @Id
    @SequenceGenerator(
            name = "agentTT_sequence",
            sequenceName = "agentTT_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agentTT_sequence"
    )
    private Long idResponsable;
    private String name;
    private String email;

    public responsableTT() {
    }

    public responsableTT(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public responsableTT(Long idAgentTT, String name, String email) {
        this.idResponsable = idAgentTT;
        this.name = name;
        this.email = email;
    }

    public Long getIdAgentTT() {
        return idResponsable;
    }

    public void setIdAgentTT(Long idAgentTT) {
        this.idResponsable = idAgentTT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
