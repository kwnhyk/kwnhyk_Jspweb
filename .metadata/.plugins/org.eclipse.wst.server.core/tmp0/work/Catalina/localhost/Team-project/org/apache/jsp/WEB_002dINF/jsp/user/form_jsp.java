/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.28
 * Generated at: 2020-06-30 20:57:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.user;

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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/style.css\" />\r\n");
      out.write("    <link rel=\"favicon\" href=\"images/favicon.ico\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"http://localhost:9999/Team-project/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("    <link rel=\"icon\" href=\"http://localhost:9999/Team-project/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<!-- sweet alert2 -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script>   \r\n");
      out.write("<script src=\"https://kit.fontawesome.com/764f0503e3.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- bootstrap -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<title>BTS-회원가입</title>\r\n");
      out.write("<style>\r\n");
      out.write("html, body, .container {\r\n");
      out.write("height: 100%;\r\n");
      out.write("}\r\n");
      out.write("form {\r\n");
      out.write("height: 10em;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container d-flex justify-content-center align-items-center\">\r\n");
      out.write("  <div class=\"d-flex flex-column justify-content-center align-items-center w-100\" style=\"margin-top:-20em;\">\r\n");
      out.write("    <img src=\"/Team-project/images/logo_bts.png\" style=\"width:5em; height:5em;\">\r\n");
      out.write("    <form class=\"d-flex flex-column col-12 justify-content-center align-items-center\" \r\n");
      out.write("    id=\"addForm\" action='signup' method='post' enctype='multipart/form-data'>\r\n");
      out.write("        <input class=\"form-control col-3\" id = \"emailInput\" name='email' type='email' placeholder=\"   이메일\">\r\n");
      out.write("        <input class=\"form-control mt-2 col-3\" id = \"nameInput\" name='name' type='text' placeholder=\"   이름\">\r\n");
      out.write("        <input class=\"form-control mt-2 col-3\" id=\"passwordInput\" name='password' type='password' placeholder=\"   비밀번호\">\r\n");
      out.write("        <input class=\"form-control mt-2 col-3\" id=\"passwordInput2\" type='password' placeholder=\"   비밀번호 재확인\">\r\n");
      out.write("        <label class=\"text-primary mt-2 font-weight-bold\" id=\"form-label\" style=\"height:2em;\">\r\n");
      out.write("        비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.\r\n");
      out.write("        </label>\r\n");
      out.write("        <input name=\"loginMethod\" type=\"hidden\" value=\"0\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary col-3\" id=\"completeBtn\">완료</button>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("    <script>\r\n");
      out.write("    //const emailReg = /^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;\r\n");
      out.write("    const emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;\r\n");
      out.write("\r\n");
      out.write("    const passwordReg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;\r\n");
      out.write("\r\n");
      out.write("    $('#completeBtn').click(function(event){\r\n");
      out.write("    \tevent.preventDefault();\r\n");
      out.write("        if($('#emailInput').val() == \"\" || $('#nameInput').val() == \"\" || $('#passwordInput') == \"\") {\r\n");
      out.write("        \t$('#form-label').html(\"모든 정보를 입력해주세요.\");\r\n");
      out.write("        } else {\r\n");
      out.write("            let email = $('#emailInput').val()\r\n");
      out.write("            let password = $('#passwordInput').val();\r\n");
      out.write("            let password2 = $('#passwordInput2').val();\r\n");
      out.write("            if(emailReg.test(String(email).toLowerCase()) == false) {\r\n");
      out.write("            \t$('#emailInput').focus();\r\n");
      out.write("          \t\t$('#form-label').html(\"올바른 이메일 형식을 입력해주세요.\");\r\n");
      out.write("            } else if(passwordReg.test(password) == false) {\r\n");
      out.write("            \t$('#passwordInput').focus();\r\n");
      out.write("\t            $('#form-label').html(\"비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.\");\r\n");
      out.write("\t          } else if(password != password2) {\r\n");
      out.write("\t        \t  $('#passwordInput2').focus();\r\n");
      out.write("            \t$('#form-label').html(\"비밀번호와 재확인 비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("            } else if(emailReg.test(String(email).toLowerCase()) == true && passwordReg.test(password) == true) {\r\n");
      out.write("            \t$.ajax({\r\n");
      out.write("            \t\turl : 'signup',\r\n");
      out.write("            \t\tmethod: 'POST',\r\n");
      out.write("            \t\tdata:{\r\n");
      out.write("            \t\t\temail:$('#emailInput').val(),\r\n");
      out.write("            \t\t\tname:$('#nameInput').val(),\r\n");
      out.write("            \t\t\tpassword:$('#passwordInput').val()\r\n");
      out.write("            \t\t},\r\n");
      out.write("            \t\tbeforeSend:function(){\r\n");
      out.write("            \t\t\tvar width = 0;\r\n");
      out.write("                  var height = 0;\r\n");
      out.write("                  var left = 0;\r\n");
      out.write("                  var top = 0;\r\n");
      out.write("                  width = 50;\r\n");
      out.write("                  height = 50;\r\n");
      out.write("                  top = ( $(window).height() - height ) / 2 + $(window).scrollTop();\r\n");
      out.write("                  left = ( $(window).width() - width ) / 2 + $(window).scrollLeft();\r\n");
      out.write("                  if($(\"#div_ajax_load_image\").length != 0) {\r\n");
      out.write("                         $(\"#div_ajax_load_image\").css({\r\n");
      out.write("                                \"top\": top+\"px\",\r\n");
      out.write("                                \"left\": left+\"px\"\r\n");
      out.write("                         });\r\n");
      out.write("                         $(\"#div_ajax_load_image\").show();\r\n");
      out.write("                  }\r\n");
      out.write("                  else {\r\n");
      out.write("                         $('body').append('<div id=\"div_ajax_load_image\" style=\"position:absolute; top:' \r\n");
      out.write("                         + top + 'px; left:' + left + 'px; width:' + width + 'px; height:' + height \r\n");
      out.write("                         + 'px; z-index:9999; background:#f0f0f0; filter:alpha(opacity=50); opacity:alpha*0.5; margin:auto; padding:0; \"><img src=\"/Team-project/images/loading.gif\" style=\"width:50px; height:50px;\"></div>');\r\n");
      out.write("                        }\r\n");
      out.write("            \t\t},\r\n");
      out.write("            \t\tcomplete: function () {\r\n");
      out.write("                  $(\"#div_ajax_load_image\").hide();\r\n");
      out.write("                },\r\n");
      out.write("                statusCode:{\r\n");
      out.write("                \t400:function(){\r\n");
      out.write("                \t\t$('#form-label').html(\"이미 회원으로 가입된 이메일입니다.\");\r\n");
      out.write("                \t},\r\n");
      out.write("                \t200:function(){\r\n");
      out.write("                \t    Swal.fire({\r\n");
      out.write("                \t            icon : 'success',\r\n");
      out.write("                \t            title : '회원가입을 완료하기 위해 이메일을 인증해주세요!'\r\n");
      out.write("                \t        }).then((result) => {\r\n");
      out.write("                                    if (result.value) {\r\n");
      out.write("                \t        \t           location.href=\"../auth/form\";\r\n");
      out.write("                                    }\r\n");
      out.write("                          });\r\n");
      out.write("                  }\r\n");
      out.write("            \t}//statusCode\r\n");
      out.write("\t          }); // ajax\r\n");
      out.write("        }\r\n");
      out.write("      }//else      \r\n");
      out.write("    });//click\r\n");
      out.write("    \r\n");
      out.write("    $(\"input\").keydown(function(key) {\r\n");
      out.write("        if (key.keyCode == 13) {\r\n");
      out.write("          $(\"#completeBtn\").trigger(\"click\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
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