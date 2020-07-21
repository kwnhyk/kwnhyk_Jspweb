<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>


<%-- 
<jsp:usebean id ="userID"
class="Lecture.Evaluation.user.UserDTO"
scope="session"/>




--%>

 <jsp:include page="header.jsp"/>

        
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
        	
        	
       <jsp:include page="footer.jsp"/>