<%@page import="data.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
<title>Users</title>
</head>
<body>
	<a href="createUser.jsp">Create User</a>
	<form action="" method="get">
	<table>
		<tr>
			<th>User ID</th>
			<th>Organisation ID</th>
			<th>User Type</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Floorplan</th>
		</tr>
		<%
			ArrayList<User> users = new ArrayList<>();
			Facade facade = new Facade();
			users = facade.getUsers();
			for (User u : users) {
				if(u.getUser_type().name().equalsIgnoreCase("CUST")){
		%>
		<tr>
			<td><%=u.getUser_id()%></td>
			<td><%=u.getOrganisations_id()%></td>
			<td><%=u.getUser_type()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUser_email()%></td>
			<td><input class="btn-class" type="submit" value="view"
					name="<%=u.getUser_id()%>" /></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	</form>
</body>
</html>