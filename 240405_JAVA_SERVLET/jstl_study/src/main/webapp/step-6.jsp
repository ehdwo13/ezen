<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 메뉴판을 체크박스 형태로 만들어서 step-7.jsp로 전송  -->
	<!-- step-7.jsp에서 주문자명 어떤 메뉴를 주문했는지 출력 -->
	<form action="step-7.jsp" method="post">
		주문자명 : <input type="text" name="customer"><br>
		<input type="checkbox" name="drink" value="커피">커피 <br>
		<input type="checkbox" name="drink" value="에이드">에이드 <br>
		<input type="checkbox" name="drink" value="차">차 <br>
		<input type="checkbox" name="drink" value="라떼">라떼 <br>
		<input type="checkbox" name="drink" value="우유">우유 <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>