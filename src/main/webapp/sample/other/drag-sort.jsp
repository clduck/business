<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、列表拖拽排序</legend>
	<input type="button" value="点击查看效果" onclick='top.Dialog.open({URL:"<%=path%>/sample/other/drag-sort-content1.jsp",Title:"列表拖拽效果",Width:300,Height:200});'/>	
  </fieldset>
  <div class="height_15"></div>
  
  
   <fieldset>
   <legend>2、容器拖拽排序</legend>
   <input type="button" value="点击查看效果" onclick='top.Dialog.open({URL:"<%=path%>/sample/other/drag-sort-content2.jsp",Title:"容器拖拽效果",Width:740,Height:500});'/>	
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>