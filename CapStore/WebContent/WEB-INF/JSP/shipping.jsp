<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CapStore</title>
<link type="text/css" href="resources/Css/style.css" rel="stylesheet" />
<link type="text/css" href="resources/Css/login.css" rel="stylesheet" />
<link type="text/css" href="resources/Css/shipment.css" rel="stylesheet" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>

<script src="resources/Script/login.js"></script>
<script src="resources/Script/scripts.js"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"
	type="text/javascript"></script>


<!-- Shipping script Starts -->
<script type="text/javascript">
$(document).ready(function(){
	  $('[name="addr_type"]').change(function(){
		  
	    var type = $('[name="addr_type"]').val();
	 	
	    if (type == "defaultLocation") {
	    	   	
	    	$('[name="txt_new_address"]').val($('[name="txt_address"]').val()); 	
	    	var loc=$('[name="txt_new_address"]').val($('[name="txt_address"]').val()); 
	    	
		}   else if (type == "newLocation") {
			$('[name="txt_new_address"]').val(''); 
	    	$('[name="txt_new_address"]').val($('[name="txt_new_address"]').val()); 	
	    	var loc=$('[name="txt_new_address"]').val($('[name="txt_new_address"]').val());
	    	
		}
	    
	    else {
			$('[name="txt_new_address"]').val(''); 
		}
	  });
	});	
	
</script>
<!-- Shipping script Ends -->


</head>

<body oncontextmenu="return false;">
	<!--Header Section-->

	<div class="header-tile"></div>
	<div class="header">
		<div class="header-title">
			<img src="resources/Images/fly.png" border="0" class="fly"
				height="3px" width="30px" /> <img src="resources/Images/fly.png"
				border="0" class="fly1" height="3px" width="30px" /> <img
				src="resources/Images/fly.png" border="0" class="fly2" height="3px"
				width="30px" />Cap Store
		</div>



		<!--Header Section->
<!--Search Bar-->
		<form action="" method="get">
			<input type="text" class="mainSearchBar" list="awards"
				style="color: #000" title="Search" type="text" name="Search"
				onblur="showText()" onfocus="hideText();" value=""
				placeholder="       Search Here"> <datalist id="awards"
					list="awards" class="datalist1"> <select>
					<option value="Best Picture"></option>
					<option value="Best Director"></option>
					<option value="Best Adapted Screenplay"></option>
					<option value="Best Original Screenplay"></option>
				</select> </datalist> <input class="mainSubmit" value=" " type="submit"
				style="position: relative; margin-left: -76px;">
		</form>
		<!--Search Bar-->
	</div>
	<!-- Login Starts Here -->
	<div id="loginContainer">
		<a href="#" id="loginButton"><span>Login</span><em></em></a>
		<div style="clear: both"></div>
		<div id="loginBox">
			<form id="loginForm">
				<fieldset id="body">
					<fieldset>
						<label for="email">Email Address</label> <input type="text"
							name="email" id="email" onblur="showText()" />
					</fieldset>
					<fieldset>
						<label for="password">Password</label> <input type="password"
							name="password" id="password" onblur="showText()" />
					</fieldset>
					<input type="submit" id="login" value="Sign in" />

				</fieldset>
				<span><a href="#">Change password</a><a href="#">Forgot
						your password?</a></span>
			</form>
		</div>
	</div>
	<!-- Login Ends Here -->

	<div class="left-border"></div>
	<!--Header Section Ends Here-->


	<!--Menu Section-->
	<div class="container-menu">


		<ul class="nav">
			<li><a href="#"><img class="icon-home icon-large"
					src="resources/Images/Home_icon_black.png" width="25px"
					height="25px" /></a></li>


			<!----- Full Drop Down Name ---->
			<li class="dropdown"><a href="#">Drop Down Menu 1</a> <!----- Full Drop Down Name Ends Here ---->

				<!----- Full Drop Down Contents  Starts Here---->

				<div class="fulldrop">
					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Menu-1</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>



					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>
				</div></li>
			<!----- Full Drop Down Contents  Ends  Here---->




			<!----- Full Drop Down Name ---->
			<li class="dropdown"><a href="#">Drop Down Menu 2</a> <!----- Full Drop Down Name Ends Here ---->

				<!----- Full Drop Down Contents  Starts Here---->

				<div class="fulldrop">
					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>



					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>


					<div class="column">
						<h3>Menu Header</h3>
						<ul>
							<li><a href="#">Tech ANd All</a></li>
							<li><a href="#">Web Designs</a></li>
							<li><a href="#">PSD</a></li>
							<li><a href="#">Scripts</a></li>
						</ul>
					</div>
				</div></li>
			<!----- Full Drop Down Contents  Ends  Here---->



			<!----- Regular Menu Button ---->
			<li><a href="#"> Web Designs</a></li>
			<!----- Regular Menu Button Ends---->


			<!----- Regular Menu Button ---->
			<li><a href="#"> LifeStyle</a></li>
			<!----- Regular Menu Button Ends---->


			<!----- Regular Menu Button ---->
			<li><a href="#"> About</a></li>
			<!----- Regular Menu Button Ends---->

			<!----- Regular Menu Button ---->
			<li><a href="#"> Contact</a></li>
			<!----- Regular Menu Button Ends---->

		</ul>
	</div>


	<!--Shipment Form Starts Here-->
	<div class="middle-container" align="center">
		<h1>&nbsp;</h1>
		<h1>&nbsp;</h1>
		<h1>&nbsp;</h1>
		<h1>Shipment Details</h1>

		<form id="create" action="address" name="create" method="get">

			<div class="info">
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td align="left">First Name</td>
									<td align="justify"><input type="text" name="fname"
										value=${fname } id="shipment" readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="left">Last Name</td>
									<td align="justify"><input type="text" name="lname"
										value=${lname } id="shipment" readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="left">Email</td>
									<td align="justify"><input type="text" name="email" id="shipment" readonly="readonly" 
										value=${email } /></td>
								</tr>
								<tr>
									<td align="left">Phone No.</td>
									<td align="justify"><input type="text" name="phnum"
										maxlength="10" onblur="validate_Phone()" id="shipment" /></td>
								</tr>
								<tr>
									<td align="left">Address</td>
									<td align="justify"><input type="text" name="txt_address"
										value=${user_address } id="shipment" readonly="readonly" /></td>
								</tr>

								<tr>
									<td><select id="shipment" onchange="changeElement()"
										name="addr_type">

											<option>Select the address</option>
											<option value="defaultLocation">Default Location</option>
											<option value="newLocation">New Location</option>

									</select></td>
								</tr>
								<tr>
									<td align="left">Shipping Address</td>
									<td align="justify"><p>
											<textarea name="txt_new_address" id="txt_new_address"
												cols="20" rows="2" style="visibility: visible;"> </textarea>
										</p></td>
								</tr>
								<tr>
									<td align="left">Amount</td>
									<td align="justify"><input type="text" name="cartValue"
										value="${cart_value}
										id="
										shipment" readonly="readonly" /></td>
								</tr>

							</table>
						</td>
						<td style="padding: 3%"><iframe id="map1" width="300" height="260"
								frameborder="3" padding="2%" scrolling="no" marginheight="3"
								marginwidth="2"
								src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=${user_address }&amp;ie=UTF8&amp;z=12&amp;t=m&amp;iwloc=addr&amp;output=embed">
							</iframe></td>
					</tr>

				</table>
			</div>
			<div class="submitbutton">
				<input type="submit" name="creationform" value="Make Payment"
					id="shipment" />
			</div>
		</form>

	</div>
	<!--Shipment Form Ends Here-->



	<!--Footer Section-->
	<div class="right-border"></div>
	<div class="footer">@Copyright CapStore</div>
	<div class="footer-tile"></div>
	<!--Footer Section-->
</body>
</html>
