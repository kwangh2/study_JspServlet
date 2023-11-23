<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mybatis Index!</h1>
	<h3>insert</h3>
	<form action="insert.mytbl">
	
	<input type="text" text ="col1" name="col1">
	<input type="text" text ="col1" name="col2">
	<input type="text" text ="col1" name="col3">
	<input type="submit" value="추가">
	</form>
		<h3>UPDATE</h3>
	<form action="update.mytbl">
	
	<input type="text" text ="col1" name="col1">
	<input type="text" text ="col1" name="col2">
	<input type="text" text ="col1" name="col3">
	<input type="submit" value="수정">
	</form>
			<h3>DELETE</h3>
	<form action="delete.mytbl">
	
	<input type="text" text ="col1" name="col1">

	<input type="submit" value="삭제">
	</form>
	<a href="select.mytbl">select</a>
	
	<c:forEach items="${list}" var = "vo">
	<p>${vo.col1}</p>
	</c:forEach>
</body>
</html>