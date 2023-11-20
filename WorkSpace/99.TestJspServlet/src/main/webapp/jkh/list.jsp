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

	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</a></th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="dto">
    <tr>
      <th scope="row">1</th>
      <td><a href="update?username=${dto.username}">${dto.username}</a></td>
      <td>${dto.birthday}</td>
      <td>${dto.bloodtype}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>


<%@ include file="/include/footer.jsp" %>
</body>
</html>