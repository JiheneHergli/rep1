package com.sfm.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Compte
 * 
 */
@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCompte;
	private long numero;
	private String devise;
	private double soldeDt;
	private double soldeDevise;
	private Date dateD;
	private Date dateF;
	private String note;
	private Banque banque;
	private SFM sfm;

	public Compte() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getDevise() {
		return this.devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public double getSoldeDt() {
		return this.soldeDt;
	}

	public void setSoldeDt(double soldeDt) {
		this.soldeDt = soldeDt;
	}

	public double getSoldeDevise() {
		return this.soldeDevise;
	}

	public void setSoldeDevise(double soldeDevise) {
		this.soldeDevise = soldeDevise;
	}

	public Date getDateD() {
		return this.dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Date getDateF() {
		return this.dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ManyToOne
	@JoinColumn(name = "idBanque")
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@ManyToOne
	@JoinColumn(name = "idSfm")
	public SFM getSfm() {
		return sfm;
	}

	public void setSfm(SFM sfm) {
		this.sfm = sfm;
	}

}
