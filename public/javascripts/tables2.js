$(document).ready(function(){
	  $("#entities tr").click(function() {
	  	if(!$(this).hasClass("header")){
	  		$(".selected").removeClass("selected");
	    	$(this).addClass("selected");
	    	sync($(this));
	    }
	  });
	  
	  $("#kartice tr").click(function() {
		  	if(!$(this).hasClass("header")){
		  		$(".selected").removeClass("selected");
		    	$(this).addClass("selected");
		    	
		    	$("#robnaKartica").html(this.children[12].textContent);
		    	alert($("#robnaKartica").html());
		    }
	  });
});