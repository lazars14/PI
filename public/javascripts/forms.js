function setFormAction(action){
	document.getElementById("crud").action = action;
	document.getElementById("crud").submit();
}

function checkForDeletion(action, entity){
	if(confirm("Da li ste sigurni da hocete da obrisete " + entity)){
        setFormAction(action);
    }
    else{
        return false;
    }
}
