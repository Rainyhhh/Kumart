<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="unimelb.edu.au.kumart.entity.Item"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
				<form action="/Kumart/admin_search" method="post">
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
				<a class="btn btn-info" href="/Kumart/admin_prepareaddItem">+
					Add new Item</a>
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
						pageContext.setAttribute("quantity", item.getNumber());
						pageContext.setAttribute("modifiedTime", format.format(item.getUpdateTime()));
				%>
				<div class="col-sm-6 col-md-3">
					<div class="small-box box text-black">
						<img style="width: 100%;" src="images/defaut-kuma.png" alt="..."
							class="img-thumbnail">
						<div class="small-box-footer text-yellow">
							<div class="row">
								<div class="col-md-12">
									<div class="col-sm-6">
										<a href="#" class="text-yellow"><h4>${name}</h4></a>
									</div>
									<div class="col-sm-6">
										<a href="admin_prepareUpdate?id=${_id}"> <i
											class="glyphicon glyphicon-pencil image_display_icon"
											aria-hidden="true"></i>
										</a> <a href="admin_deleteItem?id=${_id}"
											onclick="return confirm('Delete this item?')"> <i
											class="glyphicon glyphicon-trash image_display_icon"
											aria-hidden="true"></i>
										</a>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="col-sm-6">
										<h5>AU$${price}</h5>
										<span>Quantity:${quantity}</span>
									</div>
									<div class="col-sm-6" style="padding-top: 10px;">
										<p style="font-size: 13px; color: black;">${modifiedTime}</p>
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
</body>
</html>
