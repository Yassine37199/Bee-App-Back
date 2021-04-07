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
public class Config {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConfig;
	
	@Column(name = "login")
	@NotBlank(message = "login is mandatory")
	private String loginConf;
	
	@Column(name = "mdp Conf")
	@NotBlank(message = "mdp Conf is mandatory")
	private String mdpConf;

	public long getIdConfig() {
		return idConfig;
	}

	public void setIdConfig(long idConfig) {
		this.idConfig = idConfig;
	}

	public String getLoginConf() {
		return loginConf;
	}

	public void setLoginConf(String loginConf) {
		this.loginConf = loginConf;
	}

	public String getMdpConf() {
		return mdpConf;
	}

	public void setMdpConf(String mdpConf) {
		this.mdpConf = mdpConf;
	}

	public Config(long idConfig, @NotBlank(message = "login is mandatory") String loginConf,
			@NotBlank(message = "mdp Conf is mandatory") String mdpConf) {
		super();
		this.idConfig = idConfig;
		this.loginConf = loginConf;
		this.mdpConf = mdpConf;
	}

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
	    	
	
		}
