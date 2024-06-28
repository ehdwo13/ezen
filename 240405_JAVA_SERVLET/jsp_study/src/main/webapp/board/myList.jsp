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
	}
	h1{
		margin-top: 10%;
		margin-bottom: 30px;
	}
	table{
		margin: auto;
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
<title>MyBoard</title>
</head>
<body>
	<h1>내가 쓴글 리스트</h1>
	<form name="myform" action="/brd/remove" method="post">
	
	<table id="table">
		<tr>
			<th class="th1">번호</th>
			<th class="th1">제목</th>
			<th class="th2">작성자</th>
			<th class="th3">등록일</th>
			<th class="th1">삭제<input type="checkbox" id="allCbox" onclick='allCheck()'></th>
		</tr>
	<c:forEach items="${list}" var="bvo">
	<c:if test="${bvo.writer eq ses.id }">
		<tr>
			<td>${bvo.bno}</td>
			<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title}</a> </td>
			<td>${bvo.writer}</td>
			<td>${bvo.regdate}</td>
			<td><input type="checkbox" id="cbox" name="bno" value="${bvo.bno }"></td>
		</tr>
	</c:if>
	</c:forEach>
	</table>
	<button>선택 항목 삭제</button>
	</form>
	<a href="/board/register.jsp?a=my"><button>게시글 작성</button></a>
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
	function allCheck(){
		let ac = document.myform.allCbox;
		let onec = document.myform.cbox;
		let rows = document.getElementById("table").getElementsByTagName("tr");
		let count = rows.length-2;
		if(ac.checked == true){
			for(i=0; i<=count; i++ ){
			onec[i].checked = true;
			}
		}else{
			for(i=0; i<=count; i++ ){
			onec[i].checked = false;
			}
		}
	}
	</script>
</body>
</html>