package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Personnel;

@Repository
public class PersonnelDao extends GenericDao<Personnel> implements Serializable,
IPersonnelDao {

/**
* 
*/
private static final long serialVersionUID = 1L;



}
