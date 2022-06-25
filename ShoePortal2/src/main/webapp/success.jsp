<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="com.example.pojo.*" %>
    <%@ page import="com.example.dao.*" %>
    <%@ page import="com.example.repository.*" %>
    <%@ page import="com.example.appController.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.Application.*" %>
        
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Portal</title>
</head>
<body>

<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: gray">
			<div>
				<a href="http://localhost:8080" class="navbar-brand"> Welcome <%=session.getAttribute("firstName")%>, this is Sporty Shoes </a>
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
				<li><a href="<%=request.getContextPath()%>/logout"
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