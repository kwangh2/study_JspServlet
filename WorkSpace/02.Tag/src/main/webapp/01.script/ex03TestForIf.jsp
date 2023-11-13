<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>합구하기</h1>
	<% %>
	 <%  int tempInt , odd=0 ,even=0;
	 for(tempInt = 0 ; tempInt <=100; tempInt++){
		  if( tempInt %2 ==1){
			  odd += tempInt;
		  }else{
			  even += tempInt;
		  }
	  }
	 %>
	 <p style="color:blue">홀수 합 : <%= odd %></p>
	 <p>짝수 합 : <%= even %></p>
	 <p>총합 : <%= odd+even %></p>
</body>
</html>