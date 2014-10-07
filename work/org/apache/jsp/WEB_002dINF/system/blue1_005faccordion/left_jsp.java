package org.apache.jsp.WEB_002dINF.system.blue1_005faccordion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 	String iconPath = "/business/system/blue1_accordion";
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
      out.write("<style>\r\n");
      out.write("\t.ztree li span.zbutton.diy01_ico_open, .ztree li span.zbutton.diy01_ico_close{width:24px!important;height:24px!important;padding-top:0;}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar zNodes =[\r\n");
      out.write("\t\t{ id:3001, parentId:0, name:\"表单模板\",icon:\"");
      out.print(iconPath);
      out.write("/skin/icons/icon_1.png\",iconSkin:\"diy01\"},\r\n");
      out.write("\t\t{ id:101, parentId:3001, name:\"页面中的表单\",url:\"");
      out.print(path);
      out.write("/aboutInfo/do.xhtml\", target:\"frmright\",iconOpen:\"");
      out.print(path);
      out.write("/libs/icons/tree_close.gif\",iconClose:\"");
      out.print(path);
      out.write("/libs/icons/tree_open.gif\",icon:\"");
      out.print(iconPath);
      out.write("/skin/titlebar_arrow.gif\"},\r\n");
      out.write("\t\t{ id:102, parentId:3001, name:\"弹窗中的表单\",url:\"");
      out.print(path);
      out.write("/sample_skin/normal/form-pop.html\", target:\"frmright\",iconOpen:\"");
      out.print(path);
      out.write("/libs/icons/tree_close.gif\",iconClose:\"");
      out.print(path);
      out.write("/libs/icons/tree_open.gif\",icon:\"");
      out.print(iconPath);
      out.write("/skin/titlebar_arrow.gif\"}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t];\r\n");
      out.write("\t\r\n");
      out.write("\tvar fixedObj=60;\r\n");
      out.write("\tfunction customHeightSet(contentHeight){\r\n");
      out.write("\t\t$(\"#scrollContent\").height(contentHeight-fixedObj);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftFrame=\"true\">\r\n");
      out.write("<div class=\"padding_top5 ali02\" style=\"height:55px;\">\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"85%\" class=\"ali03\"><input type=\"text\" id=\"searchKey\" value=\"\"></td>\r\n");
      out.write("\t\t<td><span class=\"img_find hand\" title=\"点击查找节点\" keepDefaultStyle=\"true\" onclick=\"findNode()\"></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" class=\"ali02\"><a onclick=\"showAll()\">全部展开</a>&nbsp;&nbsp;<a onclick=\"hideAll()\">全部收缩</a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"scrollContent\" style=\"overflow-x:hidden;\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<ul id=\"treeDemo\" class=\"ztree ztree_accordition\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\t\t\t\t\r\n");
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
