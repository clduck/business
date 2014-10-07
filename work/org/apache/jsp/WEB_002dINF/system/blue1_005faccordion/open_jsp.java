package org.apache.jsp.WEB_002dINF.system.blue1_005faccordion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class open_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!--框架必需start-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/manage/accordion/framework_inc.jsp", out, false);
      out.write("\r\n");
      out.write("<!--框架必需end-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t $(function(){\r\n");
      out.write("\t\t$(\".navIcon\").jomino();\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction customHeightSet(contentHeight){\r\n");
      out.write("\t\t$(\"#scrollContent\").height(contentHeight);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!--动画方式入场效果end-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"scrollContent\">\r\n");
      out.write("\t<table width=\"100%\" height=\"90%\">\r\n");
      out.write("\t\t<tr><td class=\"ali02 ver02\">\r\n");
      out.write("\t\t\t<div  style=\"width:800px;margin:0 auto;\">\r\n");
      out.write("\t\t\t<table class=\"ali01 ver01\">\r\n");
      out.write("\t\t\t\t<tr height=\"146\">\r\n");
      out.write("\t\t\t\t\t<td width=\"260\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('个人中心')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/01.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">个人中心</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t个人基础信息设置<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t手机短信提醒设置<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t更改密码\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"260\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('个人收藏夹')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/02.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">个人收藏夹</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看曾经加入到收藏夹中的数据\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"260\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('高级搜索')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/03.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">高级搜索</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可搜索整个系统的数据<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可选择多种过滤条件\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"146\">\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('文档管理')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/04.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">文档管理</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t保存了自己的文档附件和别人转发的文档\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('帮助中心')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/05.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">帮助中心</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t系统使用常见问题<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t用户手册<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t系统更新日志等\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('个人存储空间')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/06.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">个人存储空间</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t每个用户在系统中有100M的存储空间。在这里可进行管理\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"146\">\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('附件管理')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/07.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">附件管理</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t保存了自己上传的附件<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可进行下载、删除等操作\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('通知消息')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/08.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">通知消息</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t系统发送的消息<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t其他用户发送的消息\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navIcon\" onclick=\"top.Dialog.alert('回收站')\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_left\"><img src=\"");
      out.print(path);
      out.write("/libs/icons/png/09.png\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navIcon_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_title\">回收站</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"navIcon_right_con\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t保存了曾经删除的数据和文档资料等\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
