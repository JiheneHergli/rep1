package com.sfm.erp.model;


import java.util.Date;
import java.util.List;
import java.io.Serializable;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;


@Entity
public class Personnel  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String  nom ;
	 private String prenom;
	 private String  cin ;
	 private String  tel_pro;
	 private String  email_pro ;
	 private  String  fax;
	 private String  departement;
	 private String  emploi;
	 private StreamedContent image = null;
	 private String directeur;
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
	 private String contrat;
	 private int nbr_jour = 30  ;
	 private int nbr_jour_restant = 30 ;
	private Integer idpersonnel;
    private List<Evaluation> evaluations;
    private List<Emploiprecedent> emploi_precs;
    private List<Diplome> diplomes;
    private List<Cong> congs;
    private List<Demandesortie> demandes;
    
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdpersonnel() {
		return idpersonnel;
	}
	public void setIdpersonnel(Integer idPersonnel) {
		this.idpersonnel = idPersonnel;
	}
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
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getEmploi() {
		return emploi;
	}
	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}
	public String getDirecteur() {
		return directeur;
	}
	public void setDirecteur(String directeur) {
		this.directeur = directeur;
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
	
	
	@Temporal(TemporalType.DATE )
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
	public Personnel() {
		
	}
	public Personnel(String nom, String prenom, String cin) {

		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
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
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idpersonnel == null) ? 0 : idpersonnel.hashCode());
		return result;
	}
	public Personnel(String nom, String prenom, String cin, String tel_pro,
				String email_pro, String fax, String departement,
				String emploi, StreamedContent image, String directeur,
				String autres_info, String nationnalite,
				String num_compte_bancaire, String rue, String ville,
				String statut, Date date_naissance, String sexe,
				String etat_civil, int nbr_enfant, String ville_naissance,
				String contrat, int nbr_jour, int nbr_jour_restant,
				Integer idpersonnel, List<Evaluation> evaluations,
				List<Emploiprecedent> emploi_precs, List<Diplome> diplomes,
				List<Cong> congs, List<Demandesortie> demandes) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.cin = cin;
			this.tel_pro = tel_pro;
			this.email_pro = email_pro;
			this.fax = fax;
			this.departement = departement;
			this.emploi = emploi;
			this.image = image;
			this.directeur = directeur;
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
			this.contrat = contrat;
			this.nbr_jour = nbr_jour;
			this.nbr_jour_restant = nbr_jour_restant;
			this.idpersonnel = idpersonnel;
			this.evaluations = evaluations;
			this.emploi_precs = emploi_precs;
			this.diplomes = diplomes;
			this.congs = congs;
			this.demandes = demandes;
		}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnel other = (Personnel) obj;
		if (idpersonnel == null) {
			if (other.idpersonnel != null)
				return false;
		} else if (!idpersonnel.equals(other.idpersonnel))
			return false;
		return true;
	}
	
	
	public int getNbr_jour() {
		return nbr_jour;
	}
	public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}
	


public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

public int getNbr_jour_restant() {
	return nbr_jour_restant;
}

public void setNbr_jour_restant(int nbr_jour_restant) {
	this.nbr_jour_restant = nbr_jour_restant;
}


@OneToMany(mappedBy = "perso",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
public List<Evaluation> getEvaluations() {
	return evaluations;
}
public void setEvaluations(List<Evaluation> evaluations) {
	this.evaluations = evaluations;
}



	@OneToMany(mappedBy = "personnel",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Cong> getCongs() {
		return congs;
	}
	public void setCongs(List<Cong> congs) {
		this.congs = congs;
	}
 
@OneToMany(mappedBy = "personn",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
public List<Emploiprecedent> getEmploi_precs() {
	return emploi_precs;
}
public void setEmploi_precs(List<Emploiprecedent> emploi_precs) {
	this.emploi_precs = emploi_precs;
}


@OneToMany(mappedBy = "person",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
public List<Diplome> getDiplomes() {
	return diplomes;
}
public void setDiplomes(List<Diplome> diplomes) {
	this.diplomes = diplomes;
}

@OneToMany(mappedBy = "personnel",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
public List<Demandesortie> getDemandes() {
	return demandes;
}
public void setDemandes(List<Demandesortie> demandes) {
	this.demandes = demandes;
}
 





	 
}
