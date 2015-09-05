<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title>Welcome to Kumart!</title>

</head>
<body class="skin-yellow">
	<jsp:include page="navigator.jsp" />
	<div class="content-wrapper" style="margin-left: 0px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			My Items <small>Homepage</small>
		</h1>
		<div class="row">
			<div class="col-md-12">
				<div class="pull-right">
					<a class="btn btn-info" data-toggle="modal"
						data-target="#add_new_website">+ Add a new item</a>
				</div>
			</div>
		</div>
		</section>
		<!-- Main content -->
		<section class="content"> <!-- Small boxes (Stat box) -->
		<div class="row">
			<div class="col-md-12">
				<!-- PRODUCT LIST -->
				<div class="col-sm-6 col-md-3">
					<div class="small-box box text-black">
							<img style="width:100%;" src="images/default.jpg" alt="...">
						<div class="small-box-footer ">
							<a class="text-yellow"><h4>Kuma</h4></a>
							<div class="row">
							<div class="col-md-12">
							<div style="display:inline-block;" class="pull-right">
								<a href="#"><img alt="remove"
									title="delete" src="images/remove.png" /></a>
								<a
									href="#"><img alt="edit" title="edit" src="images/edit.png" /></a>
							</div>
							</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- /.col-md-12 -->
		</div>
		<!-- /.row (main row) --> </section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->




	<form action="/Kumart/addItem" method="post">
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
		<input type=submit value='submit' />
	</form>
</body>
</html>