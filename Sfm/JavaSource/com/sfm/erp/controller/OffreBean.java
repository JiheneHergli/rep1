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

import com.sfm.erp.model.Offre;

import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class OffreBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Offre off;
	private Offre pselected=null;
	private List<Offre> offres = new ArrayList<>();

	public void onRowSelect(final SelectEvent event) {
		this.off = pselected;
		
	}
	public void info() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"ajout avec succés"));
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	@PostConstruct
	public void init() {

		off = new Offre();
		offres = sService.listOffre();
	}

	public void createOffre() {
		try {
			sService.createOff(off);
			offres = sService.listOffre();
			info();
		} catch (Exception e) {

		}
	}

	public void updateOffre(){
		try {
		sService.updateOff(pselected);
		} catch (Exception e) {

		}	
	}
	public void deleteOffre(){
		try {
		sService.deleteOff(pselected.getIdOffre());
		} catch (Exception e) {
		}
	}
	
	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Offre getOff() {
		return off;
	}

	public void setOff(Offre off) {
		this.off = off;
	}

	public Offre getPselected() {
		return pselected;
	}

	public void setPselected(Offre pselected) {
		this.pselected = pselected;
	}

}
