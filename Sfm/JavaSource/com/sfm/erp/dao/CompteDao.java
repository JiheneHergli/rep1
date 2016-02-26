package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Compte;

@Repository
public class CompteDao extends GenericDao<Compte> implements Serializable,
		ICompteDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
