<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메소드 사용 </h1>
	<!-- Java에서 메소드를 만드는 과정에서 사용되었던 지역( 클래스의 지역) -->
	<%! int getSum(int x, int y){
		return x+y;
		
	} %>
	<a> getSum: <%= getSum(10, 20) %></a><br>
	<%! int getMinus(int x, int y){
		return x-y;
	}
		int getMul(int x, int y){
			return x*y;
		}
		int getDiv(int x, int y){
			return x/y;
		}
	%>
	
	<a>getMinus : <%= getMinus(10, 20)%></a> <br>
	<a>getMul : <%= getMul(10, 20)%></a><br>
	<a>getDiv : <%= getDiv(20, 10)%></a>
</body>
</html>