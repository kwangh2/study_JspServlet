<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> if 문</h1>
	<%! int iVar = 0;  %>

	<% if(iVar % 2 ==1){ %>
	<p> <%= "iVar = "+iVar  %> </p>
	<% } %>
		<p><%= iVar++ %></p>
</body>
</html>