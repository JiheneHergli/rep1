package com.sfm.erp.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entity implementation class for Entity: Demandesortie
 * 
 */
@Entity
public class Demandesortie implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
    
    private Personnel personnel ;
    private String description ;
    private String tel ;
    private String adresse ;
    private int  heure_debut;
    private int  heure_fin;
    private String etat = "en cours" ;
    private Integer iddem;
    private int  nbr_heure ;
    private Date d1;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIddem() {
		return iddem;
	}
	public void setIddem(Integer iddem) {
		this.iddem = iddem;
	}
    
    
    
    
	@ManyToOne
	@JoinColumn(name = "idpersonnel")
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(int heure_debut) {
		this.heure_debut = heure_debut;
	}
	public int getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(int heure_fin) {
		this.heure_fin = heure_fin;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

	public int getNbr_heure() {
		return nbr_heure;
	}
	public void setNbr_heure(int nbr_heure) {
		this.nbr_heure = nbr_heure;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public Demandesortie() {
	
	}
    


}
