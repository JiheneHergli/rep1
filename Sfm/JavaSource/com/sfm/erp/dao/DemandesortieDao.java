package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Demandesortie;



@Repository
public class DemandesortieDao extends GenericDao<Demandesortie> implements Serializable,
IDemandesortieDao {

/**
* 
*/
private static final long serialVersionUID = 1L;

@PersistenceContext
protected EntityManager em;

@SuppressWarnings("unchecked")
@Override
public List<Demandesortie> findDemandeByPerson(int idpersonnel ) 
{
	Query query = em
			.createQuery("SELECT DISTINCT a FROM Demandesortie a  JOIN a.personnel b WHERE b.idpersonnel = :idpersonnel");
	query.setParameter("idpersonnel", idpersonnel);
	List<Demandesortie> demandes = null;
	
	try {
		demandes = (List<Demandesortie>) query.getResultList();
	} catch (Exception e) {
	}
		return demandes;
}
		

	
	

}
