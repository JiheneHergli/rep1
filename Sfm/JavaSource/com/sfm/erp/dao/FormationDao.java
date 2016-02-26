package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.sfm.erp.model.Formation;

@Repository
public class FormationDao extends GenericDao<Formation> implements IFormationDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		

}
