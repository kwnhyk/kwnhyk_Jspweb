<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ page import="java.io.PrintWriter" %>	
<%@ page import="java.util.ArrayList" %>	
<%@ page import="java.net.URLEncoder" %>	


<%-- 	
<jsp:usebean id ="userID"	
class="Lecture.Evaluation.user.UserDTO"	
scope="session"/>	
--%>	
<%	
	String userID = null;	
	if(session.getAttribute("userID")!=null){	
		userID = (String) session.getAttribute("userID");	
	}	
%>	
<!DOCTYPE html>	
<html>	
    <head>	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
        <meta name="viewport" content="width=device-width, initial=scale=1,shrink-to-fit=no" />	
        <title>강의평가 웹 사이트</title>	
        <!-- 부트스트랩CSS추가 -->	
        <link rel="stylesheet" href="./css/bootstrap.css" >	
        <!-- 커스텀CSS추가 -->	
        <link rel="stylesheet" href="./css/custom.css" >	
        <!-- 커스텀Navbar추가 -->	
        <link rel="stylesheet" href="./css/custom-theme.min.css">	

        <!--점보트론 스타일 적용-->	

<style type="text/css">	
      .jumbotron{	
      		
        background-image: url('images/jumbotron.jpg');	
        background-size: cover;	
        text-shadow: black 0.2em 0.2em 0.2em;	
        color:white;	
      }	
</style>	

    </head>	
    <body>	
   		<div class="header fixed-top">	
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
            		<%	
            			if(userID!=null){	
            		%>	
            			<a class="nav-link" href="main2.jsp">평가</a>	

            			<% 	
            			}else{	
            			%>	
            			<a class="nav-link" href="main2.jsp">참여</a>	
            			<%	
            			}	
            			%>	
            		</li>	
            		<li class="nav-item dropdown">	
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">	
            			회원관리	
            			</a>	

            			<div class="dropdown-menu" aria-labelledby="dropdown">	

            			<%	
            				
            			if(userID  == null){	
            				%>	
            				<a class="dropdown-item" href="userLogin.jsp">로그인</a>	
                			<a class="dropdown-item" href="userJoin.jsp">회원가입</a>	



            			 <%	
            			 	
            			}else {	
            				%>	
            				<a class="dropdown-item" href="userLogout.jsp">로그아웃</a>	

            		<%	
            			}	
            		%>	

            			</div>		
            			</li>	

            	</ul>	
            	<form action="./index.jsp" method="get"class="form-inline my-2 my-lg-0">	
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요."aria-label="search">	
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>	
            	</form>	
            </div>	
        </nav>	
        </div>	


        	<div class="jumbotron " >	
        		<h1 class ="text-center">세상의 모든 강의평</h1>	
        		<p class="text-center" ><br><br>강의를 평가하자</p>	


        	</div>	





		<div class="container">	

  			<div id="myCarousel" class="carousel slide" data-ride="carousel">	
   			 <!-- Indicators -->	
   				 <ol class="carousel-indicators">	
      				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>	
      				<li data-target="#myCarousel" data-slide-to="1"></li>	
      				<li data-target="#myCarousel" data-slide-to="2"></li>	
    			</ol>	

		    <!-- Wrapper for slides -->	
		    <div class="carousel-inner">	
		      <div class="carousel-item active">	
		        <img src="images/carousel1.jpg"  style="width:100%;">	
		      </div>	

		      <div class="carousel-item">	
		        <img src="images/carousel2.jpg"  style="width:100%;">	
		      </div>	

		      <div class="carousel-item">	
		        <img src="images/carousel3.jpg" style="width:100%;">	
		      </div>	
		    </div>	

		    <!-- Left and right controls -->	
		    <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">	
		      <span class="carousel-control-prev-icon"></span>	
		      <span class="sr-only">Previous</span>	
		    </a>	
		    <a class="carousel-control-next" href="#myCarousel" data-slide="next">	
		      <span class="carousel-control-next-icon"></span>	
		      <span class="sr-only">Next</span>	
		    </a>	
		  </div>	
		</div>	


        			<p class="text-center">	
        			<a class="btn button-custom" href="./main2.jsp" role="button">참여</a>	
        			</p>	




		<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">	

			Copyright &copy; 2020 권혁윤 All Rights Reserved.	
		</footer>	
        <!-- 제이쿼리 자바스크립트 추가하기 -->	
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>	
        <script src="js/bootstrap.js"></script>	
    </body>	
</html>