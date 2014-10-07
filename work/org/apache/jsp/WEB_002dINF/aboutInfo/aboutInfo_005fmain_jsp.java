package org.apache.jsp.WEB_002dINF.aboutInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aboutInfo_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t\t\t\t<td>企业名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"searchInput\" name=\"conditions.aboutName\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td><button type=\"button\" onclick=\"searchHandler()\"><span class=\"icon_find\">查询</span></button></td>\r\n");
      out.write("\t\t\t\t\t\t<td><button type=\"button\" onclick=\"resetSearch()\"><span class=\"icon_reload\">重置</span></button></td>\r\n");
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
      out.write("\t\t{ id:1,  parentId:0, name:\"中心1\", open: true,icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:11, parentId:1, name:\"部门1\",icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:12, parentId:1, name:\"部门2\",icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:13, parentId:1, name:\"部门3\",icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:2,  parentId:0, name:\"中心2\", open: true,icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:21, parentId:2, name:\"部门4\",icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:22, parentId:2, name:\"部门5\",icon:path+\"/libs/icons/user_group.gif\"},\r\n");
      out.write("\t\t{ id:23, parentId:2, name:\"部门6\",icon:path+\"/libs/icons/user_group.gif\"}\r\n");
      out.write("\t];\r\n");
      out.write("\t\r\n");
      out.write("\t//数据表格使用\r\n");
      out.write("    var grid;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction initComplete(){\r\n");
      out.write("\t  //本地数据源\r\n");
      out.write("\t  $.fn.zTree.init($(\"#tree-1\"), {}, nodes1);\r\n");
      out.write("\t  grid = $(\"#maingrid\").quiGrid({\r\n");
      out.write("       columns: [ \r\n");
      out.write("\t                { display: '企业ID', name: 'aboutID',     align: 'left', width: \"20%\"},\r\n");
      out.write("\t                { display: '企业名称', name: 'aboutName',      align: 'left', width: \"20%\"},\r\n");
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
      out.write("        url: path+'/aboutInfo/getPages.xhtml', \r\n");
      out.write("        sortName: 'aboutID',\r\n");
      out.write("        rownumbers:true,\r\n");
      out.write("        checkbox:true,\r\n");
      out.write("        height: '100%', \r\n");
      out.write("        width:\"100%\",\r\n");
      out.write("        pageSize:10,\r\n");
      out.write("        //顶部图标按钮栏\r\n");
      out.write("\t\ttoolbar: \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\titems: [\r\n");
      out.write("                { text: '新增', click: onAdd, iconClass: 'icon_add' },\r\n");
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
      out.write("        });\r\n");
      out.write("\t  \r\n");
      out.write("\t\t//监听查询框的回车事件\r\n");
      out.write("\t\t$(\"#searchInput\").keydown(function(event){\r\n");
      out.write("\t\t\tif(event.keyCode==13){\r\n");
      out.write("\t\t\t\tsearchHandler();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//添加\r\n");
      out.write("\tfunction onAdd() {\r\n");
      out.write("\t\tvar diag = new top.Dialog();\r\n");
      out.write("\t\tdiag.Title = \"新增\";\r\n");
      out.write("// \t\tdiag.ShowMaxButton=true;\r\n");
      out.write("// \t\tdiag.ShowMinButton=true;\r\n");
      out.write("\t\tdiag.Width=800;\r\n");
      out.write("\t\tdiag.Height=400;\r\n");
      out.write("\t\tdiag.OKEvent = function(){\r\n");
      out.write("\t\t\tvar modelObj = diag.innerFrame.contentWindow.beforeAjaxHander();\r\n");
      out.write("\t\t\tif(modelObj){\r\n");
      out.write("\t\t\t\t$.post(path+\"/aboutInfo/saveAboutInfo.xhtml\",\r\n");
      out.write("\t\t\t\t\t\tmodelObj,\r\n");
      out.write("\t\t\t\t\t\tfunction(result){\r\n");
      out.write("\t\t\t\t\t\t\t top.Dialog.alert(result.msg);\r\n");
      out.write("\t\t\t\t\t\t\t grid.loadData();//加载数据\r\n");
      out.write("\t\t\t\t\t\t\t diag.close();\r\n");
      out.write("\t\t\t\t\t\t},\"json\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tdiag.CancelEvent = function(){\r\n");
      out.write("\t\t\tdiag.close();\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\tdiag.URL = path+\"/aboutInfo/add.xhtml\";\r\n");
      out.write("\t\tdiag.ShowButtonRow=true;\r\n");
      out.write("\t\tdiag.show();\r\n");
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
      out.write("\t\ttop.Dialog.open({URL:path+\"/sample_html/layout/user-management-content2.html\",Title:\"查看\",Width:500,Height:330}); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//修改\r\n");
      out.write("\tfunction onEdit(rowid){\r\n");
      out.write("\t\tvar diag = new top.Dialog();\r\n");
      out.write("\t\tdiag.Title = \"编辑\";\r\n");
      out.write("// \t\tdiag.ShowMaxButton=true;\r\n");
      out.write("// \t\tdiag.ShowMinButton=true;\r\n");
      out.write("\t\tdiag.Width=800;\r\n");
      out.write("\t\tdiag.Height=400;\r\n");
      out.write("\t\tdiag.OKEvent = function(){\r\n");
      out.write("\t\t\tvar modelObj = diag.innerFrame.contentWindow.beforeAjaxHander();\r\n");
      out.write("\t\t\tif(modelObj){\r\n");
      out.write("\t\t\t\t$.post(path+\"/aboutInfo/saveAboutInfo.xhtml\",\r\n");
      out.write("\t\t\t\t\t\tmodelObj,\r\n");
      out.write("\t\t\t\t\t\tfunction(result){\r\n");
      out.write("\t\t\t\t\t\t\t top.Dialog.alert(result.msg);\r\n");
      out.write("\t\t\t\t\t\t\t grid.loadData();//加载数据\r\n");
      out.write("\t\t\t\t\t\t\t diag.close();\r\n");
      out.write("\t\t\t\t\t\t},\"json\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tdiag.CancelEvent = function(){\r\n");
      out.write("// \t\t\talert(\"点击了取消\");\r\n");
      out.write("\t\t\tdiag.close();\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\tdiag.URL = path+\"/aboutInfo/edit.xhtml?rowid=\"+rowid;\r\n");
      out.write("\t\tdiag.ShowButtonRow=true;\r\n");
      out.write("\t\tdiag.show();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//删除\r\n");
      out.write("\tfunction onDelete(rowid,rowidx){\r\n");
      out.write("\t\ttop.Dialog.confirm(\"确定要删除该记录吗？\",function(){\r\n");
      out.write("\t\t  \ttop.Dialog.alert(\"向后台发送ajax请求来删除。见JAVA版或.NET版演示。\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction customHeightSet(contentHeight){\r\n");
      out.write("\t\t$(\".cusBoxContent\").height(contentHeight-55)\r\n");
      out.write("\t}\r\n");
      out.write("\t//查询\r\n");
      out.write("\tfunction searchHandler(){\r\n");
      out.write("\t\tvar query = $(\"#queryForm\").formToArray(); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar modelObj = query;\r\n");
      out.write("\t    grid.setOptions({ params : modelObj});\r\n");
      out.write("\t    //页号重置为1\r\n");
      out.write("\t    grid.setNewPage(1);\r\n");
      out.write("\t    grid.loadData();//加载数据\r\n");
      out.write("\t}\r\n");
      out.write("\t//获取行数据\r\n");
      out.write("\tfunction getRowData(rowid){\r\n");
      out.write("\t\tvar rowData = grid.getRow(rowid);\r\n");
      out.write("\t\treturn rowData;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//重置查询\r\n");
      out.write("\tfunction resetSearch(){\r\n");
      out.write("\t\t$(\"#queryForm\")[0].reset();\r\n");
      out.write("// \t   searchHandler();\r\n");
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
