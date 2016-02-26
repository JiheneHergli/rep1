
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



import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class DepartementBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Departement departement;
	private Departement departementSelected = null;

	private List<Departement> departements  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
	departement = new Departement();
	departements = sService.listdepartement();
	

	}

	public void createdepartement() {
		try {
			sService.createdepar(departement);
		departements = sService.listdepartement();
			info();
		} catch (Exception e) {
			error();
		}
	}
	
	public void deletedepartement() {
		try {
			sService.deletedepartement(departementSelected.getIddepartement());
		} catch (Exception e) {

		}

	}

	
	public void info() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Entité ajouté avec success"));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"Erreur création !"));
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Departement getDepartementSelected() {
		return departementSelected;
	}

	public void setDepartementSelected(Departement departementSelected) {
		this.departementSelected = departementSelected;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}




	
}
