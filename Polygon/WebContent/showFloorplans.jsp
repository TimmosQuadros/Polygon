<%@page import="java.util.ArrayList"%>
<%@page import="data.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="Resources/js/min.js"></script>
<script src="Resources/js/imageSlider.js"></script>
<link href="Resources/css/imageSlider.css" rel="stylesheet"
	type="text/css">
<link href="Resources/js/imageSlider.js" type="text/javascript">



</head>
<body>
	<%
		ArrayList<String> imgPaths = (ArrayList<String>) session.getAttribute("paths.floorplans");
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
			<form action="${pageContext.request.contextPath}/UploadFileServlet"
				method="post" enctype="multipart/form-data">

				<input type="file" name="file" size="50" value="select images..." />
				<input type="submit" value="Upload File" />

			</form>
		</fieldset>
	</div>


</body>
</html>
