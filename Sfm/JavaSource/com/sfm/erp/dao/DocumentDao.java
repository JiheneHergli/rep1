package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Document;

@Repository
public class DocumentDao  extends GenericDao<Document> implements Serializable,
IDocumentDao {

/**
* 
*/
private static final long serialVersionUID = 1L;

}



