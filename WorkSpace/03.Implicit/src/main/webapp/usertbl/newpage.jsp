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
	<%@ include file="/include/header.jsp" %>
	<!-- form태그의 액션이 바뀌어야한다. -->
	<form  action = "insert">
	<!-- 인서트요청한곳으로 액션  -->
	  <div class="form-group">
    <label>이름</label>
    <input type="text" class="form-control" name="username" >
  </div>
    <div class="form-group">
    <label>출생년도</label>
    <input type="number" class="form-control" name="birthyear" >
  </div>
    <div class="form-group">
    <label>주소</label> 
    <input type="text" class="form-control" name="address">
  </div>
    <div class="form-group">
    <label>폰번호</label>
    <input type="text" class="form-control" name="mobile" >
  </div>
  <input type="submit" class="btn btn-primary" value="추가하기">
</form>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>