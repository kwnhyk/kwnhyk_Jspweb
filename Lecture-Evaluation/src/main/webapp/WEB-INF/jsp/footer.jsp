<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <section class="page-section bg-dark text-white">
    	<div class="jumbotron" >	
        		<h1 class ="text-center">세상의 모든 강의평</h1>	
        		<p class="text-center" ><br><br>강의를 평가하자</p>	


        	</div>	
    
        
        </section>
        <style type="text/css">	
      .jumbotron{	
      		
        background-image: url(${pageContext.servletContext.contextPath}/images/jumbotron.jpg');	
        background-size: cover;	
        text-shadow: black 0.2em 0.2em 0.2em;	
        color:white;	
        margin-bottom: 0px;
      }	
</style>	
       
<footer class="bg-dark p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 권혁윤 All Rights Reserved.
		</footer>
		
        <!-- 커스텀CSS추가 -->	
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom.css" >	
        <!-- 커스텀Navbar추가 -->	
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom-theme.min.css">	
		

		<!-- sweet alert2 -->
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
		<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
        <!-- 제이쿼리 자바스크립트 추가하기 -->
        <script src="https://unpkg.com/@popperjs/core@2"></script>
        <script src="/Lecture-Evaluation/js/jquery.min.js"></script>
        <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
        
    </body>
</html>
