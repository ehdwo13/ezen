<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" />
<div class="container-md">
		<h1>Member Register Page</h1>
		<form action="/member/register" method="post">
		<div class="mb-3">
	  		<label for="i" class="form-label">ID</label>
	  		<input type="text" class="form-control" name="id" id="i" placeholder="ID...">
		</div>
		<div class="mb-3">
	  		<label for="p" class="form-label">PW</label>
	  		<input type="text" class="form-control" name="pw" id="p" placeholder="PW...">
		</div>
		<div class="mb-3">
	  		<label for="n" class="form-label">NAME</label>
	  		<input type="text" class="form-control" name="name" id="n" placeholder="NAME...">
		</div>
		<div class="mb-3">
	  		<label for="e" class="form-label">E-MAIL</label>
	  		<input type="email" class="form-control" name="email" id="e" placeholder="E-MAIL...">
		</div>
		<div class="mb-3">
	  		<label for="h" class="form-label">HOME</label>
	  		<input type="text" class="form-control" name="home" id="h" placeholder="HOME...">
		</div>
		<div class="mb-3">
	  		<label for="a" class="form-label">AGE</label>
	  		<input type="number" class="form-control" name="age" id="a" placeholder="AGE...">
		</div>
		<button type="submit" class="btn btn-primary">JOIN</button>
	</form>
</div>
<jsp:include page="../layout/footer.jsp" />