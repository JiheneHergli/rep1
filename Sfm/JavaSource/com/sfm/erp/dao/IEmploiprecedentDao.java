package com.sfm.erp.dao;

import java.util.List;

import com.sfm.erp.model.Emploiprecedent;


public interface IEmploiprecedentDao  extends IGenericDao<Emploiprecedent >  {
	
	
	public List<Emploiprecedent> findEmploiByPerson( int idpersonnel );
	
	

}
