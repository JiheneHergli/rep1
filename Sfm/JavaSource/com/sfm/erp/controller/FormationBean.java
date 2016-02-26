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

import com.sfm.erp.model.Formation;
import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class FormationBean implements Serializable{
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Formation frm;
	private Formation pselected=null;
	private List<Formation> formations = new ArrayList<>();


	private static final long serialVersionUID = 1L;


	@PostConstruct
	public void init() {

		frm = new Formation();
		formations = sService.listFRM();
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
	public void onRowSelect(final SelectEvent event) {
		this.frm = pselected;
		
	}
	
	public void createFormation() {
		try {
			sService.createFor(frm);
			formations = sService.listFRM();
			info();
		} catch (Exception e) {

		}
	}
	

	public void updateFormation(){
		try {
		sService.updateFrm(pselected);
		} catch (Exception e) {
			error2();

		}	
	}
	
	public void deleteFormation(){
		try {
		sService.deleteFRM(pselected.getIdformation());
		} catch (Exception e) {
			error1();
		}
	}
	public void info() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"ajout avec succés"));
	}


	public Formation getFrm() {
		return frm;
	}

	public void setFrm(Formation frm) {
		this.frm = frm;
	}

	public Formation getPselected() {
		return pselected;
	}

	public void setPselected(Formation pselected) {
		this.pselected = pselected;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	
	public void error1() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"Erreur de modification !"));
	}
	public void error2() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"Erreur de suppression !"));
	}
}
