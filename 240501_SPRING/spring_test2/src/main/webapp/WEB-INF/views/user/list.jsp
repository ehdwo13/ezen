<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<div class="container">
<h1>User List Page</h1>
<div class="row">
<c:forEach items="${list }" var="uvo">
<div class="col">
<div class="card" style="width: 18rem;">
  <img src="/resources/image/rock.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">NickName | ${uvo.nickName }</h5>
    <p class="card-text">Email | ${uvo.email }</p>
    <p class="card-text">RegDate | ${uvo.regDate }</p>
    <p class="card-text">LastLogin | ${uvo.lastLogin }</p>
    <p class="card-text">
    (<c:forEach items="${uvo.authList }" var="authList">
	 ${authList.auth } 
	</c:forEach>)
	</p>
    <!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
  </div>
  </div>
</div>
</c:forEach>
</div>
</div>
<jsp:include page="../layout/footer.jsp" />