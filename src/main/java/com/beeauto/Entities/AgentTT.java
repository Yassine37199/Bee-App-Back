package com.beeauto.entities;

import javax.persistence.*;

@Entity
public class AgentTT {

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
    private Long idAgentTT;
    private String name;
    private String email;

    public AgentTT() {
    }

    public AgentTT(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AgentTT(Long idAgentTT, String name, String email) {
        this.idAgentTT = idAgentTT;
        this.name = name;
        this.email = email;
    }

    public Long getIdAgentTT() {
        return idAgentTT;
    }

    public void setIdAgentTT(Long idAgentTT) {
        this.idAgentTT = idAgentTT;
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
