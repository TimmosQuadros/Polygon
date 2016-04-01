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
</head>
<body>
	<h1>Tech Page</h1>
	<form>
		<fieldset>
		<legend> Select Organisation</legend>
			<select>
			<%
			OrganisationMapper oMap = new OrganisationMapper();
			ArrayList<Organisation> orgID =  new ArrayList<>();
			orgID = oMap.getOrganisations(); 
			for (Organisation o : orgID){
			%>
			<option value = "<%=o.getId() %>"><%=o.getName() %></option>
			<%} %>
			</select>
		</fieldset>
	</form>
</body>
</html>