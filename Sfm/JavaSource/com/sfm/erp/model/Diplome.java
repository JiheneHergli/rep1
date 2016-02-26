package com.sfm.erp.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * Entity implementation class 
 * 
 */
@Entity
public class Diplome  implements Serializable {
	
	private Integer iddiplome;
	private static final long serialVersionUID = 1L;
	 private Personnel person ;
	 private Integer  annee ;
	 private String denomination ;
	 private String etablissement ;
	 private String niveau ;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIddiplome() {
		return iddiplome;
	}
	 
	public void setIddiplome(Integer iddiplome) {
		this.iddiplome = iddiplome;
	}
	
	
	public Integer getAnnee() {
		return annee;
	}
	
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Diplome() {
	
	}


	 
	


	@ManyToOne
	@JoinColumn(name = "idpersonnel")
	public Personnel getPerson() {
		return person;
	}
	

	public void setPerson(Personnel person) {
		this.person = person;
	}
	


}
