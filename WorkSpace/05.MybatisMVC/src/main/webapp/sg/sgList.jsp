<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/customer/header.jsp" %>
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">name</th>
      <th scope="col">department</th>
      <th scope="col">email</th>
      <th scope="col">salary</th>
      <th scope="col">삭제</th>
    </tr>
  </thead>
  <tbody>
  <form action="insert.sg">
      <tr>
      <th><input type="text" class="form-control" placeholder="name" name = "name" ></th>
      <th><input type="text" class="form-control" placeholder="department" name = "department" ></th>
      <th><input type="text" class="form-control" placeholder="email" name=email ></th>
      <th><input type="number" class="form-control" placeholder="salary" name="salary" ></th>
	 <th><button type="submit" class="btn btn-primary">추가</button></th>
    </tr>
    </form>
  <c:forEach items="${list}" var="vo">
    <tr>
      <th>${vo.name}</th>
      <th>${vo.department_name}</th>
      <th>${vo.email}</th>
      <th>${vo.salary}</th>
	 <th><a href="delete.sg?id=${vo.employee_id} " class="btn btn-outline-danger">삭제</a></th>
    </tr>
    </c:forEach>
  </tbody>
</table>
	
	<%@ include file="/customer/footer.jsp" %>
</body>
</html>