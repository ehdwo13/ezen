<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" />
<div class="container-md">
		<h1>User Login Page</h1>
		<form action="/user/login" method="post">
		<div class="mb-3">
	  		<label for="e" class="form-label">EMAIL</label>
	  		<input type="text" class="form-control" name="email" id="e" placeholder="EMAIL...">
		</div>
		<div class="mb-3">
	  		<label for="p" class="form-label">PW</label>
	  		<input type="text" class="form-control" name="pw" id="p" placeholder="PW...">
		</div>
		<button type="submit" class="btn btn-primary">LOGIN</button>
		</form>
</div>
<jsp:include page="../layout/footer.jsp" />