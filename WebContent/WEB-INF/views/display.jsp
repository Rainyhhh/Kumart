<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="unimelb.edu.au.kumart.entity.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All items</title>
</head>
<body>
<%
List<Item> items =(List<Item>) request.getAttribute("items");
%>
<%
for (Item item : items){
	pageContext.setAttribute("name", item.getName());
	pageContext.setAttribute("price", item.getPrice());
%>
<div>${name}</div>
<div>${price}</div>
<% 
}
%>

</body>
</html>