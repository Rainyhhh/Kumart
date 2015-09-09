<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="unimelb.edu.au.kumart.entity.Item"%>
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
	<%
		List<Item> items = (List<Item>) request.getAttribute("items");
	%>
	<jsp:include page="navigator.jsp" />
	<div class="content-wrapper" style="margin-left: 0px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			My Items <small>Homepage</small>
		</h1>
		<div class="row">
			<div class="col-sm-offset-5 col-sm-3">
				<form action="/Kumart/search" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="query"
							placeholder="Search by name ..."> <span
							class="input-group-btn"> <input class="btn btn-default"
							aria-hidden="true" type="submit" value="search" />
						</span>
					</div>
				</form>
			</div>
			<div class="col-sm-offset-9">
				<a class="btn btn-info" data-toggle="modal"
					data-target="#add_new_item">+ Add new Item</a>
			</div>
		</div>
		</section>
		<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-md-12">
				<!-- PRODUCT LIST -->
				<%
					for (Item item : items) {
						pageContext.setAttribute("_id", item.get_id());
						pageContext.setAttribute("name", item.getName());
						pageContext.setAttribute("price", item.getPrice());
				%>
				<div class="col-sm-6 col-md-3">
					<div class="small-box box text-black">
						<img style="width: 100%;" src="images/defaut-kuma.png" alt="..."
							class="img-thumbnail">
						<div class="small-box-footer text-yellow">

							<a href="#" class="text-yellow"><h4>${name}</h4></a>
							<div class="row">
								<div class="col-md-12">
									<div class="col-sm-6">
										<h5>AU$${price}</h5>
									</div>

									<div class="col-sm-6">
										<a href="prepareUpdate?id=${_id}"><i
											class="glyphicon glyphicon-pencil image_display_icon"
											aria-hidden="true"></i></a> <a href="deleteItem?id=${_id}"><i
											class="glyphicon glyphicon-trash image_display_icon"
											aria-hidden="true"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<%
					}
				%>
			</div>
			<!-- /.col-md-12 -->
		</div>
		<!-- /.row (main row) --> </section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->



	<div id="add_new_item" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="addModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="addModal">Add an Item</h4>
				</div>
				<div class="modal-body">
					<form action="/Kumart/addItem" method="post">
						<div class="form-group">
							<span class="required-field">Name:</span> <input type="text"
								name="name" class="form-control">
						</div>
						<div class="form-group">
							<span class="required-field">Description:</span> <input
								type="text" name="description" class="form-control">
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
							<input type="submit" class="btn btn-save" value='submit' />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
