package com.sfm.erp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;



public interface IGenericDao<T> extends Serializable {

	long countAll(Map<String, Object> params);

	T create(T t);

	void delete(Object id);

	T find(Object id);

	T update(T t);

	public List<T> list();
	}
