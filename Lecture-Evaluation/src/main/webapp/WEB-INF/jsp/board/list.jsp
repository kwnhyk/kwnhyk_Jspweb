<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="/WEB-INF/jsp/header.jsp" %>



<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "write";
        });
    });
</script>

<div class="container" style="overflow: hidden; position: relative;">
 <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">게시글 목록</h3>


	</div>
		
	</div>
<div class="box-body">

<c:if test="${loginUser!=null}">



<button type="button" id="btnWrite" class="btn btn-success mt-5">글쓰기</button>
</c:if>
<table class="table table-bordered table-hover" border="1" width="300px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th style="width:150px">작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.bno}</td>
         <td><a href="${path}/app/board/view?bno=${row.bno}">${row.title}</a></td>
         <td>${row.writer}</td>
       
      <!--       원하는 날짜형식으로 출력하기 위해 fmt태그 사용  -->
          
 <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${row.regdate}" />
 </td>
          
        
         <td>${row.viewcnt}</td>
         </tr>
          </c:forEach>
        
         </table>
  </div>
</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>