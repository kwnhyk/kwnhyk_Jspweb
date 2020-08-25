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
<script>


$(document).ready(function(){
	$("#searchBtn").on("click",function(event){
		self.location =
			"list${pageMaker.makeQuery(1)}"
			+"&searchType="+$("select option:selected").val()
			+"&search=" +encodeURIComponent($("#keywordInput").val());
			
		
		
	});
	
	
	
});
</script>


<div class="container" style="overflow: hidden; position: relative;">
 <div class="box box-primary">
        <div class="box-header with-border">
        <br> 
            <h2 class="box-title" >게시글 목록</h2>


	</div>
		
	</div>
<div class="box-body">

<c:if test="${loginUser!=null}">



<button type="button" id="btnWrite" class="btn btn-success btn-flat mt-5">
	<i class="fa fa-pencil"></i>


글쓰기</button>
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
         <td><a href="${path}/app/board/view${pageMaker.makeSearch(pageMaker.criteria.page)}&bno=${row.bno}">${row.title}</a></td>
         <td>${row.writer}</td>
       
      <!--       원하는 날짜형식으로 출력하기 위해 fmt태그 사용  -->
          
 <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${row.regdate}" />
 </td>
          
        
         <td>${row.viewcnt}</td>
         </tr>
          </c:forEach>
        
         </table>
  </div>
 
 
 
 
  <div class="box-footer" id="example2_paginate">
    <div class="text-center col-xs-4"  id="example2_paginate">
        <ul class="pagination">
            <c:if test="${pageMaker.prev}">
                <li class="page-item"><a class="page-link" href="${path}/app/board/list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
            </c:if>
            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                <li class="<c:out value="${pageMaker.criteria.page == idx ? 'page-item active' : ''}" />">
                    <a  class="page-link" href="${path}/app/board/list${pageMaker.makeSearch(idx)}">${idx}</a>
                </li>
            </c:forEach>
            <c:if test="${pageMaker.next && pageMaker.endPage > 0}"> 
                <li class="page-item"><a class="page-link" href="${path}/app/board/list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
            </c:if>
        </ul>
    </div>
</div>
<div class="box-footer">
<div class="form-group col-sm-3">
	<select class="form-control" name="searchType" id="searchType">
		<option value="n"<c:if test="${searchCriteria.searchType== null }">selected</c:if>>선택</option>
		<option value="t"<c:out value="${searchCriteria.searchType eq 't' ? 'selected':'' }"/>>제목</option>
		<option value="c"<c:out value="${searchCriteria.searchType eq 'c' ? 'selected':'' }"/>>내용</option>
		<option value="w"<c:out value="${searchCriteria.searchType eq 'w' ? 'selected':'' }"/>>작성자</option>
		<option value="tc"<c:out value="${searchCriteria.searchType eq 'tc' ? 'selected':'' }"/>>제목+내용</option>
		<option value="cw"<c:out value="${searchCriteria.searchType eq 'cw' ? 'selected':'' }"/>>내용+작성자</option>
		<option value="tcw"<c:out value="${searchCriteria.searchType eq 'tcw' ? 'selected':'' }"/>>제목+내용+작성자</option>
		
	
	
	
	
	
	</select>
</div>
<div class="form-group col-sm-10">
	<div class="input-group">
		<input type="text" class="form-control" name="search" id="keywordInput" value="${searchCriteria.search}"placeholder="검색어">
		<span class="input-group-btn">
			<button type="button" class="btn btn-primary btn-flat" id="searchBtn">
				<i class="fa fa-search"></i>검색
			</button>
		
		</span>
	
	
	</div>
</div>

	

</div>
</div>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>