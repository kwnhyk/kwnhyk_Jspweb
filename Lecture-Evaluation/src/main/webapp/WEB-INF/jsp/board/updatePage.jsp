<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
 
  



<style type="text/css">

.fileDrop {
    width: 100%;
    height: 200px;
    border: 2px dotted #0b58a2;
}


</style>
</head>
<body class="hold-transition skin-blue sidebar-mini layout-boxed">
<div class="wrapper">

 
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                게시판
                <small>수정페이지</small>
            </h1>
            
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <div class="col-lg-12">
                <form role="form" id="modifyForm" method="post" action="${path}/app/board/update">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">게시글 수정</h3>
                        </div>
                        <div class="box-body">

                            <input type="hidden" name="bno" value="${dto.bno}">
                            <input type="hidden" name="page" value="${searchCriteria.page}">
                            <input type="hidden" name="perPageNum" value="${searchCriteria.perPageNum}">
                            <input type="hidden" name="searchType" value="${searchCriteria.searchType}">
                            <input type="hidden" name="search" value="${searchCriteria.search}">

                            <div class="form-group">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="title" placeholder="제목을 입력해주세요" value="${dto.title}">
                            </div>
                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" rows="30"
                                          placeholder="내용을 입력해주세요" style="resize: none;">${dto.content}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input class="form-control" id="writer" name="writer" value="${dto.writer}" readonly>
                            </div>
                            <div class="form-group">
                                <div class="fileDrop">
                                    <br/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <p class="text-center"><i class="fa fa-paperclip"></i> 첨부파일을 드래그해주세요.</p>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <ul class="mailbox-attachments clearfix uploadedFileList"></ul>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-primary listBtn"><i class="fa fa-list"></i> 목록</button>
                            <div class="pull-right">
                                <button type="button" class="btn btn-warning cancelBtn"><i class="fa fa-trash"></i> 취소</button>
                                <button type="button" class="btn btn-success modBtn"><i class="fa fa-save"></i> 수정 저장</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->



</div>
    <%@ include file="/WEB-INF/jsp/footer.jsp" %>
<script src="${path}/resources/dist/js/handlebars-v4.7.6.js"></script>
<script type="text/javascript" src="${path}/resources/dist/js/article_file_upload.js?v=<%=System.currentTimeMillis() %>"></script>

<script id="fileTemplate" type="text/x-handlebars-template">
    <li>
        <span class="mailbox-attachment-icon has-img">
            <img src="{{imgSrc}}" alt="Attachment">
        </span>
        <div class="mailbox-attachment-info">
            <a href="{{originalFileUrl}}" class="mailbox-attachment-name">
                <i class="fa fa-paperclip"></i> {{originalFileName}}
            </a>
            <a href="{{fullName}}" class="btn btn-default btn-xs pull-right delBtn">
                <i class="fa fa-fw fa-remove"></i>
            </a>
        </div>
    </li>
</script>
<script>
    $(document).ready(function () {
    	 /* $("form1").submit(function (event){

               //var title = document.form1.title.value; ==> name속성으로 처리할 경우
               //var content = document.form1.content.value;
               //var writer = document.form1.writer.value;
               var title = $("#title").val();
               var content = $("#content").val();
              
               if(title == ""){
                   alert("제목을 입력하세요");
                   document.form1.title.focus();
                   event.preventDefault();
                   return;
               }
               if(content == ""){
                   alert("내용을 입력하세요");
                   document.form1.content.focus();
                   event.preventDefault();
                   return;
               }
           	
           	 event.preventDefault();
         		
                var that = $(this);
               	filesSubmit(that);
            
   		
              
           });*/
        // 전역 변수 선언
        var bno = "${dto.bno}"; // 현재 게시글 번호
        // 파일 삭제 버튼 클릭 이벤트
        $(document).on("click", ".delBtn", function (event) {
            event.preventDefault();
            if (confirm("삭제하시겠습니까? 삭제된 파일은 복구할 수 없습니다.")) {
                var that = $(this);
                deleteFileViewPage(that, bno);
            }
        });
        getFiles(bno);
        // 수정 처리시 파일 정보도 함께 처리
        $("#modifyForm").submit(function (event) {
            event.preventDefault();
            var that = $(this);
            filesSubmit(that);
        });
        /*================================================게시판 페이지 이동관련===========================================*/
        var formObj = $("form[role='form']");
        console.log(formObj);
        $(".modBtn").on("click", function () {
            formObj.submit();
        });
        $(".cancelBtn").on("click", function () {
            self.location = "view?page=${searchCriteria.page}"
                + "&perPageNum=${searchCriteria.perPageNum}"
                + "&searchType=${searchCriteria.searchType}"
                + "&search=${searchCriteria.search}"
                + "&bno=${dto.bno}";
        });
        $(".listBtn").on("click", function () {
            self.location = "list?page=${searchCriteria.page}"
                + "&perPageNum=${searchCriteria.perPageNum}"
                + "&searchType=${searchCriteria.searchType}"
                + "&search=${searchCriteria.search}";
        });
    });
</script>
</body>
</html>