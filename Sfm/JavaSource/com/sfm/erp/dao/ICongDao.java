package com.sfm.erp.dao;

import java.util.List;

import com.sfm.erp.model.Cong;


public interface ICongDao extends IGenericDao<Cong>  {
	public List<Cong> findCongByPerson(int idpersonnel ) ; 
}
