<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<table border = "1px solid black;">
			<tr>
				<td>GET 방식</td>
				<form  action = "Ex03" method = "get">
				<td>
					<input type = "text" name = "id"/>
					<input type = "submit"/>
				</td>
				</form>
			</tr>
				<tr>
				<td>GET 방식</td>
				<form  action = "Ex03" method = "post">
				<td>
				<input type = "text" name = "id"/>
					
					<input type = "submit" />
				</td>
				</form>
			</tr>
			</tr>
				<tr>
				<td>GET 방식</td>
				<form  action = "Ex03" method = "post">
				<td>
				<input type = "text" name = "id"/>
					<input type = "text" name = "pw"/>
					<input type = "submit" />
				</td>
				</form>
			</tr>
		</table>
</body>
</html>