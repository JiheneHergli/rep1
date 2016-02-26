package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Banque;

@Repository
public class BanqueDao extends GenericDao<Banque> implements Serializable,
		IBanqueDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
