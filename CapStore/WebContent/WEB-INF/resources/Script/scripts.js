//JavaScript Document


window.addEventListener("keydown", keyListener, false);
function keyListener(e) {
	if(e.keyCode == 123) {
		e.returnValue = false;
	}
}

document.onmousedown=disableclick;
status="Right Click Disabled";
function disableclick(event)
{
	if(event.button==2)
	{
		alert(status);
		return false;    
	}
}
function showText(){
	if(document.getElementById("mainSearchBar0").value == ""){
		document.getElementById("mainSearchBar0").value="Type in a word";
		document.getElementById("mainSearchBar0").style.color = "#777";}}
function hideText(){
	if(document.getElementById("mainSearchBar0").value == "Type in a word"){
		document.getElementById("mainSearchBar0").value="";
		document.getElementById("mainSearchBar0").style.color="#000";
	}
}

function validate_Phone(){
var y=document.forms["create"]["phnum"].value;
var reg_p=/^[0-9]{10}$/;
if((reg_p.test(y) == false)){
	alert(" Please fill in valid Phone number");
	return false;
	}
	else{return true;}
	}

