package com.sfm.erp.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Idformation;

	private Integer duree;
	private String  libelle ;
	private Float prixparpersonne ; 
	private String formateur;
	private String description ;
	private String organisme ;
	
	public Formation() {
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdformation() {
		return Idformation;
	}
	public void setIdformation(Integer idformation) {
		Idformation = idformation;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Float getPrixparpersonne() {
		return prixparpersonne;
	}
	public void setPrixparpersonne(Float prixparpersonne) {
		this.prixparpersonne = prixparpersonne;
	}
	public String getFormateur() {
		return formateur;
	}
	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganisme() {
		return organisme;
	}
	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public Formation(Integer idformation, Integer vHoraire, String libelle,
			Float prixparpersonne, String formateur, String description,
			String organisme) {
		super();
		Idformation = idformation;
		duree = vHoraire;
		this.libelle = libelle;
		this.prixparpersonne = prixparpersonne;
		this.formateur = formateur;
		this.description = description;
		this.organisme = organisme;
	}
	
	
	
	



}
