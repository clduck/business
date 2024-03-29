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

<!--右键菜单start-->
<script src="<%=path%>/libs/js/nav/contextMenu.js" type="text/javascript"></script>  
<!--右键菜单end-->


</head>
<body>
<div class="box1" panelWidth="800">
  	 <fieldset> 
     <legend>1、显示所有菜单</legend>
     	<div id="target" style="width:200px;border:solid 1px #ccc;">在这里右击</div>
	  </fieldset>
	  <div class="height_50"></div>
	  
	  <fieldset> 
     <legend>2、禁用某些项</legend>
     	<div id="target2" style="width:200px;border:solid 1px #ccc;">在这里右击</div>
	  </fieldset>
	  <div class="height_50"></div>
	  
	  <fieldset> 
     <legend>3、禁用右键</legend>
     	<div id="target3" style="width:200px;border:solid 1px #ccc;">在这里右击</div>
	  </fieldset>
	  
	  
	 </div>
<script type="text/javascript">
    $(function() {
        var option = { width: 150, items: [
                        { text: "第一项", icon: "<%=path%>/libs/images/icons/ico1.gif", alias: "1-1", action: menuAction },
                        { text: "第二项", icon: "<%=path%>/libs/images/icons/ico2.gif", alias: "1-2", action: menuAction },
                        { text: "第三项", icon: "<%=path%>/libs/images/icons/ico3.gif", alias: "1-3", action: menuAction },
                        { type: "splitLine" },
                        { text: "组一集合", icon: "<%=path%>/libs/images/icons/ico4.gif", alias: "1-4", type: "group", width: 170, items: [
                            { text: "组三集合", icon: "<%=path%>/libs/images/icons/ico4-1.gif", alias: "2-2", type: "group", width: 190, items: [
	                            { text: "组3一项", icon: "<%=path%>/libs/images/icons/ico4-1-1.gif", alias: "3-1", action: menuAction },
	                            { text: "组3二项", icon: "<%=path%>/libs/images/icons/ico4-1-1.gif", alias: "3-2", action: menuAction }
                            ]
                            },
                            { text: "组1一项", icon: "<%=path%>/libs/images/icons/ico4-2.gif", alias: "2-1", action: menuAction },
                            { text: "组1二项", icon: "<%=path%>/libs/images/icons/ico4-3.gif", alias: "2-3", action: menuAction },
                            { text: "组1三项", icon: "<%=path%>/libs/images/icons/ico4-4.gif", alias: "2-4", action: menuAction }
                        ]
                        },
                        { type: "splitLine" },
                        { text: "第四项", icon: "<%=path%>/libs/images/icons/ico5.gif", alias: "1-5", action: menuAction },
                        { text: "组二集合", icon: "<%=path%>/libs/images/icons/ico6.gif", alias: "1-6", type: "group", width: 180, items: [
                            { text: "组2一项", icon: "<%=path%>/libs/images/icons/ico6-1.gif", alias: "4-1", action: menuAction },
                            { text: "组2二项", icon: "<%=path%>/libs/images/icons/ico6-2.gif", alias: "4-2", action: menuAction }
                        ]
                        }
                        ], onShow: applyrule,
            onContextMenu: BeforeContextMenu
        };
        function menuAction() {
            alert(this.data.alias);
        }
        function applyrule(menu) {               
            if (this.id == "target2") {
                menu.applyrule({ name: "target2",
                    disable: true,
                    items: ["1-2", "2-3", "2-4", "1-6"]
                });
            }
            else {
                menu.applyrule({ name: "all",
                    disable: true,
                    items: []
                });
            }
        }
        function BeforeContextMenu() {
            return this.id != "target3";
        }
        $("#target,#target2,#target3").contextmenu(option);
    });
</script>
</body>
</html>