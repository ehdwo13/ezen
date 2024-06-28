<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	* {
		margin: 0px;
		padding: 0px;
		text-align: center;
		margin-top: 30px;
	}
	h1 {
		margin-top: 10%;
	}
</style>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		<input type="hidden" name="from" value="${param.a }">
		제목 : <input type="text" name="title"><br> 
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br> 
		내용 : <textarea rows="10" cols="30" name="content"></textarea><br>
		이미지파일 : <input type="file" name="imageFile" accept="image/png, image/jpg, image/gif, image/jpeg"><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>