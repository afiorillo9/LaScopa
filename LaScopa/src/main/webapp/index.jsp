<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>

<%
	Boolean test = (Boolean) request.getAttribute("test");
	
	if(test == null) {
		response.sendRedirect("Index");
		return;
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>LaScopa</title>
	</head>
	<body>
		<%
			if(test == true){
		%>
			<p>Hello World</p>
		<%
			} else {
		%>
			<p>Non funziona</p>
		<%
			} 
		%>
	</body>
</html>