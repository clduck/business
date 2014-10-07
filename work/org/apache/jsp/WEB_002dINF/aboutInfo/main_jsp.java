package org.apache.jsp.WEB_002dINF.aboutInfo;

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>基本表格模板</title>\r\n");
      out.write("<!--框架必需start-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/manage/accordion/framework_inc.jsp", out, false);
      out.write("\r\n");
      out.write("<!--框架必需end-->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table width=\"100%\" >\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<!--左侧区域start-->\r\n");
      out.write("\t\t<td class=\"ver01\" >\r\n");
      out.write("\t\t\t <div class=\"box2\"  overflow=\"auto\" showStatus=\"false\" panelTitle=\"组织结构树\">\r\n");
      out.write("\t\t\t \t<div class=\"cusBoxContent\"  style=\"width:150px;\">\r\n");
      out.write("\t\t\t  \t\t<ul id=\"tree-1\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t  \t</div>\r\n");
      out.write("\t\t  \t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<!--左侧区域end-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--右侧区域start-->\r\n");
      out.write("\t\t<td width=\"100%\" class=\"ver01\" >\r\n");
      out.write("\t\t\t<div class=\"box2\" panelTitle=\"查询\"  showStatus=\"false\">\r\n");
      out.write("\t\t\t\t<form id=\"queryForm\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td><button id=\"search\"><span class=\"icon_find\">查询</span></button></td>\r\n");
      out.write("\t\t\t\t\t\t<td><button id=\"resetButton\"><span class=\"icon_clear\">重置</span></button></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin: 0;padding: 0 5px 0 0;\">\r\n");
      out.write("\t\t\t\t<div id=\"maingrid\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<!--右侧区域end-->\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar nodes1 = [\r\n");
      out.write("\t\t{ id:1,  parentId:0, name:\"中心1\", open: true,icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:11, parentId:1, name:\"部门1\",icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:12, parentId:1, name:\"部门2\",icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:13, parentId:1, name:\"部门3\",icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:2,  parentId:0, name:\"中心2\", open: true,icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:21, parentId:2, name:\"部门4\",icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:22, parentId:2, name:\"部门5\",icon:\"../../libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:23, parentId:2, name:\"部门6\",icon:\"../../libs/icons/user_group.gif\"}\r\n");
      out.write("\t];\r\n");
      out.write("\t\r\n");
      out.write("\t//数据表格使用\r\n");
      out.write("      var gridData={\"form.paginate.pageNo\":1,\"form.paginate.totalRows\":13,\"rows\":[\r\n");
      out.write("      {\"deptName\":\"部门1\",\"sex\":\"女\",\"remark\":\"好啊\",\"hobby\":[\"唱歌\"],\"beginworkDate\":\"2012-06-13 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":125,\"degree\":\"硕士结业\",\"age\":20,\"name\":\"员工1\",\"deptId\":12,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门1\",\"sex\":\"男\",\"remark\":\"备注啊\",\"hobby\":[\"唱歌\"],\"beginworkDate\":\"2012-06-13 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":124,\"degree\":\"本科毕业\",\"age\":20,\"name\":\"员工2\",\"deptId\":11,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门1\",\"sex\":\"男\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-12 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":123,\"degree\":\"本科毕业\",\"age\":20,\"name\":\"员工3\",\"deptId\":9,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门1\",\"sex\":\"女\",\"remark\":\"不错啊\",\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-12 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":121,\"degree\":\"硕士肄业\",\"age\":20,\"name\":\"员工4\",\"deptId\":8,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门1\",\"sex\":\"男\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-12 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":120,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工5\",\"deptId\":7,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工6\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工7\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工8\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工9\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工10\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工11\",\"deptId\":6,\"ability\":5},\r\n");
      out.write("      {\"deptName\":\"部门2\",\"sex\":\"女\",\"remark\":null,\"hobby\":[\"唱歌\",\"跳舞\"],\"beginworkDate\":\"2012-06-05 00:00:00.0\",\"photo\":null,\"version\":null,\"id\":119,\"degree\":\"博士肄业\",\"age\":20,\"name\":\"员工12\",\"deptId\":6,\"ability\":5}\r\n");
      out.write("      ]}\r\n");
      out.write("      \r\n");
      out.write("        var g;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction initComplete(){\r\n");
      out.write("\t\t//本地数据源\r\n");
      out.write("\t\t$.fn.zTree.init($(\"#tree-1\"), {}, nodes1);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tg = $(\"#maingrid\").quiGrid({\r\n");
      out.write("       columns: [ \r\n");
      out.write("\t                { display: '姓名', name: 'name',     align: 'left', width: \"20%\"},\r\n");
      out.write("\t                { display: '性别', name: 'sex',      align: 'left', width: \"20%\"},\r\n");
      out.write("\t                { display: '部门', name: 'deptName', align: 'left', width: \"20%\", isSort:false},\r\n");
      out.write("\t                { display: '学历', name: 'degree',   align: 'left', width: \"20%\" },\r\n");
      out.write("                \t{ display: '操作', isAllowHide: false, align: 'left', width: 80,\r\n");
      out.write("\t\t\t\t\t\t //操作列渲染为图标\r\n");
      out.write("\t\t\t\t\t\t render: function (rowdata, rowindex, value, column){\r\n");
      out.write("\t                 \t    return '<div class=\"padding_top4 padding_left5\">'\r\n");
      out.write("\t                                 + '<span class=\"img_view hand\" title=\"查看\" onclick=\"onView(' + rowdata.id + ')\"></span>'\r\n");
      out.write("\t                                 + '<span class=\"img_edit hand\" title=\"修改\" onclick=\"onEdit(' + rowdata.id + ')\"></span>' \r\n");
      out.write("\t                                 + '<span class=\"img_delete hand\" title=\"删除\" onclick=\"onDelete(' + rowdata.id+','+rowindex + ')\"></span>'\r\n");
      out.write("\t                             + '</div>';\r\n");
      out.write("\t\t                 }\r\n");
      out.write("\t\t            }\r\n");
      out.write("         ], \r\n");
      out.write("        data:gridData, pageSize: 10, sortName: 'id',rownumbers:true,checkbox:true,\r\n");
      out.write("        height: '100%', width:\"100%\",\r\n");
      out.write("        //顶部图标按钮栏\r\n");
      out.write("\t\ttoolbar: \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\titems: [\r\n");
      out.write("                { text: '新增', click: addUser, iconClass: 'icon_add' },\r\n");
      out.write("                { line: true },\r\n");
      out.write("                { text: '批量删除', click: deleteUser, iconClass: 'icon_delete' },\r\n");
      out.write("                { line: true },\r\n");
      out.write("                { text: '导入', click: importUser, iconClass: 'icon_import' },\r\n");
      out.write("                { line: true },\r\n");
      out.write("                { text: '导出当前页', click: exportUser, iconClass: 'icon_export' },\r\n");
      out.write("                { line: true },\r\n");
      out.write("                { text: '导出所有', click: exportUser2, iconClass: 'icon_export' }\r\n");
      out.write("            ]\r\n");
      out.write("        }\r\n");
      out.write("         });\r\n");
      out.write("\t}\r\n");
      out.write("\t//添加\r\n");
      out.write("\tfunction addUser() {\r\n");
      out.write("\t\ttop.Dialog.open({URL:\"../../sample_html/layout/user-management-content.html\",Title:\"新增\",Width:500,Height:330}); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//批量删除\r\n");
      out.write("\tfunction deleteUser() {\r\n");
      out.write("\t\ttop.Dialog.alert(\"向后台发送ajax请求来批量删除。见JAVA版或.NET版演示。\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//导入\r\n");
      out.write("\tfunction importUser() {\r\n");
      out.write("\t\ttop.Dialog.alert(\"见JAVA版或.NET版演示。\");\r\n");
      out.write("\t}\r\n");
      out.write("\t//导出\r\n");
      out.write("\tfunction exportUser() {\r\n");
      out.write("\t\ttop.Dialog.alert(\"见JAVA版或.NET版演示。\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//导出所有\r\n");
      out.write("\tfunction exportUser2() {\r\n");
      out.write("\t\ttop.Dialog.alert(\"见JAVA版或.NET版演示。\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//查看\r\n");
      out.write("\tfunction onView(rowid){\r\n");
      out.write("\t\talert(\"选择的记录Id是:\" + rowid );\r\n");
      out.write("\t\ttop.Dialog.open({URL:\"../../sample_html/layout/user-management-content2.html\",Title:\"查看\",Width:500,Height:330}); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//修改\r\n");
      out.write("\tfunction onEdit(rowid){\r\n");
      out.write("\t\ttop.Dialog.alert(\"见JAVA版或.NET版演示。\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//删除\r\n");
      out.write("\tfunction onDelete(rowid,rowidx){\r\n");
      out.write("\t\ttop.Dialog.confirm(\"确定要删除该记录吗？\",function(){\r\n");
      out.write("\t\t  \ttop.Dialog.alert(\"向后台发送ajax请求来删除。见JAVA版或.NET版演示。\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("function customHeightSet(contentHeight){\r\n");
      out.write("\t\t$(\".cusBoxContent\").height(contentHeight-55)\r\n");
      out.write("\t}\r\n");
      out.write("</script>\t\r\n");
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
