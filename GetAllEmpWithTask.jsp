<%@page import="edu.jsp.controller.Controller"%>
<%@page import="java.util.List"%>
<%@page import="edu.jsp.model.Employee"%>
<%@page import="edu.jsp.model.Task"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
        /* Add your custom styles here */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .header {
            color: blue;
            background-color: aqua;
            padding: 10px;
            margin-bottom: 20px;
        }
        table {
            width: 80%; /* Adjust the width as needed */
            border-collapse: collapse;
            margin: 20px 0;
            background-color: rgba(255, 255, 255, 0.8); /* Adjust background opacity if needed */
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid black;
        }
        .separator {
            margin: 5px;
            padding: 10px;
            font-size: large;
            color: black;
        }
    </style>
</head>
<body>
    <h1 class="header">Get All Employees Details With Task</h1>

    <%
    Controller controller = new Controller();
    List<Employee> employees = controller.getAllEmployee();

    if (employees != null) {
    %>

    <table>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Age</th>
            <th>Employee Salary</th>
            <th>Employee DOJ</th>
            <th>Task ID</th>
        </tr>

        <%
        for (Employee employee : employees) {
        %>

        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getAge() %></td>
            <td><%= employee.getSalary() %></td>
            <td><%= employee.getDOJ() %></td>

            <%
            List<Task> tasks = employee.getTasks();
            if (tasks != null && !tasks.isEmpty()) {
                for (Task task : tasks) {
            %>

            <td><%= task.getId() %></td>

            <%
                }
            }
            %>
        </tr>

        <%
        }
        %>
          <%
        }
        %>
    </table>
    <div class="separator">-------------------------------------------------------</div>
    <a href="index.html"><button type="button" style="margin: 5px;">Go to Main Menu</button></a>
</body>
</html>
