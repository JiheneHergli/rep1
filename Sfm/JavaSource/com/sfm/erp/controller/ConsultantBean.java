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
import com.sfm.erp.model.Consultant;

import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class ConsultantBean implements Serializable  {
	
			private static final long serialVersionUID = 1L;
			
			@ManagedProperty(value = "#{sharedService}")
			private ISharedService sService;
			private Consultant consultant;
			private Consultant consultantSelected = null;
			
			
			private List<Consultant> consultants = new ArrayList<>();
			
			
			@PostConstruct
			public void init() {
				
				consultant= new Consultant();
				consultants= sService.listcons();
				}
			

			
			
			




			public Consultant getConsultant() {
				return consultant;
			}




			public void setConsultant(Consultant consultant) {
				this.consultant = consultant;
			}




			public Consultant getConsultantSelected() {
				return consultantSelected;
			}




			public void setConsultantSelected(Consultant consultantSelected) {
				this.consultantSelected = consultantSelected;
			}




			public List<Consultant> getConsultants() {
				return consultants;
			}




			public void setConsultants(List<Consultant> consultants) {
				this.consultants = consultants;
			}




			public void createcons() {
				try {
					sService.createcons(consultant);
					setConsultants(sService.listcons());
					info();
				}
				catch (Exception e) {
					error();
				
				}
			}
			public void deletecons() {
				try {
					sService.deletecons(consultantSelected.getIdconsultant());
					info1();
				} catch (Exception e) {
					error1();
					

				}

			}
			public void updatecons() {
				try {
					sService.updatecons(consultantSelected);
					info2();
				} catch (Exception e) {
					error2();

				}

			}
			
			public void info() {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Entité ajouté avec success"));
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


			public void onRowSelect(final SelectEvent event) {
				this.consultant = consultantSelected;

			}
	
			public void handleToggle(ToggleEvent event) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Toggled", "Visibility:" + event.getVisibility());
				FacesContext.getCurrentInstance().addMessage(null, msg);
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









			public ConsultantBean() {

			}
			
			
			
			
		
			}

	
	
	
	
	
	

	
	
	
	
	









	
	