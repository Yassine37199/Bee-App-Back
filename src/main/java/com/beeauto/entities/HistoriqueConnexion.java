package com.beeauto.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.validation.constraints.Min;
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
	private DateTimeAtCreation startTime;
	

	@Column(name = "stop time")
	@NotBlank(message = "stop time is mandatory")
	private DateTimeAtCompleted stopTime;
	
	@Column(name = "session time")
	@NotBlank(message = "session time is mandatory")
	private Integer sessionTime ;
	
	@Min(value = 9999999, message = "telADSL should not be less than 9999999")
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

	public DateTimeAtCreation getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTimeAtCreation startTime) {
		this.startTime = startTime;
	}

	public DateTimeAtCompleted getStopTime() {
		return stopTime;
	}

	public void setStopTime(DateTimeAtCompleted stopTime) {
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

	
public HistoriqueConnexion(long idHistorique, @NotBlank(message = "user name is mandatory") String userName,
			@NotBlank(message = "type is mandatory") String type,
			@NotBlank(message = "start time is mandatory") DateTimeAtCreation startTime,
			@NotBlank(message = "stop time is mandatory") DateTimeAtCompleted stopTime,
			@NotBlank(message = "session time is mandatory") Integer sessionTime,
			@NotBlank(message = "tel Adsl is mandatory") Integer telAdsl, ConfigModem config) {
		super();
		this.idHistorique = idHistorique;
		this.userName = userName;
		this.type = type;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.sessionTime = sessionTime;
		this.telAdsl = telAdsl;
		this.config = config;
	}


/**** Many To One ****/
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idConfig", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ConfigModem config ;
	
    
	public ConfigModem getConfig() {
    	return config;
    }
	
    public void setConfig(ConfigModem config) {
    	this.config=config;
    }
    }
