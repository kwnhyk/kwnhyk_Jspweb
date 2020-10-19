<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<script type="text/javascript" src="/resources/dist/js/article_file_upload.js"></script>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            let title = $("#title").val();
            let content = $("#content").val();
            let writer = $("#writer").val();
            if(title == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return;
            }
            if(writer == ""){
                alert("이름을 입력하세요");
                document.form1.writer.focus();
                return;
            }
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });
    });
</script>
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
			<b style="font-size: 30px;">게시글 작성</b>
		</a>
	</div>


<div class="container">
<form name="form1"class="text-center p-5" method="post" action="${path}/app/board/insert">
    <div>
        제목
        <input name="title" class="form-control" id="title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content"class="form-control" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
   
    
        <button type="button" id="btnSave"class="btn btn-info btn-block">확인</button>
        <button type="reset" class="btn btn-danger btn-block">취소</button>
     <%--첨부파일 영역 추가--%>
                <div class="form-group">
                    <div class="fileDrop">
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <p class="text-center"><i class="fa fa-paperclip"></i> 첨부파일을 드래그해주세요.</p>
                    </div>
                </div>
                <%--첨부파일 영역 추가--%>
            </div>
            <div class="box-footer">
                <ul class="mailbox-attachments clearfix uploadedFileList"></ul>
            </div>
            <div class="box-footer">
                <button type="button" class="btn btn-primary listBtn"><i class="fa fa-list"></i> 목록</button>
                <div class="pull-right">
                    <button type="reset" class="btn btn-warning"><i class="fa fa-reply"></i> 초기화</button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-save"></i> 저장</button>
                </div>
            </div>
        </div>     
    
</form>
</div>
</div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
