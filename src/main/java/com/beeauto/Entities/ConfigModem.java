package com.beeauto.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ConfigModem {
    @Id
    @SequenceGenerator(
            name = "modem_sequence",
            sequenceName = "modem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "modem_sequence"
    )
    private long idConfig;
    private String modemSN;
    private String loginConfig;
    private String mdpConfig;

    public ConfigModem() {
    }

    public ConfigModem(long idConfig, String loginConfig, String mdpConfig , String modemSN) {
        this.idConfig = idConfig;
        this.modemSN = modemSN;
        this.loginConfig = loginConfig;
        this.mdpConfig = mdpConfig;
    }

    public long getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(long idConfig) {
        this.idConfig = idConfig;
    }

    public String getLoginConfig() {
        return loginConfig;
    }

    public void setLoginConfig(String loginConfig) {
        this.loginConfig = loginConfig;
    }

    public String getMdpConfig() {
        return mdpConfig;
    }

    public void setMdpConfig(String mdpConfig) {
        this.mdpConfig = mdpConfig;
    }

    public String getModemSN() {
        return modemSN;
    }

    public void setModemSN(String modemSN) {
        this.modemSN = modemSN;
    }

    /***  One To One ***/

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAbonnement", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private com.beeauto.entities.Abonnement abonnement ;

    public Abonnement getabonnement() {
        return abonnement;

    }
    public void setAbonnement (Abonnement abonnement){
        this.abonnement = abonnement ;
    }
}
