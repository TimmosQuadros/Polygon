<%@page import="data.BuildingMapper"%>
<%@page import="data.Building"%>
<%@page import="data.User"%>
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
<a class="click-me" href="addBuilding.jsp">Add building</a>

<%
BuildingMapper bMap = new BuildingMapper();
User user = (User)session.getAttribute("user");
ArrayList<Building> buildings = new ArrayList<>();//bMap.getUserBuildings(user.getUser_id()); 
buildings.add(new Building("building_name", "street_address", 4444, 1999, 150));
buildings.add(new Building("test_b", "på mars", 5555, 2000, 1));
%>

	<form action="" method="get">
	<table>
	<tr>
		<td>Building name</td>
		<td>Adresse</td>
		<td>zip code</td>
		<td>Build year</td>
		<td>square meters</td>
		<td>click to view</td>
	</tr>
		
<%
for(int i = 0; i<buildings.size(); i++){
	%>
	<tr>
        <td><%=buildings.get(i).getBuilding_name()%></td>
        <td><%=buildings.get(i).getStreet_address()%></td>
        <td><%=buildings.get(i).getZip()%></td>
        <td><%=buildings.get(i).getBuild_year()%></td>
        <td><%=buildings.get(i).getFloor_area()%></td>
        <td><input type="submit" value="view" name="<%=buildings.get(i).getBuilding_id()%>" /></td>
    </tr>
    </table>
</form>
<%
}
%>

</body>
</html>