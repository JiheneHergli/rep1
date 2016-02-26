package com.sfm.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offre  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idOffre;
	private Date dateAchatCC;
	private String pays;
	private Integer fixe;
	private Integer fax;
	private String nom;
	private String mail;

	private Integer montantOffre;
	private String organisme;
	
	private String description;
	private Date dateAcceptation;
	public Integer getFixe() {
		return fixe;
	}

	public void setFixe(Integer fixe) {
		this.fixe = fixe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdOffre() {
		return idOffre;
	}

	public Date getDateAchatCC() {
		return dateAchatCC;
	}

	public void setDateAchatCC(Date dateAchatCC) {
		this.dateAchatCC = dateAchatCC;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getMontantOffre() {
		return montantOffre;
	}

	public void setMontantOffre(Integer montantOffre) {
		this.montantOffre = montantOffre;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAcceptation() {
		return dateAcceptation;
	}

	public void setDateAcceptation(Date dateAcceptation) {
		this.dateAcceptation = dateAcceptation;
	}

	public void setIdOffre(Integer idOffre) {
		this.idOffre = idOffre;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	
	
	

}
