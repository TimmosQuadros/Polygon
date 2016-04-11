<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new building</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2,i2,n3,i3,n4,i4,n6,i6,n7,i7,n9,i9:default;source-serif-pro:n4:default.js" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">
        	
<div id="subscribeBox">
	<a class="click-me" href="viewBuildings.jsp">View buildings</a>
	<h2><span class="thin">Add New</span> Building</h2>
    <p>Please fill out the following information to add a new building. please allow 1-2 working days for building to be added to the DB.</p>

<table>
	<tr><td>
	<h2>Please make sure to upload a floorplan for the building you want to add!</h2>
	<p>Uploading a floorplan for your building will speed up the entire process.
	If you dont have the floorplan, you can still add the building and upload the
	floorplan later. But notice that technician hours will increse by at least 100%
	if there doesn't exist a floorplan for the builing.
	
		<form action="UploadFileServlet" method="post" enctype="multipart/form-data">
		
			<input type="file" name="file" size="50" />
			<input type="submit" value="Upload File" />
			
		</form>
	</td></tr>
</table>

<form class="addbuilding" name="addbuilding" method="post" action="CreateBuilding">

	<input id="building_name" type="text" placeholder="Building name*" Name="building_name" required>
	<input id="street_address" type="text" placeholder="Street name*" Name="street_address" required>
	<input id="zipcode" type="text" placeholder="Zip code*" Name="zipcode" required>
	<input id="build_year" type="text" placeholder="Building year*" Name="build_year" required>
	<input id="floor_area" type="text" placeholder="Floor area in m2*" Name="floor_area" required>
	<input id="submit" type="submit" value="Send">
      	
</form>


        
</div> 
     
</div>

</body>
</html>