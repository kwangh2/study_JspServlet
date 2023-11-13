<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반복문 </h1>
	<% for(int i = 0 ; i<10 ; i++) {%>
		<p>연속 출력이 가능한지 <%= i %> </p>
	<%} %>
	</body>
</html>