package com.sfm.erp.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.primefaces.model.DefaultScheduleEvent;

/**
 * Entity implementation class for Entity: event
 * 
 */
@Entity
public class Notification extends DefaultScheduleEvent  implements Serializable {

	private static final long serialVersionUID = 1L;
	  private int idnotif ;
	  private Boolean vu ;
	  private String  msg  ;
	  
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdnotif() {
		return idnotif;
	}
	public void setIdnotif(int idnotif) {
		this.idnotif = idnotif;
	}
	public Boolean getVu() {
		return vu;
	}
	public void setVu(Boolean vu) {
		this.vu = vu;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Notification() {
	
	} 
	  
	  
	
	
	
	
	

}
