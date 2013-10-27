<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function func(){
var txt=document.getElementById("text").value;
	if(txt==''){
		alert("Enter a value");
		return false;
	}
}
</script>
</head>
<body bgcolor="#FFF8DC">
<fieldset>
	<legend align="top"> CapStore Products</legend>
	<form action="addCart" method="get" target="_parent" onsubmit="return func();">
		<table width="900PX" height="600" border="2" align="center">

			<tr align="center">
				<td><img src="resources/Images/A (1).jpg" width="150" height="100" id="A1" name="A1" title="A1">
					<hr>$40 4GB PENDRIVE<br> 
					<input type="text" id="text" size="4" name="qty" value="1">
					<input type="submit" value="Pendrive" name="addtocart" ></td>
					
				<td><img src="resources/Images/A (2).jpg" width="150" height="100" name="A2">
					<hr> $1200 ACER LAP<br> 
					<input type="submit" value="Add Cart"></td>
			</tr>
			
			<tr align="center">
				<td><img src="resources/Images/A (5).jpg" width="150" height="100" name="C4">
					<hr>$600 CANON <br> 
					<input type="submit" value="Add Cart" name="p3"></td>
				<td><img src="resources/Images/A (6).jpg" width="150" height="100" name="C5">
					<HR>$40 CASIO <BR> 
					<input type="submit" value="Add Cart" name="p4"></td>
			</tr>
			
			<tr align="center">
				<td>
					Scheme-1 <input type="radio" name = "schemeId" value="1" checked="checked"> <br>
					Scheme-2 <input type="radio" name = "schemeId" value="2"> <br>
					Scheme-3 <input type="radio" name = "schemeId" value="3"> <br>
				</td>
			</tr>
		</table>
	</form>
	</fieldset>
</body>
</html>