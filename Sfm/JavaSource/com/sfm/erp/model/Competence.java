package com.sfm.erp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Competence   implements Serializable {

	private static final long serialVersionUID = 1L;
	    private String libelle  ;

	    private List<Evaluation> evaluations;
	    public Integer idcompetence; 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	   public Integer  getIdcompetence() {
			return idcompetence;
		}



		public void setIdcompetence(Integer id) {
			this.idcompetence = id;
		}

	
	

		
		

	@Override
		public String toString() {
			return "Competence [libelle=" + libelle + ", idcompetence="
					+ idcompetence + "]";
		}



	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	public Competence() {
		
	}
	
	public Competence(Integer id, String libelle) {
		super();
		this.idcompetence = id;
		this.libelle = libelle;
	}
	public Competence(String libelle) {
		
		this.libelle = libelle;
	}


	@OneToMany(mappedBy = "comp",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Evaluation> getEvaluations() {
		if (evaluations == null) {
			evaluations = new ArrayList<>();
		}
		return evaluations;
	}



	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idcompetence == null) ? 0 : idcompetence.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;
		if (idcompetence == null) {
			if (other.idcompetence != null)
				return false;
		} else if (!idcompetence.equals(other.idcompetence))
			return false;
		return true;
	}



	

}
