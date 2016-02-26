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

import org.primefaces.event.FlowEvent;

import com.sfm.erp.model.Client;
import com.sfm.erp.service.ISharedService;

@ManagedBean 
@ViewScoped
public class ClientBean implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Client client;
	 private boolean skip;
	
	private List<Client> clients = new ArrayList<>();
	
	
	@PostConstruct
	public void init() {
		
		client = new Client();
		setClients(sService.listCl());
		}
	
	
	public void createProposition() {
		try {
			sService.createCl(client);
			setClients(sService.listCl());
			info();
		} catch (Exception e) {
		
		}
	}
	
	public ISharedService getsService() {
		return sService;
	}
	public void setsService(ISharedService sService) {
		this.sService = sService;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void info() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Entitée ajouté avec succés"));
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public boolean isSkip() {
		return skip;
	}


	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	 public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
}
