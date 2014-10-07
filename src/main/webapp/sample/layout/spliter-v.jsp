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
<body >
	<div class="cusBoxContent1" style="background-color:#eeeeee;">
		上部分内容
	</div>			
	<div class="spliter spliterStyleH" id="spliter-1" targetId="bottomContent" init="show" beforeClickTip="展开下侧内容" 
	afterClickTip="收缩上侧内容" beforeClickClass="spliterBottom" afterClickClass="spliterTop"></div>
	<div id="bottomContent" style="height:200px;background-color:#999999;">
		下部区域
	</div>	
<script type="text/javascript">
	var fixObjHeight=200;
	function initComplete(){
		$("#spliter-1").bind("stateChange",function(e,state){
			if(state=="show"){
				fixObjHeight=200;
			}
			else if(state=="hide"){
				fixObjHeight=10;
			}
			triggerCustomHeightSet();
		})
	}
	function customHeightSet(contentHeight){
		$(".cusBoxContent1").height(contentHeight-fixObjHeight);
	}
</script>
</body>
</html>