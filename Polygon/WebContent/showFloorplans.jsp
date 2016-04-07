<%@page import="java.util.ArrayList"%>
<%@page import="data.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- All code below this comment tag is the imageslider! -->
		
		<%
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_id();
		Facade facade = new Facade();
		ArrayList<String> imgPaths = facade.getUserImages(user_id);
		%>
		
		<div class=''>
		<%
		int count = 0;
		for (String p : imgPaths) {
			if(!p.isEmpty()){
		%>
		<input name="cs_anchor1" id='cs_slide1_<%=count%>' type="radio" class='cs_anchor slide' >
		<%
					count+=1;
				}
			}
		%>		
		
</body>
</html>