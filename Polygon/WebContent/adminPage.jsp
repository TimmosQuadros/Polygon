<%@page import="data.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
		User user = (User)session.getAttribute("user");
		if(user==null || user.getUser_type().toString().equals("ADMIN")==false){
	%>
			<jsp:forward page="login.jsp" />
	<%	}%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator control panel</title>
<link href="Resources/css/addbuilding.css" rel="stylesheet" type="text/css"/>
<ul>
	<li><a href="adminPage.jsp">Home</a></li>
	<li><a href="viewBuildings.jsp">View buildings</a></li>
	<li><a href="ViewOrders">View orders</a></li>
	<li><a href="viewCustomers.jsp">View customers</a></li>
	<li><a href="ViewTechnicians">View technicians</a></li>
    <li><a href="Sendnewsletter">Send newsletter</a></li>
</ul>
</head>
<body>



</body>
</html>