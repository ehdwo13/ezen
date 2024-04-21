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
	<h1>${pvo.pnum}번 상품</h1>
	<table border="1">
		<tr>
			<th>상품번호</th>
			<td>${pvo.pnum }</td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td>${pvo.category }</td>
		</tr>
		<tr>
			<th>상품이름</th>
			<td>${pvo.name }</td>
		</tr>
		<tr>
			<th>상품가격</th>
			<td>${pvo.price }</td>
		</tr>
		<tr>
			<th>보유수량</th>
			<td>${pvo.total_amount }</td>
		</tr>
		<tr>
			<th>판매수량</th>
			<td>${pvo.sale_amount }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${pvo.regdate }</td>
		</tr>
	</table>
	<a href="/pro/modify?bno=${bvo.bno }"><button>수정</button></a>
	<a href="/pro/remove?bno=${bvo.bno }"><button>삭제</button></a>
	<a href="/pro/list"><button type="button">돌아가기</button></a>
	
</body>
</html>