
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
public class TypecongeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Typeconge typeconge;
	private Typeconge typecongeSelected = null;

	private List<Typeconge> typeconges  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
	typeconge = new Typeconge();
	typeconges = sService.listtype();
	

	}

	public void createtypeconge() {
		try {
			sService.createty(typeconge);
		typeconges = sService.listtype();
			info("Entité ajouté avec success");
		} catch (Exception e) {
			error("erreur de creation!");
		}
	}
	
	public void deletetypeconge() {
		try {
			sService.deletetype(typecongeSelected.getIdtypeconge());
			info("Entité supprimé avec success");
		} catch (Exception e) {
			error("Erreur de suppression ! ");

		}

	}
	
	public void updatetypeconge() {
		try {
			
			sService.updatetype( typecongeSelected);
			info("Entité  modifié  avec success");
		} catch (Exception e) {
			error("Erreur de modification !");

		}

	}
	
	

	
	public void info( String msg ) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						msg ));
	}

	public void error(String msg ) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						msg ));
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Typeconge getTypeconge() {
		return typeconge;
	}

	public void setTypeconge(Typeconge typeconge) {
		this.typeconge = typeconge;
	}

	public Typeconge getTypecongeSelected() {
		return typecongeSelected;
	}

	public void setTypecongeSelected(Typeconge typecongeSelected) {
		this.typecongeSelected = typecongeSelected;
	}

	public List<Typeconge> getTypeconges() {
		return typeconges;
	}

	public void setTypeconges(List<Typeconge> typeconges) {
		this.typeconges = typeconges;
	}



	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	  



	public void onRowSelect(final SelectEvent event) {
		this.typeconge = typecongeSelected;

	}


	
}
