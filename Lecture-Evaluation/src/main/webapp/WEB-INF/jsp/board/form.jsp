<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial=scale=1,shrink-to-fit=no" />
        <title>������ �� ����Ʈ</title>
        <!-- ��Ʈ��Ʈ��CSS�߰� -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/bootstrap.min.css" >
        <!-- Ŀ����CSS�߰� -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom.css" >
             <!-- Ŀ����Navbar�߰� -->
        <link rel="stylesheet" href="/Lecture-Evaluation/css/custom-theme.min.css">
         <!-- �������� �ڹٽ�ũ��Ʈ �߰��ϱ� -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script src="/Lecture-Evaluation/js/bootstrap.min.js"></script>
<!-- sweet alert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://kit.fontawesome.com/764f0503e3.js" crossorigin="anonymous"></script>
  


</head>
<body>
	

     <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="/Lecture-Evaluation/">������ �� ����Ʈ</a>
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
            			<a class="nav-link" href="/Lecture-Evaluation/">����</a>
            		</li>
            		<li class="nav-item dropdown">
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
            			ȸ������
            			</a>
            			
            			<div class="dropdown-menu" aria-labelledby="dropdown">
            			
            			
            			<c:if test="${empty loginUser}">
            				<a class="dropdown-item" href="../auth/form">�α���</a>
                			<a class="dropdown-item" href="../user/form">ȸ������</a>
            				
            			</c:if>
            			<c:if test="${not empty loginUser }">
            			
            			
            			
            		
            		            				<a class="dropdown-item" href="../auth/logout">�α׾ƿ�</a>
            			
            			</c:if>
            			
            			</div>	
            			</li>
            			<c:if test="${not empty userID}">
            			<li class="nav-item active">
            				<a class="nav-link" href="../evaluation/list">������</a>
            				</li>
            				<li class="nav-item active">
            				<a class="nav-link" href="../board/form">�Խ���</a>
            				</li>
            				</c:if>
            			
            			
            	</ul>
            	<form action="./index.jsp" method="get"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="������ �Է��ϼ���."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">�˻�</button>
            	</form>
            </div>
        </nav>
        	<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 ������ All Rights Reserved.
		</footer>
        

</body>
</html>