/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-10-01 11:29:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>京东(JD.COM)-正品低价、品质保证</title>\r\n");
      out.write("    <link rel=\"icon\" href=\"/static/pic/1.png\" type=\"image/x-icon\">\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/static/bootstrap-3.3.7-dist/css/bootstrap.min.css\"/>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/static/css/login.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--<script type=\"text/javascript\" src=\"/static/js/login.js\"></script>-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"row row2\">\r\n");
      out.write("        <div class=\"col-md-6 col-md-offset-5 font\">欢迎登录</div>\r\n");
      out.write("        <br><br><br>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"col-md-6 col-md-offset-3\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <form id=\"frm\" class=\"form-horizontal\" action=\"/user?action=login\" method=\"post\">\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"username\" class=\"col-sm-2 control-label\">username</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control input\" id=\"username\" name=\"username\"\r\n");
      out.write("                               placeholder=\"username\">\r\n");
      out.write("                        <span class=\"help-block\"></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"password\" class=\"col-sm-2 control-label\">password</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">\r\n");
      out.write("                        <input type=\"password\" class=\"form-control input\" id=\"password\" name=\"password\"\r\n");
      out.write("                               placeholder=\"password\">\r\n");
      out.write("                        <span class=\"help-block\"></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group denglu\">\r\n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10 denglu\">\r\n");
      out.write("                        <div class=\"checkbox\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input type=\"checkbox\"> Remember me\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group denglu\">\r\n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10 denglu\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">sign in</button>\r\n");
      out.write("                        <a id=\"zhucefont\" href=\"/page/regist.jsp\">没有账号?点击注册</a>\r\n");
      out.write("                        <a id=\"shouye\" href=\"/catalog\">首页</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"col-md-6 col-md-offset-5\">\r\n");
      out.write("            <div class=\"err\">\r\n");
      out.write("                ");
      out.print(request.getAttribute("err") == null ? "" : request.getAttribute("err"));
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <script>\r\n");
      out.write("\r\n");
      out.write("                if (");
      out.print(request.getAttribute("err") != null);
      out.write(") {\r\n");
      out.write("                    if (");
      out.print(request.getAttribute("err") == "登录成功");
      out.write("){\r\n");
      out.write("                    }else {\r\n");
      out.write("                        $(\".err\").css(\"color\",\"#c8121d\")\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("        </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
