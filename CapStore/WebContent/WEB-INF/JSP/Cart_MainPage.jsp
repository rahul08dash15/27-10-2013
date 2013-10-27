<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Cart</title>
<link type="text/css" href="resources/Css/style.css" rel="stylesheet"  />
<link type="text/css" href="resources/Css/login.css" rel="stylesheet"  />
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script src="resources/Script/login.js"></script>
    <script src="resources/Script/scripts.js"></script>

</head>
<body oncontextmenu="return false;">
<!--Header Section-->

<div class="header-tile"></div>
<div class="header" >
<div class="header-title">
<img src="Images/fly.png" border="0" class="fly" height="3px" width="30px"  />
<img src="Images/fly.png" border="0" class="fly1" height="3px" width="30px"/>
<img src="Images/fly.png" border="0" class="fly2" height="3px" width="30px"/>Cap Store</div>



<!--Header Section->
<!--Search Bar-->
<form action="tsearch" method="get">
<input  type="text" class="mainSearchBar" list="awards"  style="color: #000" title="Search" type="text" name="Search" onblur="showText()" onfocus="hideText();" value="" placeholder="       Search Here" >

<datalist id="awards" list="awards" class="datalist1">
<select>
<option value="Best Picture"></option>
<option value="Best Director"></option>
<option value="Best Adapted Screenplay"></option>
<option value="Best Original Screenplay"></option>
</select>
</datalist>

<input class="mainSubmit" value=" " type="submit" style="position:relative;margin-left:-76px;">
</form>
<!--Search Bar-->      
</div>
  <!-- Login Starts Here -->
            <div id="loginContainer">
                <a href="#" id="loginButton"><span>Login</span><em></em></a>
                <div style="clear:both"></div>
                <div id="loginBox">                
                    <form id="loginForm">
                        <fieldset id="body">
                            <fieldset>         
                                <label for="email">Email Address</label>
                                <input type="text" name="email" id="email" onblur="showText()"/>
                            </fieldset>
                            <fieldset>
                                <label for="password">Password</label>
                                <input type="password" name="password" id="password" onblur="showText()" />
                            </fieldset>
                            <input type="submit" id="login" value="Sign in" />
                            
                        </fieldset>
                        <span><a href="#">Change password</a><a href="#">Forgot your password?</a></span>
                    </form>
                </div>
            </div>
            <!-- Login Ends Here -->

<div class="left-border"></div>
<!--Header Section Ends Here-->
	<center>
		<iframe src="DisplayCart" scrolling="yes" width="1000" height="250"
			frameborder="0" align="middle"> </iframe>
		<iframe src="Product" scrolling="yes" width="1000"
			height="620" frameborder="0" align="middle"> </iframe>
	</center>












<!--Footer Section-->
<div class="right-border"></div>
<div class="footer">@Copyright Cap Store</div>
<div class="footer-tile"></div>
<!--Footer Section-->
</body>
</html>
