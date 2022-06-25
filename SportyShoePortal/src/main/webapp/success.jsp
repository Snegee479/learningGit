<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="com.example.pojo.*" %>
    <%@ page import="com.example.dao.*" %>
    <%@ page import="com.example.repository.*" %>
    <%@ page import="com.example.appController.*" %>
    <%@ page import="java.util.*" %>
        
	
<!DOCTYPE html>
<html>
<head>
<title>WELCOME TO SPORTY SHOES PORTAL</title>
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
				<a href="http://localhost:8080" class="navbar-brand"> Welcome <%=session.getAttribute("firstName")%>, this is Sporty Shoes </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllBuyerProducts"
					class="nav-link">Products</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllBuyerCategory"
					class="nav-link">Categories</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/Buyerlogout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

<br>


<h1>Select Category to browse </h1>


<%List<Category> list=(List<Category>)session.getAttribute("categoryList");  %>
<% for(Category category:list){%>
	<form action=buyProduct><input type="submit" value=<%=category.getCategoryName() %>></form>
		
<%}%>

</body>
</html>