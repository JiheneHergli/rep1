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
public class DiplomeBean  implements Serializable{


	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Diplome dip ;
	private Diplome  dipSelected = null;

	private List<Diplome> dips  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
	dip = new Diplome();
	dips = sService.listdep();
	

	}

	public void createdip() {
		try {
			sService.createdep(dip);
		dips = sService.listdep();
			info("Entité ajoutée avec success");
		} catch (Exception e) {
			error("erreur de creation");
		}
	}
	
	public void deletedip() {
		try {
			sService.deleteeval(dipSelected.getIddiplome());
			
			info("Entité supprimé avec success");
		} catch (Exception e) {
			error("erreur de suppression");

		}

	}

	
	public void info(String msg) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						msg));
	}
	


	public void error(String msg ) {
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


	public void updatedip() {
		try {
			sService.updatedep(dipSelected);
			info("Entité modifiée avec success");
		} catch (Exception e) {
			error("erreur de modification");

		}

	}
	public void onRowSelect(final SelectEvent event) {
		this.dip= dipSelected;

	}

	public Diplome getDip() {
		return dip;
	}

	public void setDip(Diplome dip) {
		this.dip = dip;
	}

	public Diplome getDipSelected() {
		return dipSelected;
	}

	public void setDipSelected(Diplome dipSelected) {
		this.dipSelected = dipSelected;
	}

	public List<Diplome> getDips() {
		return dips;
	}

	public void setDips(List<Diplome> dips) {
		this.dips = dips;
	}
	







}





