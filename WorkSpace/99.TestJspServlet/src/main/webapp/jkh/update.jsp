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
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">수정하기</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name = "username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">생년월일</label>
    <input type="text" class="form-control" name = "birthday">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">혈액형</label>
    <input type="text" class="form-control" name = "bloodtype">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<%@ include file="/include/footer.jsp" %>

</body>
</html>