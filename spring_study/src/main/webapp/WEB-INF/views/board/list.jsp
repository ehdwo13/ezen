<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<div class="container-md">
	<h1>Board List Page</h1>
	<!-- search Line -->
	<form class="row gy-2 gx-3 align-items-center justify-content-center">
   		<div class="col-auto">
    		<label class="visually-hidden" for="autoSizingSelect">Preference</label>
    		<select class="form-select" id="autoSizingSelect">
      			<option selected>Choose...</option>
      			<option value="1">Title</option>
      			<option value="2">Writer</option>
      			<option value="3">Content</option>
   			</select>
  		</div>
		<div class="col-auto">
    		<label class="visually-hidden" for="autoSizingInput">Name</label>
    		<input type="text" class="form-control" id="autoSizingInput" placeholder="search..">
  		</div>
  		<div class="col-auto">
    		<button type="submit" class="btn btn-primary">Search</button>
  		</div>
  	</form>
	<table class="table table-hover">
	  <thead>
	  	<tr>
	  		<th>#</th>
	  		<th>title</th>
	  		<th>writer</th>
	  		<th>reg_date</th>
	  		<th>read_count</th>
	  	</tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${list }" var="bvo">
	  	<tr>
			<td>${bvo.bno}</td>
			<td><a href="/board/detail?bno=${bvo.bno }">${bvo.title}</a></td>
			<td>${bvo.writer}</td>
			<td>${bvo.reg_date}</td>
			<td>${bvo.read_count}</td>
		</tr>
	  </c:forEach>
	  </tbody>
	</table>
		<!-- paging Line -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span></a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item"><a class="page-link" href="#">2</a></li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span></a>
	    </li>
	  </ul>
	</nav>
</div>
<jsp:include page="../layout/footer.jsp" />