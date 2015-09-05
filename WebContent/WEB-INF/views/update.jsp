<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unimelb.edu.au.kumart.entity.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Item item = (Item)request.getAttribute("Item");
pageContext.setAttribute("_id", item.get_id());
pageContext.setAttribute("name", item.getName());
pageContext.setAttribute("description", item.getDescription());
pageContext.setAttribute("number", item.getNumber());
pageContext.setAttribute("price", item.getPrice());
%>
<form action="/Kumart/update" method="post">
        <input type="hidden" name="_id" value="${_id}">
		<div class="form-group">
			<span class="required-field">Name:</span> 
			<input type="text" name="name" class="form-control" value="${name}">
		</div>
		<div class="form-group">
			<span class="required-field">Description:</span> 
			<input type="text" name="description" class="form-control" value="${description}">
		</div>
		<div class="form-group">
			<span class="required-field">Price:</span> 
			<input type="text" name="price" class="form-control" value="${price}">
		</div>
		<div class="form-group">
			<span class="required-field">Number:</span> 
			<input type="text" name="number" class="form-control" value="${number}">
		</div>
		<input type=submit value='submit' />
	</form>
</body>
</html>