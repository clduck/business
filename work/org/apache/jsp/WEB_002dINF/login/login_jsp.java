package org.apache.jsp.WEB_002dINF.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Frameset//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\r\n");
      out.write("<title>QUI网页界面集成框架JAVA示例版</title>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/system/login/skin/style.css\" rel=\"stylesheet\" type=\"text/css\" id=\"skin\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--居中显示start-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/libs/js/method/center-plugin.js\"></script>\r\n");
      out.write("<!--居中显示end-->\r\n");
      out.write("<style>\r\n");
      out.write("/*提示信息*/\t\r\n");
      out.write("#cursorMessageDiv {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tz-index: 99999;\r\n");
      out.write("\tborder: solid 1px #cc9933;\r\n");
      out.write("\tbackground: #ffffcc;\r\n");
      out.write("\tpadding: 2px;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tline-height:150%;\r\n");
      out.write("}\r\n");
      out.write("/*提示信息*/\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("\t<div class=\"login_main\">\r\n");
      out.write("\t\t<div class=\"login_top\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"login_middle\">\r\n");
      out.write("\t\t\t<div class=\"login_middleleft\"></div>\r\n");
      out.write("\t\t\t<div class=\"login_middlecenter\">\r\n");
      out.write("\t\t\t\t\t<form id=\"loginForm\"  class=\"login_form\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"login_user\"><input type=\"text\" id=\"username\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"login_pass\"><input type=\"password\" id=\"password\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"login_button\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login_button_left\"><input type=\"button\" onclick=\"login()\"/></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login_button_right\"><input type=\"reset\" value=\"\"/></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<div class=\"login_info\" style=\"display:none;\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"login_info2\">&nbsp;&nbsp;测试用户名:guest 密码：123456</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login_middleright\"></div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"login_bottom\">\r\n");
      out.write("\t\t\t<div class=\"login_copyright\">版权所有：http://www.quickui.net</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t//居中\r\n");
      out.write("\t\t $('.login_main').center();\r\n");
      out.write("\t\t document.getElementById(\"username\").focus();\r\n");
      out.write("\t\t $(\"#username\").keydown(function(event){\r\n");
      out.write("\t\t \tif(event.keyCode==13){\r\n");
      out.write("\t\t\t\tlogin()\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t $(\"#password\").keydown(function(event){\r\n");
      out.write("\t\t \tif(event.keyCode==13){\r\n");
      out.write("\t\t\t\tlogin()\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t \r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\t//登录\r\n");
      out.write("\tfunction login() {\r\n");
      out.write("\t\tvar errorMsg = \"\";\r\n");
      out.write("\t\tvar loginName = document.getElementById(\"username\");\r\n");
      out.write("\t\tvar password = document.getElementById(\"password\");\r\n");
      out.write("\t\tif(!loginName.value){\r\n");
      out.write("\t\t\terrorMsg += \"&nbsp;&nbsp;用户名不能为空!\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!password.value){\r\n");
      out.write("\t\t\terrorMsg += \"&nbsp;&nbsp;密码不能为空!\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif(errorMsg != \"\"){\r\n");
      out.write("\t\t\t$(\".login_info\").html(errorMsg);\r\n");
      out.write("\t\t\t$(\".login_info\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\t$(\".login_info\").show();\r\n");
      out.write("\t\t\t$(\".login_info\").html(\"&nbsp;&nbsp;正在登录中...\");\r\n");
      out.write("\t\t\t//登录处理\r\n");
      out.write("\t\t\tvar path = '");
      out.print(path);
      out.write("/login/loginAction.xhtml';\r\n");
      out.write("\t\t\t$.post(path,\r\n");
      out.write("\t\t\t\t  {\"userinfor.userLoginName\":loginName.value,\"userinfor.userPassword\":password.value},\r\n");
      out.write("\t\t\t\t  function(result){\r\n");
      out.write("\t\t\t\t\t  if(result == null){\r\n");
      out.write("\t\t\t\t\t\t  $(\".login_info\").html(\"&nbsp;&nbsp;登陆失败！\");\r\n");
      out.write("\t\t\t\t\t\t  return false;\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  if(result.code == 0){\r\n");
      out.write("\t\t\t\t\t  \t  $(\".login_info\").html(\"&nbsp;&nbsp;登录成功，正在转到主页...\");\r\n");
      out.write("\t\t\t\t\t  \t  var url = '");
      out.print(path);
      out.write("'+result.retobj;\r\n");
      out.write("\t\t\t\t\t  \t  alert(url);\r\n");
      out.write("\t\t\t\t\t\t  window.location=url;  \r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  else{\r\n");
      out.write("\t\t\t\t\t  \t $(\".login_info\").html(\"&nbsp;&nbsp;\"+result.message);\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t  },\"json\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
