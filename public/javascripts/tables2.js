$(document).ready(function(){
	  $("#entities tr").click(function() {
	  	if(!$(this).hasClass("header")){
	  		$("#entities tr").removeClass("selected");
	    	$(this).addClass("selected");
	    	sync($(this));
	    }
	  });
	  
	  $("#kartice tr").click(function() {
		  	if(!$(this).hasClass("header")){
		  		$("#kartice .selected").removeClass("selected");
		    	$(this).addClass("selected");
		    	
		    	$("#robnaKartica").html(this.children[12].textContent);
		    	alert("id robne kartice u js-u: " + $("#robnaKartica").html());
		    }
	  });
});