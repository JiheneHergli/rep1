package com.sfm.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: SFM
 * 
 */
@Entity
public class SFM implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idSfm;
	private String nom;
	private String type;
	private String tel;
	private String email;
	private String adresse;
	private String fax;
	private String mobile;
	private List<Compte> comptes;

	public SFM() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdSfm() {
		return idSfm;
	}

	public void setIdSfm(Integer idSfm) {
		this.idSfm = idSfm;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@OneToMany(mappedBy = "sfm", cascade = CascadeType.ALL)
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
