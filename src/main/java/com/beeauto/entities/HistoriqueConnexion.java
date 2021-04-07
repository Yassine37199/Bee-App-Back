package com.beeauto.entities;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;





@Entity
public class HistoriqueConnexion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idHistorique;
	
	
	@Column(name = "user name")
	@NotBlank(message = "user name is mandatory")
	private String userName;
	
	
	@Column(name = "type")
	@NotBlank(message = "type is mandatory")
	private String type;
	
	@Column(name = "start time ")
	@NotBlank(message = "start time is mandatory")
	private Time startTime;
	

	@Column(name = "stop time")
	@NotBlank(message = "stop time is mandatory")
	private Time stopTime;
	
	@Column(name = "session time")
	@NotBlank(message = "session time is mandatory")
	private Time sessionTime ;
	
	@Column(name = "tel Adsl ")
	@NotBlank(message = "tel Adsl is mandatory")
	private Integer telAdsl;

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

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getStopTime() {
		return stopTime;
	}

	public void setStopTime(Time stopTime) {
		this.stopTime = stopTime;
	}

	public Time getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Time sessionTime) {
		this.sessionTime = sessionTime;
	}

	public Integer getTelAdsl() {
		return telAdsl;
	}

	public void setTelAdsl(Integer telAdsl) {
		this.telAdsl = telAdsl;
	}

	public HistoriqueConnexion(long idHistorique, @NotBlank(message = "user name is mandatory") String userName,
			@NotBlank(message = "type is mandatory") String type,
			@NotBlank(message = "start time is mandatory") Time startTime,
			@NotBlank(message = "stop time is mandatory") Time stopTime,
			@NotBlank(message = "session time is mandatory") Time sessionTime,
			@NotBlank(message = "tel Adsl is mandatory") Integer telAdsl) {
		super();
		this.idHistorique = idHistorique;
		this.userName = userName;
		this.type = type;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.sessionTime = sessionTime;
		this.telAdsl = telAdsl;
	}

/**** Many To One ****/
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idConfig", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Config config ;
	
    
	public Config getConfig() {
    	return config;
    }
	
    public void setConfig(Config config) {
    	this.config=config;
    }
    }
