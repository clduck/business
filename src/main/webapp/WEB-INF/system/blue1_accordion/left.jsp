<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%
 	String iconPath = "/business/system/blue1_accordion";
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<jsp:include page="/manage/accordion/framework_inc.jsp" flush="false" />
<!--框架必需end-->
<style>
	.ztree li span.zbutton.diy01_ico_open, .ztree li span.zbutton.diy01_ico_close{width:24px!important;height:24px!important;padding-top:0;}
</style>
<script type="text/javascript">
	var zNodes =[
		{ id:3001, parentId:0, name:"表单模板",icon:"<%=iconPath%>/skin/icons/icon_1.png",iconSkin:"diy01"},
		{ id:101, parentId:3001, name:"页面中的表单",url:"<%=path%>/aboutInfo/do.xhtml", target:"frmright",iconOpen:"<%=path%>/libs/icons/tree_close.gif",iconClose:"<%=path%>/libs/icons/tree_open.gif",icon:"<%=iconPath%>/skin/titlebar_arrow.gif"},
		{ id:102, parentId:3001, name:"弹窗中的表单",url:"<%=path%>/sample_skin/normal/form-pop.html", target:"frmright",iconOpen:"<%=path%>/libs/icons/tree_close.gif",iconClose:"<%=path%>/libs/icons/tree_open.gif",icon:"<%=iconPath%>/skin/titlebar_arrow.gif"}
		
		
	];
	
	var fixedObj=60;
	function customHeightSet(contentHeight){
		$("#scrollContent").height(contentHeight-fixedObj);
	}
</script>
</head>

<body leftFrame="true">
<div class="padding_top5 ali02" style="height:55px;">
<table width="100%">
	<tr>
		<td width="85%" class="ali03"><input type="text" id="searchKey" value=""></td>
		<td><span class="img_find hand" title="点击查找节点" keepDefaultStyle="true" onclick="findNode()"></span></td>
	</tr>
	<tr>
		<td colspan="2" class="ali02"><a onclick="showAll()">全部展开</a>&nbsp;&nbsp;<a onclick="hideAll()">全部收缩</a></td>
	</tr>
</table>
</div>
<div id="scrollContent" style="overflow-x:hidden;">
	<div>
		<ul id="treeDemo" class="ztree ztree_accordition"></ul>
	</div>
</div>				
</body>
</html>