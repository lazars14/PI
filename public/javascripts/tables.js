$(document).ready(function(){
	  $("tr").click(function() {
	  	if(!$(this).hasClass("header")){
	  		$(".selected").removeClass("selected");
	    	$(this).addClass("selected");
	    	sync($(this));
	    }
	  });
});
