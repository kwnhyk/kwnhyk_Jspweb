<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<head>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial=scale=1,shrink-to-fit=no" />
        <title>강의평가 웹 사이트</title>
        <link rel="stylesheet" href="${path}/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${path}/resources/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
        <!-- 부트스트랩CSS추가 -->
        <link rel="stylesheet" href="${path}/css/bootstrap.min.css" >
        <!-- 커스텀CSS추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom.css" >
             <!-- 커스텀Navbar추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom-theme.min.css">
       
<!-- sweet alert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
 
<!-- jQuery -->
<script src="${path}/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${path}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- AdminLTE App -->
<script src="${path}/resources/dist/js/adminlte.min.js"></script>

<style type="text/css">	
      .custom-toggler .navbar-toggler-icon {
  background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255,102,203, 0.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E");
}

.custom-toggler.navbar-toggler {
  border-color: rgb(255,102,203);
} 
</style>	

</head>
<body>

	

     <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="/Lecture-Evaluation/">강의평가 웹 사이트</a>
            <button
                class="navbar-toggler collapsed custom-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbar"
                aria-expanded="false"
                aria-controls="navbar"
            >
            <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbar" class="collapse navbar-collapse">
            	<ul class="navbar-nav mr-auto">
            		<li class="nav-item active">
            			<a class="nav-link" href="/Lecture-Evaluation/">메인</a>
            		</li>
            		<li class="nav-item dropdown">
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
            			회원관리
            			</a>
            			
            			<div class="dropdown-menu" aria-labelledby="dropdown">
            			
            			
            			<c:if test="${empty loginUser}">
            				<a class="dropdown-item" href="../auth/form">로그인</a>
                			<a class="dropdown-item" href="../user/form">회원가입</a>
            				
            			</c:if>
            			<c:if test="${not empty loginUser }">
            			
            			
            			
            		
            		            				<a class="dropdown-item" href="../auth/logout">로그아웃</a>
            			
            			</c:if>
            			
            			</div>	
            			</li>
            			<c:if test="${not empty loginUser}">
            			<li class="nav-item active">
            				<a class="nav-link" href="../evaluation/list">강의평가</a>
            				</li>
            				<li class="nav-item active">
            				<a class="nav-link" href="../board/list">게시판</a>
            				</li>
            				</c:if>
            			
            			
            	</ul>
            	<form action="../../app/evaluation/list" method="post"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
            	</form>
            </div>
        </nav>
        <%-- div class="content-wrapper" style="min-height: 868px;">--%>