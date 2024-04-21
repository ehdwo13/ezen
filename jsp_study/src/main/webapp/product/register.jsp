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
<title>Register Product</title>
</head>
<body>
	<h1>상품 등록 페이지</h1>
	<form action="/pro/insert" method="post">
		상품분류 : <input type="text" name="category"><br> 
		상품이름 : <input type="text" name="name"><br> 
		상품가격 : <input type="number" name="price"><br> 
		보유수량 : <input type="number" name="total_amount"><br> 
		<button type="submit">등록</button>
		<a href="/product/main.jsp"><button type="button">취소</button></a> 
	</form>
</body>
</html>