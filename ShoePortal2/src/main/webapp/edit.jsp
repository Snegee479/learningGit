<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateCategory">

<input type="hidden" name="categoryId" value="<%=session.getAttribute("categoryId")%>">
Category Name<input type="text" name="categoryName"><br>
<input type="submit" value="edit">
</form>

</body>
</html>