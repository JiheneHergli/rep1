package com.sfm.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Typeconge   implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	
	 private String type ;
	 private String description ;
	 private String color ;
	  private List<Cong> congs;
		
	    public Integer idtypeconge; 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	   public Integer getIdtypeconge() {
			return idtypeconge;
		}


		public void setIdtypeconge(Integer id) {
			this.idtypeconge = id;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Typeconge() {
		
		}


		public Typeconge(String type, String description, Integer idtypeconge) {
			super();
			this.type = type;
			this.description = description;
			this.idtypeconge = idtypeconge;
		}


		public Typeconge(String type, String description) {
			super();
			this.type = type;
			this.description = description;
		}


		public Typeconge(String type) {
			super();
			this.type = type;
		}


		@Override
		public String toString() {
			return "Typeconge [type=" + type + ", description=" + description
					+ ", idtypeconge=" + idtypeconge + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((idtypeconge == null) ? 0 : idtypeconge.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Typeconge other = (Typeconge) obj;
			if (idtypeconge == null) {
				if (other.idtypeconge != null)
					return false;
			} else if (!idtypeconge.equals(other.idtypeconge))
				return false;
			return true;
		}

		@OneToMany(mappedBy = "typeconge",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		public List<Cong> getCongs() {
			return congs;
		}


		public void setCongs(List<Cong> congs) {
			this.congs = congs;
		}


		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}
		
		
		
}
