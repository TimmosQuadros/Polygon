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
<div><center>
<link rel="stylesheet" href="cssslider_files/csss_engine1/style.css">
		<!--[if IE]><link rel="stylesheet" href="cssslider_files/csss_engine1/ie.css"><![endif]-->
		<!--[if lte IE 9]><script type="text/javascript" src="cssslider_files/csss_engine1/ie.js"></script><![endif]-->
		<%
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_id();
		Facade facade = new Facade();
		ArrayList<String> imgPaths = facade.getUserImages(user_id);
		%>
		
		<div class='csslider1 autoplay '>
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
		<input name="cs_anchor1" id='cs_slide1_0' type="radio" class='cs_anchor slide' >
		<input name="cs_anchor1" id='cs_slide1_1' type="radio" class='cs_anchor slide' >
		<input name="cs_anchor1" id='cs_slide1_2' type="radio" class='cs_anchor slide' >
		<input name="cs_anchor1" id='cs_slide1_3' type="radio" class='cs_anchor slide' >
		<input name="cs_anchor1" id='cs_play1' type="radio" class='cs_anchor' checked>
		<%
		count = 0;
		for (String p : imgPaths) {
			if(!p.isEmpty()){
		%>
		<input name="cs_anchor1" id='cs_pause1_<%=count%>' type="radio" class='cs_anchor pause'>
		<%
					count+=1;
				}
			}
		%>	
		<input name="cs_anchor1" id='cs_pause1_0' type="radio" class='cs_anchor pause'>
		<input name="cs_anchor1" id='cs_pause1_1' type="radio" class='cs_anchor pause'>
		<input name="cs_anchor1" id='cs_pause1_2' type="radio" class='cs_anchor pause'>
		<input name="cs_anchor1" id='cs_pause1_3' type="radio" class='cs_anchor pause'>
		<ul>
			<li class="cs_skeleton"><img src="cssslider_files/csss_images1/cornerhouse1052sqft.png" style="width: 100%;"></li>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>
			<li class='num<%=count%> img slide'> <img src='<%=p%>' alt='Floorplan-<%=count%>' title='Floorplan-<%=count%>' /></li>
			<%
					count+=1;
				}
			}
			%>
			<li class='num0 img slide'> <img src='cssslider_files/csss_images1/cornerhouse1052sqft.png' alt='Floorplan-001' title='Floorplan-001' /></li>
			<li class='num1 img slide'> <img src='cssslider_files/csss_images1/eb8fb2dbc8c57e8a743586aa2d9f6a98.jpg' alt='Floorplan-002' title='Floorplan-002' /></li>
			<li class='num2 img slide'> <img src='cssslider_files/csss_images1/roomsketcher2dfloorplans.jpg' alt='Floorplan-003' title='Floorplan-003' /></li>
			<li class='num3 img slide'> <img src='cssslider_files/csss_images1/thesavilleluxuryfloorplansanddesignsbyengleharthomes1.png' alt='Floorplan-004' title='Floorplan-004' /></li>
		</ul><div class="cs_engine"><a href="http://cssslider.com">bootstrap slider</a> by cssSlider.com v2.1</div>
		
		<div class='cs_description'>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>
			<label class='num<%=count%>'><span class="cs_title"><span class="cs_wrapper">Floorplan-<%=count%></span></span></label>
			<%
					count+=1;
				}
			}
			%>
			<label class='num0'><span class="cs_title"><span class="cs_wrapper">Floorplan-001</span></span></label>
			<label class='num1'><span class="cs_title"><span class="cs_wrapper">Floorplan-002</span></span></label>
			<label class='num2'><span class="cs_title"><span class="cs_wrapper">Floorplan-003</span></span></label>
			<label class='num3'><span class="cs_title"><span class="cs_wrapper">Floorplan-004</span></span></label>
		</div>
		
		<div class='cs_play_pause'>
			<label class='cs_play' for='cs_play1'><span><i></i><b></b></span></label>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>
			<label class='cs_pause num<%=count%>' for='cs_pause1_<%=count%>'><span><i></i><b></b></span></label>
			<%
					count+=1;
				}
			}
			%>
			<label class='cs_pause num0' for='cs_pause1_0'><span><i></i><b></b></span></label>
			<label class='cs_pause num1' for='cs_pause1_1'><span><i></i><b></b></span></label>
			<label class='cs_pause num2' for='cs_pause1_2'><span><i></i><b></b></span></label>
			<label class='cs_pause num3' for='cs_pause1_3'><span><i></i><b></b></span></label>
			</div>
			
			
		<div class='cs_arrowprev'>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>		
			<label class='num<%=count%>' for='cs_slide1_<%=count%>'><span><i></i><b></b></span></label>
			<%
					count+=1;
				}
			}
			%>
			<label class='num0' for='cs_slide1_0'><span><i></i><b></b></span></label>
			<label class='num1' for='cs_slide1_1'><span><i></i><b></b></span></label>
			<label class='num2' for='cs_slide1_2'><span><i></i><b></b></span></label>
			<label class='num3' for='cs_slide1_3'><span><i></i><b></b></span></label>
		</div>
		
		
		<div class='cs_arrownext'>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>	
			<label class='num<%=count%>' for='cs_slide1_<%=count%>'><span><i></i><b></b></span></label>
			<%
					count+=1;
				}
			}
			%>
			<label class='num0' for='cs_slide1_0'><span><i></i><b></b></span></label>
			<label class='num1' for='cs_slide1_1'><span><i></i><b></b></span></label>
			<label class='num2' for='cs_slide1_2'><span><i></i><b></b></span></label>
			<label class='num3' for='cs_slide1_3'><span><i></i><b></b></span></label>
		</div>
		
		
		<div class='cs_bullets'>
			<%
			count = 0;
			for (String p : imgPaths) {
				if(!p.isEmpty()){
			%>
			<label class='num<%=count%>' for='cs_slide1_<%=count%>'> <span class='cs_point'></span>
				<span class='cs_thumb'><img src='<%=p%>' alt='Floorplan-<%=count%>' title='Floorplan-<%=count%>' /></span></label>
			<%
					count+=1;
				}
			}
			%>
			<label class='num0' for='cs_slide1_0'> <span class='cs_point'></span>
				<span class='cs_thumb'><img src='cssslider_files/csss_tooltips1/cornerhouse1052sqft.png' alt='Floorplan-001' title='Floorplan-001' /></span></label>
			<label class='num1' for='cs_slide1_1'> <span class='cs_point'></span>
				<span class='cs_thumb'><img src='cssslider_files/csss_tooltips1/eb8fb2dbc8c57e8a743586aa2d9f6a98.jpg' alt='Floorplan-002' title='Floorplan-002' /></span></label>
			<label class='num2' for='cs_slide1_2'> <span class='cs_point'></span>
				<span class='cs_thumb'><img src='cssslider_files/csss_tooltips1/roomsketcher2dfloorplans.jpg' alt='Floorplan-003' title='Floorplan-003' /></span></label>
			<label class='num3' for='cs_slide1_3'> <span class='cs_point'></span>
				<span class='cs_thumb'><img src='cssslider_files/csss_tooltips1/thesavilleluxuryfloorplansanddesignsbyengleharthomes1.png' alt='Floorplan-004' title='Floorplan-004' /></span></label>
		</div>
		</div>
</center></div>
</body>
</html>