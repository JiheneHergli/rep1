package com.sfm.erp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Banque
 * 
 */
@Entity
public class Banque implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idBanque;
	private String nom;
	private String email;
	private String fax;
	private String tel;
	private String adresse;
	private List<Compte> comptes;

	public Banque() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdBanque() {
		return this.idBanque;
	}

	public void setIdBanque(Integer idBanque) {
		this.idBanque = idBanque;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Compte> getComptes() {
		if (comptes == null) {
			comptes = new ArrayList<>();
		}
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
