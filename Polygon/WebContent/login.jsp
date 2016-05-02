<%@page import="data.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  
  User user = (User) session.getAttribute("user");
	if(user!=null){
		
		switch (user.getUser_type()) {
		case ADMIN: %> <jsp:forward page="adminPage.jsp"/> <%
		case TECH:	%> <jsp:forward page="techPage.jsp"/> <%
		case CUST:	%> <jsp:forward page="customerPage.jsp"/> <%
		} 
	} 
  
  String message = (String)session.getAttribute("user.password");
  if(message == null){
	  message = "";
  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Polygon Group</title>
<!--  <link rel="css" href="css/login.css">-->
<link href="Resources/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="form">
<form class="login" action="Login" method="post">
  
  <header>Login</header>
  <label><span></span></label>
  <input type="text" name="username" maxlength="45" required="required" placeholder="Username"/>
  <label><span></span></label>
  <input type="password" name="password" pattern=".{6,}" required title="6 characters minimum" required="required" placeholder="Password"/>
  <p><label class="message"><%=message%></label></p>
  <button type="submit" value="Check" >Login</button>
</form>
</div>
</body>
</html>