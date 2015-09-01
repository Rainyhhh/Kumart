<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Kumart!</title>
</head>
<body>
	<form action="/Kumart/addItem" method="post">
		<div class="form-group">
			<span class="required-field">Name:</span> 
			<input type="text" name="name" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Description:</span> 
			<input type="text" name="description" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Price:</span> 
			<input type="text" name="price" class="form-control">
		</div>
		<div class="form-group">
			<span class="required-field">Number:</span> 
			<input type="text" name="number" class="form-control">
		</div>
		<input type=submit value='submit'/>
	</form>
</body>
</html>