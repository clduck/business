<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 树start-->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
	var setting = {
		callback: {
			onClick: onClick
		}
	};
	
	
	var zNodes =[
		
		{ id:3000, parentId:0, name:"常用资源索引"},
		{ id:002, parentId:3000, name:"CSS库索引",url:"<%=path%>/sample/index/css.jsp", target:"frmright"},
		{ id:003, parentId:3000, name:"图标库索引",url:"<%=path%>/sample/index/icons.jsp", target:"frmright"},
		
		{ id:3001, parentId:0, name:"多功能容器"},
		{ id:101, parentId:3001, name:"box1",url:"<%=path%>/sample/box/box1.jsp", target:"frmright" ,title:"box1"},
		{ id:102, parentId:3001, name:"box2",url:"<%=path%>/sample/box/box2.jsp", target:"frmright", title:"box2"},
		
		{ id:3002, parentId:0, name:"提示类组件"},
		{ id:201, parentId:3002, name:"鼠标提示",url:"<%=path%>/sample/popup/tooltip.jsp", target:"frmright",title:"title"},
		{ id:202, parentId:3002, name:"弹窗",url:"<%=path%>/sample/popup/window.jsp", target:"frmright",title:"Dialog"},
		{ id:203, parentId:3002, name:"浮动面板",url:"<%=path%>/sample/popup/floating.jsp", target:"frmright",title:"floatPanel"},
		{ id:204, parentId:3002, name:"展出式提示框",url:"<%=path%>/sample/popup/messager.jsp", target:"frmright",title:"messager"},
		
		{ id:3003, parentId:0, name:"树组件*"},
		{ id:301, parentId:3003, name:"基本使用*",url:"<%=path%>/sample/tree/basic.jsp", target:"frmright",title:"基本使用"},
		{ id:302, parentId:3003, name:"异步加载数据*",url:"<%=path%>/sample/tree/async.jsp", target:"frmright",title:"异步加载数据"},
		{ id:303, parentId:3003, name:"添加复选框",url:"<%=path%>/sample/tree/checktree.jsp", target:"frmright",title:"添加复选框"},
		{ id:304, parentId:3003, name:"树的拖拽",url:"<%=path%>/sample/tree/dragdrop.jsp", target:"frmright",title:"树的拖拽"},
		{ id:305, parentId:3003, name:"树其他DOM节点拖拽",url:"<%=path%>/sample/tree/dragdrop-other.jsp", target:"frmright",title:"树其他DOM节点拖拽"},
		{ id:306, parentId:3003, name:"树的编辑",url:"<%=path%>/sample/tree/edit.jsp", target:"frmright",title:"树的编辑"},
		{ id:307, parentId:3003, name:"右键菜单",url:"<%=path%>/sample/tree/contextmenu.jsp", target:"frmright",title:"右键菜单"},
		{ id:308, parentId:3003, name:"自定义外观",url:"<%=path%>/sample/tree/style-custom.jsp", target:"frmright",title:"自定义外观"},
		{ id:309, parentId:3003, name:"添加自定义控件",url:"<%=path%>/sample/tree/diy-dom.jsp", target:"frmright",title:"添加自定义控件"},
		{ id:310, parentId:3003, name:"节点隐藏",url:"<%=path%>/sample/tree/node-hide.jsp", target:"frmright",title:"节点隐藏"},
		{ id:311, parentId:3003, name:"树的分页",url:"<%=path%>/sample/tree/page.jsp", target:"frmright",title:"树的分页"},
		
		{ id:3004, parentId:0, name:"表单元素*"},
		{ id:401, parentId:3004, name:"文本框",url:"<%=path%>/sample/form/textinput-password.jsp", target:"frmright",title:"textinput/password"},
		{ id:402, parentId:3004, name:"文本域",url:"<%=path%>/sample/form/textarea.jsp", target:"frmright",title:"textarea"},
		{ id:403, parentId:3004, name:"基本按钮",url:"<%=path%>/sample/form/button.jsp", target:"frmright",title:"button"},
		{ id:404, parentId:3004, name:"单选按钮",url:"<%=path%>/sample/form/radio.jsp", target:"frmright",title:"radio"},
		{ id:405, parentId:3004, name:"多选按钮",url:"<%=path%>/sample/form/checkbox.jsp", target:"frmright",title:"checkbox"},
		{ id:406, parentId:3004, name:"单选下拉框*",url:"<%=path%>/sample/form/select-single.jsp", target:"frmright",title:"select"},
		{ id:407, parentId:3004, name:"树形下拉框*",url:"<%=path%>/sample/form/select-tree.jsp", target:"frmright",title:"selectTree"},
		{ id:408, parentId:3004, name:"多选下拉框*",url:"<%=path%>/sample/form/select-multi.jsp", target:"frmright",title:"selectTree multi"},
		{ id:409, parentId:3004, name:"组合下拉框*",url:"<%=path%>/sample/form/select-custom.jsp", target:"frmright",title:"selectCustom"},
		{ id:410, parentId:3004, name:"自动提示框*",url:"<%=path%>/sample/form/suggestion.jsp", target:"frmright",title:"suggestion"},
		{ id:411, parentId:3004, name:"日期选择器",url:"<%=path%>/sample/form/date.jsp", target:"frmright",title:"date"},
		{ id:412, parentId:3004, name:"双向选择器*",url:"<%=path%>/sample/form/lister.jsp", target:"frmright",title:"lister"},
		{ id:413, parentId:3004, name:"树形双选器*",url:"<%=path%>/sample/form/lister-tree.jsp", target:"frmright",title:"listerTree"},
		{ id:414, parentId:3004, name:"条件过滤器*",url:"<%=path%>/sample/form/filter.jsp", target:"frmright",title:"filter"},
		{ id:415, parentId:3004, name:"颜色选择器",url:"<%=path%>/sample/form/color.jsp", target:"frmright",title:"color"},
		{ id:416, parentId:3004, name:"数字步进器",url:"<%=path%>/sample/form/stepper.jsp", target:"frmright",title:"stepter"},
		{ id:417, parentId:3004, name:"软键盘控件",url:"<%=path%>/sample/form/keypad.jsp", target:"frmright",title:"keypad"},
		{ id:418, parentId:3004, name:"评星级控件",url:"<%=path%>/sample/form/rating.jsp", target:"frmright",title:"rating"},
		{ id:419, parentId:3004, name:"异步上传控件*",url:"<%=path%>/sample/form/fileupload.jsp", target:"frmright",title:"fileUpload"},
		{ id:420, parentId:3004, name:"上传文件列表*",url:"<%=path%>/sample/form/filelist.jsp", target:"frmright",title:"fileList"},
		{ id:421, parentId:3004, name:"同步上传控件*",url:"<%=path%>/sample/form/file.jsp", target:"frmright",title:"file"},
		
		
		{ id:3005, parentId:0, name:"综合表单*"},
		{ id:501, parentId:3005, name:"表单布局",url:"<%=path%>/sample/fullform/layout.jsp", target:"frmright",title:"table"},
		{ id:502, parentId:3005, name:"表单验证*",url:"<%=path%>/sample/fullform/validation.jsp", target:"frmright",title:"validation"},
		{ id:503, parentId:3005, name:"表单拆分",url:"<%=path%>/sample/fullform/step.jsp", target:"frmright",title:"stepForm"},
		{ id:504, parentId:3005, name:"同步提交*",url:"<%=path%>/sample/fullform/submit.jsp", target:"frmright"},
		{ id:505, parentId:3005, name:"同步编辑*",url:"<%=path%>/preEditWebform.action", target:"frmright"},
		{ id:506, parentId:3005, name:"异步提交*",url:"<%=path%>/sample/fullform/submit-ajax.jsp", target:"frmright"},
		{ id:507, parentId:3005, name:"异步弹窗提交",url:"<%=path%>/sample/fullform/submit-ajax-pop.jsp", target:"frmright"},
		{ id:508, parentId:3005, name:"异步编辑-标签赋值*",url:"<%=path%>/preEditWebform.action?ajax=1", target:"frmright"},
		{ id:509, parentId:3005, name:"异步编辑-JSON赋值*",url:"<%=path%>/sample/fullform/edit-ajax-notag.jsp", target:"frmright"},
		{ id:510, parentId:3005, name:"动态创建表单并赋值",url:"<%=path%>/sample/fullform/create-form.jsp", target:"frmright"},
		{ id:511, parentId:3005, name:"大量表单元素方案",url:"<%=path%>/sample/fullform/large-elements.jsp", target:"frmright"},
		
		{ id:3006, parentId:0, name:"grid表格*"},
		{ id:601, parentId:3006, name:"使用url*",url:"<%=path%>/sample/datagrid/basic-url.jsp", target:"frmright"},
		{ id:602, parentId:3006, name:"使用远程data*",url:"<%=path%>/sample/datagrid/basic-data.jsp", target:"frmright"},
		{ id:603, parentId:3006, name:"使用本地数据",url:"<%=path%>/sample/datagrid/basic-local.jsp", target:"frmright"},
		{ id:604, parentId:3006, name:"对行列渲染",url:"<%=path%>/sample/datagrid/render.jsp", target:"frmright"},
		{ id:605, parentId:3006, name:"锁定列",url:"<%=path%>/sample/datagrid/lock.jsp", target:"frmright"},
		{ id:606, parentId:3006, name:"多表头支持",url:"<%=path%>/sample/datagrid/multiheader.jsp", target:"frmright"},
		{ id:607, parentId:3006, name:"弹窗中的表格",url:"<%=path%>/sample/datagrid/basic-pop.jsp", target:"frmright"},
		{ id:608, parentId:3006, name:"表格动态操作",url:"<%=path%>/sample/datagrid/dynamic.jsp", target:"frmright"},
		{ id:609, parentId:3006, name:"树形表格*",url:"<%=path%>/sample/datagrid/treegrid.jsp", target:"frmright"},
		{ id:610, parentId:3006, name:"父子表格*",url:"<%=path%>/sample/datagrid/detailgrid.jsp", target:"frmright"},
		{ id:611, parentId:3006, name:"分组表格",url:"<%=path%>/sample/datagrid/group.jsp", target:"frmright"},
		{ id:612, parentId:3006, name:"数据汇总",url:"<%=path%>/sample/datagrid/summary.jsp", target:"frmright"},
		{ id:613, parentId:3006, name:"内容格式化",url:"<%=path%>/sample/datagrid/format.jsp", target:"frmright"},
		{ id:614, parentId:3006, name:"动态选中",url:"<%=path%>/sample/datagrid/checkrows.jsp", target:"frmright"},
		{ id:615, parentId:3006, name:"选中项分页记忆",url:"<%=path%>/sample/datagrid/checkrows-memory.jsp", target:"frmright"},
		{ id:616, parentId:3006, name:"动态切换表格",url:"<%=path%>/sample/datagrid/change-grid.jsp", target:"frmright"},
		{ id:617, parentId:3006, name:"动态设置url*",url:"<%=path%>/sample/datagrid/seturl.jsp", target:"frmright"},
		{ id:618, parentId:3006, name:"滚动条位置",url:"<%=path%>/sample/datagrid/scroll-to.jsp", target:"frmright"},
		{ id:619, parentId:3006, name:"工具栏权限控制",url:"<%=path%>/sample/datagrid/toolbar.jsp", target:"frmright"},
		{ id:620, parentId:3006, name:"大数据测试",url:"<%=path%>/sample/datagrid/large-data.jsp", target:"frmright"},
		
		
		{ id:3007, parentId:0, name:"table表格*"},
		{ id:701, parentId:3007, name:"特性举例",url:"<%=path%>/sample/table/guide.jsp", target:"frmright"},
		{ id:702, parentId:3007, name:"基本表格模板*",url:"<%=path%>/getUsersBasic.action", target:"frmright"},
		{ id:703, parentId:3007, name:"含横向滚动条",url:"<%=path%>/sample/table/scroll.jsp", target:"frmright"},
		{ id:704, parentId:3007, name:"多表头支持",url:"<%=path%>/sample/table/multiheader.jsp", target:"frmright"},
		{ id:705, parentId:3007, name:"弹窗中的表格",url:"<%=path%>/sample/table/basic-pop.jsp", target:"frmright"},
		{ id:706, parentId:3007, name:"表格动态操作",url:"<%=path%>/sample/table/dynamic.jsp", target:"frmright"},
		{ id:707, parentId:3007, name:"树形表格*",url:"<%=path%>/sample/table/treetable.jsp", target:"frmright"},
		{ id:708, parentId:3007, name:"父子表格*",url:"<%=path%>/sample/table/detailtable.jsp", target:"frmright"},
		{ id:709, parentId:3007, name:"列表性能优化方案",url:"<%=path%>/sample/table/improve.jsp", target:"frmright"},
		
		{ id:3008, parentId:0, name:"导航组件"},
		{ id:801, parentId:3008, name:"弹出菜单",url:"<%=path%>/sample/nav/menu-popup.jsp", target:"frmright"},
		{ id:802, parentId:3008, name:"右键菜单",url:"<%=path%>/sample/nav/menu-rightclick.jsp", target:"frmright"},
		{ id:803, parentId:3008, name:"个性化菜单(篮子)",url:"<%=path%>/sample/nav/menu-basket.jsp", target:"frmright"},
		{ id:804, parentId:3008, name:"个性化菜单(鱼眼)",url:"<%=path%>/sample/nav/menu-fisheye.jsp", target:"frmright"},
		{ id:805, parentId:3008, name:"基本选项卡",url:"<%=path%>/sample/nav/tab-basic.jsp", target:"frmright"},
		{ id:822, parentId:3008, name:"基本选项卡-样式2",url:"<%=path%>/sample/nav/tab-basic-modern.jsp", target:"frmright"},
		{ id:806, parentId:3008, name:"动态选项卡",url:"<%=path%>/sample/nav/tab-dynamic.jsp", target:"frmright"},
		{ id:807, parentId:3008, name:"抽屉容器",url:"<%=path%>/sample/nav/accordion.jsp", target:"frmright"},
		{ id:808, parentId:3008, name:"当前位置",url:"<%=path%>/sample/nav/position.jsp", target:"frmright"},
		{ id:809, parentId:3008, name:"图标导航",url:"<%=path%>/sample/nav/icon-nav.jsp", target:"frmright"},
		{ id:810, parentId:3008, name:"图标工具箱",url:"<%=path%>/sample/nav/icon-toolbox.jsp", target:"frmright"},
		{ id:811, parentId:3008, name:"图标工具栏",url:"<%=path%>/sample/nav/icon-toolbar.jsp", target:"frmright"},
		{ id:812, parentId:3008, name:"数字分页控件",url:"<%=path%>/sample/nav/paging-number.jsp", target:"frmright"},
		{ id:813, parentId:3008, name:"箭头分页控件",url:"<%=path%>/sample/nav/paging-arrow.jsp", target:"frmright"},
		{ id:814, parentId:3008, name:"分隔条组件",url:"<%=path%>/sample/nav/spliter-part.jsp", target:"frmright"},
		
		
		
		{ id:3009, parentId:0, name:"图片特效", isParent: true},
		{ id:901, parentId:3009, name:"图片标题特效",url:"<%=path%>/sample/pic/title.jsp", target:"frmright"},
		{ id:902, parentId:3009, name:"图片列表特效",url:"<%=path%>/sample/pic/list.jsp", target:"frmright"},
		{ id:903, parentId:3009, name:"图片预览", url:"<%=path%>/sample/pic/preview.jsp",target:"frmright"},
		{ id:904, parentId:3009, name:"图片滚动", url:"<%=path%>/sample/pic/scroll.jsp", target:"frmright"},
		{ id:905, parentId:3009, name:"图片滚动(可控)", url:"<%=path%>/sample/pic/scroll-control.jsp", target:"frmright"},
		{ id:906, parentId:3009, name:"单图边框", url:"<%=path%>/sample/pic/frame.jsp",target:"frmright"},
		{ id:907, parentId:3009, name:"单图区域放大", url:"<%=path%>/sample/pic/zoom.jsp", target:"frmright"},
		{ id:908, parentId:3009, name:"图片幻灯", url:"<%=path%>/sample/pic/slider.jsp", target:"frmright"},
		
		{ id:3010, parentId:0, name:"文本特效", isParent: true},
		{ id:1001, parentId:3010, name:"文本截取", url:"<%=path%>/sample/text/slice.jsp", target:"frmright"},
		{ id:1003, parentId:3010, name:"文章列表", url:"<%=path%>/sample/text/list.jsp" ,target:"frmright"},
		{ id:1004, parentId:3010, name:"文本变色", url:"<%=path%>/sample/text/color.jsp" ,target:"frmright"},
		{ id:1005, parentId:3010, name:"文本滚动", url:"<%=path%>/sample/text/scroll.jsp", target:"frmright"},
		{ id:1006, parentId:3010, name:"监听文字改变", url:"<%=path%>/sample/text/watch.jsp",target:"frmright"},
		
		{ id:3011, parentId:0, name:"其他特效", isParent: true},
		{ id:1101, parentId:3011, name:"设为主页与加入收藏",url:"<%=path%>/sample/other/sethome.jsp", target:"frmright"},
		{ id:1102, parentId:3011, name:"多视图切换", url:"<%=path%>/sample/other/multiview.jsp", target:"frmright"},
		{ id:1103, parentId:3011, name:"拖放与接收", url:"<%=path%>/sample/other/drag-drop.jsp", target:"frmright"},
		{ id:1104, parentId:3011, name:"拖拽排序", url:"<%=path%>/sample/other/drag-sort.jsp", target:"frmright"},
		{ id:1105, parentId:3011, name:"平滑锚点链接", url:"<%=path%>/sample/other/smoothlink.jsp", target:"frmright"},
		{ id:1106, parentId:3011, name:"遮罩", url:"<%=path%>/sample/other/mask.jsp", target:"frmright"},
		{ id:1107, parentId:3011, name:"真实进度条", url:"<%=path%>/sample/other/progressbar.jsp", target:"frmright"},
		

		{ id:3012, parentId:0, name:"常用布局模板", isParent: true},
		{ id:1201, parentId:3012, name:"资源维护",url:"<%=path%>/sample/layout/nav-management.jsp", target:"frmright"},
		{ id:1202, parentId:3012, name:"机构维护",url:"<%=path%>/sample/layout/org-management.jsp", target:"frmright"},
		{ id:1203, parentId:3012, name:"用户管理",url:"<%=path%>/sample/layout/user-management.jsp", target:"frmright"},
		{ id:1204, parentId:3012, name:"角色管理",url:"<%=path%>/sample/layout/role-management.jsp", target:"frmright"},
		{ id:1205, parentId:3012, name:"资源分配(按用户)",url:"<%=path%>/sample/layout/user-assignment.jsp", target:"frmright"},
		{ id:1206, parentId:3012, name:"资源分配(按角色)",url:"<%=path%>/sample/layout/role-assignment.jsp", target:"frmright"},
		{ id:1204, parentId:3012, name:"纵向导航",url:"<%=path%>/sample/layout/nav-single.jsp", target:"frmright"},
		{ id:1208, parentId:3012, name:"纵向导航(迷你)",url:"<%=path%>/sample/layout/nav-single-min.jsp", target:"frmright"},
		{ id:1209, parentId:3012, name:"纵向导航(列表)",url:"<%=path%>/sample/layout/nav-double-list.jsp", target:"frmright"},
		{ id:1210, parentId:3012, name:"纵向导航(分组)",url:"<%=path%>/sample/layout/nav-double-group.jsp", target:"frmright"},
		{ id:1211, parentId:3012, name:"横向tab",url:"<%=path%>/sample/layout/layout-htab.jsp", target:"frmright"},
		{ id:1212, parentId:3012, name:"横向tab（多表格）",url:"<%=path%>/sample/layout/tab-grid.jsp", target:"frmright"},
		{ id:1213, parentId:3012, name:"横纵向tab",url:"<%=path%>/sample/layout/layout-hvtab.jsp", target:"frmright"},
		{ id:1214, parentId:3012, name:"左右分隔条布局",url:"<%=path%>/sample/layout/spliter-h.jsp", target:"frmright"},
		{ id:1215, parentId:3012, name:"上下分隔条布局",url:"<%=path%>/sample/layout/spliter-v.jsp", target:"frmright"},
		{ id:1216, parentId:3012, name:"综合分隔条布局",url:"<%=path%>/sample/layout/spliter-full.jsp", target:"frmright"},
		{ id:1217, parentId:3012, name:"弹窗分隔条布局",url:"<%=path%>/sample/layout/popup-nav.jsp", target:"frmright"},
		{ id:1218, parentId:3012, name:"树组件打开tab",url:"<%=path%>/sample/layout/layout-hvtab-dynamic.jsp", target:"frmright"},
		{ id:1219, parentId:3012, name:"grid组件打开tab",url:"<%=path%>/sample/layout/grid-addtab.jsp", target:"frmright"},
		{ id:1220, parentId:3012, name:"多区域展示1",url:"<%=path%>/sample/layout/layout-multiarea1.jsp", target:"frmright"},
		{ id:1221, parentId:3012, name:"多区域展示2",url:"<%=path%>/sample/layout/layout-multiarea2.jsp", target:"frmright"},
		{ id:1222, parentId:3012, name:"综合box容器布局",url:"<%=path%>/sample/layout/layout-box.jsp", target:"frmright"},
		{ id:1223, parentId:3012, name:"分离模式使用",url:"<%=path%>/sample/split/split-index.jsp", target:"frmright"},
		{ id:1224, parentId:3012, name:"框架右侧打开第三方页面",url:"http://www.baidu.com", target:"frmright",showProgess:false},
		
		{ id:3013, parentId:0, name:"综合功能示例*", isParent: true},
		{ id:1301, parentId:3013, name:"组织机构维护*",url:"<%=path%>/sample/unit/org-management.jsp", target:"frmright"},
		{ id:1302, parentId:3013, name:"系统用户管理*",url:"<%=path%>/sample/unit/user-management.jsp", target:"frmright"},
		{ id:1303, parentId:3013, name:"用户新增与即时编辑*",url:"<%=path%>/sample/unit/edit.jsp", target:"frmright"},
		{ id:1304, parentId:3013, name:"用户新增与整行即时编辑*",url:"<%=path%>/sample/unit/edit-row.jsp", target:"frmright"},
		{ id:1305, parentId:3013, name:"展开区域即时编辑用户*",url:"<%=path%>/sample/unit/edit-detail.jsp", target:"frmright"},
		
		{ id:3014, parentId:0, name:"与第三方控件整合*", isParent: true},
		{ id:1401, parentId:3014, name:"声明",url:"<%=path%>/sample/thirdparty/declaration.jsp", target:"frmright"},
		{ id:1402, parentId:3014, name:"与fusioncharts整合*"},
		{ id:140200, parentId:1402, name:"控件介绍",url:"<%=path%>/sample/thirdparty/fusioncharts/intro.jsp", target:"frmright"},
		{ id:140201, parentId:1402, name:"单列图表*",url:"<%=path%>/sample/thirdparty/fusioncharts/single-serial.jsp", target:"frmright"},
		{ id:140202, parentId:1402, name:"多列图表",url:"<%=path%>/sample/thirdparty/fusioncharts/multi-series.jsp", target:"frmright"},
		{ id:140203, parentId:1402, name:"堆积图",url:"<%=path%>/sample/thirdparty/fusioncharts/stacked.jsp", target:"frmright"},
		{ id:140204, parentId:1402, name:"组合图表",url:"<%=path%>/sample/thirdparty/fusioncharts/combination.jsp", target:"frmright"},
		{ id:140205, parentId:1402, name:"泡状图",url:"<%=path%>/sample/thirdparty/fusioncharts/plot.jsp", target:"frmright"},
		{ id:140206, parentId:1402, name:"含滚动条的图表",url:"<%=path%>/sample/thirdparty/fusioncharts/scroll.jsp", target:"frmright"},
		{ id:140207, parentId:1402, name:"个性图表",url:"<%=path%>/sample/thirdparty/fusioncharts/special.jsp", target:"frmright"},
		{ id:140208, parentId:1402, name:"图表链接",url:"<%=path%>/sample/thirdparty/fusioncharts/link.jsp", target:"frmright"},
		{ id:140209, parentId:1402, name:"单列图表(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-single-serial.jsp", target:"frmright"},
		{ id:140210, parentId:1402, name:"多列图表(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-multi-series.jsp", target:"frmright"},
		{ id:140211, parentId:1402, name:"堆积图(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-stacked.jsp", target:"frmright"},
		{ id:140212, parentId:1402, name:"组合图表(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-combination.jsp", target:"frmright"},
		{ id:140213, parentId:1402, name:"泡状图(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-plot.jsp", target:"frmright"},
		{ id:140215, parentId:1402, name:"图表链接(JS版)",url:"<%=path%>/sample/thirdparty/fusioncharts/js-link.jsp", target:"frmright"},
		
		{ id:1405, parentId:3014, name:"与layout布局控件整合", isParent: true},
		{ id:140501, parentId:1405, name:"左中右布局",url:"<%=path%>/sample/thirdparty/layout/layout1.jsp", target:"frmright"},
		{ id:140502, parentId:1405, name:"左右布局+tab",url:"<%=path%>/sample/thirdparty/layout/layout2.jsp", target:"frmright"},
		{ id:140503, parentId:1405, name:"上下布局-1",url:"<%=path%>/sample/thirdparty/layout/layout3.jsp", target:"frmright"},
		{ id:140504, parentId:1405, name:"上下布局-2",url:"<%=path%>/sample/thirdparty/layout/layout4.jsp", target:"frmright"},
		
		{ id:1406, parentId:3014, name:"与lodop打印控件整合", isParent: true},
		{ id:140601, parentId:1406, name:"控件介绍",url:"<%=path%>/sample/thirdparty/lodop/intro.jsp", target:"frmright"},
		{ id:140602, parentId:1406, name:"grid打印",url:"<%=path%>/sample/thirdparty/lodop/print-grid.jsp", target:"frmright"},
		{ id:140603, parentId:1406, name:"table打印",url:"<%=path%>/sample/thirdparty/lodop/print-table.jsp", target:"frmright"},
		
		{ id:1407, parentId:3014, name:"与UEditor整合",url:"<%=path%>/sample/thirdparty/ueditor.jsp", target:"frmright"},
		
		{ id:1403, parentId:3014, name:"与highslide整合",url:"<%=path%>/sample/thirdparty/highslide.jsp", target:"frmright"},
		{ id:1404, parentId:3014, name:"与ckEditor整合",url:"<%=path%>/sample/thirdparty/ckediter.jsp", target:"frmright"}

	];
	
	function initComplete(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		//每次刷新时保持上次打开的
		showContent();
	}
	function showContent(){
		var treeNodeId=jQuery.jCookie('leftTreeNodeId');
		if(treeNodeId==false||treeNodeId=="false"){}
		else{
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", treeNodeId);
			zTree.selectNode(node);
			if(node.url){
				//每次刷新时设置当前位置内容
				if(node.name=="当前位置"){
					top.positionType="normal";
					top.positionContent="当前位置："+node.getParentNode().name+">>"+node.name;
				}
				else{
					top.positionType="none";
				}
				top.frmright.location=node.url;
			}
		}
	}
		
	function onClick(e,treeId, treeNode){
		//单击展开
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.expandNode(treeNode);
		//出现进度条
		if(treeNode.url!=null&&treeNode.showProgess!=false){
			showProgressBar();
		}
		
		//可以设置某些页面出现或者某些页面不出现当前位置组件
		if(treeNode.name=="当前位置"){
			//每次点击时设置当前位置内容
			top.positionContent="当前位置："+treeNode.getParentNode().name+">>"+treeNode.name;
			top.positionType="normal";
		}
		else{
			top.positionType="none";
		}
		
		//存储点击节点id
		jQuery.jCookie('leftTreeNodeId',treeNode.id.toString());
	}

	function  showAll(){
		var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
		treeObj.expandAll(true);
	}
	function  hideAll(){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo")
		treeObj.expandAll(false);
	}
	function customHeightSet(contentHeight){
		var windowWidth=document.documentElement.clientWidth;
		$("#scrollContent").width(windowWidth-4);
		$("#scrollContent").height(contentHeight-50);
	}
</script>
<!-- 树end -->
<style>
.ztree *{
	font-family:sans-serif!important;
}
</style>
</head>

<body leftFrame="true">
<div class="padding_top5 ali02">
	<a onclick="showAll()">全部展开</a>&nbsp;&nbsp;<a onclick="hideAll()">全部收缩</a>
	<div class="red">（含*号表示该项实现由后台支持）</div>
</div>

<div id="scrollContent" style="overflow-x:hidden;">

	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
		
</div>	
</body>
</html>