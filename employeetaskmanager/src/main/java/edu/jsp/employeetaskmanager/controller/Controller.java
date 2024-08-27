package edu.jsp.employeetaskmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import edu.jsp.employeetaskmanager.model.Employee;
import edu.jsp.employeetaskmanager.model.EmployeeNotFoundException;
import edu.jsp.employeetaskmanager.model.Task;
import edu.jsp.employeetaskmanager.model.TaskNotFoundException;



public class Controller {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("employeetaskmanager");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	List<Employee> employees=new ArrayList<Employee>();
	List<Task> tasks= new ArrayList<Task>();
	
	public Employee addEmployee(Employee employee){
		
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	
		return employee;
	
	}
	
	public Employee removeEmployee(int id) throws EmployeeNotFoundException {
		transaction.begin();
		Employee employee=manager.find(Employee.class, id);
		 if (employee != null) {
			
			 tasks=employee.getTasks();
				if (tasks!=null) {
				
				for (Task task : tasks) {
					task.getEmp().remove(employee);
				}
			}
				manager.merge(employee);
				manager.remove(employee);
				transaction.commit();
				return employee;
			}
			else {
				throw new EmployeeNotFoundException();
			}
		
		
	}
	
	public Employee searchEmployee(int id) throws EmployeeNotFoundException{
	
		Employee employee=manager.find(Employee.class, id);
		
		if(employee!=null) {
			return employee;
		}
		else {
			throw new EmployeeNotFoundException();
		}
		
	}
	
	public List<Employee> getAllEmployee(){
	
	    employees = manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
	    
	    if (employees != null) {
	    	
	    	return employees;
	    }
	    else {
	    	
	    	throw new EmployeeNotFoundException();
	    }
	    
	}

	
	public Task addTask(Task task)
	{
		transaction.begin();
		manager.persist(task);
		transaction.commit();
		return task;
	}
	
	
	public Task removeTask(int id) throws TaskNotFoundException{
		transaction.begin();
		Task task= manager.find(Task.class, id);
		
		if(task!=null) {
			
			for (Employee employee : task.getEmp()) {
				employee.getTasks().remove(task);
				manager.merge(employee);
			}
			
			manager.remove(task);
			transaction.commit();
			
			return task;
		}
		 else {
			 transaction.rollback();
			 throw new TaskNotFoundException();
		 }
	}
	
	
	public Task searchTask(int id) throws TaskNotFoundException
	{
		Task task=manager.find(Task.class, id);
		if(task!=null) {
			return task;
		}
		else {
			throw new TaskNotFoundException();
		}
	}
	
	
	public List<Task> getAllTasks()
	{
		tasks= manager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
		if (tasks != null) {
			
			return tasks;
		}
		else {
			throw new TaskNotFoundException();
		}
	}
	
	
	public Task assignTask(int empId, int taskId)
	{
		
	    Employee employee = manager.find(Employee.class, empId);
	    Task task = manager.find(Task.class, taskId);
	    
	    List<Task> tasks = employee.getTasks();

		List<Employee> employees = task.getEmp();
		
	    if (employee != null && task != null) {
	    	
	    	tasks.add(task);
	    	employee.setTasks(tasks);
	    	employees.add(employee);
			task.setEmp(employees);
			
			transaction.begin();
			manager.merge(employee);
			manager.merge(task);
			transaction.commit();
			
	    }else {
	    	
	        if (employee == null && task == null) {
	        	
	            throw new EmployeeNotFoundException();
	            
	        } else if (employee == null) {
	        	
	            throw new EmployeeNotFoundException();
	            
	        } else {
	        	
	            throw new TaskNotFoundException();
	        }
	    }
	  
	    return task;
	}
	

	 
	 public Employee updateEname(int id, String name) throws EmployeeNotFoundException {
	       
		 	transaction.begin();
	        Employee employee= manager.find(Employee.class,id);

	        if (employee != null) {
	        	try {

	        		employee.setName(name);
	        		manager.merge(employee);
	        		transaction.commit();

	        		return employee;
	        	}
	        	catch (Exception e) {
					// TODO: handle exception
	        		throw new EmployeeNotFoundException();
				}
	        } else {
	        	transaction.rollback();
	            throw new EmployeeNotFoundException();
	        }
	    }
	 
	 public Employee updateAge(int id, int age) throws EmployeeNotFoundException {
	       
		 	transaction.begin();
	        Employee employee= manager.find(Employee.class,id);

	        if (employee != null) {
	        	try {
	        	
	        		employee.setAge(age);
	        		manager.merge(employee);
	        		transaction.commit();

	        		return employee;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	        	transaction.rollback();
	            throw new EmployeeNotFoundException();
	        }
	    }
	 
	 public Employee updateSalary(int id, double Salary) throws EmployeeNotFoundException {
	       
		 	transaction.begin();
	        Employee employee= manager.find(Employee.class,id);

	        if (employee != null) {
	        	try {
	        	
	        		employee.setSalary(Salary);
	        		manager.merge(employee);
	        		transaction.commit();

	        		return employee;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	        	transaction.rollback();
	            throw new EmployeeNotFoundException();
	        }
	    }
	 
	 public Employee updateEmployee(int id, String name, int age, double Salary) throws EmployeeNotFoundException {
	       
		 	transaction.begin();
	        Employee employee= manager.find(Employee.class,id);

	        if (employee != null) {
	        	try {
	        		employee.setName(name);
	        		employee.setAge(age);
	        		employee.setSalary(Salary);
	        		manager.merge(employee);
	        		transaction.commit();

	        		return employee;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	        	transaction.rollback();
	        	throw new EmployeeNotFoundException();
	        }
	    }
	 
	 public Task updateTname(int id, String name) throws TaskNotFoundException {
	        transaction.begin();
	        Task task = manager.find(Task.class, id);

	        if (task != null) {
	        	try {
	        		task.setName(name);

	        		manager.merge(task);
	        		transaction.commit();

	        		return task;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	            transaction.rollback();
	            throw new TaskNotFoundException();
	        }
	    }
	
	 public Task updateStartDate(int id, LocalDate startDate) throws TaskNotFoundException {
	        transaction.begin();
	        Task task = manager.find(Task.class, id);

	        if (task != null) {
	        	try {
	        		task.setStartDate(startDate);
	        		manager.merge(task);
	        		transaction.commit();

	        		return task;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	            transaction.rollback();
	            throw new TaskNotFoundException();
	        }
	    }
	 public Task updateDeadline(int id, LocalDate deadline) throws TaskNotFoundException {
	        transaction.begin();
	        Task task = manager.find(Task.class, id);

	        if (task != null) {
	        	try {
	        		task.setDeadline(deadline);
	        		manager.merge(task);
	        		transaction.commit();

	        		return task;
	        	}
	        	catch (Exception e) {
	        		// TODO: handle exception
	        		throw new EmployeeNotFoundException();
	        	}
	        } else {
	            transaction.rollback();
	            throw new TaskNotFoundException();
	        }
	    }
	 public Task updateTask(int id,String name,  LocalDate deadline) throws TaskNotFoundException {
	        transaction.begin();
	        Task task = manager.find(Task.class, id);

	        if (task != null) {
		        try {
		        		task.setName(name);
		        		task.setDeadline(deadline);
		        		manager.merge(task);
		        		transaction.commit();
	
		        		return task;
		        }
		        catch (Exception e) {
		        	// TODO: handle exception
		        	throw new EmployeeNotFoundException();
		        }
		     } else {
	            transaction.rollback();
	            throw new TaskNotFoundException();
	        }
	    }

	

}
