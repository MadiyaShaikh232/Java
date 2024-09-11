<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="upTaskAllform" method="post" action="upTaskAll">

		<div id="1"
			style="background-image: url('https://www.shutterstock.com/image-vector/business-planning-task-management-concept-260nw-1987578881.jpg'); background-size: cover; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;">
			<h1 style="color: blue; background-color: white; padding: 10px;">Update
				Task All Detail</h1>



			<label>Task ID to Update: </label> <input type="text" name="id"
				required><br>

			 <label for="taskname">Updated Name:</label>
                <input type="text" name="taskname" required><br>
                
                <label for="startdate">Updated Task Start Date:</label>
                <input type="date" name="startdate" required><br>
                
                <label for="deadline">Updated Task DeadLine Date:</label>
                <input type="date" name="deadline" required><br>
                

             <input type="submit" value="Update Task">
             
             <a href="index.html">
				<button type="button" style="margin: 5px;">Go to Main Menu</button>
			</a><br>
			
          
		</div>
	</form>


</body>
</html>