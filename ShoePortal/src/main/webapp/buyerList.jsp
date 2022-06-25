<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="com.example.dao.*" %>
    <%@ page import="java.util.*" %>
	
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
			<h3 class="text-center">CUSTOMER/BUYER DETAILS</h3>
			<hr>
			<br>
			<%List<Buyer> list=(List<Buyer>)session.getAttribute("buyerList");  %>
			<table class="table table-bordered">
				<thead>
					<tr><th>Buyer FirstName</th>
						<th>Buyer LastName</th>
						<th>Buyer Email</th>
					</tr>
				</thead>
				<tbody>
					<% for(Buyer buyer:list){%>
						<tr>
							<td><%=buyer.getFirstName() %></td>
							<td><%=buyer.getLastName() %></td>
							<td><%=buyer.getEmail()%></td>
						</tr>
						<%}%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>


