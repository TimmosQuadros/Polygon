<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Resources/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
#comment{
    width: 500px;
    height: 100px;
}

#UlBtn{
    display: block;
    width: 100%;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#addRoom").hide();
	$("#hide" || "hide2").click(function(){
        $("#addRoom").hide();
    });
    $("#show").click(function(){
        $("#addRoom").show();
    });
});
</script>
</head>
<body>


<button id="show">Add new room</button>
<div id="addRoom">
<button id="hide">Hide</button><br>
	<table id="room">
	<tr>
		<th colspan="2">
			Room (required)
		</th>

	</tr>
	<tr>
		<form action="ReportServlet" method="post">
			<td>
				<input type="text" placeholder="Room*" Name="room_name" required><br>
			</td>
			<td>
				<input id="submitRoom" type="submit" value="Add room" name="add_room_name">
			</td>
		</form>
	</tr>
</table>
<h2>Damage and restorations.</h2>
<p>please fill out information about damages in this room, followed by (if) 
any earlier damages have been repaired or restored.<br>
Remember to include: Moist, rot/mold and fire damages</p>
	<form action="ReportServlet" method="post">
	<input id="comment" type="text" placeholder="Write comments here*" name="damage"><br>
	<input id="submitWallComment" type="submit" value="Save wall comments" name="damage_check">
	</form>
<br>
<h2>Examination of:</h2>
<form action="ReportServlet" method="post">
	<table id="examination">
		<tr>
			<th colspan="2">Comments section</th>
			<th>Upload images (optional)</th>
		</tr>
		<tr>
			<td>
				Walls
			</td>
			<td>
				<input id="comment" type="text" placeholder="Write comments here*" Name="wall_comment"><br>
			</td>
			<td>
				<form action="" method="post" enctype="multipart/form-data">
					<input type="file" name="file" size="25" value="select images..." />
					<input id="UlBtn" type="submit" value="Upload image" />
				</form>
			</td>
		</tr>
		
		<tr>
			<td>
				Ceiling
			</td>
			<td>
				<input id="comment" type="text" placeholder="Write comments here*" Name="ceiling_comment"><br>
			</td>
			<td>
				<form action="" method="post" enctype="multipart/form-data">
					<input type="file" name="file" size="25" value="select images..." />
					<input id="UlBtn" type="submit" value="Upload image" />
				</form>
			</td>
		</tr>
		
		<tr>
			<td>
				Floor
			</td>
			<td>
				<input id="comment" type="text" placeholder="Write comments here*" Name="floor_comment"><br>
			</td>
			<td>
				<form action="" method="post" enctype="multipart/form-data">
					<input type="file" name="file" size="25" value="select images..." />
					<input id="UlBtn" type="submit" value="Upload image" />
				</form>
			</td>
		</tr>
		
		<tr>
			<td>
				Windows/  <br>doors
			</td>
			<td>
				<input id="comment" type="text" placeholder="Write comments here*" Name="WD_comment"><br>
			</td>
			<td>
				<form action="" method="post" enctype="multipart/form-data">
					<input type="file" name="file" size="25" value="select images..." />
					<input id="UlBtn" type="submit" value="Upload image" />
				</form>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="Save notes" name="save_notes" />		
			</td>
		</tr>
	</table>
</form>
<br>

<h2>Moisture scanning</h2>
<p>If a moisture scanning have been conducted please wirte notes here:
<form action="ReportServlet" method="post">
<input id="comment" type="text" placeholder="Write comments here*" Name="Moisture_comment"><br>
<input type="submit" value="Save notes" name="save_notes_m" />
</form><br>
<button id="hide2">Hide</button> Click hide when this room report is done.
</div>
</body>
</html>