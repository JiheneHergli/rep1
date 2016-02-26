package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Offre;

@Repository
public class OffreDao extends GenericDao<Offre> implements Serializable,IOffreDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
