<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<script>
	var bno = "${dto.bno}";
	
    $(document).ready(function(){
        $("#btnDelete").click(function(){
        	//댓글이 달린 게시글 삭체처리 방지
        	var replyCnt = $(".replyDiv").length;
        	if(replyCnt >0){
        		alert("댓글이 달린 게시글 삭제 불가");
        		return;
        		
        	}
        	//첨부파일명들 배열에 저장
        	var arr =[];
        	$(".uploadedFileList li").each(function(){
        		arr.push($(this).attr("data-src"));
        		
        	});
        	// 첨부파일 삭제요청
        	if(arr.length>0){
        		$.post("/Lecture-Evaluation/app/board/file/deleteAll",{files:arr},function(){
        			
        		});
        	}
        	
        	const swalWithBootstrapButtons = Swal.mixin({
        		  customClass: {
        		    confirmButton: 'btn btn-success mr-3 ',
        		    cancelButton: 'btn btn-danger'
        		  },
        		  buttonsStyling: false
        		})

        		swalWithBootstrapButtons.fire({
        		  title: '삭제하시겠습니까?',
        		  text: "삭제하면 돌릴수 없습니다",
        		  icon: 'warning',
        		  showCancelButton: true,
        		  confirmButtonText: '네! ' ,
        		  cancelButtonText: '아니요  ',
        		  reverseButtons: false
        		}).then((result) => {
        		  if (result.value) {
        		    swalWithBootstrapButtons.fire(
        		      '삭제!',
        		      '게시물 삭제 완료',
        		      'success'
        		    )
        		    document.form1.action= "${path}/app/board/delete";
        		    document.form1.submit();
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
        });

        var formObj = $("form[role='form']");
        console.log(formObj);
        $(".modBtn").on("click", function () {
            formObj.attr("action", "updatePage");
            formObj.attr("method", "get");
            formObj.submit();
        });
       
       
        
       
          
        
          
            	
           
      
     
        $("#btnList").on("click", function(){
            self.location =
            "list?page=${searchCriteria.page}"
            +"&perPageNum=${searchCriteria.perPageNum}"
			+"&searchType=${searchCriteria.searchType}"
			+"&search=${searchCriteria.search}";
          
          

        });
     // 첨부파일 삭제 버튼 클릭 이벤트
        $(document).on("click", ".delBtn", function (event) {
            event.preventDefault();
            if (confirm("삭제하시겠습니까? 삭제된 파일은 복구할 수 없습니다.")) {
                var that = $(this);
                deleteFileViewPage(that,bno);
            }
        });
    
       
        getFiles(bno);
    });

</script>

<style type="text/css">

.fileDrop {
    width: 100%;
    height: 200px;
    border: 2px dotted #0b58a2;
}


</style>
</head>
<body>
<div class="container" style="overflow: hidden; position: relative;">
<br>
<h2>게시글 보기</h2>
<form role="form"method="post"  id="viewForm">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
        작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
        조회수 : ${dto.viewcnt}
    </div>
     <div class="form-group">
    <label for="title" class="control-label">제목</label>
   
        
        <input name="title" id="title" class="form-control" value="${dto.title}" placeholder="제목을 입력해주세요">
    </div>
    
      <div class="form-group">
     <label for="content" class="control-label">내용</label>
    
        
        <textarea name="content" id="content" rows="10" class="form-control" placeholder="내용을 입력해주세요">${dto.content}</textarea>
    </div>
   
    <div class="form-group">
    <label for="writer" class="control-label">작성자</label>
  
        
        ${dto.writer}
       <!--  <input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요"> -->
    </div>
   
   
    <%--업로드 파일 정보영역 --%>
  	<div class="box-footer uploadFiles">
  	<ul class="mailbox-attachment clearfix uploadedFileList"></ul>
  	</div>
  	 <%--업로드 파일 정보영역 --%>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
      
        <input type="hidden" name="bno" value="${dto.bno}">
        
        <input type="hidden" name="page" value="${searchCriteria.page}">
        <input type="hidden" name="perPageNum" value="${searchCriteria.perPageNum}">
        <input type="hidden" name="searchType" value="${searchCriteria.searchType}">
        <input type="hidden" name="search" value="${searchCriteria.search}">
      </form>
         <c:if test="${loginUser.userID==dto.writer}">
        <button type="submit" class="btn-warning modBtn" id="btnUpdate"><i class="fa fa-edit">

          수정</i></button>
        <button type="button" class="btn-danger delBtn"id="btnDelete"><i class="fa fa-trash">

          삭제</i></button>
        </c:if>
        <button type="button" class="btn btn-primary listBtn" id="btnList"><i class="fa fa-list">
        목록</i></button>
    </div>


</div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
<script src="${path}/resources/dist/js/handlebars-v4.7.6.js"></script>
<script type="text/javascript" src="${path}/resources/dist/js/article_file_upload.js?v=<%=System.currentTimeMillis() %>"></script>
<script id="fileTemplate" type="text/x-handlebars-template">
    <li data-src="{{fullName}}">
        <span class="mailbox-attachment-icon has-img">
            <img src="{{imgSrc}}" alt="Attachment">
        </span>
        <div class="mailbox-attachment-info">
            <a href="{{originalFileUrl}}" class="mailbox-attachment-name">
                <i class="fa fa-paperclip"></i> {{originalFileName}}
            </a>
 			
        </div>
    </li>
</script>
</body>
</html>
