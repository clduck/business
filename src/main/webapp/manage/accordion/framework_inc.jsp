<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<% 
	String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>

<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>


<!-- 树型抽屉导航start-->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/libs/js/nav/treeAccordion_normal.js"></script>
<!-- 树型抽屉导航end -->

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->

<!--表单异步提交start-->
<script src="<%=path%>/libs/js/form/form.js" type="text/javascript"></script>
<!--表单异步提交end-->

<!--动画方式入场效果start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/jomino.js"></script>
<!--动画方式入场效果end  -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

<!-- 软键盘控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/keypad.js"></script>
<!-- 软键盘控件end -->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

<!-- 组合下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectCustom.js"></script>
<!-- 组合拉框end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!--修正IE6不支持PNG图start-->
<style>
img {
	behavior:url("<%=path%>/libs/js/method/pngFix/pngbehavior.htc");
}
</style>
<!--修正IE6不支持PNG图end-->


<script type="text/javascript">
	var path = '<%=path%>';
	//获取父页面
	function getParent(){
		return top.frmright;
	}
	
</script>