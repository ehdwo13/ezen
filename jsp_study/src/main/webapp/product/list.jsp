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
	button{
		background-color: white;
		border: none;
	}
	
</style>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h1>상품 리스트</h1>
	<table>
		<tr>
			<th class="th1">상품번호</th>
			<th class="th1">분류<button><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"  class="bi bi-caret-down-fill" viewBox="0 0 16 16">
  <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>
</svg></button></th>
			<th class="th1">이름</th>
			<th class="th1">가격</th>
			<th class="th3">등록일</th>
		</tr>
		<c:forEach items="${list}" var="pvo">
		<tr>
			<td>${pvo.pnum}</td>
			<td>${pvo.category}</td>
			<td><a href="/pro/detail?pnum=${pvo.pnum }">${pvo.name}</a></td>
			<td>${pvo.price}</td>
			<td>${pvo.regdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>