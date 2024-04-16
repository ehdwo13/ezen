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
<title>Home</title>
</head>
<body>
	<h1>환영합니다</h1>
	<c:if test="">
	
	</c:if>
	<form action="/mem/login" method="post">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="pwd"><br>
		<button type="submit">로그인</button>
	<a href="/member/join.jsp"><button type="button">회원가입</button></a>
	
	</form>
	<script type="text/javascript">
		const msg_modify = `<c:out value="${msg_modify}"></c:out>`;
		if (msg_modify === '-1'){
			alert("회원정보 수정완료. 다시로그인해주세요.  ")
			location.href ="/index.jsp"
		}
		const msg_loginCheck = `<c:out value="${msg_loginCheck}"></c:out>`;
		if (msg_loginCheck === '-1'){
			alert("로그인 실패 ! 아이디 비밀번호를 확인해주세요. ")
		}
		const msg_logout = `<c:out value="${msg_logout}"></c:out>`;
		if (msg_logout === '-1'){
			alert("로그아웃")
			location.href ="/index.jsp"
		}
		const msg_delete = `<c:out value="${msg_delete}"></c:out>`;
		if (msg_delete === '-1'){
			alert("회원탈퇴 완료")
			location.href ="/index.jsp"
		}
		const msg_join = `<c:out value="${msg_join}"></c:out>`;
		if (msg_join === '-1'){
			alert("회원가입 완료 환영합니다")
			location.href ="/index.jsp"
		}
		
	</script>
</body>
</html>