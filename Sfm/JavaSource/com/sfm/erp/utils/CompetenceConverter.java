package com.sfm.erp.utils;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.sfm.erp.model.Competence;
import com.sfm.erp.service.ISharedService;

@ManagedBean
@RequestScoped
public class CompetenceConverter implements Converter {
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService s;
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Competence comp = null;
		if (!arg2.trim().equals(""))
			comp= s.findcomp(Integer.parseInt(arg2));
		return comp;
	}
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null || arg2.equals(""))
			return null;
		else
			return String.valueOf(((Competence) arg2).getIdcompetence());
	}
	public ISharedService getS() {
		return s;
	}
	public void setS(ISharedService s) {
		this.s = s;
	}

	
	
	
}


