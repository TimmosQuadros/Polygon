<%@page import="data.Facade"%>
<%@page import="data.Checkup"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkup</title>
</head>
<body>
	<%
		Facade fac = new Facade();
		ArrayList<Checkup> checkupList = fac.getCheckups();
	%>
	<form action="CheckupServlet" method="get">
		<table>
			<tr>
				<th>CHECKUP ID</th>
				<th>BUILDING ID</th>
				<th>CUSTOMER ID</th>
				<th>TECH ID</th>
				<th>ISSSUE DATE</th>
				<th>PROCESSED DATE</th>
				<th>STATUS</th>
			</tr>
			<%
				for (Checkup c : checkupList) {
			%>
			<tr>
				<td><%=c.getCheckupID()%></td>
				<td><%=c.getBuildingID()%></td>
				<td><%=c.getCustomerID()%></td>
				<td><%=c.getTechID()%></td>
				<td><%=c.getDateIssued()%></td>
				<td><%=c.getDateProcessed()%></td>
				<td><%=c.getStatus()%></td>
			</tr>
			<%
				}
			%>

		</table>
	</form>

</body>
</html>