<%@page import="data.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Organisation" %>
<%@page import="data.OrganisationMapper" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create user</title>
<link href="Resources/css/addbuilding.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2,i2,n3,i3,n4,i4,n6,i6,n7,i7,n9,i9:default;source-serif-pro:n4:default.js" type="text/javascript"></script>

</head>
<body>

<div id="wrapper">
        	
<div id="subscribeBox">
	<h2><span class="thin">Create new</span> User</h2>
    <p>Please fill out the following information to create a user. If your organisation doesn't appear in the list please contact us.</p>


<form class="addbuilding" name="addbuilding" method="post" action="CreateBuilding">


	<select>
	<%
                OrganisationMapper orgMap = new OrganisationMapper();
				ArrayList<Organisation> organisatioins = new ArrayList<>();//orgMap.getOrganisations();
				organisatioins.add(new Organisation(1, "test1"));
				organisatioins.add(new Organisation(2, "test2"));
                
                for(int i = 0;i<organisatioins.size();i++){
            %>
  		<option value="<%=organisatioins.get(i).getId()%>"><%=organisatioins.get(i).getName()%></option>
	<%
                }
            %>
	</select>
	<input id="password" type="text" placeholder="Password*" Name="password" required>
	<input id="confirm_password" type="text" placeholder="confirm password*" Name="confirm_password" required>
	<input id="email" type="text" placeholder="Email*" Name="email" required>
	<input id="confirm_email" type="text" placeholder="Confirm email*" Name="confirm_email" required>
		
	<input id="submit" type="submit" value="Send">
      	
</form>
        
</div> 
     
</div>

</body>
</html>