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
	table{
		margin: auto;
		margin-top: 50px;
		font-size: 20px;
	}
	a{
		text-decoration: none;
		color: black;
	}
	.th1{
		width: 100px;
	}
	.th2{
		width: 150px;	
	}
	.th3{
		width: 300px;	
	}
</style>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	<table>
		<tr>
			<th class="th1">번호</th>
			<th class="th1">제목</th>
			<th class="th2">작성자</th>
			<th class="th3">등록일</th>
		</tr>
		<c:forEach items="${list}" var="bvo">
		<tr>
			<td>${bvo.bno}</td>
			<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title}</a> </td>
			<td>${bvo.writer}</td>
			<td>${bvo.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/board/register.jsp"><button>게시글 작성</button></a>
	<a href="/main.jsp"><button>돌아가기</button></a>
	<script type="text/javascript">
	const msg_update = `<c:out value="${msg_update}"></c:out>`;
		if (msg_update === '-1'){
			alert("수정 완료")
		}
	const msg_delete = `<c:out value="${msg_delete}"></c:out>`;
		if (msg_delete === '-1'){
			alert("삭제 완료")
		}
	</script>
</body>
</html>