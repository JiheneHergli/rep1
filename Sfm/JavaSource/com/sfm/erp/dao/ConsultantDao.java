package com.sfm.erp.dao;
import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Consultant;

@Repository
public class ConsultantDao extends GenericDao<Consultant> implements Serializable,
IConsultantDao {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

}



