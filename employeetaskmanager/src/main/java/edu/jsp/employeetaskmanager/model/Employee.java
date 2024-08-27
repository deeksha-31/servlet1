package edu.jsp.employeetaskmanager.model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "My_Seq1")
	@SequenceGenerator(name="My_Seq1", initialValue = 1, allocationSize = 10,sequenceName = "My_Cust_Seq1a")
	private int id;
	private String name;
	private int age;
	private LocalDate DOJ;
	private double Salary;
	
	@ManyToMany
	List <Task> tasks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDOJ() {
		return DOJ;
	}

	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Employee() {
		super();
	}
	
	
	

}
