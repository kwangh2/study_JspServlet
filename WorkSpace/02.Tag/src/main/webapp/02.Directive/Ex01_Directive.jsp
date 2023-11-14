<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디렉티브 태그(Directive Tag) : <\%@</h1>
	<h4>ContentType : 어떤 형태로 페이지리를 출력할건지에 대한 결정 : 웹에서는 변경이 거의 없음.</h4>
	<h5>contentType="application/json; charset=UTF-8" Json 형태로 응답 </h5>
	<h4>PageEncoding : 문자 인코딩 (각 나라별 언어마다 인코딩 방식이 다름. 한글 : UTF-8)</h4>
	
	<h4>import : 자바 Date 클래스 <%= new Date() %></h4>
	<h5>java.util.Date 라는 클래스를(외부) 사용하기 위해서 기능을 추가함 ※자동완성을 안쓰면 이클립스에서 처럼 마우스 올려서 자동 임포트x※</h5>
	
	
	<%! Random random = new Random(); 	%>
	<% int i =  random.nextInt(100)+1; 
	if(i%2 == 0 ){ %>
		<a>짝수 랜덤값 : <%= i %></a>
	<%}else{%>
	<a>홀수 랜덤값 : <%= i %></a>
	<% } %>
	
</body>
</html>