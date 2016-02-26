
package com.sfm.erp.dao;


import java.util.List;

import com.sfm.erp.model.Evaluation;

public interface IEvaluationDao  extends IGenericDao<Evaluation>  {
	public List<Evaluation> findEvalByPerson(int idpersonnel );

}

