<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바코드 + HTML 태그</h1>
	<% int vInt =10; %>
	<% String vStr = "테스트 중입니다."; %>
	<% double vDb = 3.14; %>
	<% ArrayList<String> arrList = new ArrayList<>();  %>
	<% arrList.add("j"); %>
	<% arrList.add("k"); %>
	<% arrList.add("h"); %>
	<p style = "font-size: 24px; color : #009900">vInt = <%= vInt   %><br>
	<%= vStr   %><br>
	<%= vDb %>
	<%= arrList.get(0)+arrList.get(1) %>
	
</body>
</html>