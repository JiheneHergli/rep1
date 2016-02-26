package com.sfm.erp.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.sfm.erp.model.*;

import com.sfm.erp.service.ISharedService;



@ManagedBean
@ViewScoped

public class EventBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Event event ;
	@ManagedProperty(value = "#{sharedService}")
	private ISharedService sService;
	private List<Cong> congs  = new ArrayList<>();
	private List<Event> events  = new ArrayList<>();
	
	private  Cong congSelected ;
	private ScheduleModel eventModel;
	
	private   DefaultScheduleModel   eventModels;



	@PostConstruct
	public void init() {
		
		event = new Event();
	    congs = sService.listcong();
        events = sService.listevent();
        eventModel = new DefaultScheduleModel();
        
        for(Cong cong  : getCongs()) {
        	if(cong.getEtat().equals("validée"))
        	{
        		
        		 eventModel.addEvent(new DefaultScheduleEvent ("Le personnel " +cong.getPersonnel().getPrenom() + cong.getPersonnel().getNom() + " a un congé de type "+ cong.getTypeconge().getType() , cong.getDate_debut() , cong.getDate_fin(), "color2" ) );
        		 
        	}
        	else if ((cong.getEtat().equals("en cours")))
        	{
      eventModel.addEvent(new DefaultScheduleEvent ("Le personnel " +cong.getPersonnel().getPrenom() + cong.getPersonnel().getNom() + " veux un congé de type "+ cong.getTypeconge().getType() , cong.getDate_debut() , cong.getDate_fin(),"color1" ) );
       		 
        	}
        	else
        	{
        eventModel.addEvent(new DefaultScheduleEvent ("Le personnel " +cong.getPersonnel().getPrenom() + cong.getPersonnel().getNom() + " n'a pas pu avoir un congé de type "+ cong.getTypeconge().getType() , cong.getDate_debut() , cong.getDate_fin(),"color3" ));
       		 
        	}
        	
   
        }
    	

	}
	
	
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
        {
            
            sService.createevent(event) ; 
    		setEvents(sService.listevent());
    		eventModel.addEvent(event);
            
 
        }
        else
            eventModel.updateEvent(event);
         
        event = new Event();
        
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
    	
        event = (Event) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
    	
        event = new Event("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}


	public ISharedService getsService() {
		return sService;
	}


	public void setsService(ISharedService sService) {
		this.sService = sService;
	}


	public List<Cong> getCongs() {
		return congs;
	}


	public void setCongs(List<Cong> congs) {
		this.congs = congs;
	}


	public DefaultScheduleModel getEventModels() {
		return eventModels;
	}


	public void setEventModels(DefaultScheduleModel eventModels) {
		this.eventModels = eventModels;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;

	}






	public Cong getCongSelected() {
		return congSelected;
	}






	public void setCongSelected(Cong congSelected) {
		this.congSelected = congSelected;
	}

	
 
	}

	
	
    