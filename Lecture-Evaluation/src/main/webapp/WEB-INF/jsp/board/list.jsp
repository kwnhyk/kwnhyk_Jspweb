<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



     <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="index.jsp">강의평가 웹 사이트</a>
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
            			<a class="nav-link" href="index.jsp">메인</a>
            		</li>
            		<li class="nav-item dropdown">
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
            			회원관리
            			</a>
            			
            			<div class="dropdown-menu" aria-labelledby="dropdown">
            			
            			
            			<c:if test="${empty loginUser}">
            				<a class="dropdown-item" href="userLogin.jsp">로그인</a>
                			<a class="dropdown-item" href="userJoin.jsp">회원가입</a>
            				
            			</c:if>
            			<c:if test="${not empty loginUser }">
            		
            		            				<a class="dropdown-item" href="userLogout.jsp">로그아웃</a>
            			
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
        <section class="container">
        	<form method="get" action="./index.jsp" class="form-inline mt-3">
        	
        		<select name="lectureDivide" class="form-control mx-1 mt-2">
        			<option value="전체"> 전체</option>
        			<option value="전공">전공</option>
        			<option value="교양">교양</option>
        			<option value="기타" >기타</option>
        		</select>
        		<select name="searchType" class="form-control mx-1 mt-2">
        			<option value="최신순"> 최신순</option>
        			<option value="추천순">추천순</option>
        		</select>
        		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
        		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>

        		<a class ="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a>
        		<a class ="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고</a>
	
        	</form>


</body>
</html>