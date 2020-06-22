/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.28
 * Generated at: 2020-06-22 11:35:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import user.UserDAO;
import evaluation.EvaluationDTO;
import evaluation.EvaluationDAO;
import java.util.ArrayList;
import java.net.URLEncoder;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("java.net.URLEncoder");
    _jspx_imports_classes.add("evaluation.EvaluationDTO");
    _jspx_imports_classes.add("evaluation.EvaluationDAO");
    _jspx_imports_classes.add("user.UserDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial=scale=1,shrink-to-fit=no\" />\r\n");
      out.write("        <title>강의평가 웹 사이트</title>\r\n");
      out.write("        <!-- 부트스트랩CSS추가 -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\" >\r\n");
      out.write("        <!-- 커스텀CSS추가 -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/custom.css\" >\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    ");

    	request.setCharacterEncoding("UTF-8");
    	String lectureDivide = "전체";
    	String searchType = "최신순";
    	String search = "";
    	int pageNumber =0;
    	if(request.getParameter("lectureDivide")!=null){
    		lectureDivide = request.getParameter("lectureDivide");
    	}
    	if(request.getParameter("searchType")!=null){
    		searchType = request.getParameter("searchType");
    	}
    	if(request.getParameter("search")!=null){
    		search = request.getParameter("search");
    	}
    	if(request.getParameter("pageNumber")!=null){
    		try{
    		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    	}catch(Exception e){
    		System.out.println("검색 페이지 번호 오류");
    		
    	}
    		
    	
    	}
    		
    	
    	String userID =null;
    	if(session.getAttribute("userID")!=null){
    		userID =(String)session.getAttribute("userID");
    	}
    	if(userID ==null){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('로그인을 해주세요');");
    		
    		script.println("location.href='userLogin.jsp'");
    		script.println("</script>");
    		script.close();
    		return;
    	}
    	boolean emailChecked = new UserDAO().getUserEmailChecked(userID);
    	if(emailChecked==false){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		
    		script.println("location.href='emailSendConfirm.jsp'");
    		script.println("</script>");
    		script.close();
    		return;
    	}
    
    
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">강의평가 웹 사이트</a>\r\n");
      out.write("            <button\r\n");
      out.write("                class=\"navbar-toggler\"\r\n");
      out.write("                type=\"button\"\r\n");
      out.write("                data-toggle=\"collapse\"\r\n");
      out.write("                data-target=\"#navbar\"\r\n");
      out.write("            >\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n");
      out.write("            \t<ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("            \t\t<li class=\"nav-item active\">\r\n");
      out.write("            \t\t\t<a class=\"nav-link\" href=\"index.jsp\">메인</a>\r\n");
      out.write("            \t\t</li>\r\n");
      out.write("            \t\t<li class=\"nav-item dropdown\">\r\n");
      out.write("            \t\t\t<a class=\"nav-link dropdown-toggle\" id=\"dropdown\" data-toggle=\"dropdown\">\r\n");
      out.write("            \t\t\t회원관리\r\n");
      out.write("            \t\t\t</a>\r\n");
      out.write("            \t\t\t\r\n");
      out.write("            \t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"dropdown\">\r\n");
      out.write("            \t\t\t\r\n");
      out.write("            \t\t\t");

            			
            			if(userID  == null){
            				
      out.write("\r\n");
      out.write("            \t\t\t\t<a class=\"dropdown-item\" href=\"userLogin.jsp\">로그인</a>\r\n");
      out.write("                \t\t\t<a class=\"dropdown-item\" href=\"userJoin.jsp\">회원가입</a>\r\n");
      out.write("            \t\t\t\t\r\n");
      out.write("            \r\n");
      out.write("            \t\t\r\n");
      out.write("            \t\t\t ");

            			 
            			}else {
            				
      out.write("\r\n");
      out.write("            \t\t\t\t<a class=\"dropdown-item\" href=\"userLogout.jsp\">로그아웃</a>\r\n");
      out.write("            \t\t\t\r\n");
      out.write("            \t\t");

            			}
            		
      out.write("\r\n");
      out.write("            \t\t\t\r\n");
      out.write("            \t\t\t</div>\t\r\n");
      out.write("            \t\t\t</li>\r\n");
      out.write("            \t\t\t\r\n");
      out.write("            \t</ul>\r\n");
      out.write("            \t<form action=\"./index.jsp\" method=\"get\"class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("            \t\t<input type=\"text\" name=\"search\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"내용을 입력하세요.\"aria-label=\"search\">\r\n");
      out.write("            \t\t<button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">검색</button>\r\n");
      out.write("            \t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <section class=\"container\">\r\n");
      out.write("        \t<form method=\"get\" action=\"./index.jsp\" class=\"form-inline mt-3\">\r\n");
      out.write("        \t\r\n");
      out.write("        \t\t<select name=\"lectureDivide\" class=\"form-control mx-1 mt-2\">\r\n");
      out.write("        \t\t\t<option value=\"전체\"> 전체</option>\r\n");
      out.write("        \t\t\t<option value=\"전공\" ");
 if(lectureDivide.equals("전공"))out.println("selected"); 
      out.write(">전공</option>\r\n");
      out.write("        \t\t\t<option value=\"교양\"");
 if(lectureDivide.equals("교양"))out.println("selected"); 
      out.write(">교양</option>\r\n");
      out.write("        \t\t\t<option value=\"기타\" ");
 if(lectureDivide.equals("기타"))out.println("selected"); 
      out.write(">기타</option>\r\n");
      out.write("        \t\t</select>\r\n");
      out.write("        \t\t<select name=\"searchType\" class=\"form-control mx-1 mt-2\">\r\n");
      out.write("        \t\t\t<option value=\"최신순\"> 최신순</option>\r\n");
      out.write("        \t\t\t<option value=\"추천순\" ");
 if(searchType.equals("추천순"))out.println("selected"); 
      out.write(">추천순</option>\r\n");
      out.write("        \t\t</select>\r\n");
      out.write("        \t\t<input type=\"text\" name=\"search\" class=\"form-control mx-1 mt-2\" placeholder=\"내용을 입력하세요\">\r\n");
      out.write("        \t\t<button type=\"submit\" class=\"btn btn-primary mx-1 mt-2\">검색</button>\r\n");
      out.write("\r\n");
      out.write("        \t\t<a class =\"btn btn-primary mx-1 mt-2\" data-toggle=\"modal\" href=\"#registerModal\">등록하기</a>\r\n");
      out.write("        \t\t<a class =\"btn btn-danger mx-1 mt-2\" data-toggle=\"modal\" href=\"#reportModal\">신고</a>\r\n");
      out.write("\t\r\n");
      out.write("        \t</form>\r\n");

	ArrayList<EvaluationDTO> evaluationList = new ArrayList<EvaluationDTO>();
	evaluationList = new EvaluationDAO().getList(lectureDivide, searchType, search, pageNumber);
	if(evaluationList !=null)
		for(int i =0; i< evaluationList.size();i++){
			if(i==5) break;
			EvaluationDTO evaluation = evaluationList.get(i);
			
		
		



      out.write("\r\n");
      out.write("        \t  <div class=\"card bg-light mt-3\">\r\n");
      out.write("        \r\n");
      out.write("        \t<div class=\"card-header bg-light\">\r\n");
      out.write("        \t\t<div class=\"row\">\r\n");
      out.write("        \t\t\t<div class=\"col-8 text-left\">");
      out.print( evaluation.getLectureName() );
      out.write("&nbsp;<small>");
      out.print( evaluation.getProfessorName() );
      out.write("</small></div>\r\n");
      out.write("        \t\t\t<div class=\"col-4 text-right\">\r\n");
      out.write("        \t\t\t\t종합<span style=\"color:red;\">");
      out.print( evaluation.getTotalScore() );
      out.write("</span>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\r\n");
      out.write("        \t\t\t\t<div class=\"card-body\">\r\n");
      out.write("        \t\t\t\t<h5 class=\"card-title\">\r\n");
      out.write("        \t\t\t");
      out.print(evaluation.getEvaluationTitle() );
      out.write("&nbsp;<small>(");
      out.print( evaluation.getLectureYear());
      out.write(' ');
      out.write('년');
      out.write(' ');
      out.print(evaluation.getSemesterDivide() );
      out.write(")</small>\r\n");
      out.write("        \t\t\t\t</h5>\r\n");
      out.write("        \t\t\t\t<p class=\"card-text\">");
      out.print(evaluation.getEvaluationContent() );
      out.write("</p>\r\n");
      out.write("        \t\t\t\t<div class=\"row\">\r\n");
      out.write("        \t\t\t\t\t<div class=\"col-9 text-left\">\r\n");
      out.write("        \t\t\t\t\t\t성적<span style=\"color: red;\">");
      out.print( evaluation.getCreditScore() );
      out.write("</span>\r\n");
      out.write("        \t\t\t\t\t\t인성<span style=\"color: red;\">");
      out.print( evaluation.getCharacterScore() );
      out.write("</span>\r\n");
      out.write("        \t\t\t\t\t\t강의<span style=\"color: red;\">");
      out.print( evaluation.getLectureScore() );
      out.write("</span>\r\n");
      out.write("        \t\t\t\t\t\t<span style=\"color:green;\">(");
      out.print( evaluation.getLikeCount() );
      out.write(")</span>\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t<div class=\"col-3 text-right\">\r\n");
      out.write("        \t\t\t\t\t\t<a onclick=\"return confirm('추천하시겠습니까?')\"href=\"./likeAction.jsp?evaluationID=\">추천</a>\r\n");
      out.write("        \t\t\t\t\t\t<a onclick=\"return confirm('삭제하시겠습니까?')\"href=\"./deleteAction.jsp?evaluationID=\">삭제</a>\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t</div>\r\n");

}

      out.write("        \t\t\t\t\r\n");
      out.write("\t\t</section>\r\n");
      out.write("        <ul class =\"pagination justify-content-center mt-3\">\r\n");
      out.write("        \t<li class=\"page-item\">\r\n");

 	if(pageNumber <=0){

      out.write(" \r\n");
      out.write(" <a class=\"page-link disabled\">이전</a>      \t\r\n");

 	}else{

      out.write("\r\n");
      out.write(" \t<a class =\"page-link\" href=\"./index.jsp?lectureDivide= ");
      out.print( URLEncoder.encode(lectureDivide,"UTF-8"));
      out.write("&searchType=\r\n");
      out.write(" \t");
      out.print(URLEncoder.encode(searchType,"UTF-8") );
      out.write("&search=");
      out.print( URLEncoder.encode(search,"UTF-8") );
      out.write("&pageNumber= \r\n");
      out.write(" \t");
      out.print(pageNumber-1);
      out.write("\">이전</a>\r\n");

 	}

      out.write("\r\n");
      out.write(" </li>\r\n");
      out.write(" \r\n");
      out.write(" <li>\r\n");
      out.write(" ");

 	if(evaluationList.size()<6){
 		
 		
 	

      out.write(" \r\n");
      out.write(" <a class=\"page-link disabled\">다음</a>      \t\r\n");
      out.write(" \r\n");

 	}else{
 

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \t<a class =\"page-link\" href=\"./index.jsp?lectureDivide= ");
      out.print( URLEncoder.encode(lectureDivide,"UTF-8"));
      out.write("&searchType=\r\n");
      out.write(" \t");
      out.print(URLEncoder.encode(searchType,"UTF-8") );
      out.write("&search=");
      out.print( URLEncoder.encode(search,"UTF-8") );
      out.write("&pageNumber= \r\n");
      out.write(" \t");
      out.print(pageNumber+1);
      out.write("\">다음</a>\r\n");
      out.write("\r\n");

 	
 	}

      out.write("\r\n");
      out.write(" </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      \r\n");
      out.write("        <div class=\"modal fade\" id=\"registerModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("        \t<div class=\"modal-dialog\">\r\n");
      out.write("        \t\t\t<div class=\"modal-content\">\r\n");
      out.write("        \t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("        \t\t\t\t\t<h5 class=\"modal-title\" id=\"modal\">평가등록</h5>\r\n");
      out.write("        \t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("        \t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t</button>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("        \t\t\t\t\t\t<form action=\"./evaluationRegisterAction.jsp\" method=\"post\">\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-6\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>강의명</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"lectureName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-6\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>교수명</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"professorName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>수강 연도</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"lectureYear\" class= \"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2012\">2012</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2013\">2013</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2014\">2014</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2015\">2015</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2016\">2016</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2017\">2017</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2018\">2018</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2019\">2019</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2020\" selected>2020</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2021\">2021</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2022\">2022</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2023\">2023</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>수강 학기</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"semesterDivide\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"1학기\" selected>1학기</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"여름학기\" >여름학기</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"2학기\" >2학기</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"겨울학기\" >겨울학기</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>강의 구분</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"lectureDivide\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"전공\" selected>전공</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"교양\" >교양</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"기타\" >기타</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<label>제목</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<input type=\"text\" name=\"evaluationTitle\" class=\"form-control\"maxlength=\"30\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<label>내용</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t<textarea  name=\"evaluationContent\" class=\"form-control\"\r\n");
      out.write("        \t\t\t\t\t\t\t\t maxlength=\"2048\" style=\"height:180px;\"></textarea>\r\n");
      out.write("        \t\t\t\t\t\t\t\t \r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>종합</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"totalScore\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>인성</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"characterScore\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>강의</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"lectureScore\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<label>성적</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t<select name=\"creditScore\" class=\"form-control\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("        \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\"data-dismiss=\"modal\">취소</button>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">등록하기</button>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t</form>\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("           <div class=\"modal fade\" id=\"reportModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("        \t<div class=\"modal-dialog\">\r\n");
      out.write("        \t\t\t<div class=\"modal-content\">\r\n");
      out.write("        \t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("        \t\t\t\t\t<h5 class=\"modal-title\" id=\"modal\">신고하기</h5>\r\n");
      out.write("        \t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("        \t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t</button>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("        \t\t\t\t\t\t<form action=\"./reportAction.jsp\" method=\"post\">\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<label>신고 제목</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<input type=\"text\" name=\"reportTitle\" class=\"form-control\"maxlength=\"30\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<label>신고 내용</label>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\t<textarea  name=\"reportContent\" class=\"form-control\"\r\n");
      out.write("        \t\t\t\t\t\t\t\t maxlength=\"2048\" style=\"height:180px;\"></textarea>\r\n");
      out.write("        \t\t\t\t\t\t\t\t \r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\"data-dismiss=\"modal\">취소</button>\r\n");
      out.write("        \t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-danger\">신고하기</button>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t</form>\r\n");
      out.write("        \t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t\t\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<footer class=\"bg-dark mt-4 p-5 text-center\" style=\"color:#FFFFFF;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tCopyright &copy; 2020 권혁윤 All Rights Reserved.\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("        <!-- 제이쿼리 자바스크립트 추가하기 -->\r\n");
      out.write("        <script src=\"./js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"./js/bootstrap.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
