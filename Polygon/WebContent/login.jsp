<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Polygongroup</title>
<!--  <link rel="css" href="css/login.css">-->
<link href="Resources/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="form">
<form class="login" action="LoginServlet" method="post">
  <%
  String message = (String)session.getAttribute("user.password");
  if(message == null){
	  message = "";
  }
  %>
  <header>Login</header>
  <label><span></span></label>
  <input type="text" name="username" required="required" placeholder="Username"/>
  <label><span></span></label>
  <input type="password" name="password" pattern=".{6,}" required title="6 characters minimum" required="required" placeholder="Password"/>
  <p><label><%=message%></label></p>
  <button type="submit" value="Check" >Login</button>
  <p class="message">Not registered? <a href="#">Create an account</a></p>
</form>
<form class="register" action="CreateUserServlet" method="post">
	  <header>Create account</header>
	  <label></label>
  	  <input type="text" name="organization" placeholder="Organization" />
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
      <p class="message">Already registered? <a href="#">Sign In</a></p>
</form>
</div>
<script src='http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js'></script>
<script src="Resources/js/login.js"></script>

</body>
</html>