package com.sfm.erp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;


import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;
 

@ManagedBean
@ViewScoped
public class EmploiprecedentBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Emploiprecedent emploiprec ;
	private Emploiprecedent emploiprecSelected = null;

	private List<Emploiprecedent> emploiprecs  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
	emploiprec = new Emploiprecedent();
	emploiprecs = sService.listemploi();
	

	}




	public void createemploiprec() {
		try {
			sService.createemploiprec(emploiprec);
			emploiprecs = sService.listemploi();
			info("Entité ajoutée avec success");
		} catch (Exception e) {
			error("Erreur de creation ");
		}
	}
	
	public void deleteemploiprec() {
		try {
			sService.deleteemploiprec(emploiprecSelected.getIdemploi());
			
			info("Entité supprimé avec success");
		} catch (Exception e) {
			error("erreur de suppression ! ");

		}

	}

	
	public void info( String msg ) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						msg));
	}
	
	


	public void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						msg));
	}



	
	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	
	

	
	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public void updateemploiprec() {
		try {
			sService.updateemploiprec(emploiprecSelected);
			info("Entité modifié");
		} catch (Exception e) {
			error("erreur de modification");

		}

	}
	public void onRowSelect(final SelectEvent event) {
		this.emploiprec = emploiprecSelected;

	}




	public Emploiprecedent getEmploiprec() {
		return emploiprec;
	}




	public void setEmploiprec(Emploiprecedent emploiprec) {
		this.emploiprec = emploiprec;
	}




	public Emploiprecedent getEmploiprecSelected() {
		return emploiprecSelected;
	}




	public void setEmploiprecSelected(Emploiprecedent emploiprecSelected) {
		this.emploiprecSelected = emploiprecSelected;
	}




	public List<Emploiprecedent> getEmploiprecs() {
		return emploiprecs;
	}




	public void setEmploiprecs(List<Emploiprecedent> emploiprecs) {
		this.emploiprecs = emploiprecs;
	}

	




}





