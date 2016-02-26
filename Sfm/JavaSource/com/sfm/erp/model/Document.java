package com.sfm.erp.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private String nom ;
	 private int iddoc ;
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIddoc() {
		return iddoc;
	}
	
	public void setIddoc(int iddoc) {
		this.iddoc = iddoc;
	}
	
	public Document(String nom, int iddoc) {
		
		this.nom = nom;
		this.iddoc = iddoc;
	}
	
	public Document() {
		
	}
	 
	
	

}
