<%@page import="java.util.ArrayList"%>
<%@page import="data.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sort by condition level</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
	Facade fac = new Facade();
	ArrayList<BuildingReport> reports = fac.getBuildingReports(building_id)
%>

<table>
	<th>
		<td>Building</td><td></td>Technician<td>Roof remark</td><td>Outer walls remark</td><td>Condition level</td>
	</th>
<%

	
%>
	<tr>
	</tr>
</table>


</body>
</html>