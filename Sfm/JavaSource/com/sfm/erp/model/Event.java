package com.sfm.erp.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.primefaces.model.DefaultScheduleEvent;

/**
 * Entity implementation class for Entity: event
 * 
 */
@Entity
public class Event extends DefaultScheduleEvent  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	    private Cong conge ;
	    private String title ;
	    private int idevent ;
	    private Date  startDate ; 
	    private Date endDate;
		public Cong getConge() {
			return conge;
		}
		public void setConge(Cong conge) {
			this.conge = conge;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public int getIdevent() {
			return idevent;
		}
		public void setIdevent(int idevent) {
			this.idevent = idevent;
		}
		public Event() {
		
		}
		public Event(String title, Date start, Date end) {
			super(title, start, end);
		
		}
		public Event(String title, Date start, Date end, boolean allDay) {
			super(title, start, end, allDay);
		
		}
		public Event(String title, Date start, Date end, Object data) {
			super(title, start, end, data);
			
		}
		public Event(String title, Date start, Date end, String styleClass) {
			super(title, start, end, styleClass);
			// TODO Auto-generated constructor stub
		}
	
		
		public Event(Cong conge, int idevent) {
		
			this.conge = conge;
			this.idevent = idevent;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
	    
	    
		
		
		
		
}
