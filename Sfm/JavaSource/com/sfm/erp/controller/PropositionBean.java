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

import com.sfm.erp.model.Proposition;

import com.sfm.erp.service.ISharedService;


@ManagedBean
@ViewScoped
public class PropositionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Proposition proposition;
	private Proposition pselected = null;
   private List<Proposition> propositions = new ArrayList<>();

	@PostConstruct
	public void init() {

		proposition = new Proposition();
		propositions = sService.listP();
	}

	public void createProposition() {
		try {
			sService.createP(proposition);
			propositions = sService.listP();
			info();
		} catch (Exception e) {

		}
	}

	public void updateProposition() {
		try {
			sService.updateP(pselected);
		} catch (Exception e) {

		}

	}

	public void deleteProposition() {
		try {
			sService.deleteP(pselected.getReference());
		} catch (Exception e) {

		}

	}

	public void onRowSelect(final SelectEvent event) {
		this.proposition = pselected;

	}

	public void info() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Entitée ajoutée avec succés"));
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Proposition getPselected() {
		return pselected;
	}

	public void setPselected(Proposition pselected) {
		this.pselected = pselected;
	}

}
