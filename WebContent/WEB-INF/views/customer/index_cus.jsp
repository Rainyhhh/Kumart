<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="unimelb.edu.au.kumart.entity.Item"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="skin-yellow">
	<%
		List<Item> items = (List<Item>) request.getAttribute("items");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	<jsp:include page="navigator_cus.jsp" />
	<div class="content-wrapper" style="margin-left: 0px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			My Items <small>Homepage</small>
		</h1>
		<div class="row">
			<div class="col-sm-offset-8 col-sm-3">
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
						//pageContext.setAttribute("modifiedTime", format.format(item.getUpdateTime()));
				%>
				<form action="/Kumart/addShoppingCart" method="post">
					<div class="col-sm-6 col-md-3">
						<div class="small-box box text-black">
							<img style="width: 100%;" src="images/defaut-kuma.png" alt="..."
								class="img-thumbnail">
							<div class="small-box-footer text-yellow">
								<div class="row">
									<div class="col-md-12">
										<div class="col-sm-6">
											<input type="hidden" name="item_id" value="${_id}"> <a
												href="#" class="text-yellow"><h4>${name}</h4></a> <input
												type="hidden" name="item_name" value="${name}">
										</div>
										<div class="col-sm-6">
											<h5>AU$${price}</h5>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="col-sm-4">
											<div class="input-group number-spinner">
												<!-- <span class="input-group-btn">
													<button class="btn btn-default" data-dir="dwn">
														<span class="glyphicon glyphicon-minus"></span>
													</button>
												</span> -->
												 <input type="number" name="quantity"
													class="form-control text-center" value="1"/> 
													<!-- <span class="input-group-btn">
													<button class="btn btn-default" data-dir="up">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
												</span> -->
											</div>
										</div>
										<div class="col-sm-8" style="padding-top: 10px;">
											<%-- <a href="/addShoppingCart?id=${_id}" type="submit" class="btn btn-save">
									AddToShoppingCart
									</a> --%>
											<input type="submit" class="btn"
												value="AddToShoppingCart" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
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
<!-- <script>
$(document).on('click', '.number-spinner button', function () {    
	var btn = $(this),
		oldValue = btn.closest('.number-spinner').find('input').val().trim(),
		newVal = 0;
	
	if (btn.attr('data-dir') == 'up') {
		newVal = parseInt(oldValue) + 1;
	} else {
		if (oldValue > 1) {
			newVal = parseInt(oldValue) - 1;
		} else {
			newVal = 1;
		}
	}
	btn.closest('.number-spinner').find('input').val(newVal);
});
</script> -->
</html>