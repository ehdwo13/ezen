<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<style>
	*{
		margin: 0px;
		padding: 0px;
		text-align: center;
		margin-top: 30px;
	}
	h1{
		margin-top: 10%;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/mem/join" method="post">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="password"><br>
		이메일 : <input type="email" name="email"><br>
		나이 : <input type="number" name="age"><br>
		<button type="submit">회원가입</button>
		<a href="/index.jsp"><button type="button">취소</button></a> 
	</form>
</body>
</html>