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
import org.primefaces.event.RateEvent;

import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;
 
@ManagedBean
@ViewScoped
public class EvaluationBean  implements Serializable {
	
private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Evaluation eval;
	private Evaluation  evalSelected = null;

	private List<Evaluation> evals  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
		eval = new Evaluation();
	evals = sService.listeval();
		}

	public void createeval() {
		try {
			sService.createeval(eval);
		evals = sService.listeval();
			info("Entité ajoutée avec success");
		} catch (Exception e) {
			error("Erreur de creation");
		}
	}
	
	public void deleteeval() {
		try {
			sService.deleteeval(evalSelected.getIdeval());
			info("Entité supprimée avec success");
		} catch (Exception e) {
			error("Erreur de suppression !");

		}

	}

	
	public void info( String msg ) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						msg));
	}
	


	public void error(String msg) {
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

	
	

	public Evaluation getEval() {
		return eval;
	}

	public void setEval(Evaluation eval) {
		this.eval = eval;
	}

	public Evaluation getEvalSelected() {
		return evalSelected;
	}

	public void setEvalSelected(Evaluation evalSelected) {
		this.evalSelected = evalSelected;
	}

	public List<Evaluation> getEvals() {
		return evals;
	}

	public void setEvals(List<Evaluation> evals) {
		this.evals = evals;
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public void updateeval() {
		try {
			sService.updateeval(evalSelected);
			info("Entité modifiée avec success");
		} catch (Exception e) {
			error("Erreur modification");

		}

	}
	public void onRowSelect(final SelectEvent event) {
		this.eval= evalSelected;

	}
	
	public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evaluation", "la note est :" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "note nulle");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    

}





