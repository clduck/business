var iconData;
var $iconList;
var iconDiag;
var depth=500;
var currentScreenIdx=0;
var $container;
$(function(){
	//创建图标
	iconData={"list":[
			{id:"1",group:[
				{children:[
					{id:"1-9",name:"表单模板",link:"../../sample_skin/normal/form-page.html",icon:"skin/newicons/demo7.png",linkType:"tab",smallIcon:"skin/smallicons/demo7.png"},
					{id:"1-10",name:"表格模板",link:"../../sample_skin/normal/grid-page.html",icon:"skin/newicons/demo8.png",linkType:"tab",smallIcon:"skin/smallicons/demo8.png"},
					{id:"1-11",name:"大屏幕监督指挥系统",link:"../../sample_skin/normal/nav-double.html",icon:"skin/newicons/demo9.png",linkType:"tab",smallIcon:"skin/smallicons/demo9.png"},
					{id:"1-12",name:"单层左右分栏",link:"../../sample_skin/normal/nav-single.html",icon:"skin/newicons/demo10.png",linkType:"tab",smallIcon:"skin/smallicons/demo10.png"},
					{id:"1-13",name:"图片列表",link:"../../sample_skin/normal/pic-list.html",icon:"skin/newicons/demo11.png",linkType:"tab",smallIcon:"skin/smallicons/demo11.png"},
					{id:"1-14",name:"选项卡模板",link:"../../sample_skin/normal/tab-page.html",icon:"skin/newicons/demo12.png",linkType:"tab",smallIcon:"skin/smallicons/demo12.png"}
				],name:"基本页面模板",id:"group2"}
				
			]}
		]}
	createDeskIcon(iconData);
	
	resizeHandler();
	window.onresize = function(){
		resizeHandler();
	}
	
	$container=$(top.document.getElementById("allIconContainer"));
	
	//初始化鱼眼菜单并处理菜单位置
	$('#dock').Fisheye(
		{
			maxWidth: 64,
			items: 'a',
			itemsText: 'span',
			container: '.dock-container',
			itemWidth: 80,
			proximity: 80,
			valign: 'bottom',
			halign : 'center'
		}
	);
	
	
	
	//设置背景
	var bgsrc=jQuery.jCookie('deskbg');
	if(bgsrc=="false"||bgsrc==false){
		bgsrc="skin/bg/bg.jpg";
	}
	$("body").css({
		"backgroundImage":"url("+bgsrc+")"
	})
	
    var option = { width: 110, items: [
                        { text: "刷新桌面", icon: "../../libs/icons/reload.gif", alias: "1-2", action: menuAction },
						{ type: "splitLine" },
						{ text: "背景设置", icon: "../../libs/icons/img.gif", alias: "1-3", action: menuAction },
                        { text: "图标设置", icon: "../../libs/images/icons/ico4.gif", alias: "1-4", type: "group", width: 100, items: [
                            { text: "大图标", icon: "../../libs/images/icons/ico4-2.gif", alias: "1-4-1", action: menuAction },
                            { text: "小图标", icon: "../../libs/images/icons/ico4-3.gif", alias: "1-4-2", action: menuAction }
                        ]
                        },
						{ type: "splitLine" },
						{ text: "锁定屏幕", icon: "../../libs/icons/lock.gif", alias: "1-1", action: menuAction },
						{ text: "注销系统", icon: "../../libs/icons/exit.gif", alias: "1-5", action: menuAction }
                        ], onShow: applyrule
        };
	$("body").contextmenu(option);
	
	
	var myData={"list" : ["智能提示选项示例1","智能提示选项示例2","智能提示选项示例3","智能提示选项示例4"]};
	$('#searchInput').AutoComplete({
			data: myData,
			inputWidth:165,
			boxWidth:210,
			topDeff:12,
			onItemSelected: function(item){
				$("#searchPanel").hide();
				top.Dialog.alert("此处为查询结果处理。");
			}
		});
	
	
})
function resizeHandler(){
	var windowWidth=document.documentElement.clientWidth;
	$("#mydock").css({
		"left":(windowWidth-700)/2
	})
	var iconnavWidth=150;
	//if($("#iconnav").width()>100){
		//iconnavWidth=$("#iconnav").width();
	//}
	$("#iconnav").css({
		"left":(windowWidth-iconnavWidth)/2
	})
	$("#searchPanel").css({
		"left":(windowWidth-$("#searchPanel").width())/2
	})
}
 function applyrule(menu) {               
    menu.applyrule({ name: "all",
            disable: true,
            items: []
        });
}
 function menuAction() {
    if(this.data.alias=="1-1"){
		var diag = new top.Dialog();
		diag.Title = "系统锁屏";
		diag.ID = "a1";
		diag.URL="include/lock.html";
		diag.Width=350;
		diag.Height=150;
		diag.ShowCloseButton=false;
		diag.ShowCancelButton=false;
		diag.ShowOkButton=false;
		diag.AllowChangeIndex=false;
		diag.ButtonAlign="center";
		diag.show();
		diag.addButton("btn1","注销系统",function(){
			window.location="login.html";
		})
		diag.addButton("btn2","确定解锁",function(){
			top.document.getElementById("_DialogFrame_a1").contentWindow.validateForm();
		})
	}
	else  if(this.data.alias=="1-2"){
		window.location.reload();
	}
	else  if(this.data.alias=="1-3"){
		top.Dialog.open({URL:"include/skin.html",Title:"更换背景",Modal:false,ResizeResetPosition:false,ShowMinButton:true,Width:720,Height:460});
	}
	else  if(this.data.alias=="1-4-1"){
		$(".nav_icon_h_item").removeClass("nav_icon_h_item_small");
	}
	else  if(this.data.alias=="1-4-2"){
		$(".nav_icon_h_item").addClass("nav_icon_h_item_small");
	}
	else  if(this.data.alias=="1-5"){
		top.Dialog.confirm("确定要退出系统吗",function(){top.window.location="../login_tabdesk/login.html"});
	}
	
}

function changeStyle(bgsrc){
	$("body").css({
		"backgroundImage":"url("+bgsrc+")"
	});
	jQuery.jCookie('deskbg',bgsrc);
}
function createDeskIcon(data){
	var iconNavCon=$("#iconnavCon");
	$.each(data["list"],function(idx,item){
		var $screen=$('<div class="screen"></div>');
		$("body").append($screen);
		$screen.hide();
		var $iconNavItem=$('<li></li>');
		var $iconNavItemA=$('<a></a>');
		if(idx==0){
			$iconNavItemA.addClass("current");
			$screen.show();
		}
		$iconNavItemA.text(idx+1);
		$iconNavItem.append($iconNavItemA);
		iconNavCon.append($iconNavItem);
		if(item.group){
			$.each(item.group,function(idx2,item2){
				var $groupTitle=$('<div class="subTitle"><div class="subTitleCon"></div></div>');
				$groupTitle.find(".subTitleCon").text(item2.name);
				var $groupContent=$('<div class="iconContent"></div>');
				$screen.append($groupTitle);
				$screen.append($groupContent);
				$groupContent.attr("id",item2.id);
				$.each(item2.children,function(idx3,item3){
					var $iconItem=$('<div class="nav_icon_h_item "><a><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text"></div></a></div>');
					var $iconItemA=$iconItem.find("a");
					//$iconItemA.attr("link",item3.link);
					$iconItemA.click(function(){
						if(item3.link){
							var linkType="popup";
							if(item3.linkType){
								linkType=item3.linkType;
							}
							openContentWindow(item3.link,item3.name,item3.id,linkType,item3.smallIcon);
						}
					})
					if(item3.icon){
						$iconItem.find("img").attr("src",item3.icon);
					}
					
					$iconItem.find(".nav_icon_h_item_text").text(item3.name);
					$iconItem.find(".nav_icon_h_item_text").attr("title",item3.name);
					$groupContent.append($iconItem);
				})
				$groupContent.append($('<div class="clear"></div>'));
			})
		}
	});
	iconNavCon.append($('<div class="clear"></div>'));
	
	//var windowWidth=document.documentElement.clientWidth;
	//$("#iconnav").css({
		//"left":(windowWidth-$("#iconnav").width())/2
	//})
	
	iconNavCon.find("a").each(function(i){
		$(this).click(function(){
			iconNavCon.find("a").removeClass("current");
			$(this).addClass("current");
			$(".screen").hide();
			$(".screen").eq(i).fadeIn(500);
			currentScreenIdx=i;
		})
	})
	
}
function createDeskIconList(data){
	 $iconList=$('<div style="padding:0 100px 0 10px;"><table width="100%"><tr></tr></table></div>');
	var $tr=$iconList.find("tr")
	//构建自定义内容
	$.each(iconData["list"],function(idx,item){
		var $td=$('<td class="ver01"></td>');
		var $screen=$('<div class="screen"></div>');
		if(item.group){
			$.each(item.group,function(idx2,item2){
				$.each(item2.children,function(idx3,item3){
					var $iconItem=$('<div class="nav_icon_list"><a href="javascript:;"><div class="nav_icon_list_img"><img/></div><div class="nav_icon_list_text"></div><div class="clear"></div></a></div>');
					var $iconItemA=$iconItem.find("a");
					$iconItemA.click(function(){
						if(item3.link){
							var linkType="popup";
							if(item3.linkType){
								linkType=item3.linkType;
							}
							openContentWindow(item3.link,item3.name,item3.id,linkType,item3.smallIcon);
							$container.hide();
							$container.empty();
							$iconList=null;
						}
						//iconDiag.close();
					})
					if(item3.icon){
						$iconItem.find("img").attr("src",item3.icon);
					}
					
					$iconItem.find(".nav_icon_list_text").text(item3.name);
					$td.append($iconItem);
					
					$iconItem.hover(function(){
						$(this).addClass("nav_icon_list_over");
					},function(){
						$(this).removeClass("nav_icon_list_over");
					})
				})
				$td.append($('<div class="clear"></div>'));
			})
		}
    	$tr.append($td);
	});
}
function showAllIcon(){
	 //内容添加到窗口
	 try{
	 	createDeskIconList(iconData)
		$container.append($iconList);
    	var $close=$('<a href="javascript:;" class="backBtn">button</a>');
    	$container.prepend($close);
		$container.show();
		//点击关闭
	    $close.click(function(){
		  	$container.hide();
			$container.empty();
			$iconList=null;
	    });
	}
	catch(e){
		alert("IE6不支持此功能。")
	}
	
	
    
}
function showSearchPanel(){
	if($("#searchPanel")[0].style.display=="none"){
		$("#searchPanel").show();
		$("#searchInput").val("");
	}
	else{
		$("#searchPanel").hide();
	}
}
function searchHandler(){
	$("#searchPanel").hide();
	top.Dialog.alert("此处为查询结果处理。");
}
function openContentWindow(link,name,winId,linkType,icon){
	
	if(linkType=="tab"){
		top.tabAddHandler(winId,name,link);
	}
	else{
		var diag = new top.Dialog();
	    diag.URL= link;
	    diag.Title=name;
	    diag.ID=winId;
		diag.MinToTask=true;
		diag.Width=600;
		diag.Height=400;
	    diag.ShowMinButton=true;
	    diag.ShowMaxButton=true;
		diag.IconSrc=icon;
	    diag.show();
	}
}
var appSotreDiag;
function openAppStore(){
	appSotreDiag = new top.Dialog();
    appSotreDiag.ID="c1";
    appSotreDiag.Width=650;
    appSotreDiag.Height=400;
	appSotreDiag.URL="appstore.html";
	appSotreDiag.Title="应用商店";
	//appSotreDiag.Modal=false;
	appSotreDiag.ResizeResetPosition=false;
    appSotreDiag.show();
}
function closeAppStore(){
	appSotreDiag.close();
}
var appSotreDiagTree;


function openTreeWindow(link,name,id,icon,smallIcon){
	var paramsObj={ Link:"",  Name:"", Id:"", Icon:"", SmallIcon:""};
	paramsObj.Link=link;
	paramsObj.Name=name;
	paramsObj.Id=id;
	paramsObj.Icon=icon;
	paramsObj.SmallIcon=smallIcon;
	
	appSotreDiagTree = new top.Dialog();
    appSotreDiagTree.Width=400;
    appSotreDiagTree.Height=300;
	appSotreDiagTree.Title="选择分组";
	appSotreDiagTree.URL="include/appstoreTree.html";
	appSotreDiagTree.ParamsObj=paramsObj;
    appSotreDiagTree.show();
}
function closeTreeWindow(){
	appSotreDiag.close();
	appSotreDiagTree.close();
}

function addAppStoreIcon(idx,groupId,linkType){
	var paramsObj=appSotreDiagTree.ParamsObj;
	addIconHandler(idx,groupId,linkType,paramsObj.Link,paramsObj.Name,paramsObj.Id,paramsObj.Icon,paramsObj.SmallIcon);
}
function addIconHandler(idx,groupId,linkType,Link,Name,Id,Icon,SmallIcon){
	if(idx!=currentScreenIdx){
		$("#iconnav").find("a").removeClass("current");
		$("#iconnav").find("a").eq(idx).addClass("current");
		$(".screen").hide();
		$(".screen").eq(idx).fadeIn(500);
		currentScreenIdx=idx;
	}
	
	var $iconItem=$('<div class="nav_icon_h_item "><a><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text"></div></a></div>');
	var $iconItemA=$iconItem.find("a");
	$iconItemA.click(function(){
		openContentWindow(Link,Name,Id,linkType,SmallIcon);
	})
	$iconItem.find("img").attr("src",Icon);
	$iconItem.find(".nav_icon_h_item_text").text(Name);
	$iconItem.find(".nav_icon_h_item_text").attr("title",Name);
	$("#"+groupId).find(".clear").before($iconItem);
}
function changeDockPosition(str){
	$('#mydock').css("bottom",str);
}
