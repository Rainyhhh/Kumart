<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/AdminLTE.min.css">
<link rel="stylesheet" type="text/css"
	href="css/skins/_all-skins.min.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
<header class="main-header">
	<!-- Logo -->
	<a ui-sref="home" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>Ku</b>Ma</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Ku</b>Mart</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<div class="navbar-custom-menu" style="margin-right: 5%;">
			<ul class="nav navbar-nav">
			<% 
				if((request.getSession().getAttribute("customer") == null) 
						|| request.getSession().getAttribute("customer").equals("")) {
			%>
				<li>
				<a href="/Kumart/register"><span>Register</span></a>
				</li>
				<li>
				<a href="/Kumart/login"><span>Login</span></a>
				</li>	
			<%
				} else{
			%>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a class="dropdown-toggle"
					data-toggle="dropdown" style="cursor: pointer"> <img
						src="images/man-icon.png" class="user-image"
						alt="User Image" /> <span class="hidden-xs">${customer}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img src="images/man-icon.png"
							class="img-circle" alt="User Image" />
							<p>${customer}</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div align="center">
								<a href="/Kumart/admin_logout" class="btn btn-default btn-flat">Sign
									out</a>
							</div>
						</li>
					</ul></li>
					<%} %>
			</ul>
		</div>
	</nav>
</header>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/app.min.js"></script>
<script src="js/demo.js"></script>