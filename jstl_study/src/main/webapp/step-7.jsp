<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//post 방식의 한글처리
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문자명 : ${param.customer }</h1>
	<c:forEach items="${paramValues.drink }" var="drinks" varStatus="i">
		${i.count }번 주문상품 : ${drinks }<br>
	</c:forEach>
	<c:forEach items="${list }" var="car" varStatus="i">
			차종 : ${car.name} 번호 :  ${car.num } 가격 : ${car.price }<br>
			
	</c:forEach>
	<a href="step-8.jsp">step-8.jsp</a>
</body>
</html>