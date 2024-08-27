package edu.jsp.employeetaskmanager.model;

public class TaskNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
        return "Task Not Found.Please verify the Task Id";
    }
}
