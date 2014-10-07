//定义左侧菜单数据，应与桌面图标保持一致
var zNodes =[
		{ id:3001, parentId:0, name:"基本页面模板"},
		{id:"1-9",parentId:3001,name:"表单模板",link:"../../sample_skin/normal/form-page.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-10",parentId:3001,name:"表格模板",link:"../../sample_skin/normal/grid-page.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-11",parentId:3001,name:"双层左右分栏",link:"../../sample_skin/normal/nav-double.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-12",parentId:3001,name:"单层左右分栏",link:"../../sample_skin/normal/nav-single.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-13",parentId:3001,name:"图片列表",link:"../../sample_skin/normal/pic-list.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-14",parentId:3001,name:"选项卡模板",link:"../../sample_skin/normal/tab-page.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		
		{ id:3002, parentId:0, name:"用户信息"},
		{id:"1-15", parentId:3002,name:"组织机构管理",link:"../../sample_skin/normal/org-management.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-16",parentId:3002,name:"角色权限分配",link:"../../sample_skin/normal/role-assignment.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-17",parentId:3002,name:"角色管理",link:"../../sample_skin/normal/role-management.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-18",parentId:3002,name:"用户权限分配",link:"../../sample_skin/normal/user-assignment.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"},
		{id:"1-19",parentId:3002,name:"用户管理",link:"../../sample_skin/normal/user-management.html",iconOpen:"../../libs/icons/folder_doc.gif",iconClose:"../../libs/icons/folder_doc.gif",icon:"skin/titlebar_arrow.gif"}
	];
function tabAddHandler(mid,mtitle,murl){
		tab.add( {
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true,
		iframeAddtion:'style="background-color:#dbeefd"'
	});
	tab.activate(mid)
}
var tab;
var taskBarShow=false;
var taskBarHeight=0;
var chatMainShow=false;	
$( function() {
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'desk_index',
		title :"桌面导航",
		url :"desk.html",
		isClosed :false,
		iframeAddtion:'scrolling="no"'
	});
	
	$("body").bind("dynamicTabActived",function(e,tabId){
		if(tabId=="desk_index"){
			$("#leftMenu").hide();
			$("#spliter").hide();
		}
		else{
			$("#leftMenu").show();
			$("#spliter").show();
			getNodesByParam("id",tabId);
		}
	})
 	$("#spliter").hide();
	$(".spliter").each(function(){
		$(this).spliterRender();
	})
	
	resizeHandler();
	
	$("body").bind("dialogTaskShow",function(){
		taskBarShow=true;
		taskBarHeight=29;
		if(chatMainShow==true){
			$(".chat_main").css("bottom",taskBarHeight+"px")
		}
		else{
			$(".chat_main").css("bottom",-402+taskBarHeight+"px")
		}
		
		resizeHandler();
	})
	$("body").bind("dialogTaskHide",function(){
		taskBarShow=false;
		taskBarHeight=0;
		if(chatMainShow==true){
			$(".chat_main").css("bottom","0")
		}
		else{
			$(".chat_main").css("bottom","-402px")
		}
		resizeHandler();
	})
});
function backHome(){
	//tab.activate('desk_index');
	tabAddHandler("desk_index","导航首页","desk.html")
}

window.onresize = function(){
	resizeHandler()
}
function resizeHandler(){
	var windowWidth=document.documentElement.clientWidth;
	var windowHeight=document.documentElement.clientHeight;
	//整体高度-头部高度-tab栏高度-taskbar高度
	$("#page").height(windowHeight-31-30-taskBarHeight);
	$("#leftMenu").height(windowHeight-31-30-taskBarHeight);
	$("#spliter").height(windowHeight-31-30-taskBarHeight);
	$("#allIconContainer").height(windowHeight);
	
}