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
			<h3 class="text-center">All Categories of Shoes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-success">Add
					New Category</a>
			</div>
			<br>
			<%List<Category> list=(List<Category>)session.getAttribute("categoryList");  %>
			<table class="table table-bordered">
				<thead>
					<tr><th>Category Id</th>
						<th>Category Id Name</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<% for(Category category:list){%>
						<tr>
							<td><%=category.getCategoryId() %></td>
							<td><%=category.getCategoryName() %></td>
							<td>
							<a href="edit/<%=category.getCategoryId()%>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							</td>
							<td>
							<a href="delete/<%=category.getCategoryId()%>">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							</td>
						</tr>
						<%}%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

