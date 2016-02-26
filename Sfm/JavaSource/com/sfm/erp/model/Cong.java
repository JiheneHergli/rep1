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
 * Entity implementation class for Entity: Cong
 * 
 */
@Entity
public class Cong  implements Serializable {

	private static final long serialVersionUID = 1L;
     
	    private Personnel personnel ;
	    private Typeconge typeconge ;
	    private String description ;
	    private String tel_durant_conge ;
	    private String adresse_durant_conge ;
	    private Date date_debut;
	    private Date date_fin;
	    private String etat = "en cours" ;
	    private Integer idCong;
	    private int  nbr_jour_conge ;
	    
	    
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Integer getIdCong() {
			return idCong;
		}
		public void setIdCong(Integer idCong) {
			this.idCong = idCong;
		}
	    

		public String getTel_durant_conge() {
			return tel_durant_conge;
		}
		public void setTel_durant_conge(String tel_durant_conge) {
			this.tel_durant_conge = tel_durant_conge;
		}
		public String getAdresse_durant_conge() {
			return adresse_durant_conge;
		}
		public void setAdresse_durant_conge(String adresse_durant_conge) {
			this.adresse_durant_conge = adresse_durant_conge;
		}
		
		@Temporal(TemporalType.DATE )
		public Date getDate_debut() {
			return date_debut;
		}
		public void setDate_debut(Date date_debut) {
			this.date_debut = date_debut;
		}
		
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		@Temporal(TemporalType.DATE )
		public Date getDate_fin() {
			return date_fin;
		}
		public void setDate_fin(Date date_fin) {
			this.date_fin = date_fin;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public Cong() {
			
		} 
	    
	    
	
		
		
		public Cong(Personnel personnel, Typeconge typeconge, Date date_debut,
				Date date_fin, String etat) {
			super();
			this.personnel = personnel;
			this.typeconge = typeconge;
			this.date_debut = date_debut;
			this.date_fin = date_fin;
			this.etat = etat;
		}
		
		public Cong(Personnel personnel, Typeconge typeconge) {
			super();
			this.personnel = personnel;
			this.typeconge = typeconge;
		}
		public Cong(Personnel personnel, Typeconge typeconge,
				String description, String tel_durant_conge,
				String adresse_durant_conge, Date date_debut, Date date_fin,
				String etat, Integer idCong, int nbr_jour_conge) {
			super();
			this.personnel = personnel;
			this.typeconge = typeconge;
			this.description = description;
			this.tel_durant_conge = tel_durant_conge;
			this.adresse_durant_conge = adresse_durant_conge;
			this.date_debut = date_debut;
			this.date_fin = date_fin;
			this.etat = etat;
			this.idCong = idCong;
			this.nbr_jour_conge = nbr_jour_conge;
		}
		@ManyToOne
		@JoinColumn(name = "idtypeconge")
		public Typeconge getTypeconge() {
			return typeconge;
		}
		public void setTypeconge(Typeconge typeconge) {
			this.typeconge = typeconge;
		}
		
		
		@ManyToOne
		@JoinColumn(name = "idpersonnel")
		public Personnel getPersonnel() {
			return personnel;
		}
		
		
		public String  ff() {
			return personnel.getNom();
		}
		public String  f() {
			return personnel.getPrenom();
		}
		public void setPersonnel(Personnel personnel) {
			this.personnel = personnel;

	
		
		}
		public Integer getNbr_jour_conge() {
			return nbr_jour_conge;
		}
		
		public long diff()
		{
			long   a =(this.date_fin.getTime() - this.date_debut.getTime());
		return a/(24*60*60*1000); 
			
		}
		public void setNbr_jour_conge(Integer nbr_jour_conge) {
			
			this.nbr_jour_conge = (int)diff();
		
		}
		
		
	

}
