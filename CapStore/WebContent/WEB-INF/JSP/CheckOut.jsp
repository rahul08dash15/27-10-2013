<%-- <%@page import="com.cg.domain.ProductSold"%> --%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping Cart - Check out</title>

<link type="text/css" href="resources/Css/style.css" rel="stylesheet" />
<link type="text/css" href="resources/Css/login.css" rel="stylesheet" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
<script src="resources/Script/login.js"></script>
<script src="resources/Script/scripts.js"></script>

<style type="text/css">
<!--
.container {
	height: 700px;
	width: 900px;
	margin: auto;
}

.headbanner {
	float: left;
	height: 80px;
	width: 900px;
	vertical-align: middle;
	background-color: #FFCC00;
}

.container .headbanner h1 {
	font-family: Verdana, Geneva, sans-serif;
	color: #CC3300;
}

.mycontent {
	float: left;
	height: 500px;
	width: 900px;
}

.myfooter {
	float: left;
	height: 100px;
	width: 900px;
	border-top-width: 3px;
	border-top-style: solid;
	border-top-color: #FFCC00;
}

.container .myfooter h3 {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	color: #CC3300;
}

td {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: normal;
	font-size: 14px;
}
-->
</style>
</head>

<body style="margin: 0; padding: 0">
	<form id="payment" action="ordering" name="payment" method="get">

		<input type="submit" value="Purchase" />		
	
		<div class="myfooter">
			<h3 style="font-weight: normal; padding-left: 10px">&copy;CapStore</h3>
		</div>
		
	</form>
</body>
</html>