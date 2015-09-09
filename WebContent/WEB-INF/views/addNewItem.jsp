<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="unimelb.edu.au.kumart.entity.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Item</title>
<jsp:include page="navigator.jsp" />
</head>
<%-- <%
String message =request.getAttribute("message").toString();
pageContext.setAttribute("message", message);
%> --%>
<body class="skin-yellow">
<div class="content-wrapper" style="margin-left: 0px;">
<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Add a new item
		</h1>
		</section>
		<!-- Main content -->
		<section class="content"> <!-- Small boxes (Stat box) -->
		<div class="row">
		<div class="col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">	
		<div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title text-center">Item Information</div>
            </div>	
            <div class="panel body">
   	   <form action="/Kumart/addItem" method="post" style="padding: 20px;">
		<div class="form-group">
			<span class="required-field">Name:</span> <input type="text"
				name="name" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Description:</span> <input type="text"
				name="description" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Price:</span> <input type="text"
				name="price" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Number:</span> <input type="text"
				name="number" class="form-control">
		</div>		
		<div class="modal-footer">
        <input type="submit" class="btn btn-save" value='submit'/>
        </div>
	</form>
	<div>
	<span></span>
	</div>
	</div>
	</div>
	</div>
</section>
</div>

</body>
</html>