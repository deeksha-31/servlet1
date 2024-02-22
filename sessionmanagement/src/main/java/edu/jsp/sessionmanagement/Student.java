package edu.jsp.sessionmanagement;

public class Student {
	
	int id;
	String Name;
	String email;
	String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student() {
		super();
	}
	public Student(int id, String name, String email, String password) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		this.password = password;
	}
	
	

}
