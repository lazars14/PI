$(document).ready(function(){
	  $("#entities tr").click(function() {
	  	if(!$(this).hasClass("header")){
	  		$("#entities .selected").removeClass("selected");
	    	$(this).addClass("selected");
	    	sync($(this));	
	    }
		  
	  });
	  
	  $("#sub-entity tr").click(function() {
		  	if(!$(this).hasClass("header")){
		  		$("#sub-entity .selected").removeClass("selected");
		    	$(this).addClass("selected");
		    	syncSubEntity($(this));
		}
	  });
});