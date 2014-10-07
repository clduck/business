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
	function initComplete(){
		var dragDropObj = new DHTMLgoodies_dragDrop();
		dragDropObj.addSource('box1',true);	
		dragDropObj.addSource('box2',true);	
		dragDropObj.addSource('box3',true);	
		dragDropObj.addSource('box4',true);	
		dragDropObj.addSource('box5',true);	
		dragDropObj.addSource('box6',true);	
		dragDropObj.addSource('box7',true);	
		dragDropObj.addTarget('box101','dropItems');
		dragDropObj.addTarget('box102','dropItems'); 
		dragDropObj.addTarget('box103','dropItems'); 
		dragDropObj.addTarget('box104','dropItems'); 
		dragDropObj.addTarget('box105','dropItems');
		dragDropObj.addTarget('box106','dropItems');
		dragDropObj.addTarget('box107','dropItems'); 
		dragDropObj.addTarget('capitals','dropItems');
		dragDropObj.init();
	}
	function dropItems(idOfDraggedItem,targetId,x,y)
	{
		var targetObj = document.getElementById(targetId);
		var subDivs = targetObj.getElementsByTagName('DIV');
		if(subDivs.length>0 && targetId!='capitals')return;	
		var sourceObj = document.getElementById(idOfDraggedItem);
		var numericIdTarget = targetId.replace(/[^0-9]/gi,'')/1;
		var numericIdSource = idOfDraggedItem.replace(/[^0-9]/gi,'')/1;
		if(numericIdTarget-numericIdSource==100){
			sourceObj.style.backgroundColor='#0F0';	
		}else{
			sourceObj.style.backgroundColor='';	
		}
		if(targetId=='capitals'){
			targetObj = targetObj.getElementsByTagName('DIV')[0];	
		}
		targetObj.appendChild(sourceObj);
	}
</script>
<style type="text/css">
	#mainContainer{
		width:600px;
		margin:0 auto;
		margin-top:10px;
		border:1px solid #000;
		padding:2px;
		font-size:18px;
	}
	
	#capitals{
		width:200px;
		float:right;
		border:1px solid #000;
		background-color:#E2EBED;
		padding:3px;
		height:400px;
	}
	#countries{
		width:300px;
		float:left;
		margin:2px;
		height:400px;
	}	
	.dragableBox,.dragableBoxRight{
		width:80px;
		height:20px;
		border:1px solid #000;
		background-color:#FFF;		
		margin-bottom:5px;
		padding:10px;
		font-weight:bold;
		text-align:center;
	}
	div.dragableBoxRight{
		height:65px;
		width:110px;
		float:left;
		margin-right:5px;
		padding:5px;
		background-color:#E2EBED;
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
		<div id="countries">
			<p><b>问题</b></p>
			<div id="box106" class="dragableBoxRight">2x6=?</div>
			<div id="box107" class="dragableBoxRight">2x7=?</div>
			<div id="box101" class="dragableBoxRight">2x1=?</div>
			<div id="box104" class="dragableBoxRight">2x4=?</div>
			<div id="box105" class="dragableBoxRight">2x5=?</div>
			<div id="box102" class="dragableBoxRight">2x2=?</div>
			<div id="box103" class="dragableBoxRight">2x3=?</div>
		</div>
		<div id="capitals">
			<p><b>选项</b></p>
			<div id="dropContent">
				<div class="dragableBox" id="box1">2</div>
				<div class="dragableBox" id="box2">4</div>
				<div class="dragableBox" id="box3">6</div>
				<div class="dragableBox" id="box4">8</div>
				<div class="dragableBox" id="box5">10</div>
				<div class="dragableBox" id="box6">12</div>
				<div class="dragableBox" id="box7">14</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>				
</body>
</html>