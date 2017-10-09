function setFormAction(action){
	document.getElementById("crud").action = action;
	alert(document.getElementById("crud").action);
	document.getElementById("crud").submit();
}
