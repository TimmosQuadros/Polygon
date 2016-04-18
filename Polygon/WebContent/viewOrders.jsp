<%@page import="data.Facade"%>
<%@page import="data.Organisation"%>
<%@page import="data.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Checkup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View orders</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		Facade facade = new Facade();
		ArrayList<Checkup> checkupOrders = new ArrayList<>();
		ArrayList<Building> buildingsList = new ArrayList<>();
		ArrayList<Organisation> organisationList = new ArrayList<>();
		organisationList = facade.getOrganisations();
		checkupOrders = facade.getCheckups();
		buildingsList = facade.getAllBuildings();
	%>
	<form action="" method="get">
		<table class="spacing">
			<tr>
				<th>ORDER ID</th>
				<th>BUILDING NAME</th>
				<th>ORDERED BY</th>
				<th>ISSUE DATE</th>
				<th>STATUS</th>
				<th>ASSIGN TECH</th>

			</tr>

			<%
				for (Checkup c : checkupOrders) {

					int checkupID = c.getCheckupID();
					String issueDate = c.getDateIssued();
					String status = c.getStatus().name();
					String orderedBy = "";
					String buildingName = "";
					for (Building b : buildingsList) {
						if (c.getBuildingID() == b.getBuilding_id()) {

							buildingName = b.getBuilding_name();
							for (Organisation o : organisationList) {
								if (b.getOrganisation_id() == o.getId()) {
									orderedBy = o.getName();
								}
							}
						}

					}
			%>
			<tr>
				<td><%=checkupID%></td>
				<td><%=buildingName%></td>
				<td><%=orderedBy%></td>
				<td><%=issueDate%></td>
				<td><%=status%></td>
				<td><input class="btn-class" type="submit" value="assign tech"
					name="<%=checkupID%>" /></td>

			</tr>

			<%
				}
			%>

		</table>
	</form>

</body>
</html>