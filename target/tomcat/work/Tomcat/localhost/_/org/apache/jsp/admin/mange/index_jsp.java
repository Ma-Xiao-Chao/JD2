/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-10-01 11:30:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.mange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>--index--</title>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/admin/mange/stataic/boostrap/css/bootstrap.min.css\"/>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/admin/mange/stataic/css/index.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/admin/mange/stataic/boostrap/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/admin/mange/stataic/boostrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/admin/mange/stataic/js/index.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-0\">\r\n");
      out.write("            <div class=\"page-header\">\r\n");
      out.write("                <h1>Welcome <small>my admin page</small></h1>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"btn-group-vertical\" role=\"group\" aria-label=\"...\">\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default btn-lg dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("                            aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                        用户管理\r\n");
      out.write("                        <span class=\"caret\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li class=\"usersInfo\"><a href=\"#\">用户信息</a></li>\r\n");
      out.write("                        <li class=\"usersInfo\"><a href=\"#\">#</a></li>\r\n");
      out.write("                        <li class=\"usersInfo\"><a href=\"#\">#</a></li>\r\n");
      out.write("                        <li class=\"usersInfo\"><a href=\"#\">#</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default btn-lg dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("                            aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                        商品管理\r\n");
      out.write("                        <span class=\"caret\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li class=\"goodsInfo\"><a href=\"#\">菜单管理</a></li>\r\n");
      out.write("                        <li class=\"goodsInfo\"><a href=\"#\">商品管理</a></li>\r\n");
      out.write("                        <li class=\"goodsInfo\"><a href=\"#\">订单管理</a></li>\r\n");
      out.write("                        <li class=\"goodsInfo\"><a href=\"#\">#</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"btn-group \" role=\"group\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span>\r\n");
      out.write("                        退出系统\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"col-md-10 right\">\r\n");
      out.write("            <iframe id=\"rightFrame\" src=\"/admin/mange/welcome.jsp\"></iframe>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
