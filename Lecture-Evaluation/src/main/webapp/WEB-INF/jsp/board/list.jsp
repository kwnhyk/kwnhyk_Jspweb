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
        	   <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
        	<div class="modal-dialog">
        			<div class="modal-content">
        				<div class="modal-header">
        					<h5 class="modal-title" id="modal">�򰡵��</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        						<span aria-hidden="true">&times;</span>
        					
        					
        					</button>
        				</div>
        					<div class="modal-body">
        						<form action="write" method="post">
        							<div class="form-row">
        								<div class="form-group col-sm-6">
        									<label>���Ǹ�</label>
        									<input type="text" name="lectureName" class="form-control" maxlength="20">
        								</div>
        								
        								<div class="form-group col-sm-6">
        									<label>������</label>
        									<input type="text" name="professorName" class="form-control" maxlength="20">
        								
        								</div>
        							</div>
        							<div class="form-row">
        								<div class="form-group col-sm-4">
        									<label>���� ����</label>
        									
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
        									<label>���� �б�</label>
        									<select name="semesterDivide" class="form-control">
        										<option value="1�б�" selected>1�б�</option>
        										<option value="�����б�" >�����б�</option>
        										<option value="2�б�" >2�б�</option>
        										<option value="�ܿ��б�" >�ܿ��б�</option>
        										
        										
        									
        									</select>
        									
        								</div>
        								<div class="form-group col-sm-4">
        									<label>���� ����</label>
        									<select name="lectureDivide" class="form-control">
        										<option value="����" selected>����</option>
        										<option value="����" >����</option>
        										<option value="��Ÿ" >��Ÿ</option>
        									
        										
        										
        									
        									</select>
        									
        								</div>
        								
        							</div>
        							<div class="form-group">
        								<label>����</label>
        								<input type="text" name="evaluationTitle" class="form-control"maxlength="30">
        								
        								
        							</div>
        							<div class="form-group">
        								<label>����</label>
        								
        								<textarea  name="evaluationContent" class="form-control"
        								 maxlength="2048" style="height:180px;"></textarea>
        								 
        							</div>
        							<div class="form-row">
        								<div class="form-group col-sm-3">
        									<label>����</label>
        									<select name="totalScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>�μ�</label>
        									<select name="characterScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>����</label>
        									<select name="lectureScore" class="form-control">
        										<option value="A" selected>A</option>
        										<option value="B" >B</option>
        										<option value="C" >C</option>
        											<option value="D" >D</option>
        												<option value="F" >F</option>
        									</select>
        								</div>
        								<div class="form-group col-sm-3">
        									<label>����</label>
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
        								<button type="button" class="btn btn-secondary"data-dismiss="modal">���</button>
        								<button type="submit" class="btn btn-primary">����ϱ�</button>
        							
        							</div>
        							
        							
        						</form>
        					
        					</div>
        				
        			</div>
        	</div>
        </div>
           <div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
        	<div class="modal-dialog">
        			<div class="modal-content">
        				<div class="modal-header">
        					<h5 class="modal-title" id="modal">�Ű��ϱ�</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        						<span aria-hidden="true">&times;</span>
        					
        					
        					</button>
        				</div>
        					<div class="modal-body">
        						<form action="./reportAction.jsp" method="post">
        							
        							<div class="form-group">
        								<label>�Ű� ����</label>
        								<input type="text" name="reportTitle" class="form-control"maxlength="30">
        								
        								
        							</div>
        							<div class="form-group">
        								<label>�Ű� ����</label>
        								
        								<textarea  name="reportContent" class="form-control"
        								 maxlength="2048" style="height:180px;"></textarea>
        								 
        							</div>
        							
        							
        							<div class="modal-footer">
        								<button type="button" class="btn btn-secondary"data-dismiss="modal">���</button>
        								<button type="submit" class="btn btn-danger">�Ű��ϱ�</button>
        							
        							</div>
        							
        							
        						</form>
        					
        					</div>
        				
        			</div>
        	</div>
        </div>
		<footer class="bg-dark mt-4 p-5 text-center" style="color:#FFFFFF;">
		
			Copyright &copy; 2020 ������ All Rights Reserved.
		</footer>


</body>
</html>