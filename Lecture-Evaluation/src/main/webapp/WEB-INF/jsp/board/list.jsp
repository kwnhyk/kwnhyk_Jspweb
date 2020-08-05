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


<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
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
         <td><a href="${path}/board/view?bno=${row.bno}">${row.title}</a></td>
         <td>${row.writer}</td>
       
      <!--       원하는 날짜형식으로 출력하기 위해 fmt태그 사용  -->
          
 <td><fmt:formatDate value = "${row.regdate}" pattern = "yyyy-MM-dd HH:mm:ss" var = "date"/>
 </td>
          
        
         <td>${row.viewcnt}</td>
         </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>