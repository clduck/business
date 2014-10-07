package org.apache.jsp.WEB_002dINF.system.blue1_005faccordion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Frameset//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>模板</title>\r\n");
      out.write("<!--框架必需start-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/manage/accordion/index_inc.jsp", out, false);
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function bookmarksite(title, url){\r\n");
      out.write("    if (window.sidebar) // firefox\r\n");
      out.write("        window.sidebar.addPanel(title, url, \"\");\r\n");
      out.write("    else \r\n");
      out.write("        if (window.opera && window.print) { // opera\r\n");
      out.write("            var elem = document.createElement('a');\r\n");
      out.write("            elem.setAttribute('href', url);\r\n");
      out.write("            elem.setAttribute('title', title);\r\n");
      out.write("            elem.setAttribute('rel', 'sidebar');\r\n");
      out.write("            elem.click();\r\n");
      out.write("        }\r\n");
      out.write("        else \r\n");
      out.write("            if (document.all)// ie\r\n");
      out.write("                window.external.AddFavorite(url, title);\r\n");
      out.write("}\r\n");
      out.write("function windowClose(){\r\n");
      out.write("window.opener=null;\r\n");
      out.write("  window.open('', '_self'); //IE7必需的.\r\n");
      out.write("  window.close();\r\n");
      out.write("}\r\n");
      out.write("function backHome(){\r\n");
      out.write("\tdocument.getElementById(\"frmleft\").contentWindow.homeHandler();\r\n");
      out.write("}\r\n");
      out.write("$(function(){\r\n");
      out.write("\tsetTimeout(function(){\r\n");
      out.write("\t\t$.messager.show('警告','警告信息内容','10000','','box_msg_custom');\r\n");
      out.write("\t},3000);\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("a {\r\n");
      out.write("\tbehavior:url(../../libs/js/method/focus.htc)\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"mainFrame\">\r\n");
      out.write("<!--头部与导航start-->\r\n");
      out.write("<div id=\"hbox\">\r\n");
      out.write("\t<div id=\"bs_bannercenter\">\r\n");
      out.write("\t<div id=\"bs_bannerright\">\r\n");
      out.write("\t<div id=\"bs_bannerleft\">\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"bs_navcenter\">\r\n");
      out.write("\t<div id=\"bs_navleft\">\r\n");
      out.write("\t<div id=\"bs_navright\">\r\n");
      out.write("\t\t<div class=\"bs_nav\">\r\n");
      out.write("\t\t\t<div class=\"bs_navleft\">\r\n");
      out.write("\t\t\t\t<li class=\"fontTitle\">字号:</li>\r\n");
      out.write("\t\t\t\t<li class=\"fontChange\"><span><a href=\"javascript:;\" setFont=\"16\">大</a></span></li>\r\n");
      out.write("\t\t\t\t<li class=\"fontChange\"><span><a href=\"javascript:;\" setFont=\"14\">中</a></span></li>\r\n");
      out.write("\t\t\t\t<li class=\"fontChange\"><span><a href=\"javascript:;\" setFont=\"12\">小</a></span></li>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\t\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t<div class=\"float_left\" style=\"padding:2px 0 0 80px;\" id=\"positionContent\"></div>\t\r\n");
      out.write("\t\t\t<div class=\"float_right padding_top2 padding_right5\">\r\n");
      out.write("\t\t\t\t<a href=\"/main/open.xhtml\" target=\"frmright\" onclick='backHome()'><span class=\"icon_home hand\">返回导航页</span></a>\r\n");
      out.write("\t\t\t\t<span class=\"icon_fullscreen hand\" id=\"fullSrceen\" hideNav=\"true\">开启全屏</span>\r\n");
      out.write("\t\t\t\t<span class=\"icon_delete hand\" onclick='top.Dialog.confirm(\"确定要关闭本页吗？\",function(){windowClose()});'>关闭本页</span>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"float_right padding_top2 padding_right5\">\r\n");
      out.write("\t\t\t\t【今天是\r\n");
      out.write("\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\tvar weekDayLabels = new Array(\"星期日\",\"星期一\",\"星期二\",\"星期三\",\"星期四\",\"星期五\",\"星期六\");\r\n");
      out.write("\t\t\t\t\tvar now = new Date();\r\n");
      out.write("\t\t\t\t    var year=now.getFullYear();\r\n");
      out.write("\t\t\t\t\tvar month=now.getMonth()+1;\r\n");
      out.write("\t\t\t\t\tvar day=now.getDate()\r\n");
      out.write("\t\t\t\t    var currentime = year+\"年\"+month+\"月\"+day+\"日 \"+weekDayLabels[now.getDay()]\r\n");
      out.write("\t\t\t\t\tdocument.write(currentime)\r\n");
      out.write("\t\t\t\t</script>】\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--头部与导航end-->\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_border0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<!--左侧区域start-->\r\n");
      out.write("\t\t<td id=\"hideCon\" class=\"ver01 ali01\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"lbox\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_topcenter\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_topleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_topright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_middlecenter\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_middleleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_middleright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"bs_left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<IFRAME height=\"100%\" width=\"100%\"  frameBorder=0 id=frmleft name=frmleft src=\"left.xhtml\"  allowTransparency=\"true\"></IFRAME>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!--更改左侧栏的宽度需要修改id=\"bs_left\"的样式-->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_bottomcenter\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_bottomleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"lbox_bottomright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"lbox_foot\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<!--左侧区域end-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--分隔栏区域start-->\r\n");
      out.write("\t\t<td class=\"spliter main_shutiao\" targetId=\"hideCon\" beforeClickTip=\"收缩面板\" afterClickTip=\"展开面板\" beforeClickClass=\"bs_leftArr\" afterClickClass=\"bs_rightArr\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<!--分隔栏区域end-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--右侧区域start-->\r\n");
      out.write("\t\t<td class=\"ali01 ver01\"  width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"rbox\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_topcenter\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_topleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_topright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_middlecenter\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_middleleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_middleright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"bs_right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t       <IFRAME height=\"100%\" width=\"100%\" frameBorder=0 id=frmright name=frmright src=\"open.xhtml\"  allowTransparency=\"true\"></IFRAME>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_bottomcenter\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_bottomleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"rbox_bottomright\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<!--右侧区域end-->\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<!--尾部区域start-->\r\n");
      out.write("<div id=\"fbox\">\r\n");
      out.write("\t<div id=\"bs_footcenter\">\r\n");
      out.write("\t<div id=\"bs_footleft\">\r\n");
      out.write("\t<div id=\"bs_footright\">\r\n");
      out.write("\t\t版权所有：http://www.quickui.net\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--尾部区域end-->\r\n");
      out.write("\r\n");
      out.write("<!--浏览器resize事件修正start-->\r\n");
      out.write("<div id=\"resizeFix\"></div>\r\n");
      out.write("<!--浏览器resize事件修正end-->\r\n");
      out.write("\r\n");
      out.write("<!--窗口任务栏区域start-->\r\n");
      out.write("<div id=\"dialogTask\" class=\"dialogTaskBg\" style=\"display:none;\"></div>\r\n");
      out.write("<!--窗口任务栏区域end-->\r\n");
      out.write("\r\n");
      out.write("<!--载进度条start-->\r\n");
      out.write("<div class=\"progressBg\" id=\"progress\" style=\"display:none;\"><div class=\"progressBar\"></div></div>\r\n");
      out.write("<!--载进度条end-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
