package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sfm.erp.model.Emploiprecedent;



import org.springframework.stereotype.Repository;



@Repository
public class EmploiprecedentDao extends GenericDao<Emploiprecedent> implements Serializable,
IEmploiprecedentDao {

/**
* 
*/
private static final long serialVersionUID = 1L;

@PersistenceContext
protected EntityManager em;

@SuppressWarnings("unchecked")
@Override
public List<Emploiprecedent> findEmploiByPerson( int idpersonnel )
{
	Query query = em
			.createQuery("SELECT DISTINCT a FROM Emploiprecedent a  JOIN a.personn b WHERE b.idpersonnel = :idpersonnel");
	query.setParameter("idpersonnel", idpersonnel);
	List<Emploiprecedent> emplois = null;
	
	try {
		emplois = (List<Emploiprecedent> ) query.getResultList();
	} catch (Exception e) {
	}
		return emplois;
}
		

}
