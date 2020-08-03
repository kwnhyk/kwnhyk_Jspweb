<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

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
            			<li class="nav-item active">
            				<a class="nav-link" href="../board/list">게시판</a>
            				</li>
            			
            	</ul>
            	<form action="./index.jsp" method="get"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
            	</form>
            </div>
        </nav>
  

<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "write";
        });
    });
</script>


<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.bno}</td>
        <td><a href="${path}/board/view?bno=${row.bno}">${row.title}</a></td>
        <td>${row.writer}</td>
        <td>
            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
            <fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </td>
        <td>${row.viewcnt}</td>
    </tr>    
    </c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>