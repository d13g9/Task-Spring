package com.dw3.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	

	private @Id @GeneratedValue Long id;
	private String tasktitle;
	private String taskdescription;
	private String status; //Later change it to enumerations
	
	
	
	public Task() {
		
	}
	
	public Task(Long id, String tasktitle, String taskdescription, String status) {
		super();
		this.id = id;
		this.tasktitle = tasktitle;
		this.taskdescription = 	taskdescription;
		this.status = status;
	}
	
	public Task(String tasktitle, String taskdescription, String status) {	
		this.tasktitle = tasktitle;
		this.taskdescription = taskdescription;
		this.status = status;
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTasktitle() {
		return tasktitle;
	}
	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.tasktitle, this.taskdescription,this.status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		      return true;
		if (!(obj instanceof Task))
		      return false;
		
	    Task task = (Task) obj;
	    return Objects.equals(this.id, task.id) && Objects.equals(this.tasktitle, task.getTasktitle())
	        && Objects.equals(this.taskdescription, task.taskdescription) && Objects.equals(this.status, task.status);
		        
		       
		
	}
	
	
	
}
