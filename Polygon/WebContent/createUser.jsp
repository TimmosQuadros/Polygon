<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="wrapper">
        	
<div id="subscribeBox">
	<h2><span class="thin">Add New</span> Building</h2>
    <p>Please fill out the following information to add a new building. please allow 1-2 working days for building to be added to the DB.</p>


<form class="addbuilding" name="addbuilding" method="post" action="CreateBuilding">

	<input id="building_name" type="text" placeholder="Building name*" Name="building_name" required>
	<input id="username" type="text" placeholder="Username*" Name="username" required>
	<input id="password" type="text" placeholder="Password*" Name="password" required>
	<input id="confirm_password" type="text" placeholder="confirm password*" Name="confirm_password" required>
	<input id="email" type="text" placeholder="Email*" Name="floor_area" required>
	
	<input id="submit" type="submit" value="Send">
      	
</form>
        
</div> 
     
</div>

</body>
</html>