<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>modify page</h1>
	<form action="memb/update" method="post">
		id : <input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
		pwd : <input type="password" name="pwd" value="${ses.pwd }"><br>
		email : <input type="email" name="email" value="${ses.email }"><br>
		age : <input type="number" name="age" value="${ses.age }"><br>
		phone : <input type="tel" name="phone" value="${ses.phone }"><br>
		<button type="submit">modify</button>
	</form>
</body>
</html>