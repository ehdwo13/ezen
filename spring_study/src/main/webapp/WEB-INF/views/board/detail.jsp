<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<div class="container-md">
		<h1>Board Register Page</h1>
		<div class="mb-3">
	  		<label for="n" class="form-label">bno</label>
	  		<input type="text" class="form-control" name="bno" id="n" value="${bvo.bno }" readonly="readonly">
		</div>
		<div class="mb-3">
	  		<label for="t" class="form-label">title</label>
	  		<input type="text" class="form-control" name="title" id="t" value="${bvo.title }" readonly="readonly">
		</div>
		<div class="mb-3">
	  		<label for="w" class="form-label">writer</label>
	  		<input type="text" class="form-control" name="writer" id="w" value="${bvo.writer }" readonly="readonly"> 
		</div>
		<div class="mb-3">
	  		<label for="r" class="form-label">reg_date</label>
	  		<input type="text" class="form-control" name="reg_date" id="r" value="${bvo.reg_date }" readonly="readonly">
		</div>
		<div class="mb-3">
  			<label for="c" class="form-label">content</label>
  			<textarea class="form-control" id="c" name="content" aria-label="With textarea" readonly="readonly">${bvo.content }</textarea>
		</div>
		<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-warning">수정</button></a>
		<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-danger">삭제</button></a>
		<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
</div>
<jsp:include page="../layout/footer.jsp" />