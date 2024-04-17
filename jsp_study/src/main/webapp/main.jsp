<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Main</title>
</head>
<body>
	<h1>메인화면</h1>
	<h3>${ses.id }님이 로그인하셨습니다. <br>
		계정생성일 : ${ses.regdate }<br> 
		최근접속일 : ${ses.lastlogin }</h3>
	<a href="/brd/myList"><button>내가 작성한 글 리스트</button></a>
	<a href="/mem/detail"><button>회원정보</button></a>
	<a href="/brd/list"><button>게시판</button></a>
	<a href="/mem/logout"><button>로그아웃</button></a>
</body>
</html>