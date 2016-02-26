
package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import com.sfm.erp.model.*;

import javax.persistence.Query;

@Repository
public class  CongDao extends GenericDao<Cong> implements Serializable,
ICongDao {

/**
* 
*/
private static final long serialVersionUID = 1L;


	
	
	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cong> findCongByPerson(int idpersonnel ) 
	{
		Query query = em
				.createQuery("SELECT DISTINCT a FROM Cong a  JOIN a.personnel b WHERE b.idpersonnel = :idpersonnel");
		query.setParameter("idpersonnel", idpersonnel);
		List<Cong> conges = null;
		
		try {
			conges = (List<Cong>) query.getResultList();
		} catch (Exception e) {
		}
			return conges;
			
	
}

}