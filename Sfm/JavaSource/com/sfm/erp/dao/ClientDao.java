package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Client;

@Repository
public class ClientDao extends GenericDao<Client> implements Serializable,
IClientDao {

/**
* 
*/
private static final long serialVersionUID = 1L;



}
