package com.sfm.erp.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sfm.erp.model.Notification;

@Repository
public class  NotificationDao extends GenericDao<Notification> implements Serializable,
INotificationDao {

/**
* 
*/
private static final long serialVersionUID = 1L;



}
