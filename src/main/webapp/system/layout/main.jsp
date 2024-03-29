﻿﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<% String path = request.getContextPath();%>
<%
if(session.getAttribute("skinName")==null){
session.setAttribute("skinName","skin");
session.setAttribute("themeColor","blue");
}
 %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>QUI网页界面集成框架JAVA示例版</title>
<!--框架必需start-->
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link href="<%=path%>/libs/skins/<%=session.getAttribute("themeColor")%>/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="<%=session.getAttribute("themeColor")%>"/>
<link href="<%=path%>/system/layout/<%=session.getAttribute("skinName")%>/style.css" rel="stylesheet" type="text/css" id="skin"  skinPath="system/layout/<%=session.getAttribute("skinName")%>/"/>
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/main.js"></script>
<!--框架必需end-->

<!--引入弹窗组件start-->
<script type="text/javascript" src="<%=path%>/libs/js/popup/drag.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/popup/dialog.js"></script>
<!--引入弹窗组件end-->

<!--分隔条start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/spliter.js"></script>
<!--分隔条end-->
<script>
function bookmarksite(title, url){
    if (window.sidebar) // firefox
        window.sidebar.addPanel(title, url, "");
    else 
        if (window.opera && window.print) { // opera
            var elem = document.createElement('a');
            elem.setAttribute('href', url);
            elem.setAttribute('title', title);
            elem.setAttribute('rel', 'sidebar');
            elem.click();
        }
        else 
            if (document.all)// ie
                window.external.AddFavorite(url, title);
}
function exitHandler(){

	top.Dialog.confirm("确定要退出系统吗",function(){});
}
function lockScreen(){
	top.Dialog.confirm("确定要锁屏吗，锁屏后只有重新输入密码才能解除。",function(){
		openLockWindow();
	});
}
function openLockWindow(){
	var diag = new top.Dialog();
		diag.Title = "系统锁屏";
		diag.ID = "a1";
		diag.URL="<%=path%>/sample/fullform/lock.jsp";
		diag.Width=350;
		diag.Height=150;
		diag.ShowCloseButton=false;
		diag.ShowCancelButton=false;
		diag.ShowOkButton=false;
		diag.ButtonAlign="center";
		diag.AllowChangeIndex=false;
		diag.show();
		diag.addButton("btn1","注销系统",function(){
			top.Dialog.confirm("确定要退出系统吗",function(){window.location="<%=path%>/logout.action"});
		})
		diag.addButton("btn2","确定解锁",function(){
			top.document.getElementById("_DialogFrame_a1").contentWindow.validateForm();
		})
		$.post("<%=path%>/lockScreen.action");
}

function validate(){
// 	<s:if test="%{#session.isLockScreen != null && #session.isLockScreen}">
	openLockWindow();
// 	</s:if>
}
function changeSkin(themeColor,skinName){
	top.Dialog.confirm("确定应用该皮肤吗？",function(){
		document.getElementById("sessionSkin").src="<%=path%>/system/layout/skin.jsp?skinName="+skinName+"&themeColor="+themeColor;
	})
}
</script>
</head>
<body onload="validate()">
<div id="mainFrame">
<!--头部与导航start-->
<div id="hbox">
	<div id="bs_bannercenter">
	<div id="bs_bannerleft">
	<div id="bs_bannerright">
	</div>
	</div>
	</div>
	<div id="bs_navcenter">
	<div id="bs_navleft">
	<div id="bs_navright">
		<div class="bs_nav">
			<div class="bs_navleft">
				<li class="fontTitle">字号:</li>
				<li class="fontChange"><span><a href="javascript:;" setFont="16">大</a></span></li>
				<li class="fontChange"><span><a href="javascript:;" setFont="14">中</a></span></li>
				<li class="fontChange"><span><a href="javascript:;" setFont="12">小</a></span></li>
				<div class="clear"></div>	
			</div>	
			<div class="float_left padding_top2 padding_left5">
				【今天是
				<script>
					var weekDayLabels = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
					var now = new Date();
				    var year=now.getFullYear();
					var month=now.getMonth()+1;
					var day=now.getDate()
				    var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[now.getDay()]
					document.write(currentime)
				</script>】
			</div>	
			<div class="float_right padding_top2 padding_right5">
				<div class="float_left padding_right5 padding_left3">切换风格</div>
				<div class="float_left colorList padding_top7">
					<ul>
					<li onclick="changeSkin('green','grass')" class="color2"></li>
					<li onclick="changeSkin('lightBlue','ext')" class="color3"></li>
					<li onclick="changeSkin('blue','skin')" class="color1"></li>
					<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
				<span class="icon_fullscreen hand" id="fullSrceen" hideNav="true">开启全屏</span>
				<span class="icon_lock hand" onclick="lockScreen()">系统锁屏</span>
				<span class="icon_exit hand" onclick='top.Dialog.confirm("确定要退出系统吗",function(){window.location="<%=path%>/logout.action"});'>退出系统</span>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	</div>
	</div>
</div>
<!--头部与导航end-->

<table width="100%" cellpadding="0" cellspacing="0" class="table_border0">
	<tr>
		<!--左侧区域start-->
		<td id="hideCon" class="ver01 ali01">
							<div id="lbox">
								<div id="lbox_topcenter">
								<div id="lbox_topleft">
								<div id="lbox_topright">
								</div>
								</div>
								</div>
								<div id="lbox_middlecenter">
								<div id="lbox_middleleft">
								<div id="lbox_middleright">
										<div id="bs_left">
										<IFRAME height="100%" width="100%"  frameBorder=0 id=frmleft name=frmleft src="/main/left.xhtml"  allowTransparency="true"></IFRAME>
										</div>
										<!--更改左侧栏的宽度需要修改id="bs_left"的样式-->
								</div>
								</div>
								</div>
								<div id="lbox_bottomcenter">
								<div id="lbox_bottomleft">
								<div id="lbox_bottomright">
									<div class="lbox_foot"></div>
								</div>
								</div>
								</div>
							</div>
		</td>
		<!--左侧区域end-->
		
		<!--分隔栏区域start-->
		<td class="spliter main_shutiao" targetId="hideCon" beforeClickTip="收缩面板" afterClickTip="展开面板" beforeClickClass="bs_leftArr" afterClickClass="bs_rightArr">
		</td>
		<!--分隔栏区域end-->
		
		<!--右侧区域start-->
		<td class="ali01 ver01"  width="100%">
							<div id="rbox">
								<div id="rbox_topcenter">
								<div id="rbox_topleft">
								<div id="rbox_topright">
								</div>
								</div>
								</div>
								<div id="rbox_middlecenter">
								<div id="rbox_middleleft">
								<div id="rbox_middleright">
									<div id="bs_right">
									       <IFRAME height="100%"  width="100%" frameBorder=0 id=frmright name=frmright src="/main/open.xhtml"  allowTransparency="true"></IFRAME>
									</div>
								</div>
								</div>
								</div>
								<div id="rbox_bottomcenter" >
								<div id="rbox_bottomleft">
								<div id="rbox_bottomright">

								</div>
								</div>
								</div>
							</div>
		</td>
		<!--右侧区域end-->
	</tr>
</table>

<!--尾部区域start-->
<div id="fbox">
	<div id="bs_footcenter">
	<div id="bs_footleft">
	<div id="bs_footright">
		版权所有：http://www.quickui.net
	</div>
	</div>
	</div>
</div>
</div>
<!--尾部区域end-->

<!--窗口任务栏区域start-->
<div id="dialogTask" class="dialogTaskBg" style="display:none;"></div>
<!--窗口任务栏区域end-->

<!--浏览器resize事件修正start-->
<div id="resizeFix"></div>
<!--浏览器resize事件修正end-->

<!--载进度条start-->
<div class="progressBg" id="progress" style="display:none;"><div class="progressBar"></div></div>
<!--载进度条end-->
<iframe id="sessionSkin" src="" width="0" height="0" style="display:none;"></iframe>
</body>
</html>
