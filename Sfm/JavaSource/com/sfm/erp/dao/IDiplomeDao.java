package com.sfm.erp.dao;


import java.util.List;

import com.sfm.erp.model.Diplome;


public interface IDiplomeDao  extends IGenericDao<Diplome>  {
	public List<Diplome> findDiplomelByPerson(int idpersonnel ) ;

}




