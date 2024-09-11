package edu.jsp.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;
@WebServlet(name = "assignTask" ,urlPatterns = {"/assignTask"})
public class AssignTask extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 int empid=Integer.valueOf(req.getParameter("empid"));
	 
	 int taskid=Integer.valueOf(req.getParameter("taskid"));
	 
	 Controller controller =new Controller();
	 
	 if ( controller.assignTask(taskid, empid)!=false) {
		 PrintWriter writer = resp.getWriter();
			writer.write("<html><body><div style=\"background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg');background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;\"><h1 style=\"color: black; padding: 10px;font-size: large;background-color: aqua;\">Assign Task Successfully</h1><a href=\"index.html\"><button type=\"button\" style=\"margin: 5px;\">Go to Main Menu</button></a><br></div></body></html>");

		} else {

			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><div style=\"background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg');background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;\"><h1 style=\"color: black; padding: 10px;font-size: large;\">Something Went Wrong</h1><br><a href=\"index.html\">\"<button type=\"button\" style=\"margin: 5px;\">Go to Main Menu</button></a><br></div></body></html>");

		}
	 
}
}
