<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단 출력 1</h2>
	<table border = "1px solid black;">
	
	<%
	for (int i = 2; i < 10; i++) {%>
		<tr>
		<%for(int j = 1 ; j<10 ; j++){%>
		<td>
			<%= i +" * " + j + " = " + i*j %>
			</td>
	<% 	}%>
			</tr>
	<%}%>

		</table>
	<h2>구구단 출력2</h2>
	<table border = "1px solid black">
	<% for (int i= 1; i <10; i++) {%>
	<tr>
	<% for (int j = 2 ; j<10 ; j++){ %>
	<td>
		<%= j +" * " + i + " = " + i*j %>
		</td>
	<%} %>
		</tr>
	<%} %>
	</table>
	
	<h2>구구단 출력 3</h2>
	<table border = "1px solid black;">
	<%
	for (int i = 2; i < 10; i++) {%>
	<%if(i%2 ==1){ %>
		<tr style="background:blue;" >
		
		<%for(int j = 1 ; j<10 ; j++){%>
		<td>
			<%= i +" * " + j + " = " + i*j %>
			</td>
	<% 	}%>

			</tr>
	<%}else{%>
	<tr style="background:gray;" >
	<%for(int j = 1 ; j<10 ; j++){%>
		<td>
			<%= i +" * " + j + " = " + i*j %>
			</td>
	<% 	}%>
	</tr>
	<%} %>
	
<% } %>
</body>
</html>