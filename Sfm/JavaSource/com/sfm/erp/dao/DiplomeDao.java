package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Diplome;


@Repository
public class DiplomeDao extends GenericDao<Diplome> implements Serializable,
IDiplomeDao {

/**
* 
*/
private static final long serialVersionUID = 1L;

@PersistenceContext
protected EntityManager em;

@SuppressWarnings("unchecked")
@Override
public List<Diplome> findDiplomelByPerson(int idpersonnel ) 
{
	Query query = em
			.createQuery("SELECT DISTINCT a FROM Diplome a  JOIN a.person b WHERE b.idpersonnel = :idpersonnel");
	query.setParameter("idpersonnel", idpersonnel);
	List<Diplome> diplomes = null;
	
	try {
		diplomes = (List<Diplome>) query.getResultList();
	} catch (Exception e) {
	}
		return diplomes;
}
		

}




