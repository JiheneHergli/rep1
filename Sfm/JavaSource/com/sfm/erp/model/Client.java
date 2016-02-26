package com.sfm.erp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public Integer getTel() {
		return Tel;
	}

	public void setTel(Integer tel) {
		Tel = tel;
	}

	public String getCentreDinteret() {
		return centreDinteret;
	}

	public void setCentreDinteret(String centreDinteret) {
		this.centreDinteret = centreDinteret;
	}

	private Integer idClient;
	private String raisonSociale;
	private String adresse;
	private String email;
	private Integer Tel;
	private String centreDinteret;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}