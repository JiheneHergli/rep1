package com.sfm.erp.model;
import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * Entity implementation 
 * 
 */
@Entity
public class Emploiprecedent implements Serializable {
	
	 private Integer idemploi;
	 private static final long serialVersionUID = 1L;
	 private Personnel personn ;
	 private Date date_deb;
	 private Date date_ffin;
	 private String poste ;
	 private String entreprise ;
	 private String contrat ;
	 private String description ;
	 
	 
	 
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	public Integer getIdemploi() {
		return idemploi;
	} 
	 
	public void setIdemploi(Integer idemploi) {
		this.idemploi = idemploi;
	}
	
	
	
	@Temporal(TemporalType.DATE )
	public Date getDate_deb() {
		return date_deb;
	}
	
	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}
	
	@Temporal(TemporalType.DATE )
	public Date getDate_ffin() {
		return date_ffin;
	}
	
	
	public void setDate_ffin(Date date_ffin) {
		this.date_ffin = date_ffin;
	}
	
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	public String getEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public String getContrat() {
		return contrat;
	}
	
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Emploiprecedent() {

	}

	public Emploiprecedent(Integer idemploi, Personnel perso, Date date_deb,
			Date date_ffin, String poste, String entreprise, String contrat,
			String description) {
		super();
		this.idemploi = idemploi;
		this.personn = perso;
		this.date_deb = date_deb;
		this.date_ffin = date_ffin;
		this.poste = poste;
		this.entreprise = entreprise;
		this.contrat = contrat;
		this.description = description;
	}
	 
	 

	@ManyToOne
	@JoinColumn(name = "idpersonnel")
	public Personnel getPersonn() {
		
		return personn;
	}
	
	public void setPersonn(Personnel perso) {
		this.personn = perso;
	}
	
	 
	 
	 
}
