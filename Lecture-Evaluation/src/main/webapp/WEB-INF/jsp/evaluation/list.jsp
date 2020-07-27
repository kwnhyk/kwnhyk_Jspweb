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
             <!-- 커스텀Navbar추가 -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom-theme.min.css">
         <!-- 제이쿼리 자바스크립트 추가하기 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
<!-- sweet alert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
  


</head>
<body>
	

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
            				<a class="nav-link" href="../board/form">게시판</a>
            				</li>
            				</c:if>
            			
            			
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
        	<div class="card bg-light mt-3">
        	<div class="card-header bg-light">
        		<div class="row">
        		<c:forEach 	var="list" items="${evalAll}">
        	
        		
        		
        	
        			<div class="col-8 text-left">${list.lectureName}&nbsp;<small>${list.professorName}</small></div>
        			<div class="col-4 text-right">종합<span style="color:red;">${list.totalScore}</span>
        			</div>
        			</div>
        			</div>
        			
        			<div class="card-body">
        			<h5 class="card-title">
        			${list.evaluationTitle}&nbsp;<small>${list.lectureYear}년${list.semesterDivide}</small>
        			
        			
        			
        			</h5>
        			<p class="card-text">${list.evaluationContent}</p>
        				<div class="row">
        					<div class="col-9 text-left">
        						성적<span style="color: red;">${list.creditScore}</span>
        						인성<span style="color: red;">${list.characterScore}</span>
        						강의<span style="color: red;">${list.lectureScore}</span>
        						<span style="color:green;">(추천:${list.likeCount})</span>
        			</div>
        			<div class="col-3 text-right">
        						<a onclick="return confirm('추천하시겠습니까?')"href="./likeAction.jsp?evaluationID=${list.evaluationID}">추천</a>
        						<a onclick="return confirm('삭제하시겠습니까?')"href="./deleteAction.jsp?evaluationID=${list.evaluationID}">삭제</a>
        						
        						
        						</div>
        						</div>
        						</div>
        						</div>
        						
        						</c:forEach>
        		
        	
        	</section>
        	
        	
        	
        	<%-- 등록 모달창  -------------------------- --%>
        	   <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
        	<div class="modal-dialog">
        			<div class="modal-content">
        				<div class="modal-header">
        					<h5 class="modal-title" id="modal">평가등록</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        						<span aria-hidden="true">&times;</span>
        					
        					
        					</button>
        				</div>
        					<div class="modal-body">
        						<form action="write" method="post">
        							<div class="form-row">
        								<div class="form-group col-sm-6">
        									<label>강의명</label>
        									<input type="text" name="lectureName" class="form-control" maxlength="20">
        								</div>
        								
        								<div class="form-group col-sm-6">
        									<label>교수명</label>
        									<input type="text" name="professorName" class="form-control" maxlength="20">
        								
        								</div>
        							</div>
        							<div class="form-row">
        								<div class="form-group col-sm-4">
        									<label>수강 연도</label>
        									
        									<select name="lectureYear" class= "form-control">
        										<option value="2012">2012</option>
        										<option value="2013">2013</option>
        										<option value="2014">2014</option>
        										<option value="2015">2015</option>
        										<option value="2016">2016</option>
        										<option value="2017">2017</option>
        										<option value="2018">2018</option>
        										<option value="2019">2019</option>
        										<option value="2020" selected>2020</option>
        										<option value="2021">2021</option>
        										<option value="2022">2022</option>
        										<option value="2023">2023</option>
        										
        									</select>
        									
        								</div>
        								<div class="form-group col-sm-4">
        									<label>수강 학기</label>
        									<select name="semesterDivide" class="form-control">
        										<option value="1학기" selected>1학기</option>
        										<option value="여름학기" >여름학기</option>
        										<option value="2학기" >2학기</option>
        										<option value="겨울학기" >겨울학기</option>
        										
        										
        									
        									</select>
        									
        								</div>
        								<div class="form-group col-sm-4">
        									<label>강의 구분</label>
        									<select name="lectureDivide" class="form-control">
        										<option value="전공" selected>전공</option>
        										<option value="교양" >교양</option>
        										<option value="기타" >기타</option>
        									
        										
        										
        									
        									</select>
        									
        								</div>
        								
        							</div>
        							<div class="form-group">
        								<label>제목</label>
        								<input type="text" name="evaluationTitle" class="form-control"maxlength="30">
        								
        								
        							</div>
        							<div class="form-group">
        								<label>내용</label>
        								
        								<textarea  name="evaluationContent" class="form-control"
        								 maxlength="2048" style="height:180px;"></textarea>
        								 
        							</div>
        							<div class="form-row">
        								<div class="form-group col-sm-3">
        									<label>종합</label>
        									<select name="totalScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>인성</label>
        									<select name="characterScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>강의</label>
        									<select name="lectureScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>성적</label>
        									<select name="creditScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        							
        							</div>
        							
        							<div class="modal-footer">
        								<button type="button" class="btn btn-secondary"data-dismiss="modal">취소</button>
        								<button type="submit" class="btn btn-primary">등록하기</button>
        							
        							</div>
        							
        							
        						</form>
        					
        					</div>
        				
        			</div>
        	</div>
        </div>
        
        <%-- 신고 모달창 -----------------------                  --%>
           <div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
        	<div class="modal-dialog">
        			<div class="modal-content">
        				<div class="modal-header">
        					<h5 class="modal-title" id="modal">신고하기</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        						<span aria-hidden="true">&times;</span>
        					
        					
        					</button>
        				</div>
        					<div class="modal-body">
        						<form action="./reportAction.jsp" method="post">
        							
        							<div class="form-group">
        								<label>신고 제목</label>
        								<input type="text" name="reportTitle" class="form-control"maxlength="30">
        								
        								
        							</div>
        							<div class="form-group">
        								<label>신고 내용</label>
        								
        								<textarea  name="reportContent" class="form-control"
        								 maxlength="2048" style="height:180px;"></textarea>
        								 
        							</div>
        							
        							
        							<div class="modal-footer">
        								<button type="button" class="btn btn-secondary"data-dismiss="modal">취소</button>
        								<button type="submit" class="btn btn-danger">신고하기</button>
        							
        							</div>
        							
        							
        						</form>
        					
        					</div>
        				
        			</div>
        	</div>
        </div>
       
        
		<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 권혁윤 All Rights Reserved.
		</footer>


</body>
</html>