package edu.jsp.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;
import edu.jsp.model.Employee;

@WebServlet(name = "addEmp", urlPatterns = { "/addEmp" })
public class AddEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Controller controller = new Controller();

		String name = req.getParameter("employeename");
		int age = Integer.valueOf(req.getParameter("age"));
		String salaryParam = req.getParameter("sal");
		double salary = (salaryParam != null && !salaryParam.trim().isEmpty()) ? Double.parseDouble(salaryParam) : 0.0;
		Employee emp = new Employee();

		emp.setName(name);
		emp.setAge(age);
		emp.setSalary(salary);

		controller.saveEmp(emp);

		if (controller.saveEmp(emp) != false) {
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><div style=\"background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg');background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;\"><h1 style=\"color: black; padding: 10px;font-size: large;background-color: aqua;\">Employee Added Successfully</h1><a href=\"index.html\"><button type=\"button\" style=\"margin: 5px;\">Go to Main Menu</button></a><br></div></body></html>");

		} else {

			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><div style=\"background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg');background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;\"><h1 style=\"color: black; padding: 10px;font-size: large;\">Something Went Wrong</h1><br><a href=\"index.html\">\"<button type=\"button\" style=\"margin: 5px;\">Go to Main Menu</button></a><br></div></body></html>");

		}
	}

}
