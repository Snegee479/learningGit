<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="com.example.pojo.*" %>
    <%@ page import="com.example.dao.*" %>
    <%@ page import="com.example.repository.*" %>
    <%@ page import="com.example.appController.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.Application.*" %>
    	
<html>
<head>
<title>SPORTY SHOES PORTAL</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: gray">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Sporty Shoes </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllProducts"
					class="nav-link">Products</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllCategory"
					class="nav-link">Categories</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllBuyers"
					class="nav-link">Buyer's List</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllPurchaseList"
					class="nav-link">Purchase List</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">PRODUCT PURCHASE LIST</h3>
			<hr>
			<br>
			<%List<PurchaseList> list=(List<PurchaseList>)session.getAttribute("plist");  %>
			<table class="table table-bordered">
				<thead>
					<tr><th>Product Id</th>
						<th>Product Name</th>
						<th>Product Description</th>
						<th>Product Price</th>
						<th>Category Name</th>
						<th>Address</th>
					</tr>
				</thead>
				<tbody>
			<% for(PurchaseList p:list){%>
						<tr>
							<td><%=p.getProductId()%></td>
							<td><%=p.getProductName()%></td>
							<td><%=p.getProductDescription()%></td>
							<td><%=p.getProductPrice() %></td>
							<td><%=p.getCategory().getCategoryName() %></td>
							<td><%=p.getAddress() %></td>
						</tr>
						<%}%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

















