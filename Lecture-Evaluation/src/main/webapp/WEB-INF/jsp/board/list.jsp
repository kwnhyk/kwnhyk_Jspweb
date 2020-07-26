<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



     <nav class="navbar navbar-expand-lg navbar-darkgray">
            <a class="navbar-brand" href="index.jsp">������ �� ����Ʈ</a>
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
            			<a class="nav-link" href="index.jsp">����</a>
            		</li>
            		<li class="nav-item dropdown">
            			<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
            			ȸ������
            			</a>
            			
            			<div class="dropdown-menu" aria-labelledby="dropdown">
            			
            			
            			<c:if test="${empty loginUser}">
            				<a class="dropdown-item" href="userLogin.jsp">�α���</a>
                			<a class="dropdown-item" href="userJoin.jsp">ȸ������</a>
            				
            			</c:if>
            			<c:if test="${not empty loginUser }">
            		
            		            				<a class="dropdown-item" href="userLogout.jsp">�α׾ƿ�</a>
            			
            			</c:if>
            			
            			</div>	
            			</li>
            			
            	</ul>
            	<form action="./index.jsp" method="get"class="form-inline my-2 my-lg-0">
            		<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="������ �Է��ϼ���."aria-label="search">
            		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">�˻�</button>
            	</form>
            </div>
        </nav>
        <section class="container">
        	<form method="get" action="./index.jsp" class="form-inline mt-3">
        	
        		<select name="lectureDivide" class="form-control mx-1 mt-2">
        			<option value="��ü"> ��ü</option>
        			<option value="����">����</option>
        			<option value="����">����</option>
        			<option value="��Ÿ" >��Ÿ</option>
        		</select>
        		<select name="searchType" class="form-control mx-1 mt-2">
        			<option value="�ֽż�"> �ֽż�</option>
        			<option value="��õ��">��õ��</option>
        		</select>
        		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="������ �Է��ϼ���">
        		<button type="submit" class="btn btn-primary mx-1 mt-2">�˻�</button>

        		<a class ="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">����ϱ�</a>
        		<a class ="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">�Ű�</a>
	
        	</form>


</body>
</html>