//show hidden add roof field
$(document).ready(function(){
	$("#roof").hide();
    $("#hideRoof").click(function(){
        $("#roof").hide();
    });
    $("#showRoof").click(function(){
        $("#roof").show();
    });
});
//show hidden add outer walls field
$(document).ready(function(){
	$("#outerWalls").hide();
    $("#hideOuterWalls").click(function(){
        $("#outerWalls").hide();
    });
    $("#showOuterWalls").click(function(){
        $("#outerWalls").show();
    });
});