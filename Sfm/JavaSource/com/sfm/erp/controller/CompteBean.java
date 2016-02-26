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

import com.sfm.erp.model.Banque;
import com.sfm.erp.model.Compte;
import com.sfm.erp.model.SFM;
import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class CompteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Compte compte;
	private Banque banque;
	private Banque bSelected = null;
	private SFM sfmSelected = null;
	private SFM sfm;
	private List<Banque> banques = new ArrayList<>();
	private List<SFM> gsfm = new ArrayList<>();

	@PostConstruct
	public void init() {
		compte = new Compte();
		banque = new Banque();
		sfm = new SFM();
		banques = sService.listB();
		gsfm = sService.listSFM();

	}

	public void createBanque() {
		try {
			sService.createB(banque);
			banques = sService.listB();
			info();
		} catch (Exception e) {
			error();
		}
	}

	public void createCompte() {
		try {
			info();
		} catch (Exception e) {
			error();
		}
	}

	public void onRowSelected(final SelectEvent event) {
		this.banque = bSelected;

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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public SFM getSfm() {
		return sfm;
	}

	public void setSfm(SFM sfm) {
		this.sfm = sfm;
	}

	public List<Banque> getBanques() {
		return banques;
	}

	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}

	public Banque getbSelected() {
		return bSelected;
	}

	public void setbSelected(Banque bSelected) {
		this.bSelected = bSelected;
	}

	public List<SFM> getGsfm() {
		return gsfm;
	}

	public void setGsfm(List<SFM> gsfm) {
		this.gsfm = gsfm;
	}

	public SFM getSfmSelected() {
		return sfmSelected;
	}

	public void setSfmSelected(SFM sfmSelected) {
		this.sfmSelected = sfmSelected;
	}

}



