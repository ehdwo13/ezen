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
</style>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<h1>${bvo.bno }번 게시물</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${bvo.moddate }</td>
		</tr>
	</table>
	<c:if test="${bvo.writer eq ses.id }">
	<a href="/brd/modify?bno=${bvo.bno }"><button>수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button>삭제</button></a>
	</c:if>
	<a href="/brd/list"><button type="button">돌아가기</button></a>
	
	
	<hr>
	<div>
	<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly">
	<input type="text" id="cmtText" placeholder="댓글을 입력해주세요...">
	<button type="button" id="cmtAddBtn">댓글 달기</button>
	</div>
	<hr>
	<div id="commentLine">
	<div>
		<div>cno, bno, writer, regdate</div>
		<div>
		<c:if test="${bvo.writer eq ses.id }">
			<button>수정</button> <button>삭제</button><br>
			<input type="text" value="content">
		</c:if>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}" />`;
		const logVal = `<c:out value="${ses.id}" />`
	</script>
	<script type="text/javascript" src="/resources/board_detail.js"></script>
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>
</body>
</html>