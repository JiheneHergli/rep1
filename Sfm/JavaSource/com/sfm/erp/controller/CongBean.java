
package com.sfm.erp.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;


import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;
import com.sfm.erp.service.MailMail;

@ManagedBean
@ViewScoped
public class CongBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	
	@ManagedProperty(value = "#{mailMail}")
	private MailMail m;
	private Cong cong;
	private Cong  congSelected = null;
	private Date d1 = new Date();
	private List<Cong> congs  = new ArrayList<Cong>();
	private List<Cong> conges  = new ArrayList<Cong>();
	
	//constructeur 
	@PostConstruct
	public void init() {
		
	cong = new Cong();
	congs = sService.listcong();

	}

	// les crudes 
	
	
	//fonction de creation 
	
	
	public void createcong() {
		try {
			
if(  (cong.getDate_debut().after(this.d1) ) )  
{

	if(   cong.getDate_fin().after(cong.getDate_debut() ))
			{
	
			sService.createcong(cong);
		congs = sService.listcong();
			info("Entit� ajout�e avec success");
			m.sendMail("ibtihelmissaoui123456@gmail.com",
					"ibtihelmissaoui123456@gmail.com", "une nouvelle demande de cong�  est ajout�e"+ " par " + cong.getPersonnel().getNom() +" "+ cong.getPersonnel().getPrenom() ,
					"Le personnel " + cong.getPersonnel().getNom() +" "+ cong.getPersonnel().getPrenom() + " a demand� un cong�  de " + cong.getDate_debut()+" vers "+cong.getDate_fin() );
			System.out.print("Success4");
			}
	else
	{
		error("la valeur de la date debut de cong� doit etre inf�rieur � celle de la fin de cong�  !");
	}
			
		
}
else 
{
	error("la valeur de la date debut de cong� doit etre inf�rieur � celle d'aujourd'hui  !");
}
	
	
		} catch (Exception e) {
			error("Erreur de  cr�ation !");
		}
	}
	
	//fonction de suppression
	
	public void deletecong() {
		try {
			sService.deleteCompet(congSelected.getIdCong());
			
			info("Entit� supprim�e");
		} catch (Exception e) {
			
			error( "Erreur de suppression !");

		}

	}
	
	

// fonction pour la modification 
	public void updatecong() {
		try {

			if (congSelected.getEtat().equals("valid�e"))
			{
	
		congSelected.getPersonnel().setNbr_jour_restant(congSelected.getPersonnel().getNbr_jour_restant() - congSelected.getNbr_jour_conge()) ;
		
		sService.updatepersonnel(congSelected.getPersonnel());
		sService.updatecong(congSelected);
	
			}
			
			info("Entit� modifi�e");
		     } 
		catch (Exception e) {

			error( "Erreur de modification !" );
		                    }
		

	}
	
	// fonction pour la selection d'une ligne de tableau
	
	public void onRowSelect(final SelectEvent event) {
		this.cong = congSelected;

	}
	
	
	// fonction pour la coloration du tableau de liste des demandes selon l'etat de la demande 
	
	
	public String color( String etat)
	{
		if(etat.equals("en cours"))
		{
			
			return "color1";
		}
		else if(etat.equals("valid�e"))
		{
			return "color2";
		}
		else
		{
			return "color3";
		}
	}
	
	
	//fonction qui calcule le nombre des demandes en cours 
	
	public int totalencours()
	{
		        int total = 0;
		 
		        for(Cong cong  : getCongs()) {
		        	if(cong.getEtat().equals("en cours"))
		        	{
		            total ++;
		        	}
		        }
		 
		        return total;
		    }
	

	
	// fonction qui calcule le nombre des demandes annul�es 
	public int totalannule()
	{
		        int total = 0;
		 
		        for(Cong cong  : getCongs()) {
		        	if(cong.getEtat().equals("annul�e"))
		        	{
		            total ++;
		        	}
		        }
		 
		        return total;
		    }
	
	
	
	// fonction qui calcule le nombre des demandes valid�es
	
	public int totalvalide()
	{
		        int total = 0;
		 
		        for(Cong cong  : getCongs()) {
		        	if(cong.getEtat().equals("valid�e"))
		        	{
		            total ++;
		        	}
		        }
		 
		        return total;
		    }
	
	// message de succ�s 
	
	public void info( String info) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						info));
	}
	

	
	//message d'erreur

	public void error(String error ) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					error	));
	}

	
	
	
	
	
	
	// setters and getters
	
	
	
	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	
	
	public Cong getCong() {
		return cong;
	}

	public void setCong(Cong cong) {
		this.cong = cong;
	}

	public Cong getCongSelected() {
		return congSelected;
	}

	public void setCongSelected(Cong congSelected) {
		this.congSelected = congSelected;
	}

	public List<Cong> getCongs() {
		return congs;
	}

	public void setCongs(List<Cong> congs) {
		this.congs = congs;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}

	public MailMail getM() {
		return m;
	}
	public void setM(MailMail m) {
		this.m = m;
	}
	public List<Cong> getConges() {
		return conges;
	}

	public void setConges(List<Cong> conges) {
		this.conges = conges;
	}

	
	
	}

	
	
    
