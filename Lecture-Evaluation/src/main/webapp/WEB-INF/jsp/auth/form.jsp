<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
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
             <!-- 커스텀Navbar추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom-theme.min.css">
    
<!-- sweet alert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
    <!-- 제이쿼리 자바스크립트 추가하기 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
         
           <!--점보트론 스타일 적용-->
         
<style type="text/css">
      .jumbotron{
      	
        background-image: url('/Lecture-Evaluation/images/jumbotron.jpg');
        background-size: cover;
        text-shadow: black 0.2em 0.2em 0.2em;
        color:white;
      }
</style>
    </head>
    <body>
    <script>
		const lgerror = '${loginOn}';
	if(lgerror != '') {
   	 if(lgerror == '1') {
	      Swal.fire({
            icon : 'error',
            title : '로그인이 된 상태입니다!'
        });
    }else if(lgerror =='2'){
    	
    	Swal.fire({
    		icon:'error',
    		title:'로그인 해주세요!'
    	});		
    }
}
</script>

<script>

//로그인 실패시 에러 처리
const error = '${loginError}';
if(error != '') {
  if(error == '1') {
	      Swal.fire({
          icon : 'error',
          title : '이메일 인증을 완료해주세요!'
      });
  } else if(error == '2') {
	      Swal.fire({
          icon : 'error',
          title : '죄송합니다. 아이디 또는 비밀번호가 유효하지 않습니다.'
      });
  }
}


	</script>
    <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="/Lecture-Evaluation/">강의평가 웹 사이트</a>
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
            			<a class="nav-link" href="/Lecture-Evaluation/">메인</a>
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
            			
            				<a class="dropdown-item" onclick="fbLogout();" href="/auth/logout">로그아웃</a>
            				
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
        	<div class="jumbotron " >
        		<h1 class ="text-center">세상의 모든 강의평</h1>
        		<p class="text-center" ><br><br>강의를 평가하자</p>
        		
        	
        	</div>
        
        <section class="container mt-3" style="max-width:560px;">
        	<form method="post" action="login">
        		<div class="form-group">
        			<label>아이디</label>
        			<input type="text" name="userID" class="form-control">
        				
        		</div>
        		<div class="form-group">
        			<label>비밀번호</label>
        			<input type="password" name="userPassword" class="form-control">
        			
        		</div>
        		
        		 <div class="form-group  mt-3 "align="center">
        		
        		<button type="submit" class="btn btn-primary ">로그인</button>
        		
        		
        		 </div>
        		  	 <div class="form-group  mt-3 "align="center">
        		  
				   <script async defer crossorigin="anonymous" src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v7.0&appId=3297077403647118&autoLogAppEvents=1" nonce="9UWqJO10"></script>  
        		<div class="fb-login-button" data-size="large" data-button-type="login_with" data-layout="default"
        		 data-auto-logout-link="false" data-use-continue-as="false" data-width=""
        		 data-scope="public_profile,email"
        		 data-onlogin="checkLoginState();"
        		 align="center">
        	</div>
        	
        </div>
        <div class="form-group mt-3" align="center">
        	<button type="button" id="btnJoin"class="btn btn-success">회원가입</button>
        
        </div>
      
        	
        	</form>
        	
        </section>
      
       
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '3297077403647118',
      cookie     : true,
      xfbml      : true,
      version    : 'v7.0'
    });
      
    FB.AppEvents.logPageView();   
      
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  function checkLoginState() {
        FB.getLoginStatus(function(response) { 
            if (response.status == 'connected') { // 로그인이 정상적으로 되었을 때,
                requestAutoLogin(response.authResponse.accessToken);
            
            } else { // 로그인이 되지 않았을 때,
                Swal.fire({
                	icon:'error',
                	title:'페이스북 로그인을 취소했습니다.'
                });
            }
        });
    }
    
  function requestAutoLogin(accessToken) {
      location.href = "facebookLogin?accessToken=" + accessToken;
  }
  $(document).ready(function(){
		
		
		

	  $("#btnJoin").on("click",function(){
	 	location.href="../user/form";
	 	 
	 	 
	  });
	 });
	  
</script>
	

<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 권혁윤 All Rights Reserved.
		</footer>

		
	
     
        
    </body>
</html>

