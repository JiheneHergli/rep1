package com.sfm.erp.dao;
import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Event;

@Repository

public class EventDao  extends  GenericDao<Event> implements Serializable,
IEventDao {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

}
