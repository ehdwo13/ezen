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
<title>Info</title>
</head>
<body>
	<h1>회원정보</h1>
	<form action="/mem/modify" method="post">
		아이디 : <input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
		패스워드 : <input type="password" name="password" value="${ses.password }"><br>
		이메일 : <input type="email" name="email" value="${ses.email }"><br>
		나이 : <input type="number" name="age" value="${ses.age }"><br>
		회원가입일 : <input type="text" name="regdate" value="${ses.regdate } "disabled="disabled"><br>
		최근접속일 : <input type="text" name="lastlogin" value="${ses.lastlogin } "disabled="disabled"><br>
		<button type="submit">수정</button>
	</form>
	<a href="/mem/delete"><button type="button">회원탈퇴</button></a>
	
	
</body>
</html>