package com.sfm.erp.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement  implements Serializable {
	
	        private static final long serialVersionUID = 1L;
		    private String nom  ;
	
		    public Long iddepartement;
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			public Long getIddepartement() {
				return iddepartement;
			}

			public void setIddepartement(Long iddepartement) {
				this.iddepartement = iddepartement;
			} 
		
			

			public String getNom() {
				return nom;
			}

			public void setNom(String nom) {
				this.nom = nom;
			}

			@Override
			public String toString() {
				return "Departement [nom=" + nom + ", iddepartement="
						+ iddepartement + "]";
			}

		

}
