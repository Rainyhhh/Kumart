<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="unimelb.edu.au.kumart.entity.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<jsp:include page="navigator.jsp" />
</head>
<body class="skin-yellow">
<%
List<Item> items =(List<Item>) request.getAttribute("items");
%>
<div class="content-wrapper" style="margin-left: 0px;">
<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Result
		</h1>
		</section>
<!-- Main content -->
		<section class="content"> 
				<div class="row">
			<div class="col-md-12">
				<!-- PRODUCT LIST -->
				<%
				for (Item item : items){
				pageContext.setAttribute("_id", item.get_id());
				pageContext.setAttribute("name", item.getName());
				pageContext.setAttribute("price", item.getPrice());
				%>
				<div class="col-sm-6 col-md-3">
					<div class="small-box box text-black">
							<img style="width:100%;" src="images/defaut-kuma.png" alt="..."class="img-thumbnail" >
						<div class="small-box-footer text-yellow">
						 
							<a href="#" class="text-yellow"><h4>${name}</h4></a>
						<div class="row">
						 <div class="col-md-12" > 
						   <div class="col-sm-6">                     
							    <h5 >AU$${price}</h5>
							    </div>
					    
					     <div class="col-sm-6">
								<a href="prepareUpdate?id=${_id}"><i class="glyphicon glyphicon-pencil image_display_icon" aria-hidden="true"></i></a>
								<a
									href="deleteItem?id=${_id}"><i  class="glyphicon glyphicon-trash image_display_icon" aria-hidden="true"></i></a>
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
			<a href="index" class="btn btn-save"> Back </a>
		</div>
		</section>

</div>

</body>
</html>