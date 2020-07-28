
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
trimDirectiveWhitespaces="true"%>

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
         <!-- 제이쿼리 자바스크립트 추가하기 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
<!-- sweet alert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
  
        
     
        
   
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

      <%--
    	String userID =null;
    	if(session.getAttribute("userID")!=null){
    		userID =(String)session.getAttribute("userID");
    	}
    	if(userID !=null){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('로그인이 된 상태입니다.');");
    		
    		script.println("location.href='index.jsp'");
    		script.println("</script>");
    		script.close();
    		return;
    	}
    	
    
    --%>
      
      
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
            			
            		<c:if test="${empty loginUser}">
            				<a class="dropdown-item" href="../auth/form">로그인</a>
                			<a class="dropdown-item" href="../user/form">회원가입</a>
            				
             		</c:if>
            			 <c:if test="${not empty loginUser}">
            		
            			
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
        	<div class="jumbotron " >
        		<h1 class ="text-center">세상의 모든 강의평</h1>
        		<p class="text-center" ><br><br>강의를 평가하자</p>
        		
        	
        	</div>
        
        <section class="container mt-3" style="max-width:560px;">
        	<form method='post'action='signup'enctype='multipart/form-data'>
        		<div class="form-group">
        			<label>아이디</label>
        			<input type="text" name="userID" class="form-control"id="idInput">
        				
        		</div>
        		<div class="form-group">
        			<label>비밀번호</label>
        			<input type="password" name="userPassword" class="form-control"id="passwordInput">
        			
        			
        		</div>
        		<div class="form-group">
        			<label>비밀번호 재확인</label>
        			<input type="password"  class="form-control" id="passwordInput2" placeholder="비밀번호 재확인">
        			
        			
        		</div>
        		<div class="form-group">
        			<label>이메일</label>
        			<input type="email" name="userEmail" class="form-control"id="emailInput">
        			<label class="text-primary mt-2 font-weight-bold" id="form-label" style="height:2em;">
        비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.
        </label>
        		</div>
        		<button id="completeBtn" type="button" class="btn btn-primary">회원가입</button>
        	
        	
        	</form>
        	
        </section>
        <script>
    	const error = '${loginOn}';
    	if(error!=''){
    	if(error=='1'){
    		 Swal.fire({
    	            icon : 'error',
    	            title : '로그인이 된 상태입니다!'
    	        });
    	    }    		
    	}
    
    
    
  
        const emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

        const passwordReg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$/;

        $('#completeBtn').click(function(event){
        	event.preventDefault();
        	if($('#idInput').val() === '' || $('#passwordInput').val()=== '' ||  $('#emailInput').val()=== ''){
        	
        		$('#form-label').html("모든 정보를 입력해주세요.");
        	
        	}else{
        		let userID = $('#idInput').val();
        		let password = $('#passwordInput').val();
        		let password2 = $('#passwordInput2').val();
        		let email = $('#emailInput').val();
				if(emailReg.test(String(email).toLowerCase())=== false){
					$('#emailInput').focus();
					$('#form-label').html(" 올바른 이메일 형식을 입력해주세요.");
				}
					else if(passwordReg.test(password)===false){
					$('#form-label').html(" 비밀번호는 6자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.");
					}else if(password!=password2){
						
						$('#passwordInput2').focus();
						$('#form-label').html("비밀번호와 재확인이 일치하지 않습니다");
						
						
					}
					else if(emailReg.test(String(email).toLowerCase())===true && passwordReg.test(password)===true){
						$.ajax({
						
							url:'signup',
							method:'POST',
							data:{
								userEmail:$('#emailInput').val(),
								userID:$('#idInput').val(),
								userPassword:$('#passwordInput').val()
							},
							beforeSend:function(){
		            			var width = 0;
		                  var height = 0;
		                  var left = 0;
		                  var top = 0;
		                  width = 100;
		                  height = 100;
		                  top = ( $(window).height() - height ) / 2 + $(window).scrollTop();
		                  left = ( $(window).width() - width ) / 2 + $(window).scrollLeft();
		                  if($("#div_ajax_load_image").length != 0) {
		                         $("#div_ajax_load_image").css({
		                                "top": top+"px",
		                                "left": left+"px"
		                         });
		                         $("#div_ajax_load_image").show();
		                  }
		                  else {
		                         $('body').append('<div id="div_ajax_load_image" style="position:absolute; top:' 
		                         + top + 'px; left:' + left + 'px; width:' + width + 'px; height:' + height 
		                         + 'px; z-index:9999; background:#7fffd4; filter:alpha(opacity=50); opacity:alpha*0.5; margin:auto; padding:0; "><img src="/Lecture-Evaluation/images/loading.gif" style="width:100px; height:100px;"></div>');
		                        }
		            		},
		            		complete: function () {
		                  $("#div_ajax_load_image").hide();
		                },
							 statusCode:{
				                	400:function(){
				                		$('#form-label').html("이미 회원으로 가입된 이메일입니다.");
				                	},
				                	200:function(){
				                	    Swal.fire({
				                	            icon : 'success',
				                	            title : '회원가입을 완료하기 위해 이메일을 인증해주세요!'
				                	        }).then((result) => {
				                                    if (result.value) {
				                	        	           location.href="../auth/form";
				                                    }
				                          });
				                  }
				            	}//statusCode
					          }); // ajax
				        }
				      }//else      
				    });//click
							
				    
				    $("input").keydown(function(key) {
				        if (key.keyCode == 13) {
				          $("#completeBtn").trigger("click");
				        }
				    });
        </script>
    

<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 권혁윤 All Rights Reserved.
		</footer>

		     
    </body>
</html>

		
	