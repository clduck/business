var listData;
var iconContainerHide=0;
var iconContainerHideTemp=0;
var homeUrl="open.html";
function iframeClickHandler(){
	var $iconBar=$("#bs_navcenter");
	if(iconContainerHide==1){
		$iconBar.hide();
	}
	
	$(".officeMenu").officeMenuClose();
}
function backHome(){
	//取消记忆tab
	jQuery.jCookie('hiconIndex',"false");
	//取消记忆menu
	jQuery.jCookie('menuItemUrl',"false");
	//取消tab的选中
	$(".nav_icon_h_item >a").removeClass("current");
	$(".officeMenu").officeMenuClose();
	top.frmright.window.location=homeUrl;
}
function createOfficeTab(data){
	//恢复上次点击的tab
	var htabIdx=0;
	var htabIndex=jQuery.jCookie('htabIndex');
	if(htabIndex=="false"){
	}
	else{
		htabIdx=parseInt(htabIndex);
		if(isNaN(htabIdx)){
			htabIdx=0;
		}
	}
	
	//恢复上次点击的图标
	var hiconIdx=-1;
	var hiconIndex=jQuery.jCookie('hiconIndex');
	if(hiconIndex=="false"||hiconIndex==false){
		hiconIdx=-1
	}
	else{
		hiconIdx=hiconIndex;
	}
	//恢复上次点击的菜单项
	var menuItemUrl=null;
	var _menuItemUrl=jQuery.jCookie('menuItemUrl');
	if(_menuItemUrl=="false"||_menuItemUrl==false){
		menuItemUrl=null;
	}
	else{
		menuItemUrl=_menuItemUrl;
	}
	
	var $tabContent;
	if(broswerFlag=="IE6"){
		$tabContent=$('<div class="htab_ie6"></div>');
	}
	else{
		$tabContent=$('<div class="htab"></div>');
	}
	$("#bs_bannerright").append($tabContent);
	
	var $iconCon=$("#bs_navright");
	var $iconBar=$("#bs_navcenter");
	$.each(data["list"],function(idx,item){
		var $item=$('<a href="javascript:;"><b></b></a>');
		var $itemCon=$item.find("b");
		if(item.name){
			$itemCon.text(item.name);
		}
		if(item.id){
			$item.attr("id",item.id);
		}
		$tabContent.append($item);
		if(item.group){
			var $iconContent=$('<table style="display:none;"></table>');
			if(item.id){
				$iconContent.attr("id",item.id);
			}
			var $iconContentTr=$('<tr></tr>');
			
			$.each(item.group,function(idx2,item2){
				var $groupCon=$('<td><div class="group"><div class="group_center"><div class="group_left"><div class="group_right"></div></div></div></div></td>');
				if(item2.children){
					var $childrenCon=$('<div class="nav_icon_h"><table><tr><td><td></tr></table></div>');
					$groupCon.find(".group_right").append($childrenCon);
					$.each(item2.children,function(idx3,item3){
						var $childrenContent=$('<td><div class="nav_icon_h_item"><a href="javascript:;"><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text"></div></a></div></td>')
						var $childrenContentA=$childrenContent.find("a");
						if(item3.id){
							$childrenContentA.attr("id",item3.id);
						}
						if(item3.link){
							$childrenContentA.attr("href",item3.link);
						}
						if(item3.target){
							$childrenContentA.attr("target",item3.target);
						}
						if(item3.name){
							$childrenContent.find(".nav_icon_h_item_text").text(item3.name);
						}
						if(item3.icon){
							$childrenContent.find("img").attr("src",item3.icon);
						}
						$childrenCon.find("tr").append($childrenContent);
					})
				}
				$iconContentTr.append($groupCon);
				$iconContent.append($iconContentTr);
			})
			$iconCon.append($iconContent);
		}
		
		
	})
	
	$tabContent.find(">a").each(function(i){
		var pid=$(this).attr("id");
		$(this).click(function(){
			//更换tab样式
			$tabContent.find(">a").removeClass("current");
			$(this).addClass("current");
			//changeLeftMenu(pid);
			jQuery.jCookie('htabIndex',i.toString());
			
			$iconCon.find(">table").each(function(){
				$(this).hide();
				if($(this).attr("id")==pid){
					$(this).fadeIn(500);
				}
			})
			
			if(iconContainerHide==1){
				$iconBar.show();
			}
		})
		$(this).bind("dblclick",function(){
			if(iconContainerHide==0){
				iconContainerHide=1;
				iconContainerHideTemp=1;
				$iconBar.addClass("nav_icon_h_position");
				$iconBar.hide();
				autoReset();
			}
			else{
				iconContainerHide=0;
				iconContainerHideTemp=0;
				$iconBar.removeClass("nav_icon_h_position");
				$iconBar.show();
				autoReset();
			}
		})
		
		if(i==htabIdx){
			//设置tab的当前选中
			$(this).addClass("current");
			
			//还原图标导航
			$iconCon.find(">table").each(function(){
				$(this).hide();
				if($(this).attr("id")==pid){
					$(this).fadeIn(500);
				}
			})
			//还原树的数据
			//var pid=$(this).attr("id");
			//listData=getListData(pid);
		}
	})
	$iconCon.find(".nav_icon_h_item >a").each(function(i){
		var pid=$(this).attr("id");
		$(this).click(function(){
			$iconCon.find(".nav_icon_h_item >a").removeClass("current");
			$(this).addClass("current");
			if(pid){
				//记忆tab
				jQuery.jCookie('hiconIndex',pid);
				//取消记忆menu
				jQuery.jCookie('menuItemUrl',"false");
			}
			if($(this).attr("target")!=null){
				var titleStr="正在加载中...";
				progressFlag=2;
				showSimpleProgress(titleStr,0,true,"#ffffff");
			}
		})
		if(hiconIdx!=-1){
			if(pid==hiconIdx){
				$(this).addClass("current");
				//初始时打开上一次点击的tab的路径
				document.getElementById("frmright").contentWindow.location=$(this).attr("href");
			}
		}
	})
	
	if(hiconIdx==-1&&menuItemUrl==null){
		document.getElementById("frmright").contentWindow.location=homeUrl;
	}
	else if(menuItemUrl!=null){
		document.getElementById("frmright").contentWindow.location=menuItemUrl;
	}
}
function changeLeftMenu(idx){
	listData=getListData(idx);
	if(listData!=null){
		document.getElementById("frmleft").contentWindow.initTreeMenu(listData);
	}	
}

$.fn.officeMenuClose=function(){
		var $instance=$(this);
		var $menuBtn=$instance.find(".top_menuBtn");
		var $menuMain=$instance.find(".top_menu");
		if($menuMain[0].style.display!="none"){
			$menuMain.hide(200);
			$menuBtn.removeClass("top_menuBtnCurrent");
			$menuMain.find(".menubox_listCon_up").hide();
		}
	};

$.fn.officeMenuRender = function(data) {
		var $instance=$(this);
		var $menuBtn=$('<a class="top_menuBtn" href="javascript:;">button</a>')
		$instance.append($menuBtn);
		var $menuMain=$('<div class="top_menu" style="display:none;">'+
						'<div class="menubox_topcenter"><div class="menubox_topleft"><div class="menubox_topright"></div></div></div>'+
						'<div class="menubox_middlecenter"><div class="menubox_middleleft"><div class="menubox_middleright">'+
							'<div class="menubox_content">'+
								'<div class="menubox_buttonCon"></div>'+
								'<div class="menubox_listCon"></div>'+
								'<div class="clear"></div>'+
							'</div>'+
						'</div></div></div>'+
						'<div class="menubox_bottomcenter"><div class="menubox_bottomleft"><div class="menubox_bottomright"></div></div></div>'+
					'</div>');
		$instance.append($menuMain);
		if(data["list"]){
			var $parentBtnCon=$menuMain.find(".menubox_buttonCon");
			var $childBtnCon=$menuMain.find(".menubox_listCon");
			var parentBtnNum=data["list"].length;
			$.each(data["list"],function(i,item){
				var $parentItem=$("<a></a>");
				if(item.id){
					$parentItem.attr("id","menubox_button_"+item.id);
				}
				if(item.url){
					$parentItem.attr("href",item.url);
				}
				else{
					$parentItem.attr("href","javascript:;");
				}
				if(item.target){
					$parentItem.attr("target",item.target);
				}
				if(item.iconSrc){
					var parentItemSrc='<div class="menubox_button_img"><img src="'+item.iconSrc+'"/>';
					$parentItem.append(parentItemSrc);
				}
				if(item.name){
					var parentItemName='<div class="menubox_button_text">'+item.name+'</div>';
					$parentItem.append(parentItemName);
				}
				$parentItem.append('<div class="clear"></div>');
				$parentBtnCon.append($parentItem);
				//点击菜单的左侧大按钮
				$parentItem.click(function(){
					//关闭菜单
					$instance.officeMenuClose();
					if($(this).attr("href")!="javascript:;"){
						//取消记忆tab
						jQuery.jCookie('hiconIndex',"false");
						//记忆menu
						jQuery.jCookie('menuItemUrl',$(this).attr("href"));
						//取消tab的选中
						$(".nav_icon_h_item >a").removeClass("current");
					}
				})
				if(item.children){
					
					$parentItem.addClass("menubox_button_arrow");
					
					var $childList=$('<div class="menubox_listCon_up" style="display:none;"></div>');
					var $childUl=$('<ul></ul>');
					$childList.append($childUl);
					if(item.id){
						$childList.attr("id","menubox_child_con_"+item.id);
						$childUl.attr("id","menubox_child_ul_"+item.id);
					}
					var ztreeStyle=false;
					if(item.children.length==0){
						$childUl.addClass("ztree");
						ztreeStyle=true;
					}
					$childBtnCon.append($childList);
					$childList.height(parentBtnNum*50-20);
					$.each(item.children,function(i,item){
						var $li=$('<li></li>');
						if(!ztreeStyle){
							$li.addClass("li");
						}
						var $childA=$('<a></a>');
						$li.append($childA);
						//点击子菜单项
						$childA.click(function(){
							//关闭菜单
							$instance.officeMenuClose();
							if($(this).attr("href")!="javascript:;"){
								//取消记忆tab
								jQuery.jCookie('hiconIndex',"false");
								//记忆menu
								jQuery.jCookie('menuItemUrl',$(this).attr("href"));
								//取消tab的选中
								$(".nav_icon_h_item >a").removeClass("current");
							}
						})
						if(item.id){
							$childA.attr("id","menubox_child_item_"+item.id);
						}
						if(item.url){
							$childA.attr("href",item.url);
						}
						else{
							$childA.attr("href","javascript:;");
						}
						if(item.target){
							$childA.attr("target",item.target);
						}
						if(item.name){
							$childA.html(item.name);
						}
						$childUl.append($li);
					})
				}
				else{
					$parentItem.addClass("menubox_button");
				}
			})
			
			var $menubox_button_arrow_all=$parentBtnCon.find(".menubox_button_arrow");
			var $menubox_button_all=$parentBtnCon.find(".menubox_button");
			var $childListAll=$childBtnCon.find(".menubox_listCon_up");
			$menubox_button_arrow_all.each(function(i){
				$(this).hover(function(){
					$menubox_button_arrow_all.removeClass("menubox_button_hoverArrow");
					$(this).addClass("menubox_button_hoverArrow");
					//展开二级菜单
					$childListAll.hide();
					$childListAll.eq(i).show();
				},function(){})
			})
			$menubox_button_all.hover(function(){
				$menubox_button_arrow_all.removeClass("menubox_button_hoverArrow");
				$(this).addClass("menubox_button_hover");
				$childListAll.hide();
			},function(){
				$(this).removeClass("menubox_button_hover");
			})
			
		}
		
		$menuBtn.click(function(){
			if($menuMain[0].style.display=="none"){
				$menuMain.show(200);
				$(this).addClass("top_menuBtnCurrent");
			}
			else{
				$menuMain.hide(200);
				$(this).removeClass("top_menuBtnCurrent");
			}
		});
		
		if($instance.attr("exitText")){
			var $exit=$('<input type="button" class="menubox_exitBtn"/>')
			$exit.attr("value",$instance.attr("exitText"));
			$exit.css("top",parentBtnNum*50+28+"px")
			$menuMain.append($exit);
			$exit.bind("click",function(){
				//关闭菜单
				$instance.officeMenuClose();
				$instance.trigger("exit");
			})
		}
		
	};