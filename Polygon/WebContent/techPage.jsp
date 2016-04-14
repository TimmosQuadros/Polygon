<%@page import="data.Organisation"%>
<%@page import="data.OrganisationMapper"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tech Page</title>
<link href="Resources/css/style.css" rel="stylesheet"
	type="text/css">
	<%@include file="header.jsp" %>
</head>
<body>
	<h1>Tech Page</h1>
	<form action="ChooseBuilding.jsp" method="get">
		<fieldset>
			<legend> Select Organisation</legend>
			<select name="orgID">
				<%
					OrganisationMapper oMap = new OrganisationMapper();
					ArrayList<Organisation> orgID = new ArrayList<>();
					orgID = oMap.getOrganisations(); 
					// only for testing without DB connection.
					// orgID.add(new Organisation(1, "SAS"));
					// orgID.add(new Organisation(2, "CPH"));
					// orgID.add(new Organisation(3, "ICC"));

					for (Organisation o : orgID) {
				%>
				<option value="<%=o.getId()%>"><%=o.getName()%></option>
				<%
					}
				%>

			</select> <input id="submit" type="submit" value="Select">
			
		</fieldset>
	</form>
</body>
</html>