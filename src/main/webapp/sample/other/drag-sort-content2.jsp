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
<!--拖拽排序end-->
<script type="text/javascript">
	function initComplete(){
		$("#list1, #list2").dragsort({ dragSelector: "div", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li class='placeHolder'><div></div></li>" });
	}
	function saveOrder() {
		var serialStr = "";
		$("#list1 li").each(function(i, elm) { serialStr += (i > 0 ? "|" : "") + $(elm).children().html(); });
		$("input[name=list1SortOrder]").val(serialStr);
	};
</script>
<style>
	#list1, #list2 { width:350px; list-style-type:none; margin:0px; }
	#list1 li, #list2 li { float:left; padding:5px; width:100px; height:100px; }
	#list1 div, #list2 div { width:90px; height:50px; border:solid 1px black; background-color:#E0E0E0; text-align:center; padding-top:40px; }
	#list2 { float:right; }
	.placeHolder div { background-color:white !important; border:dashed 1px gray !important; }
</style>

<body>
<ul id="list2">
	<li><div>10</div></li>
	<li><div>11</div></li>
	<li><div>12</div></li>
	<li><div>13</div></li>
	<li><div>14</div></li>
	<li><div>15</div></li>
	<li><div>16</div></li>
	<li><div>17</div></li>
	<li><div>18</div></li>
</ul>

<ul id="list1">
	<li><div>1</div></li>
	<li><div>2</div></li>
	<li><div>3</div></li>
	<li><div>4</div></li>
	<li><div>5</div></li>
	<li><div>6</div></li>
	<li><div>7</div></li>
	<li><div>8</div></li>
	<li><div>9</div></li>
</ul>
<input name="list1SortOrder" type="hidden" />
</body>
</html>