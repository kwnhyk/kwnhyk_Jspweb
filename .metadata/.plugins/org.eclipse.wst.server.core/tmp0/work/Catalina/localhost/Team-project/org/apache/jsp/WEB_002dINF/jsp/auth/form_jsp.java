/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.28
 * Generated at: 2020-06-30 20:56:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/kwnhyk/git/kwnhyk_Jspweb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team-project/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1592955121743L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Required meta tags -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../css/style.css\" />\r\n");
      out.write("<link rel=\"favicon\" href=\"images/favicon.ico\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"http://localhost:9999/Team-project/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"icon\" href=\"http://localhost:9999/Team-project/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("\r\n");
      out.write("<!-- sweet alert2 -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script>\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/764f0503e3.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- 부트스트랩 -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- 카카오 로그인 -->\r\n");
      out.write("<script src=\"/Team-project/script/kakao.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.\r\n");
      out.write("        Kakao.init('e42d7bc3930faad4ef83d4fb783cf136');\r\n");
      out.write("        // SDK 초기화 여부를 판단합니다.\r\n");
      out.write("        console.log(Kakao.isInitialized());\r\n");
      out.write("    </script>\r\n");
      out.write("<!--구글 로그인 -->\r\n");
      out.write("<script src=\"https://apis.google.com/js/platform.js\" async defer></script>\r\n");
      out.write("<meta name = \"google-signin-client_id\"\r\n");
      out.write("content = \"360175730868-7161sh4v73h0hsufdvgmoa9u3o25oi21.apps.googleusercontent.com\">    \r\n");
      out.write("\r\n");
      out.write("<title>BTS-로그인</title>\r\n");
      out.write("<style>\r\n");
      out.write("html, body, .container {\r\n");
      out.write("    height: 100%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container d-flex justify-content-center align-items-center\">\r\n");
      out.write("        <div class=\"d-flex flex-column\">\r\n");
      out.write("            <div class=\"social_login\">\r\n");
      out.write("                <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-width=\"220\" data-height=\"45\" data-longtitle=\"true\"></div>\r\n");
      out.write("                <button id=\"kakao_login_btn\" style=\"margin-top:1em; border:none; background-color:white;\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"email_login d-flex flex-column align-items-center w-100\">\r\n");
      out.write("                <form id=\"loginForm\" name=\"loginForm\" method=\"post\" action=\"login\">\r\n");
      out.write("                    <input class=\"email_login__input form-control\" type=\"text\" name=\"email\"\r\n");
      out.write("                        placeholder=\"  email\" onkeyup=\"enterkey();\"> <input\r\n");
      out.write("                        class=\"email_login__input form-control\" type=\"password\" name=\"password\"\r\n");
      out.write("                        placeholder=\"  password\" onkeyup=\"enterkey();\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <div style=\"margin-top: 1em;\">\r\n");
      out.write("                        <input type=\"checkbox\" name=\"idsave\" value=\"saveOk\">아이디 저장\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input class=\"email_login__input login_btn\" type=\"button\"\r\n");
      out.write("                        value=\"로그인\" onclick=\"sendit()\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"join mt-3 d-flex flex-column align-items-center\">\r\n");
      out.write("              <div>\r\n");
      out.write("                <span style=\"margin-right: 1em;\">계정이 없나요?</span>\r\n");
      out.write("                <a href=\"../user/form\">회원가입</a>\r\n");
      out.write("              </div>\r\n");
      out.write("            <div data-toggle=\"modal\" data-target=\"#findPasswordModal\" class=\"mt-3 text-muted\" style=\"cursor:pointer;\">비밀번호를 잊으셨나요?</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("<div class=\"modal fade\" id=\"findPasswordModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"findPasswordLabel\"\r\n");
      out.write("  aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h5 class=\"modal-title\" id=\"findPasswordLabel\">비밀번호 찾기</h5>\r\n");
      out.write("        <button id=\"memberAddModalClose\" type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("        <form id='findPasswordForm' action='findPassword' method='post' class=\"inputGroup\">\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("          <input class=\"form-control\" type=\"email\" name=\"email\" id=\"emailInput\" placeholder=\"이메일을 입력하세요.\" />\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\" id=\"findPasswordBtn\">임시비밀번호 발급</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var agent = navigator.userAgent.toLowerCase();\r\n");
      out.write("if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf(\"msie\") != -1) ) {\r\n");
      out.write("    Swal.fire({\r\n");
      out.write("        icon : 'warning',\r\n");
      out.write("        title : '죄송합니다. Internet Explorer에서는 원활한 서비스를 지원하지 않습니다. 다른 브라우저를 사용해주세요.'\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//로그인 실패시 에러 처리\r\n");
      out.write("const error = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginError}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("if(error != '') {\r\n");
      out.write("    if(error == '1') {\r\n");
      out.write("\t      Swal.fire({\r\n");
      out.write("            icon : 'error',\r\n");
      out.write("            title : '이메일 인증을 완료해주세요!'\r\n");
      out.write("        });\r\n");
      out.write("    } else if(error == '2') {\r\n");
      out.write("\t      Swal.fire({\r\n");
      out.write("            icon : 'error',\r\n");
      out.write("            title : '죄송합니다. 이메일 또는 비밀번호가 유효하지 않습니다.'\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("//비밀번호 찾기\r\n");
      out.write("$('#findPasswordBtn').click(function() {\r\n");
      out.write("   $.ajax({\r\n");
      out.write("       url: \"findPassword\",\r\n");
      out.write("      method:\"GET\",\r\n");
      out.write("      data:{\r\n");
      out.write("\t      email:$('#emailInput').val()\r\n");
      out.write("      },\r\n");
      out.write("      beforeSend:function() {\r\n");
      out.write("\t  var width = 0;\r\n");
      out.write("          var height = 0;\r\n");
      out.write("          var left = 0;\r\n");
      out.write("          var top = 0;\r\n");
      out.write("          width = 50;\r\n");
      out.write("          height = 50;\r\n");
      out.write("          top = ( $(window).height() - height ) / 2 + $(window).scrollTop();\r\n");
      out.write("          left = ( $(window).width() - width ) / 2 + $(window).scrollLeft();\r\n");
      out.write("          if($(\"#div_ajax_load_image\").length != 0) {\r\n");
      out.write("                 $(\"#div_ajax_load_image\").css({\r\n");
      out.write("                        \"top\": top+\"px\",\r\n");
      out.write("                        \"left\": left+\"px\"\r\n");
      out.write("                 });\r\n");
      out.write("                 $(\"#div_ajax_load_image\").show();\r\n");
      out.write("          }\r\n");
      out.write("          else {\r\n");
      out.write("                 $('body').append('<div id=\"div_ajax_load_image\" style=\"position:absolute; top:' \r\n");
      out.write("                 + top + 'px; left:' + left + 'px; width:' + width + 'px; height:' + height \r\n");
      out.write("                 + 'px; z-index:9999; background:#f0f0f0; filter:alpha(opacity=50); opacity:alpha*0.5; margin:auto; padding:0; \"><img src=\"/Team-project/images/loading.gif\" style=\"width:50px; height:50px;\"></div>');\r\n");
      out.write("                }\r\n");
      out.write("      },\r\n");
      out.write("      complete:function() {\r\n");
      out.write("\t      $(\"#div_ajax_load_image\").hide();\r\n");
      out.write("      },\r\n");
      out.write("      statusCode:{\r\n");
      out.write("\t      200:function() {\r\n");
      out.write("  \t\t    Swal.fire({\r\n");
      out.write("  \t\t        icon : 'success',\r\n");
      out.write("  \t\t        title : '이메일로 임시비밀번호를 발급했습니다.'\r\n");
      out.write("  \t\t    });\r\n");
      out.write("\t      },\r\n");
      out.write("\t      400:function() {\r\n");
      out.write("\t\t        Swal.fire({\r\n");
      out.write("\t              icon : 'error',\r\n");
      out.write("\t              title : '유효하지 않는 이메일입니다.'\r\n");
      out.write("\t          });\r\n");
      out.write("\t      }\r\n");
      out.write("      }\r\n");
      out.write("   }); \r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"/Team-project/script/loginForm.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("//카카오 로그인 script\r\n");
      out.write("Kakao.Auth.createLoginButton({\r\n");
      out.write("  container: '#kakao_login_btn',\r\n");
      out.write("  success: function(authObj) {\r\n");
      out.write("      Kakao.API.request({\r\n");
      out.write("            url: '/v2/user/me',\r\n");
      out.write("            success: function(user) {\r\n");
      out.write("                console.log(user);\r\n");
      out.write("                console.log(user.properties.profile_image);\r\n");
      out.write("               window.location.href=\"social?email=\"+user.kakao_account.email\r\n");
      out.write("                        +\"&id=\"+user.id\r\n");
      out.write("                        +\"&nickname=\"+encodeURI(user.properties.nickname, \"UTF-8\")\r\n");
      out.write("                        +\"&loginMethod=1\";\r\n");
      out.write("            },\r\n");
      out.write("            fail: function(error) {\r\n");
      out.write("                console.log(error);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("  },\r\n");
      out.write("  fail: function(error) {\r\n");
      out.write("    console.log(error);\r\n");
      out.write("  },\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("//구글로그인 script\r\n");
      out.write("function onSignIn(googleUser) {\r\n");
      out.write("    var profile = googleUser.getBasicProfile();\r\n");
      out.write("      \r\n");
      out.write("    console.log('ID: ' + profile.getId());\r\n");
      out.write("    console.log('Name: ' + profile.getName());\r\n");
      out.write("    console.log('Email: ' + profile.getEmail());\r\n");
      out.write("    window.location.href=\"social?email=\"+profile.getEmail()\r\n");
      out.write("    +\"&id=\"+profile.getId()\r\n");
      out.write("    +\"&nickname=\"+encodeURI(profile.getName(), \"UTF-8\")\r\n");
      out.write("    +\"&loginMethod=2\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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