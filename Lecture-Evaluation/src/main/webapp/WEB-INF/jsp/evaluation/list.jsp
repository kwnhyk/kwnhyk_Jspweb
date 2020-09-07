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
                class="navbar-toggler custom-toggler"
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
            				<a class="nav-link" href="../board/list">게시판</a>
            				</li>
            				</c:if>
            			
            			
            	</ul>
            	<form action="list" method="post"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
            	</form>
            </div>
        </nav>
        	
        <section class="container">
      
        	<form method="post" action="list" class="form-inline mt-3">
        	
        		<select name="lectureDivide" class="form-control mx-1 mt-2">
        			<option value="전체">전체</option>
        			<option value="전공"<c:if test="${searchCriteria.lectureDivide =='전공'}">selected</c:if>>전공</option>
        			<option value="교양"<c:out value="${searchCriteria.lectureDivide =='교양'?'selected':'' }"/>>교양</option>
        			<option value="기타"<c:if test="${searchCriteria.lectureDivide =='기타'}">selected</c:if>>기타</option>
        		</select>
        		<select name="searchType" class="form-control mx-1 mt-2">
        			<option value="최신순"> 최신순</option>
        			<option value="추천순"<c:out value="${searchCriteria.searchType =='추천순'?'selected':'' }"/>>추천순</option>
        		</select>
        		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
        		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>

        		<a class ="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a>
        		<a class ="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고</a>
	
        	</form>
        	
        	  <c:forEach 	var="list" items="${list}">
        
        	<div class="card bg-light mt-3">
        	<div class="card-header bg-light">
        		<div class="row">
        		
        	
        		
        		
        	
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
        			<input type='button' id='like' value='추천'>
        			<a href="#" onclick="confirmDelete(${list.evaluationID})" >삭제</a>
        			 	<!--  <a onclick="return confirm('삭제하시겠습니까?')"href="./delete?evaluationID=${list.evaluationID}">삭제</a>-->
        						
        						
        						
        						</div>
        						</div>
        						</div>
        						</div>
        						
        						</c:forEach>
        		
        	
        	</section>
        	<script>
        	
        	function confirmDelete(list) {
        		let eval = list;
        	const swalWithBootstrapButtons = Swal.mixin({
      		  customClass: {
      		    confirmButton: 'btn btn-success mr-3',
      		    cancelButton: 'btn btn-danger'
      		  },
      		  buttonsStyling: false
      		})

      		swalWithBootstrapButtons.fire({
      		  title: '삭제하시겠습니까?',
      		  text: "삭제하면 돌릴수 없습니다",
      		  icon: 'warning',
      		  showCancelButton: true,
      		  confirmButtonText: '네!',
      		  cancelButtonText: '아니요',
      		  reverseButtons: false
      		}).then((result) => {
      		  if (result.value) {
      			 $.ajax({
     	            url: "../evaluation/delete",
     	            type: "POST",
     	          	data: {evaluationID : eval},
     	            cache: false,
     	           
     	            
     	           statusCode:{
     	        		400:function(){
	                		Swal.fire({
	                			icon:'error',
	                			title:'본인이 작성한 글이 아닙니다'
	                		})
	                	},
	                	200:function(){
	                	    Swal.fire({
	                	            icon : 'success',
	                	            title : '삭제완료!'
	                	        }).then((result) => {
	                                    if (result.value) {
	                	        	           location.href="../evaluation/list";
	                                    }
	                          });
	                  }
	            	}//statusCode
     	           
     	        });
      		
      		   
      		  } else if (
      		    /* Read more about handling dismissals below */
      		    result.dismiss === Swal.DismissReason.cancel
      		  ) {
      		    swalWithBootstrapButtons.fire(
      		      '취소',
      		      '게시물 삭제 취소 :)',
      		      'error'
      		    )
      		  }
      		})
      		  
         // if(confirm("삭제하시겠습니까?")){
              
         // }
      }
        	
     
        	</script>
        	 <ul class ="pagination justify-content-center mt-3">
        	<%--li class="page-item"> --%>
        	<c:choose>
        	<c:when test="${pageMaker.startPage==1}">
        	<li class="page-item">
        	<a class="page-link disabled">이전</a>
        	</li>
        	</c:when>
        	<c:otherwise>
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/app/evaluation/list${pageMaker.makeDivide(pageMaker.startPage - 1)}">이전</a></li>
            </c:otherwise>
            </c:choose>
            <c:choose>
        	<c:when test="${pageMaker.next==true}">
        	<li class="page-item">
        	<a class="page-link disabled">다음</a>
        	</li>
        	</c:when>
        	
 <c:otherwise> 
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/app/evaluation/list${pageMaker.makeDivide(pageMaker.criteria.page + 1)}">다음</a></li>
            </c:otherwise>
        	</c:choose>
 
 <%-- a class="page-link disabled">이전</a>   --%>   	

 	

 
 
 
<%--
 	}else{
 
--%>
 
 
<%--
 	
 	}
--%>

        </ul>
      
        	<script>
        	function validateForm(){
        	
        		let lectureName = document.getElementById("lectureName");
        		let professorName = document.getElementById("professorName");
        		
        		
        		let evaluationTitle = document.getElementById("evaluationTitle");
        		let evaluationContent = document.getElementById("evaluationContent");
        		
        		
        	
        		if(lectureName.value == "" || professorName.value== ""||evaluationTitle.value=="" ||evaluationContent.value=="" 
        				){
        		
        		
        		Swal.fire({
        			icon:'error',
        			title:'입력이 없습니다.'
        			});
        		
        		return false;
        		
        		}
        		
        	
        		}
        	
        
        	
        	</script>
        	
        	
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
        						<form name="register" onsubmit="return validateForm();" action="write" method="post">
        							<div class="form-row">
        								<div class="form-group col-sm-6">
        									<label>강의명</label>
        									<input type="text" id="lectureName" name="lectureName" class="form-control" maxlength="20">
        								</div>
        								
        								<div class="form-group col-sm-6">
        									<label>교수명</label>
        									<input type="text" id="professorName"name="professorName" class="form-control" maxlength="20">
        								
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
        								<input type="text" id="evaluationTitle"name="evaluationTitle" class="form-control"maxlength="30">
        								
        								
        							</div>
        							<div class="form-group">
        								<label>내용</label>
        								
        								<textarea id="evaluationContent" name="evaluationContent" class="form-control"
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