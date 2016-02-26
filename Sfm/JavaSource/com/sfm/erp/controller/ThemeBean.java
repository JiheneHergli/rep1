
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


import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;

@ManagedBean
@ViewScoped
public class ThemeBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private Theme theme;
	private Theme themeSelected = null;

	private List<Theme> themes  = new ArrayList<>();
	@PostConstruct
	public void init() {
		
		theme= new Theme();
	themes = sService.listtheme();
	

	}

	public void createtheme() {
		try {
			sService.createthe(theme);
		themes = sService.listtheme();
			info();
		} catch (Exception e) {
			error();
		}
	}
	
	public void deletetheme() {
		try {
			sService.deleteth(themeSelected.getIdtheme());
		} catch (Exception e) {

		}

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

	public ISharedService getsService() {
		return sService;
	}

	public void setsService(ISharedService sService) {
		this.sService = sService;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Theme getThemeSelected() {
		return themeSelected;
	}

	public void setThemeSelected(Theme themeSelected) {
		this.themeSelected = themeSelected;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}





	
}
