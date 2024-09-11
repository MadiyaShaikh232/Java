<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="upTaskform" method="post" action="upTask">

		<div id="1"
			style="background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg'); background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;">
			<h1 style="color: blue; background-color: white; padding: 10px;">Update Task </h1>

 
        <label>Choose What To Do Update Type: </label>
        <select name="updateType">
            <option value="taskname">Name</option>
            <option value="startdate">Startdate</option>
            <option value="deadline">Deadline</option>
            <option value="all">All</option>
        </select><br>
        
        <button type="submit" value="Submit">Submit</button>
	
        <a href="index.html"><button type="button">Go to Main Menu</button></a>
        
</div>
</form>


</body>
</html>