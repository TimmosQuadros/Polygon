<%@page import="java.util.ArrayList"%>
<%@page import="data.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Resources/css/imageSlider.css" rel="stylesheet" type="text/css">
<link href="Resources/js/imageSlider.js" type="text/javascript">



</head>
<body>
		<%
		//User user = (User) session.getAttribute("user");
		//int user_id = user.getUser_id();
		//Facade facade = new Facade();
		//ArrayList<String> imgPaths = facade.getUserImages(user_id);
		ArrayList<String> testPaths = new ArrayList<>();
		testPaths.add("Resources/Images/Floorplans/Floorplan0.png");
		testPaths.add("Resources/Images/Floorplans/Floorplan1.png");
		testPaths.add("Resources/Images/Floorplans/Floorplan2.png");
		%>
		
<section class="demo">
  <button class="next">Next</button>
  <button class="prev">Previous</button>
  <div class="container">
<%
	int count = 0;
	//for (String path : imgPaths) {
	for (String path : testPaths) {
		if(!path.isEmpty()){
%>
    <div>
      <img src="<%=path%>"/>
    </div>
<%
			count+=1;
		}
	}
%>
  </div>
</section>


</body>
</html>
<script src="Resources/js/min.js"></script>
<script src="Resources/js/imageSlider.js"></script>
