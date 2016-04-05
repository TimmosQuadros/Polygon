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
<title>Insert title here</title>
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
	<a class="click-me" href="addBuilding.jsp">Add building</a>

	<%
		Facade fac = new Facade();
		User user = (User) session.getAttribute("user");
		ArrayList<Building> buildings = fac.getUserBuildings(user.getUser_id());
	%>

	<form action="" method="get">
		<table>
			<tr>
				<th>Building name</th>
				<th>Adresse</th>
				<th>zip code</th>
				<th>Build year</th>
				<th>square meters</th>
				<th>click to view</th>
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
			</tr>
		</table>
	</form>
	<%
		}
	%>

</body>
</html>