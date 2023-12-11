<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/customer/header.jsp"%>

	<section class="h-130 bg-dark">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card card-registration my-4">
						<div class="row g-0">
							<div class="col-xl-6 d-none d-xl-block">
								<img src="css/img1.jpg" alt="Sample photo" class="img-fluid"
									style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
							</div>
							<div class="col-xl-6">
								<div class="card-body p-md-5 text-black">
									<h3 class="mb-5 text-uppercase">회원가입!</h3>

									<div class="form-outline mb-4">
										<input type="text" 
											class="form-control form-control-lg"name = "user_id" id="user_id" /> <label
											class="form-label" for="form3Example8" >아이디</label>
									</div>
									<div class="form-outline mb-4">
										<input type="password" 
											class="form-control form-control-lg"name="user_pw" id="user_pw" /> <label
											class="form-label" for="form3Example9">비밀번호</label>
									</div>

									<div class="form-outline mb-4">
										<input type="password" 
											class="form-control form-control-lg" id="user_pwchk"/> <label
											class="form-label" for="form3Example90">비밀번호 확인</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text"
											class="form-control form-control-lg" name = "name" id="name"/> <label
											class="form-label" for="form3Example99" >이름</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" 
											class="form-control form-control-lg"name = "email" id="email" /> <label
											class="form-label" for="form3Example97" >이메일</label>
										<div class="d-flex justify-content-start pt-3">
											<a class="btn btn-secondary btn-lg ms-2" id="btn_post" >주소찾기</a>
										</div>
									</div>
									<div class="form-outline mb-4">
										<input type="text" id="address"
											class="form-control form-control-lg" name="address"/> <label
											class="form-label" for="form3Example97" >주소</label>
									</div>
									<div class="form-outline mb-4">
										<input type="text" 
											class="form-control form-control-lg"  name = "post" id="post"/> <label
											class="form-label" for="form3Example97">상세주소</label>
									</div>

									<div class="d-flex justify-content-end pt-3">
										<a class="btn btn-success btn-lg ms-2">가입</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<%@ include file="/customer/footer.jsp"%>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
	$('#btn_post').click(function () {

		    new daum.Postcode({
		        oncomplete: function(data) {
		        	let address = data.userSelectedType=='R' ? data.roadAddress : data.jibunAddress;
		        	
					$('#address').val(address);
					$('#post').val(data.zonecode);
		        }
		    }).open();
	});
	</script>
</body>
</html>