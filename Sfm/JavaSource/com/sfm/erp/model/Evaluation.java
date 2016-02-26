package com.sfm.erp.model;


import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * Entity implementation class for Entity: SFM
 * 
 */
@Entity
public class Evaluation implements Serializable {
	private Integer ideval;
	private static final long serialVersionUID = 1L;
	private Personnel perso ;

	private Date  date;
	private Integer note ;
	private String commentaire;
	
	private Competence comp  ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdeval() {
		return ideval;
	}
	
	
	public void setIdeval(Integer ideval) {
		this.ideval = ideval;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	
	public Evaluation() {

	}
	public Evaluation(Integer ideval,  
			Date date, Integer note, String commentaire) {
	
		this.ideval = ideval;
		

		this.date = date;
		this.note = note;
		this.commentaire = commentaire;
	}
	public Evaluation(  Date date, Integer note,
			String commentaire) {
	
	
		this.date = date;
		this.note = note;
		this.commentaire = commentaire;
	}

	@ManyToOne
	@JoinColumn(name = "idcompetence")
	public Competence getComp() {
		return comp;
	}


	public void setComp(Competence comp) {
		this.comp = comp;
	}
	

	@ManyToOne
	@JoinColumn(name = "idpersonnel")
	public Personnel getPerso() {
		return perso;
	}


	public void setPerso(Personnel perso) {
		this.perso = perso;
	}
	
	
	
	
	

}
