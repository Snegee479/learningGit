<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editStudent">

<input type="hidden" name="sid" value="<%=request.getParameter("id")%>" />
sname<input type="text" name="name"><br>
semail<input type="email" name="email"><br>
<input type="submit" value="edit">
</form>

</body>
</html>