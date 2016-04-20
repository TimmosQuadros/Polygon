<%@page import="java.awt.List"%>
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
<h2>Reports/buildings sorted by condition level</h2>
<p>Keep in mind that ONLY buildings that have had an health checkup will appear on thils list<br>
if you want to add a building to the list please order a health checkup and a technician will<br>
make a report, and the building will then get a condition level, and appear in this list</p>
<%
	Facade fac = new Facade();
	ArrayList<BuildingReport> reports = fac.getBuildingReports();
	ArrayList<BuildingReport> sortedReports = new ArrayList<>();
	
		for(int i = 0; i<reports.size(); i++){
			if(reports.get(i).getBuildingCondition().name().equalsIgnoreCase("CON0")){
				sortedReports.add(reports.get(i));
				reports.remove(reports.get(i));
			}
		}
		for(int i = 0; i<reports.size(); i++){
			if(reports.get(i).getBuildingCondition().name().equalsIgnoreCase("CON1")){
				sortedReports.add(reports.get(i));
				reports.remove(reports.get(i));
			}
		}
		for(int i = 0; i<reports.size(); i++){
			if(reports.get(i).getBuildingCondition().name().equalsIgnoreCase("CON2")){
				sortedReports.add(reports.get(i));
				reports.remove(reports.get(i));
			}
		}
		sortedReports.addAll(reports);
		
		
%>

<table>
	<tr>
		<th>Building</th><th>Technician</th><th>Roof remark</th><th>Outer walls remark</th><th>Condition level</th>
	</tr>
<%
	for(BuildingReport r : sortedReports){
	
%>
	<tr>
		<td><%=r.getBuilding_id() %></td><td><%=r.getTech_id() %></td><td><%=r.getRoof_remark() %></td><td><%=r.getOuter_wall_remark() %></td><td><%=r.getBuildingCondition() %></td>
	</tr>
<%
	}
%>
</table>


</body>
</html>