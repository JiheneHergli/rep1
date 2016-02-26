package com.sfm.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposition implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer reference;
	private String intitule;
	private Date dateEnvoi;
	private Date dateAcceptation;
	private String description;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateAcceptation() {
		return dateAcceptation;
	}

	public void setDateAcceptation(Date dateAcceptation) {
		this.dateAcceptation = dateAcceptation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
