
<%@page import="data.User"%>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css" />


<%
		User headerU = (User)session.getAttribute("user");
		switch(headerU.getUser_type()){
		case ADMIN:
%>			
		
		<ul>
			<li><a href="adminPage.jsp">Home</a></li>
			<li><a href="viewBuildings.jsp">View buildings</a></li>
			<li><a href="ViewOrders">View orders</a></li>
			<li><a href="viewCustomers.jsp">View customers</a></li>
			<li><a href="viewTechnicians.jsp">View technicians</a></li>
			<li><a href="Sendnewsletter">Send newsletter</a></li>
			<li style="float: right"><a class="active" href="LogoutServlet">Logout</a></li>
		</ul>
<%			
		
		
			break;
		case TECH:
			
%>

		<ul>
			<li><a href="techPage.jsp">Home</a></li>
			<li><a href="viewBuildings.jsp">View buildings</a></li>
			<li><a href="#ViewOrders">View orders</a></li>
		
			<li style="float: right"><a class="active" href="LogoutServlet">Logout</a></li>
		</ul>			
<%		break;
		case CUST:
			
%>	

		<ul>
			<li><a href="customerPage.jsp">Home</a></li>
			<li><a href="viewBuildings.jsp">View buildings</a></li>
		
		
			<li style="float: right"><a class="active" href="LogoutServlet">Logout</a></li>
		</ul>		
			
<% 			break;
	}
%>

