package edu.jsp.employeetaskmanager.model;

public class EmployeeNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
        return "Employee Not Found. Please verify the Emp Id";
    }
}
