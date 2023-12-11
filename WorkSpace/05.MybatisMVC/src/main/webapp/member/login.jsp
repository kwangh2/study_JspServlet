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
	<%@ include file="/customer/header.jsp" %>
	
<!-- Section: Design Block -->
<section class=" text-center text-lg-start">
  <style>
    .rounded-t-5 {
      border-top-left-radius: 0.5rem;
      border-top-right-radius: 0.5rem;
    }

    @media (min-width: 992px) {
      .rounded-tr-lg-0 {
        border-top-right-radius: 0;
      }

      .rounded-bl-lg-5 {
        border-bottom-left-radius: 0.5rem;
      }
    }
  </style>
  <div class="card mb-3">
    <div class="row g-0 d-flex align-items-center">
      <div class="col-lg-4 d-none d-lg-flex">
        <img src="css/bori.jpg" alt="Trendy Pants and Shoes"
          class="w-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
      </div>
      <div class="col-lg-8">
        <div class="card-body py-5 px-md-5">

          <form method="post">
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input type="text" id="user_id" name = "user_id" class="form-control" placeholder = "아이디 입력"/>
              <label class="form-label" for="form2Example1">ID</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input type="password" id="user_pw" name = "user_pw" class="form-control" placeholder="비밀번호 입력" onkeypress="if (event.keyCode==13 ) login()"/> <!-- 엔터누르면 로그인  -->
              <label class="form-label" for="form2Example2">Password</label>
            </div>

            <!-- 2 column grid layout for inline styling -->
            <div class="row mb-4">
              <div class="col d-flex justify-content-center">

              </div>

              <div class="col">
                <!-- Simple link -->
                <a href="#!">Forgot password?</a>
              </div>
            </div>

            <!-- Submit button -->
            <a type="button" class="btn btn-primary btn-block mb-4" onclick="login()">로그인</a>

          </form>

        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->
	<%@ include file="/customer/footer.jsp" %>
	
	<script type="text/javascript">
	function login() {
		//console.log($('#user_id').val());
		if($('#user_id').val() ==''){
			alert('아이디를 입력하세요');
			$('#user_id').focus();//커서
			return;
		}else if($('#user_pw').val() ==''){
			alert('비밀번호를 입력하세요');
			$('#user_pw').focus();//커서
			return;
		}
		
		//비동기 통신 : 페이지를 새로 요청하지않고 , Controller나 다른 API에 데이터만 따로 요청을 하는 형태 
		//XMLHttpRequest 객체 , Http객체 : 코드가 조금 복잡함
		//Jquery: Ajax
		//type: json..
		//method : post
		//url : 어디에 요청할건지 
		//data 어떤것을 전송할건지
		//success : 실행되는 펑션
		//error : 실행되는 펑션
		
		$.ajax({
			type : 'post' , 
			url : 'login.me',
			data : { user_id:$('#user_id').val() , user_pw:$('#user_pw').val() },
			success : function( res){
				if(res == '1'){
					//1.reload(x) , 로그인페이지가 다시나옴 
					//2.href = '/mvc'
					//3.href= 'c:url value="/" '
					//   / <- root
					location.href='/mvc'
				}else
				 alert('로그인 실패');
				$('#user_id').focus();
			},
			error : function(req, text) {
				alert(req.status + '오류! 다시 로그인 시도를 해주세요.');
			}
		});
	}

	</script>
</body>
</html>