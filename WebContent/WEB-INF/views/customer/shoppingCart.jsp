<%@page import="unimelb.edu.au.kumart.entity.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="unimelb.edu.au.kumart.entity.ShoppingCart"%>
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
List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) request.getAttribute("shoppingCarts");
%>
<body class="skin-yellow sidebar-mini">
<jsp:include page="navigator_cus.jsp" />
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">My Shopping Cart</h3>
                  <div class="box-tools">
                    <div class="input-group">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                      <th>Item</th>
                      <th>Quantity</th>
                      <th>Price</th>
                      <th></th>
                    </tr>
                    <%
             for(ShoppingCart shoppingCart : shoppingCarts){
            	 pageContext.setAttribute("item", shoppingCart.getItem_name());
            	 pageContext.setAttribute("item_id", shoppingCart.getItem_id());
            	 pageContext.setAttribute("quantity", shoppingCart.getQuantity());
            	 pageContext.setAttribute("price", shoppingCart.getPrice());
             %>
                    <tr>             
                      <td>${item}</td>
                      <td>${quantity}</td>
                      <td>${price}</td>
                      <td><a href="/Kumart/deleteRecord"><span>Delete</span></a></td>                     
                    </tr>
                    <%
             }
                    %>
                  </table>                
                </div><!-- /.box-body -->
              </div><!-- /.box -->
               <a class="btn btn-default col-md-offset-9" href="/Kumart/order"><span>Payment</span></a>
            </div>
          </div>
</body>
</html>