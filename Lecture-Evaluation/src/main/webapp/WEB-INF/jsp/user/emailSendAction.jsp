<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial=scale=1,shrink-to-fit=no" />
        <title>강의평가 웹 사이트</title>
        <!-- 부트스트랩CSS추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/bootstrap.min.css" >
        <!-- 커스텀CSS추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom.css" >
        <!-- 제이쿼리 자바스크립트 추가하기 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
    </head>
    <body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="app/">강의평가 웹 사이트</a>
            <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbar"
            >
            <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbar" class="collapse navbar-collapse">
            	<ul class="navbar-nav mr-auto">
            		<li class="nav-item active">
            			<a class="nav-link" href="app/evaluation/form">메인</a>
            		</li>
            		<li class="nav-item dropdown">
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
            			회원관리
            			</a>
            			
            			<div class="dropdown-menu" aria-labelledby="dropdown">
            			<c:if test="${empty userID}">
            				<a class="dropdown-item" href="../auth/form">로그인</a>
                			<a class="dropdown-item" href="../user/form">회원가입</a>
            				
             		</c:if>
            			 <c:if test="${not empty userID}">
            		
            			
            				<a class="dropdown-item" href="../auth/logout">로그아웃</a>
            			
            		</c:if>
            		
            			</div>	
            			</li>
            			
            	</ul>
            		<form action="./index.jsp" method="get"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
            	</form>
            </div>
        </nav>
        <section class="container mt-3" style="max-width:560px;">
        	<div class ="alert alert-success mt-4" role="alert">
        		이메일 주소 인증 메일 전송되었습니다. 이메일 인증해주세요.
        	</div>
        </section>
      
       
		<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 권혁윤 All Rights Reserved.
		</footer>
      
        <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
    </body>
</html>
	