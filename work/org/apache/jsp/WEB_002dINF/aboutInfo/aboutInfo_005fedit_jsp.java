package org.apache.jsp.WEB_002dINF.aboutInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aboutInfo_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>表单编辑</title>\r\n");
      out.write("\r\n");
      out.write("<!--框架必需start -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/manage/accordion/framework_inc.jsp", out, false);
      out.write("\r\n");
      out.write("<!--框架必需end -->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div class=\"box1\" panelWidth=\"800\">\r\n");
      out.write("    <fieldset>\r\n");
      out.write("      <legend>编辑信息</legend>\r\n");
      out.write("   <form id=\"editFrom\" method=\"post\" >\r\n");
      out.write("\t <table class=\"tableStyle\" formMode=\"line\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan=\"4\">表单填写</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"15%\">企业名称：</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"aboutName\" id=\"aboutName\" class=\"validate[required]\" /><span class=\"star\">*</span>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t    <td width=\"15%\">是否显示：</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div style=\"width:120px;\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" id=\"viewFlag-1\" name=\"viewFlag\" class=\"validate[required] radio\"  value=\"1\"/><label for=\"viewFlag-1\" class=\"hand\">是</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" id=\"viewFlag-2\" name=\"viewFlag\" class=\"validate[required] radio\" value=\"2\"/><label for=\"viewFlag-2\" class=\"hand\">否</label> <span class=\"star\">*</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>单选下拉框：</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<select id=\"clickNumber\" name=\"clickNumber\" class=\"validate[required]\" prompt=\"请选择\"  data='{\"list\":[{\"value\":\"1\",\"key\":\"1\"},{\"value\":\"2\",\"key\":\"2\"}]}'></select><span class=\"star\">*</span>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>创建时间：</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input id=\"addTime\" name=\"addTime\" type=\"text\" class=\"date validate[required,custom[date]]\"/><span class=\"star\">*</span>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>公司简介：</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" >\r\n");
      out.write("\t\t\t\t<textarea id=\"content\" name=\"content\" watermark=\"请填写公司简介\" maxNum=\"150\" style=\"width:600px;height:100px;\"></textarea>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t </table>\r\n");
      out.write("  </form>\r\n");
      out.write(" </fieldset>\r\n");
      out.write("  <div class=\"height_15\"></div>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("  \t$(function(){\r\n");
      out.write("  \t\tvar rowid = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rowid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("  \t\tvar rowData = getParent().getRowData(rowid);\r\n");
      out.write("  \t\talert(JSON.stringify(rowData));\r\n");
      out.write("  \t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
