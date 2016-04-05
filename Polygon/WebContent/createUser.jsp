<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form">
<form class="register" action="CreateUser" method="post">
	  <header>Create account</header>
	  <label></label>
  	  <input type="text" name="organisation" placeholder="Organisation" />
      <label><span></span></label>
      <input type="text" name="username" placeholder="Username"/>
      <label><span></span></label>
  	  <input type="password" name="password" placeholder="Password" />
      <label></label>
  	  <input type="text" name="email" placeholder="Email" />
  	  <div>
  	  <label></label>
  	  <select id="usertype" name="usertype">
      	<option value="CUST">Customer</option>
      	<option value="TECH">Technician</option>
      	<option value="ADMIN">Administrator</option>
	  </select>
	  </div>
      <button type="submit" value="Check" >Create</button>
</form>
</div>
</body>
</html>