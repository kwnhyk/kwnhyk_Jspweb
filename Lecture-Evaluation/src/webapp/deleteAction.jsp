<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Lecture.Evaluation.user.UserDAO" %>
<%@ page import="Lecture.Evaluation.evaluation.EvaluationDAO" %>
<%@ page import="Lecture.Evaluation.likey.LikeyDAO" %>
<%@ page import="java.io.PrintWriter" %>

<%
	UserDAO userDAO = new UserDAO();
	String userID = null;
	if(session.getAttribute("userID")!=null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 하세요.');");
		script.println("location.href='userLogin.jsp'");
		script.println("</script>");
		script.close();
	
	return;
	
	 }
	

	
	
	
	request.setCharacterEncoding("UTF-8");
	String evaluationID = null;
	if(request.getParameter("evaluationID")!=null){
		evaluationID =request.getParameter("evaluationID");
		
	}
	EvaluationDAO evaluationDAO = new EvaluationDAO();
	if(userID.equals(evaluationDAO.getUserID(evaluationID))){
		int result = new EvaluationDAO().delete(evaluationID);
		if(result ==1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('삭제 완료');");
			script.println("location.href='main2.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
		else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터 베이스 오류 발생');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
			
			
		}
	}
		else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('자신이 쓴 글만 삭제가능');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
			
			
		}
	
	
%>