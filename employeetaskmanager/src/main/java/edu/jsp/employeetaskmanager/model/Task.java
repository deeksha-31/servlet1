package edu.jsp.employeetaskmanager.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "My_Seq")
	@SequenceGenerator(name="My_Seq", initialValue = 1000, allocationSize = 10,sequenceName = "My_Cust_Seq")
	private int taskid;
	private String name;
	private LocalDate StartDate;
	private LocalDate Deadline;
	
	
	@ManyToMany(mappedBy = "tasks")
	List <Employee> emp;



	public int getTaskid() {
		return taskid;
	}


	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getStartDate() {
		return StartDate;
	}


	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}


	public LocalDate getDeadline() {
		return Deadline;
	}


	public void setDeadline(LocalDate deadline) {
		Deadline = deadline;
	}


	public List<Employee> getEmp() {
		return emp;
	}


	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}


	public Task() {
		super();
	}
	
	
	

}
