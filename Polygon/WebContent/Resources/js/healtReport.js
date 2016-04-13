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

//script til checkbox (condition level) 
$("input:checkbox").on('click', function() {
	  var $box = $(this);
	  if ($box.is(":checked")) {
	    var group = "input:checkbox[name='" + $box.attr("name") + "']";
	    $(group).prop("checked", false);
	    $box.prop("checked", true);
	  } else {
	    $box.prop("checked", false);
	  }
	});