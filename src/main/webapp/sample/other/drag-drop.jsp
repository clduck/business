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

<!--拖放与接收start-->
<script type="text/javascript" src="<%=path%>/libs/js/other/dragdrop.js"></script>
<!--拖放与接收end-->
<script type="text/javascript">
	function initComplete(){
		var dragDropObj = new DHTMLgoodies_dragDrop();
		//指定可拖放物体
		dragDropObj.addSource('box1',true);
		dragDropObj.addSource('box2',true);
		dragDropObj.addSource('box3',true);
		dragDropObj.addSource('box4',true);
		//指定可接收物体
		dragDropObj.addTarget('dropBox','dropItems');
		dragDropObj.addTarget('dropBox2','dropItems2');
		dragDropObj.init();
	}
	function dropItems(idOfDraggedItem,targetId,x,y)
	{
		var html = document.getElementById('dropContent').innerHTML;
		if(html.length>0)html = html + '<br>';
		html = html + 'id="' + idOfDraggedItem+'" 的物体被拖放';
		document.getElementById('dropContent').innerHTML = html;
	}
	function dropItems2(idOfDraggedItem,targetId,x,y)
	{
		var html = document.getElementById('dropContent2').innerHTML;
		if(html.length>0)html = html + '<br>';
		html = html + '内容为 "' + document.getElementById(idOfDraggedItem).innerHTML + '" 的物体被拖放';
		document.getElementById('dropContent2').innerHTML = html;
	}
</script>
<style>
	#mainContainer{
		width:600px;
		margin:0 auto;
		margin-top:10px;
		border:1px double #000;
		padding:3px;

	}
	
	#leftColumn{
		width:300px;
		float:left;
		
	}
	#rightColumn{
		width:200px;
		float:right;
		margin:2px;
		height:450px;
	}	
	.dragableBox{
		width:100px;
		height:60px;
		border:1px solid #000;
		background-color:#FFF;		
		margin-bottom:5px;
		padding:10px;
		font-weight:bold;
		text-align:center;
	}
	.dropBox{
		width:190px;
		border:1px solid #000;
		background-color:#E2EBED;
		height:200px;
		overflow:auto;
		margin-bottom:10px;
		padding:3px;
	}		
</style>

<body>
	<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、基本使用</legend>
	<div id="mainContainer">
		<div id="leftColumn">
			<div class="dragableBox" id="box1">可拖放物体1</div>
			<div class="dragableBox" id="box2">可拖放物体2</div>
			<div class="dragableBox" id="box3">可拖放物体3</div>
			<div class="dragableBox" id="box4">可拖放物体4</div>
		</div>
			<div id="rightColumn">
			<div id="dropBox" class="dropBox">
				<p><b>可接收区域1</b></p>
				<div id="dropContent"></div>		
			</div>
			<div id="dropBox2" class="dropBox">
				<p><b>可接收区域2</b></p>
				<div id="dropContent2"></div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="konaBody"></div>
	</div>
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>2、自定义参数</legend>
	通过设置addSource的参数可指定拖拽回调函数和拖放时是否移除自己。<br /><br />
<input type="button" value="点击这里查看效果" onclick='top.Dialog.open({URL:"<%=path%>/sample/other/drag-drop-content1.jsp",Title:"拖放效果",Width:640,Height:460});'/>
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>3、匹配拖拽</legend>
	通过拖拽和接收物体的id可实现匹配拖拽。见下面示例<br /><br />
<input type="button" value="点击这里查看效果" onclick='top.Dialog.open({URL:"<%=path%>/sample/other/drag-drop-content2.jsp",Title:"拖放效果",Width:640,Height:460});'/>	
  </fieldset>
  <div class="height_15"></div>
  
  
</div>
</body>
</html>