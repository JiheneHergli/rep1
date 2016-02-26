package com.sfm.erp.model;



import java.util.Date;


import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Consultant implements Serializable {

	private static final long serialVersionUID = 1L;

	private String  nom ;
	 private String prenom;
	 private String  cin ;
	 private String  tel_pro;
	 private String  email_pro ;
	 private  String  fax;
	 private String  emploi;
	 private String autres_info;
	 private String  nationnalite;
	 private String  num_compte_bancaire;
	 private String rue;
	 private String  ville;
	 private String  statut ;
	 private Date  date_naissance;
	 private String  sexe;
	 private String etat_civil;
	 private int nbr_enfant;
	 private String ville_naissance;
	 private Integer idconsultant;
	 
	 
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getCin() {
		return cin;
	}
	
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	public String getEmail_pro() {
		return email_pro;
	}
	
	public void setEmail_pro(String email_pro) {
		this.email_pro = email_pro;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmploi() {
		return emploi;
	}
	
	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}
	
	public String getAutres_info() {
	
		return autres_info;
	}
	
	public void setAutres_info(String autres_info) {
		this.autres_info = autres_info;
	}
	
	public String getNum_compte_bancaire() {
		return num_compte_bancaire;
	}
	
	public void setNum_compte_bancaire(String num_compte_bancaire) {
		this.num_compte_bancaire = num_compte_bancaire;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public Date getDate_naissance() {
		return date_naissance;
	}
	
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getEtat_civil() {
		return etat_civil;
	}
	
	public void setEtat_civil(String etat_civil) {
		this.etat_civil = etat_civil;
	}
	
	public int getNbr_enfant() {
		return nbr_enfant;
	}
	
	public void setNbr_enfant(int nbr_enfant) {
		this.nbr_enfant = nbr_enfant;
	}
	
	public String getVille_naissance() {
		return ville_naissance;
	}
	
	public void setVille_naissance(String ville_naissance) {
		this.ville_naissance = ville_naissance;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdconsultant() {
		return idconsultant;
	}
	
	public void setIdconsultant(Integer idconsultant) {
		this.idconsultant = idconsultant;
	}

	public Consultant() {
	
	}

	public String getTel_pro() {
		return tel_pro;
	}

	public void setTel_pro(String tel_pro) {
		this.tel_pro = tel_pro;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public Consultant(String nom, String prenom, String cin, String tel_pro,
			String email_pro, String fax, String emploi, String autres_info,
			String nationnalite, String num_compte_bancaire, String rue,
			String ville, String statut, Date date_naissance, String sexe,
			String etat_civil, int nbr_enfant, String ville_naissance,
			Integer idconsultant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel_pro = tel_pro;
		this.email_pro = email_pro;
		this.fax = fax;
		this.emploi = emploi;
		this.autres_info = autres_info;
		this.nationnalite = nationnalite;
		this.num_compte_bancaire = num_compte_bancaire;
		this.rue = rue;
		this.ville = ville;
		this.statut = statut;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.etat_civil = etat_civil;
		this.nbr_enfant = nbr_enfant;
		this.ville_naissance = ville_naissance;
		this.idconsultant = idconsultant;
	}
		
	
}
