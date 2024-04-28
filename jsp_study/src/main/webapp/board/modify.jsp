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
<title>modify</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="/brd/update" method="post" enctype="multipart/form-data">
		글번호 : <input type="text" name="bno" value="${bvo.bno }" readonly="readonly"><br> 
		제목 : <input type="text" name="title" value="${bvo.title }"><br> 
		작성자 : <input type="text" name="writer" value="${bvo.writer }" readonly="readonly"><br> 
		내용 : <textarea rows="10" cols="30" name="content" >${bvo.content }</textarea><br>
		이미지 <input type="hidden" name="imageFile" value="${bvo.imageFile }"><input type="file" name="newFile">
		<button type="submit">수정</button>
	</form>
	<img alt="" src="/_fileUpload/${bvo.imageFile }" width="300px" height="300px"><br>
	<a href="/brd/list"><button>돌아가기</button></a>
</body>
</html>