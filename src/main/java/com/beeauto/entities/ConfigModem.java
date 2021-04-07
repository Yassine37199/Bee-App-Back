package com.beeauto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
public class ConfigModem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConfig;
	
	@Column(name = "login Modem")
	@NotBlank(message = "login Modem is mandatory")
	private String loginConfig;
	
	@Column(name = "mdp Config modem")
	@NotBlank(message = "mdp Config modem is mandatory")
	private String mdpConfig;


		/***  One To One ***/
	
		@OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idAbonnement", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Abonnement abonnement ;
		
		public Abonnement getabonnement() {
	    	return abonnement;
	    	
		}
		public void setAbonnement (Abonnement abonnement){ 
			this.abonnement = abonnement ; 
		}
		
		public long getIdConfig() {
			return idConfig;
		}
		public void setIdConfig(long idConfig) {
			this.idConfig = idConfig;
		}
		public String getLoginConf() {
			return loginConfig;
		}
		public void setLoginConf(String loginConf) {
			this.loginConfig = loginConf;
		}
		public String getMdpConf() {
			return mdpConfig;
		}
		public void setMdpConf(String mdpConf) {
			this.mdpConfig = mdpConf;
		}
		public Abonnement getAbonnement() {
			return abonnement;
		}
		
		public ConfigModem(long idConfig, @NotBlank(message = "login Modem is mandatory") String loginConfig,
				@NotBlank(message = "mdp Config modem is mandatory") String mdpConfig, Abonnement abonnement) {
			super();
			this.idConfig = idConfig;
			this.loginConfig = loginConfig;
			this.mdpConfig = mdpConfig;
			this.abonnement = abonnement;
		}
	    	
	
		}
