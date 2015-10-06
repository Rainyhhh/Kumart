<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unimelb.edu.au.kumart.entity.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<jsp:include page="navigator.jsp" />
</head>
<body class="skin-yellow">
<% 
Item item = (Item)request.getAttribute("Item");
pageContext.setAttribute("_id", item.get_id());
pageContext.setAttribute("name", item.getName());
pageContext.setAttribute("description", item.getDescription());
pageContext.setAttribute("number", item.getNumber());
pageContext.setAttribute("price", item.getPrice());
%>
<div class="content-wrapper" style="margin-left: 0px;">
<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Update Item
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
<form action="/Kumart/admin_update" method="post" style="padding: 20px;">
        <input type="hidden" name="_id" value="${_id}">
		<div class="form-group">
			<span class="required-field">Name:</span> 
			<input type="text" name="name" class="form-control" value="${name}" required="true">
		</div>
		<div class="form-group">
			<span class="required-field">Description:</span> 
			<input type="text" name="description" class="form-control" value="${description}" required="true">
		</div>
		<div class="form-group">
			<span class="required-field">Price:</span> 
			<input type="number" name="price" class="form-control" value="${price}" min="1" required="true">
		</div>
		<div class="form-group">
			<span class="required-field">Number:</span> 
			<input type="number" name="number" class="form-control" value="${number}" min="1" required="true">
		</div>
		<div class="row">
		<div class="col-sm-6" align="center">
		<input type=submit class="btn btn-save" value='submit' />
		</div>
		<div class="col-sm-6" align="center">
		<a href="index" type=button class="btn btn-danger">cancel</a>
		</div>
		</div>
	</form>
	</div>
	</div>
	</div>
</section>
</div>
</body>
</html>