function setFormAction(action){
	document.getElementById("crud").action = action;
	document.getElementById("crud").submit();
}

$(document).ready(function(){
	  $("tr").click(function() {
	  	if(!$(this).hasClass("header")){
	  		$(".selected").removeClass("selected");
	    	$(this).addClass("selected");
	    	sync($(this));
	    }
	  });
}