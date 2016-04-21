<%@page import="java.util.ArrayList"%>
<%@page import="data.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Resources/css/imageSlider.css" rel="stylesheet"
	type="text/css">
	<script src="Resources/js/min.js"></script>
<link href="Resources/js/min.js" type="text/javascript">
</head>
<body>
	<%
		ArrayList<String> imgPaths = (ArrayList<String>) session.getAttribute("paths.floorplans");
		Facade fac = new Facade();
		User user = (User) session.getAttribute("user");
		ArrayList<Building> buildings = new ArrayList<>();
		buildings = fac.getUserBuildings(user.getUser_id());
	%>

	<section class="demo">
	<button class="next">Next</button>
	<button class="prev">Previous</button>
	<div class="container">
		<%
			int count = 0;
			//for (String path : imgPaths) {
			for (String path : imgPaths) {
				response.getWriter().append(path);

				if (!path.isEmpty()) {
		%>
		<div>
			<img src="<%=path%>" />
		</div>
		<%
			count += 1;
				}
			}
		%>
	</div>

	</section>
	<div style="margin-top: 80px;">
		<fieldset>
			<legend>Upload floorplan</legend>
			<form action="${pageContext.request.contextPath}/AttachImageServlet"
				method="post" enctype="multipart/form-data">
				<input type="file" name="file" size="50" value="select image..." />
				<input type="submit" value="Upload File" />
			</form>
		</fieldset>
	</div>


</body>
<script src="Resources/js/imageSlider.js"></script>
<link href="Resources/js/imageSlider.js" type="text/javascript">
</html>
