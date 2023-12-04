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
      <td><input type="text" class="form-control" placeholder="name" name = "name" ></td>
      <td><input type="text" class="form-control" placeholder="department" name = "department" ></td>
      <td><input type="text" class="form-control" placeholder="email" name=email ></td>
      <td><input type="number" class="form-control" placeholder="salary" name="salary" ></td>
	 <td><button type="submit" class="btn btn-primary">추가</button></td>
	 <td><button type="submit" class="btn btn-primary">수정</button></td>
    </tr>
    </form>
    
    
  <c:forEach items="${list}" var="vo" varStatus="i">
    <tr>
      <th>${vo.name}</th>
      <th>${vo.department_name}</th>
      <th>${vo.email}</th>
      <th>${vo.salary}</th>
	 <th><a href="delete.sg?id=${vo.employee_id} " class="btn btn-outline-danger">삭제</a></th>
	 <td><a onclick="updateCus(${i.index},${vo.employee_id})"class="btn btn-danger">수정</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="modal fade" id="updateModal" tabindex="-1" 
		aria-labelledby="updateModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="updateModalLabel" >정보수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="update.cu" method="get">
				<input type="hidden" >
					<div class="modal-body">
						<div class="form-group">
							<label for="name">이름</label> <input type="text"
								class="form-control" id="name" name="name" >
						</div>
						<div class="form-group">
							<label for="email">이메일</label> <input type="text"
								class="form-control" id="email" name="email" >
						</div>
						<div class="form-group">
							<label for="phone">부서</label> <input type="text"
								class="form-control" id="phone" name="department" >
						</div>
						<div class="form-group">
							<label for="phone">급여</label> <input type="number"
								class="form-control" id="phone" name="salary" >
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">취소</button>
							<input type="submit" class="btn btn-primary" value="수정"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
 	<script type="text/javascript">
 	function updateCus(idx,employee_id){
 		var name = $('table tr:eq('+ idx +') td:eq(0)').text();
 		var department  = $('table tr:eq('+ idx +') td:eq(1)').text();
 		var email = $('table tr:eq('+ idx +') td:eq(2)').text();
 		var salary = $('table tr:eq('+ idx +') td:eq(3)').text();
 		$('#updateModal input[name=name]').val(name);
 		$('#updateModal input[name=department]').val(department);
 		$('#updateModal input[name=email]').val(email);
 		$('#updateModal input[name=salary]').val(salary);
 		$('#updateModal').modal('show');
 	}
 	</script>
	<%@ include file="/customer/footer.jsp" %>
</body>
</html>