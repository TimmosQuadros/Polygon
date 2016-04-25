<%@page import="data.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String orgID = request.getParameter("orgID");
		request.getSession().setAttribute("orgName", orgID);
		Facade fac = new Facade();
		ArrayList<Building> buildings = fac.getAllBuildings();
		
	%>

	<form action="buildingReport.jsp" method="post" >
		<table>
			<tr>
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>ZIP CODE</th>
				<th>BUILD YEAR</th>
				<th>AREA m<sup>2</sup></th>
				<th>REPORT</th>
			</tr>

			<%
				for (Building b : buildings) {
					if(b.getOrganisation_id() ==  Integer.parseInt(orgID)){
			%>
			<tr>
				<td><%=b.getBuilding_name()%></td>
				<td><%=b.getStreet_address()%></td>
				<td><%=b.getZip()%></td>
				<td><%=b.getBuild_year()%></td>
				<td><%=b.getFloor_area()%></td>
				<td><input class="btn-class" type="submit" value="Inspect"
					name="<%=b.getBuilding_id()%>" /></td>
					
			</tr>
			<%	
					}
				}
			%>
		</table>
	</form>


</body>
</html>