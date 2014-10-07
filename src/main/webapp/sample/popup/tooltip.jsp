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
     <legend>1、span标签</legend>
		<span title="不超过5字">小尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。">中尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。">大尺寸提示</span><br />
		<div class="height_10"></div>
		<span title="图片过大<br/>会<span style='color:red;'>撑坏</span>网页结构。">提示信息含html元素</span>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>2、div标签</legend>
		<div title="在div标签加入title属性" style="width:200px;background-color:#eeeeee">这是在div中的内容</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>3、a标签</legend>
		<a title="这是一个链接提示">查看</a>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>4、表单元素</legend>
		<input  type="text" title="在这里输入查询条件"/>
		<div class="height_5"></div>
		<textarea title="请限制在200个字内"></textarea>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>5、图片</legend>
		<img src="<%=path%>/libs/images/demo/demo1.jpg" title="图片提示信息"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>6、动态添加提示</legend>
		<input type="button" id="addTitle" value="点击后鼠标重新移入按钮上" onclick="addTip()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>7、动态更改提示信息</legend>
		<input type="button" id="changeTitle" value="点击后鼠标重新移入按钮上" title="前进"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>8、强制让提示消失</legend>
     	未设置时，在IE的效果为：按钮移动，但提示仍然在原来的位置：<br/>
		<input type="button" id="hideTip" value="点击移动" title="提示信息"/><br/>
		设置后效果：按钮移动，提示消失<br/>
		<input type="button" id="hideTip2" value="点击移动" title="提示信息"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>9、第二种提示(非鼠标移入触发)</legend>
     	下面的是onfocus事件触发：<br />
		<input type="text" onfocus="$.cursorMessage('注意不能输入特殊字符');"/><br />
		下面的是onchange事件触发：<br />
		<script>
		function selFunc(){
			$.cursorMessage("选择了："+$("#sel").attr("relText"));
		}
		</script>		
		<select  onchange='selFunc()' id="sel">
		    <option value="">请选择功能</option>
		    <option value="1">新增图片</option>
		    <option value="2">维护图片</option>
		    <option value="3">新增新闻</option>
		</select><br />		
		下面的是onkeydown事件触发：<br />
		<textarea onkeydown="$.cursorMessage('填写详细有助于我们更好地服务');"></textarea>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>不使用提示特效</legend>
     	<img src="<%=path%>/libs/images/demo/demo1.jpg" title="系统默认提示效果" keepDefaultStyle="true"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	</div>

<script>
		$(document).ready(function(){
			$("#changeTitle").toggle(function(){
				$("#changeTitle").attr("title","后退");
				addTooltip($("#changeTitle")[0]);
			},function(){
				$("#changeTitle").attr("title","前进");
				addTooltip($("#changeTitle")[0]);
			})
			
			$("#hideTip").toggle(function(){
				$("#hideTip").animate({
					"marginLeft":"200px"
				})
			},function(){
				$("#hideTip").animate({
					"marginLeft":0
				})
			})
			
			$("#hideTip2").toggle(function(){
				//元素移动
				$("#hideTip2").animate({
					"marginLeft":"200px"
				})
				//强制提示消失一次
				hideTooltip();
			},function(){
				$("#hideTip2").animate({
					"marginLeft":0
				})
				hideTooltip()
			})
		})
		function addTip(){
			$("#addTitle").attr("title","新添加的提示");
			addTooltip($("#addTitle")[0]);
		}
</script>
</body>
</html>