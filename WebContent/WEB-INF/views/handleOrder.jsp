<%@page import="unimelb.edu.au.kumart.entity.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="unimelb.edu.au.kumart.entity.Order"%>
<%@ page import="unimelb.edu.au.kumart.entity.OrderItem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/AdminLTE.min.css">
<link rel="stylesheet" type="text/css"
	href="css/skins/_all-skins.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<%
	List<Order> list = (List<Order>) request.getAttribute("orderList");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<body class="skin-yellow sidebar-mini">
	<jsp:include page="navigator.jsp" />
	<div class="content-wrapper" style="margin-left: 0px;">
		<!-- Content Header (Page header) -->
		<section  class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">My orders</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
							<tr>
								<th>Order ID</th>
								<th>Items</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Update Date</th>
								<th>State</th>
							</tr>
							<%
								for (Order order : list) {
							%>
							<tr>
								<td><%=order.getOrder_id()%></td>
								<td>
									<%
										for (OrderItem item : order.getItemList()) {
									%>
									<p><%=item.getItem_name()%></p> <%
 	}
 %>
								</td>
								<td>
									<%
										for (OrderItem item : order.getItemList()) {
									%>
									<p><%=item.getQuantity()%></p> <%
 	}
 %>
								</td>
								<td>
									<%
										for (OrderItem item : order.getItemList()) {
									%>
									<p><%=item.getPrice()%></p> <%
 	}
 %>
								</td>
								<td><%=format.format(order.getModifiedTime())%></td>
								<%
									if (order.getState() == 1) {
								%>
								<td><a
									href="/Kumart/admin_approveCancellation?order_id=<%=order.getOrder_id()%>">Approve
										Cancellation</a></td>
								<%
									}
								%>
								<%
									if (order.getState() == 2) {
								%>
								<td>Cancellation Approved</td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>