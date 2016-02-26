package com.sfm.erp.dao;


import java.util.List;

import com.sfm.erp.model.Demandesortie;

public interface IDemandesortieDao  extends IGenericDao<Demandesortie>
{
	public List<Demandesortie> findDemandeByPerson(int idpersonnel ) ;
}
