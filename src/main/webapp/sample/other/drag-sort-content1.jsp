<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--拖拽排序start-->
<script type="text/javascript" src="<%=path%>/libs/js/other/dragsort.js"></script>
<script type="text/javascript">
	function initComplete(){
		$("ul:first").dragsort();
	}
</script>
<!--拖拽排序end-->
<body>
	<ul>
		<li>列表选项1</li>
		<li>列表选项2</li>
		<li>列表选项3</li>
		<li>列表选项4</li>
		<li>列表选项5</li>
		<li>列表选项6</li>
	</ul>
</body>
</html>