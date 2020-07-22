
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
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
    
    
    </script>
     <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="../main.jsp">강의평가 웹 사이트</a>
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
            			
            		<c:if test="${empty userID}">
            				<a class="dropdown-item" href="../auth/form">로그인</a>
                			<a class="dropdown-item" href="../user/form">회원가입</a>
            				
             		</c:if>
            			 <c:if test="${empty userID}">
            		
            			
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
        	<form method="post" action="../user/signup">
        		<div class="form-group">
        			<label>아이디</label>
        			<input type="text" name="userID" class="form-control">
        				
        		</div>
        		<div class="form-group">
        			<label>비밀번호</label>
        			<input type="password" name="userPassword" class="form-control">
        			
        		</div>
        		<div class="form-group">
        			<label>이메일</label>
        			<input type="email" name="userEmail" class="form-control">
        			
        		</div>
        		<button type="submit" class="btn btn-primary">회원가입</button>
        	
        	
        	</form>
        	
        </section>
      
       
	<jsp:include page="../footer.jsp"/>