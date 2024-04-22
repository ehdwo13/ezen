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
	<div>
	<form action="/brd/list" method="get">
	<div>
		<select name="type">
			<option ${ph.pgvo.type eq null ? 'selected':''}>Choose</option>
			<option value='t' ${ph.pgvo.type eq 't' ? 'selected':''}>title</option>
			<option value='w' ${ph.pgvo.type eq 'w' ? 'selected':''}>writer</option>
			<option value='c' ${ph.pgvo.type eq 'c' ? 'selected':''}>content</option>
		</select>
		<input type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword }">
		<input type="hidden" name="pageNo" value="1">
		<input type="hidden" name="qty" value="${ph.pgvo.qty }">
		<button type="submit">Search</button>
		<span>totalCount : ${ph.totalCount }</span>
	</div>
	</form>
	</div>
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
	<div>
	<!-- prev  -->
	<c:if test="${ph.prev }">
	<a href="/brd/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty }&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">⇦</a> 
	</c:if>
	<!-- paging -->
	<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
		<a href="/brd/list?pageNo=${i }&qty=${ph.pgvo.qty }&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i }</a> 
	</c:forEach>
	<!-- next -->
	<c:if test="${ph.next }">
	<a href="/brd/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty }&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">⇨</a>
	</c:if>
	</div>
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