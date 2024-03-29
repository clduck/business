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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--分隔条start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/spliter.js"></script>
<!--分隔条end-->
</head>
<body>
 	<table width="100%" cellpadding="0" cellspacing="0" class="table_border0">
 		<tr>
		<td id="leftContent" class="ver01 ali01">
				<div class="cusBoxContent" style="width:200px;background-color:#eeeeee;">
					这是左侧区域
				</div>
		</td>
		
		<td class="spliter spliterStyleV" id="spliter-left" targetId="leftContent" beforeClickTip="收缩左侧内容"
		 afterClickTip="展开左侧内容" beforeClickClass="spliterLeft" afterClickClass="spliterRight"></td>
		
		<td class="ali01 ver01"  width="100%">
			<div id="topContent" style="height:150px;background-color:#cccccc;">
				上部区域
			</div>
			
			<div class="spliter spliterStyleH" id="spliter-top" targetId="topContent" beforeClickTip="收缩上侧内容" 
			afterClickTip="展开上侧内容" beforeClickClass="spliterTop" afterClickClass="spliterBottom"></div>
			
			<div id="middleContent" style="background-color:#ffffff;">
				内容区域
			</div>
			
			<div class="spliter spliterStyleH" id="spliter-bottom" targetId="bottomContent" init="hide" beforeClickTip="展开下侧内容" 
			afterClickTip="收缩上侧内容" beforeClickClass="spliterTop" afterClickClass="spliterBottom"></div>
			
			<div id="bottomContent" style="height:150px;background-color:#aaaaaa;">
				下部区域
			</div>
		</td>
		
		<td class="spliter spliterStyleV" id="spliter-right" targetId="rightContent" init="hide" beforeClickTip="展开右侧内容" 
		afterClickTip="收缩右侧内容" beforeClickClass="spliterLeft" afterClickClass="spliterRight"></td>
		
		<td id="rightContent" class="ver01 ali01">
				<div class="cusBoxContent" style="width:200px;background-color:#999999;">
					这是右侧区域
				</div>
		</td>
	</tr>
</table>
<script type="text/javascript">
	var fixObjHeightTop=160;
	var fixObjHeightBottom=10;
	function initComplete(){
		$("#spliter-top").bind("stateChange",function(e,state){
			if(state=="show"){
				fixObjHeightTop=160;
			}
			else if(state=="hide"){
				fixObjHeightTop=10;
			}
			triggerCustomHeightSet();
		})
		$("#spliter-bottom").bind("stateChange",function(e,state){
			if(state=="show"){
				fixObjHeightBottom=160;
			}
			else if(state=="hide"){
				fixObjHeightBottom=10;
			}
			triggerCustomHeightSet();
		})
	}
	function customHeightSet(contentHeight){
		$(".cusBoxContent").height(contentHeight);
		$("#spliter-left").height(contentHeight);
		$("#spliter-right").height(contentHeight);
		$("#middleContent").height(contentHeight-fixObjHeightTop-fixObjHeightBottom);
	}
</script>
</body>
</html>