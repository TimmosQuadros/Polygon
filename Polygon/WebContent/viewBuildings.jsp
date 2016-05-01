<%@page import="data.BuildingMapper"%>
<%@page import="data.Building"%>
<%@page import="data.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Facade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View building</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>
	var __adobewebfontsappname__ = "dreamweaver"
</script>
<script
	src="http://use.edgefonts.net/source-sans-pro:n2,i2,n3,i3,n4,i4,n6,i6,n7,i7,n9,i9:default;source-serif-pro:n4:default.js"
	type="text/javascript"></script>

</head>
<body>
	<%@include file="header.jsp"%>
	<a class="click-me" href="addBuilding.jsp">Add building</a>

	<%
		Facade fac = new Facade();
		User user = (User) session.getAttribute("user");
		ArrayList<Building> buildings = new ArrayList<>();
		if(user==null){
			%>
			<jsp:forward page="login.jsp" />
		<%}
		if(user.getUser_type().toString().equalsIgnoreCase("ADMIN")){
			buildings = fac.getAllBuildings();
		}else if (user.getUser_type().toString().equalsIgnoreCase("CUST")){
			buildings = fac.getUserBuildings(user.getOrganisations_id());	
		}else{
			buildings = fac.getAllBuildings();
		}
	%>

	<form action="ButtonClickedServlet" method="post">
		<table>
			<tr>
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>ZIP CODE</th>
				<th>BUILD YEAR</th>
				<th>AREA m<sup>2</sup></th>
				<th>FLOORPLAN</th>
				<th>ORDER CHECKUP</th>
			</tr>

			<%
				for (Building b : buildings) {
			%>
			<tr>
				<td><%=b.getBuilding_name()%></td>
				<td><%=b.getStreet_address()%></td>
				<td><%=b.getZip()%></td>
				<td><%=b.getBuild_year()%></td>
				<td><%=b.getFloor_area()%></td>
				<td><input class="btn-class" type="submit" value="view"
					name="<%=b.getBuilding_id()%>" /></td>
				<td><input class="btn-class" type="submit" onclick="form.action='CheckupServlet';" value="order checkup"
					name="<%=b.getBuilding_id()%>" /></td>
					
			</tr>
			<%
				}
			%>
		</table>
		
	</form>
</body>
</html>