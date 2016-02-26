package com.sfm.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Relance implements Serializable{

	private Integer IdRelance;
	private String pays ;
	private String organisme ;
	private String contact;
	private String  etat;
	private Date dateDR;
	private String email;
	private Integer tel;
	private String typeR;
	private String intituleR;
	private String derniere_action;
	private String responsable;
	private Date datePR;
	private String remarques;
	private String type;
	private Date dateDep;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdRelance() {
		return IdRelance;
	}
	public void setIdRelance(Integer idRelance) {
		IdRelance = idRelance;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getOrganisme() {
		return organisme;
	}
	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateDR() {
		return dateDR;
	}
	public void setDateDR(Date dateDR) {
		this.dateDR = dateDR;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getTypeR() {
		return typeR;
	}
	public void setTypeR(String typeR) {
		this.typeR = typeR;
	}
	public String getIntituleR() {
		return intituleR;
	}
	public void setIntituleR(String intituleR) {
		this.intituleR = intituleR;
	}
	public String getDerniere_action() {
		return derniere_action;
	}
	public void setDerniere_action(String derniere_action) {
		this.derniere_action = derniere_action;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Date getDatePR() {
		return datePR;
	}
	public void setDatePR(Date datePR) {
		this.datePR = datePR;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateDep() {
		return dateDep;
	}
	public void setDateDep(Date dateDep) {
		this.dateDep = dateDep;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
