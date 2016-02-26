package com.sfm.erp.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theme   implements Serializable {
	private static final long serialVersionUID = 1L;
    private String libelle  ;
	
    public Long idtheme; 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	   public Long getIdtheme() {
			return idtheme;
		}



		public void setIdtheme(Long id) {
			this.idtheme = id;
			
		}



		public String getLibelle() {
			return libelle;
		}



		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}



		public Theme() {
		
		}



		public Theme(String libelle, Long idtheme) {
		
			this.libelle = libelle;
			this.idtheme = idtheme;
		}



		public Theme(String libelle) {
		
			this.libelle = libelle;
		}



		@Override
		public String toString() {
			return "Theme [libelle=" + libelle + ", idtheme=" + idtheme + "]";
		}
		

		
}
