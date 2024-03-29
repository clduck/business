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
<script>
	var dragDropObj
	function initComplete(){
		dragDropObj = new DHTMLgoodies_dragDrop();
		dragDropObj.addSource('box1',true,true,true,false,'onDragFunction');
		dragDropObj.addSource('box2',true,true,true,false,'onDragFunction');
		dragDropObj.addSource('box3',true,true,true,false,'onDragFunction');
		dragDropObj.addSource('box4',true,true,true,false,'onDragFunction');
		dragDropObj.addTarget('dropBox','dropItems');
		dragDropObj.addTarget('leftColumn','dropItems');
		dragDropObj.init();
	}
	function dropItems(idOfDraggedItem,targetId,x,y)
	{
		if(targetId=='dropBox'){
			var obj = document.getElementById(idOfDraggedItem);
			if(obj.parentNode.id=='dropContent2')return;		
			document.getElementById('dropContent2').appendChild(obj);
		}
		if(targetId=='leftColumn'){
			var obj = document.getElementById(idOfDraggedItem);
			if(obj.parentNode.id=='dropContent')return;	
			document.getElementById('dropContent').appendChild(obj);
		}
	}
	function onDragFunction(cloneId,origId)
	{
		var obj = document.getElementById(cloneId);
		obj.style.border='1px solid #F00';
	}
</script>
<style type="text/css">
	#mainContainer{
		width:600px;
		margin:0 auto;
		margin-top:10px;
		border:1px solid #000;
		padding:2px;
	}
	
	#leftColumn{
		width:300px;
		float:left;
		border:1px solid #000;
		background-color:#E2EBED;
		padding:3px;
		height:400px;
	}
	#rightColumn{
		width:200px;
		float:right;
		margin:2px;
		height:400px;
	}	
	.dragableBox{
		width:100px;
		height:40px;
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
		height:400px;
		margin-bottom:10px;
		padding:3px;
		overflow:auto;
	}		
</style>	
<!--拖放与接收end-->
<body>
	<div id="mainContainer">
		<div id="leftColumn">
			<div id="dropContent">
				<div class="dragableBox" id="box1">可拖放物体1</div>
				<div class="dragableBox" id="box2">可拖放物体2</div>
				<div class="dragableBox" id="box3">可拖放物体3</div>
				<div class="dragableBox" id="box4">可拖放物体4</div>
			</div>
		</div>
			<div id="rightColumn">
			<div id="dropBox" class="dropBox">
				<p><b>可接收区域</b></p>
				<div id="dropContent2"></div>		
			</div>
		</div>
		<div class="clear"></div>
		<div class="konaBody">
		<a href="#" onclick="dragDropObj.setSlide(false);return false">关闭动画效果</a> | <a href="#" onclick="dragDropObj.setSlide(true);return false">开启动画效果</a>
		</div>
	</div>
</body>
</html>