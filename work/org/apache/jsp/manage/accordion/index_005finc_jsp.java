package org.apache.jsp.manage.accordion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005finc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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

      out.write("  \r\n");
 
	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!--框架必需start-->\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/libs/css/import_basic.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/libs/skins/blue/style.css\" rel=\"stylesheet\" type=\"text/css\" id=\"theme\" themeColor=\"blue\" positionTarget=\"positionContent\"/>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/system/blue1_accordion/skin/style.css\" rel=\"stylesheet\" type=\"text/css\" id=\"skin\" skinPath=\"system/blue1_accordion/skin/\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/main.js\"></script>\r\n");
      out.write("<!--框架必需end-->\r\n");
      out.write("\r\n");
      out.write("<!--弹窗组件start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/popup/drag.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/popup/dialog.js\"></script>\r\n");
      out.write("<!--弹窗组件end-->\r\n");
      out.write("\r\n");
      out.write("<!--分隔条start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/nav/spliter.js\"></script>\r\n");
      out.write("<!--分隔条end-->\r\n");
      out.write("\r\n");
      out.write("<!--弹出式提示框start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/popup/messager.js\"></script>\r\n");
      out.write("<!--弹出式提示框end-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
