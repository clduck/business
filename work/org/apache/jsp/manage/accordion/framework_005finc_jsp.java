package org.apache.jsp.manage.accordion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class framework_005finc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/framework.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/libs/css/import_basic.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" id=\"skin\" prePath=\"");
      out.print(path);
      out.write("/\" scrollerY=\"false\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" id=\"customSkin\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 树型抽屉导航start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/nav/treeAccordion_normal.js\"></script>\r\n");
      out.write("<!-- 树型抽屉导航end -->\r\n");
      out.write("\r\n");
      out.write("<!--树组件start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!--树组件end -->\r\n");
      out.write("\r\n");
      out.write("<!--数据表格start-->\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/libs/js/table/quiGrid.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!--数据表格end-->\r\n");
      out.write("\r\n");
      out.write("<!--表单异步提交start-->\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/libs/js/form/form.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!--表单异步提交end-->\r\n");
      out.write("\r\n");
      out.write("<!--动画方式入场效果start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/pic/jomino.js\"></script>\r\n");
      out.write("<!--动画方式入场效果end  -->\r\n");
      out.write("\r\n");
      out.write("<!-- 树组件start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.js\"></script>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/libs/js/tree/ztree/ztree.css\"></link>\r\n");
      out.write("<!-- 树组件end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 树形下拉框start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/selectTree.js\"></script>\r\n");
      out.write("<!-- 树形下拉框end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 日期控件start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/datePicker/WdatePicker.js\"></script>\r\n");
      out.write("<!-- 日期控件end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 条件过滤器 start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/filter.js\"></script>\r\n");
      out.write("<!-- 条件过滤器 end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 数字步进器start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/stepper.js\"></script>\r\n");
      out.write("<!-- 数字步进器end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 软键盘控件start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/keypad.js\"></script>\r\n");
      out.write("<!-- 软键盘控件end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 双向选择器start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/lister.js\"></script>\r\n");
      out.write("<!-- 双向选择器end -->\r\n");
      out.write("\r\n");
      out.write("<!--自动提示框start-->\r\n");
      out.write("<script type='text/javascript' src='");
      out.print(path);
      out.write("/libs/js/form/suggestion.js'></script>\r\n");
      out.write("<!--自动提示框end-->\r\n");
      out.write("\r\n");
      out.write("<!-- 树形双选器start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/listerTree.js\"></script>\r\n");
      out.write("<!-- 树形双选器end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 组合下拉框start -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/form/selectCustom.js\"></script>\r\n");
      out.write("<!-- 组合拉框end -->\r\n");
      out.write("\r\n");
      out.write("<!-- 表单验证start -->\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/libs/js/form/validationRule.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/libs/js/form/validation.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- 表单验证end -->\r\n");
      out.write("\r\n");
      out.write("<!--修正IE6不支持PNG图start-->\r\n");
      out.write("<style>\r\n");
      out.write("img {\r\n");
      out.write("\tbehavior:url(\"");
      out.print(path);
      out.write("/libs/js/method/pngFix/pngbehavior.htc\");\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<!--修正IE6不支持PNG图end-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar path = '");
      out.print(path);
      out.write("';\r\n");
      out.write("\t//获取父页面\r\n");
      out.write("\tfunction getParent(){\r\n");
      out.write("\t\treturn top.frmright;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>");
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
