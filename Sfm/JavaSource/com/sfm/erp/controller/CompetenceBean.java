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
	public class CompetenceBean implements Serializable {

		private static final long serialVersionUID = 1L;
		@ManagedProperty(value = "#{sharedService}")
		private ISharedService sService;
		private Competence competence;
		private Competence competenceSelected = null;
	
		private List<Competence> competences  = new ArrayList<>();
		@PostConstruct
		public void init() {
			
			competence = new Competence();
		competences = sService.listCompetence();
		

		}

		public void createcompetence() {
			try {
				sService.createCo(competence);
			competences = sService.listCompetence();
				info();
			} catch (Exception e) {
				error();
			}
		}
		
		public void deletecompetence() {
			try {
				sService.deleteCompet(competenceSelected.getIdcompetence());
				
				info1();
			} catch (Exception e) {
				error2();

			}

		}

		
		public void info() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité ajoutée avec success"));
		}
		
		public void info1() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité supprimée"));
		}
		public void info2() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité modifiée"));
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

		public Competence getCompetence() {
			return competence;
		}

		public void setCompetence(Competence competence) {
			this.competence = competence;
		}

		public Competence getCompetenceSelected() {
			return competenceSelected;
		}

		public void setCompetenceSelected(Competence competenceSelected) {
			this.competenceSelected = competenceSelected;
		}

		public List<Competence> getCompetences() {
			return competences;
		}

		public void setCompetences(List<Competence> competences) {
			this.competences = competences;
		}
		
		
		public void handleToggle(ToggleEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Toggled", "Visibility:" + event.getVisibility());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}


		public void updateCompetence() {
			try {
				sService.updateCompetence(competenceSelected);
				info2();
			} catch (Exception e) {
				error1();

			}

		}
		public void onRowSelect(final SelectEvent event) {
			this.competence = competenceSelected;

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
