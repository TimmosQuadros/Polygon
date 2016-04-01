<%@page import="data.BuildingMapper"%>
<%@page import="data.Building"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Zip</th>
			<th>Build Year</th>
			<th>Floor Area</th>
		</tr>
		<%
			ArrayList<Building> userBuildings = new ArrayList<>();
			BuildingMapper bmap = new BuildingMapper();
			userBuildings =bmap.getUserBuildings(((data.User)session.getAttribute("user")).getUser_id());
			for (Building b : userBuildings) {
		%>
		<tr>
			<td><%=b.getBuilding_id()%></td>
			<td><%=b.getBuilding_name()%></td>
			<td><%=b.getStreet_address()%></td>
			<td><%=b.getBuild_year()%></td>
			<td><%=b.getFloor_area()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>