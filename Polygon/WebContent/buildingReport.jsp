<%@page import="data.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

#comment{
    width: 500px;
    height: 100px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="Resources/js/healtReport.js"></script>
<body>
<h2>Building information</h2>

<%
	Facade f = new Facade();
	ArrayList<Building> buildings = f.getAllBuildings();
	
	Building thisBuilding = null;
	int thisId = 2; //den skal hente building ID fra sessionen.
	for (Building b : buildings){
		if(b.getBuilding_id()==thisId){
			thisBuilding = b;
		} 
	}
%>
<table>
	<tr>
		<td>
			<table>
				<tr>
					<td>Building name:</td><td><%=thisBuilding.getBuilding_name() %></td>
				</tr>
				<tr>
					<td>Adresse:</td><td><%=thisBuilding.getStreet_address() %></td>
				</tr>
				<tr>
					<td>Zip code:</td><td><%=thisBuilding.getZip() %></td>
				</tr>
				<tr>
					<td>Build year:</td><td><%=thisBuilding.getBuild_year() %></td>
				</tr>
				<tr>
					<td>Square meters (all floors):</td><td><%=thisBuilding.getFloor_area() %>m<sup>2</sup></td>
				</tr>
			</table>
		</td>
		<td>
		 image here
		</td>
	</tr>
</table>
<h2>Inspection notes</h2>
Do you want to add inspection notes on the roof?<br>
<button id="showRoof">Add</button>
<button id="hideRoof">Hide</button>
<div id="roof"><br>
	
	
	<form action="${pageContext.request.contextPath}/UploadFileServlet" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Add picture of roof:</legend>
				<input type="file" name="file" size="50" value="select images..." />
				<input type="submit" value="Upload File" />
		</fieldset>	
	</form><br>
	Write notes about roof:
	<form action="healthReportServlet" method="post">
	
		<input id="comment" type="text" placeholder="Write comments here*" Name="roof_comment" required><br>
		<input id="submitRoof" type="submit" value="Save roof comments">
		
	</form>
</div><br>

Do you want to add inspection notes on the outer walls?<br>
<button id="showOuterWalls">Add</button>
<button id="hideOuterWalls">Hide</button>
<div id="outerWalls"><br>
	Write notes about outer walls:
		<form action="${pageContext.request.contextPath}/UploadFileServlet" method="post" enctype="multipart/form-data">
		
		<input type="file" name="file" size="50" value="select images..." />
		<input type="submit" value="Upload File" />
			
	</form><br>
	Write notes about roof:
	<form action="healthReportServlet" method="post">
	
		<input id="comment" type="text" placeholder="Write comments here*" Name="outerWalls_comment" required><br>
		<input id="submitOuterWalls" type="submit" value="Save outer walls comments">
		
	</form>
</div><br>
<h2>Rooms</h2>
<p> click add button to add rooms for inspections for this report.</p>
<div id="rooms">
<%@include file="roomReport.jsp" %>
</div>

<h2>Overall condition status</h2>
<form action="healthReportServlet" method="get">
	 <input type="radio" name="conditionLevel" value="con0"> Condition level 0<br>
	 <input type="radio" name="conditionLevel" value="con1"> Condition level 1<br>
	 <input type="radio" name="conditionLevel" value="con2"> Condition level 2<br>
	 <input type="radio" name="conditionLevel" value="con3"> Condition level 3<br>
	 <input type="submit" value="Submit">
</form>
</body>
</html>