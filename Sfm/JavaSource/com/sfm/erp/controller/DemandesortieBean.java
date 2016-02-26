package com.sfm.erp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.sfm.erp.model.Demandesortie;
import com.sfm.erp.service.ISharedService;
import com.sfm.erp.service.MailMail;

@ManagedBean
@SessionScoped
public class DemandesortieBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;

	@ManagedProperty(value = "#{mailMail}")
	private MailMail m;
	private Demandesortie dem;
	private Demandesortie demSelected = null;
	private Date d = new Date();

	private List<Demandesortie> dems = new ArrayList<>();

	@PostConstruct
	public void init() {

		dem = new Demandesortie();
		dems = sService.listdem();

	}
	
public void test() {
	m.sendMail("ibtihelmissaoui5@gmail.com"," ibtihelmissaoui5@gmail.com", "test","hellooooooooooooooo");
	System.out.println("goooooooooooo");
}
	public void createdem() {
		try {

			if (dem.getHeure_debut() < dem.getHeure_fin()) {
                this.dem.setD1(d);
				sService.createdem(dem);
				dems = sService.listdem();
				System.out.print("Success1");
				info("Entité crée");
				m.sendMail("ibtihelmissaoui123456@gmail.com",
						"mohamed.themri@sfmtechnologies.com", "une nouvelle demande de sortie est ajoutée par "+" "+ dem.getPersonnel().getNom() +" "+ dem.getPersonnel().getPrenom()  ,
						"Le personnel " + dem.getPersonnel().getNom() +" "+ dem.getPersonnel().getPrenom() + " a demandé une autorisation de " + dem.getHeure_debut()+" vers "+ dem.getHeure_fin());
				System.out.print("Success4");

				
				System.out.print("Success 5");

			} else {
				error("l'heure de début doit être inférieur à celle de fin");
			}

		} catch (Exception e) {

			error("Erreur de creation !");
		}
	}

	public void updatedem()

	{
		try {

			sService.updatedem(demSelected);
			info("Entité modifiée");
		}

		catch (Exception e) {

			error("Erreur de modification !");
		}
	}

	public void deletedem() {
		try {
			sService.deletedem(demSelected.getIddem());

			info("Entité supprimée");
		} catch (Exception e) {

			error("Erreur de suppression !");

		}
	}

	public void onRowSelect(final SelectEvent event) {
		this.dem = demSelected;

	}

	public String color(String etat) {
		if (etat.equals("en cours")) {

			return "color1";
		} else if (etat.equals("validée")) {
			return "color2";
		} else {
			return "color3";
		}
	}

	// message de succés

	public void info(String info) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", info));
	}

	// message d'erreur

	public void error(String error) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Demandesortie getDem() {
		return dem;
	}

	public void setDem(Demandesortie dem) {
		this.dem = dem;
	}

	public Demandesortie getDemSelected() {
		return demSelected;
	}

	public void setDemSelected(Demandesortie demSelected) {
		this.demSelected = demSelected;
	}

	public List<Demandesortie> getDems() {
		return dems;
	}

	public void setDems(List<Demandesortie> dems) {
		this.dems = dems;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public MailMail getM() {
		return m;
	}

	public void setM(MailMail m) {
		this.m = m;
	}

}
