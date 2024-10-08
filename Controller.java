package edu.jsp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.model.*;

public class Controller {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("task");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public boolean saveEmp(Employee employee) {

		transaction.begin();
		manager.persist(employee);
		transaction.commit();

		return true;

	}

	public boolean removeEmp(int id) {
		Employee emp = manager.find(Employee.class, id);

		if (emp != null) {
			List<Task> task = emp.getTasks();
			Iterator<Task> iterator = task.iterator();
			while (iterator.hasNext()) {
				Task task2 = (Task) iterator.next();
				task.remove(task2);
				break;
			}
			transaction.begin();
			emp.setTasks(task);
			manager.remove(emp);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public Employee searchEmp(int id) {
		Employee emp = manager.find(Employee.class, id);
		if (emp != null) {
			return emp;
		} else {
			return null;
		}

	}

//	public List<Employee> getAllEmployee() {
//		String query = "select e from Employee e";
//		Query query1 = manager.createQuery(query);
//		@SuppressWarnings("unchecked")
//		List<Employee> employees = (List<Employee>) query1.getResultList();
//		if (employees != null) {
//			return employees;
//		} else {
//			return null;
//		}
//	}
	
	public List<Employee> getAllEmployee() {
	    try {
	        String query = "select e from Employee e";
	        Query query1 = manager.createQuery(query);
	        @SuppressWarnings("unchecked")
	        List<Employee> employees = (List<Employee>) query1.getResultList();
	        return employees;
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        return null;
	    }
	}


	public boolean addTask(Task task) {

		transaction.begin();
		manager.persist(task);
		transaction.commit();

		return true;

	}

	public boolean removeTask(int id) {
		Task task = manager.find(Task.class, id);

		if (task != null) {
			for (Employee employee : task.getEmployees()) {
				employee.getTasks().remove(task);
				manager.merge(employee);
			}
			
			transaction.begin();
			manager.remove(task);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public Task searchTask(int id) {
		Task task = manager.find(Task.class, id);
		if (task != null) {
			return task;
		} else {
			return null;
		}

	}

	public List<Task> getAllTasks() {
		String query = "select t from Task t";
		Query query1 = manager.createQuery(query);
		@SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) query1.getResultList();
		if (tasks != null) {
			return tasks;
		} else {
			return null;
		}
	}

	public boolean assignTask(int tid, int empid) {
		Employee employee = manager.find(Employee.class, empid);
		Task task = manager.find(Task.class, tid);

		List<Task> tasks = employee.getTasks();
		tasks.add(task);

		List<Employee> employees = task.getEmployees();
		employees.add(employee);

		if (employee != null && task != null) {
			employee.setTasks(tasks);
			task.setEmployees(employees);
			transaction.begin();
			manager.merge(employee);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean updateSal(int id, double salary) {

		Employee emp = manager.find(Employee.class, id);

		if (emp != null) {
			transaction.begin();
			emp.setSalary(salary);
			manager.merge(emp);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateName(int id, String name) {

		Employee emp = manager.find(Employee.class, id);

		if (emp != null) {
			transaction.begin();
			emp.setName(name);
			manager.merge(emp);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateAge(int id, int age) {

		Employee emp = manager.find(Employee.class, id);

		if (emp != null) {
			transaction.begin();
			emp.setAge(age);
			manager.merge(emp);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateTaskName(int id, String name) {

		Task task = manager.find(Task.class, id);

		if (task != null) {
			transaction.begin();
			task.setName(name);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateTaskStart(int id, LocalDate sdate) {

		Task task = manager.find(Task.class, id);

		if (task != null) {
			transaction.begin();
			task.setStartDate(sdate);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateTaskDeadline(int id, LocalDate ddate) {

		Task task = manager.find(Task.class, id);

		if (task != null) {
			transaction.begin();
			task.setDeadLine(ddate);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateTaskAll(int id, String Name, LocalDate sdate, LocalDate ddate) {
		Task task = manager.find(Task.class, id);

		if (task != null) {
			transaction.begin();
			task.setName(Name);
			task.setStartDate(sdate);
			task.setDeadLine(ddate);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}

	public boolean updateEmpAll(int tid, String empName, int empage, double empsal) {
		// TODO Auto-generated method stub
		Employee emp = manager.find(Employee.class, tid);

		if (emp != null) {
			transaction.begin();
			emp.setName(empName);
			emp.setAge(empage);
			emp.setSalary(empsal);
			manager.merge(emp);
			transaction.commit();
			return true;
		} else {

			return false;
		}
	}
	
	public boolean close() {
		
		manager.close();
		factory.close();
		
		return true;
	}

}
