
package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.sfm.erp.model.Evaluation;

@Repository
public class  EvaluationDao extends GenericDao<Evaluation> implements Serializable,
IEvaluationDao {

/**
* 
*/
private static final long serialVersionUID = 1L;


@PersistenceContext
protected EntityManager em;

@SuppressWarnings("unchecked")
@Override
public List<Evaluation> findEvalByPerson(int idpersonnel ) 
{
	Query query = em
			.createQuery("SELECT DISTINCT a FROM Evaluation a  JOIN a.perso b WHERE b.idpersonnel = :idpersonnel");
	query.setParameter("idpersonnel", idpersonnel);
	List<Evaluation> evales = null;
	
	try {
		evales = (List<Evaluation>) query.getResultList();
	} catch (Exception e) {
	}
		return evales;
}
		

}

