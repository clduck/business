<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本表格模板</title>
<!--框架必需start-->
<jsp:include page="/manage/accordion/framework_inc.jsp" flush="false" />
<!--框架必需end-->

</head>
<body>
	<table width="100%" >
	<tr>
		<!--左侧区域start-->
		<td class="ver01" >
			 <div class="box2"  overflow="auto" showStatus="false" panelTitle="组织结构树">
			 	<div class="cusBoxContent"  style="width:150px;">
			  		<ul id="tree-1" class="ztree"></ul>
			  	</div>
		  	</div>
		</td>
		<!--左侧区域end-->
		
		<!--右侧区域start-->
		<td width="100%" class="ver01" >
			<div class="box2" panelTitle="查询"  showStatus="false">
				<form id="queryForm" method="post">
				<table>
					<tr>
						<td>企业名称：</td>
						<td><input id="searchInput" name="conditions.aboutName" type="text" /></td>
						<td><button type="button" onclick="searchHandler()"><span class="icon_find">查询</span></button></td>
						<td><button type="button" onclick="resetSearch()"><span class="icon_reload">重置</span></button></td>
					</tr>
				</table>
				</form>
				</div>
			<div style="margin: 0;padding: 0 5px 0 0;">
				<div id="maingrid"></div>
			</div>
		</td>
		<!--右侧区域end-->
	</tr>
	</table>
<script type="text/javascript">
	var nodes1 = [
		{ id:1,  parentId:0, name:"中心1", open: true,icon:path+"/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"部门1",icon:path+"/libs/icons/user_group.gif"},
		{ id:12, parentId:1, name:"部门2",icon:path+"/libs/icons/user_group.gif"},
		{ id:13, parentId:1, name:"部门3",icon:path+"/libs/icons/user_group.gif"},
		{ id:2,  parentId:0, name:"中心2", open: true,icon:path+"/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"部门4",icon:path+"/libs/icons/user_group.gif"},
		{ id:22, parentId:2, name:"部门5",icon:path+"/libs/icons/user_group.gif"},
		{ id:23, parentId:2, name:"部门6",icon:path+"/libs/icons/user_group.gif"}
	];
	
	//数据表格使用
    var grid;
	
	function initComplete(){
	  //本地数据源
	  $.fn.zTree.init($("#tree-1"), {}, nodes1);
	  grid = $("#maingrid").quiGrid({
       columns: [ 
	                { display: '企业ID', name: 'aboutID',     align: 'left', width: "20%"},
	                { display: '企业名称', name: 'aboutName',      align: 'left', width: "20%"},
	                { display: '部门', name: 'deptName', align: 'left', width: "20%", isSort:false},
	                { display: '学历', name: 'degree',   align: 'left', width: "20%" },
                	{ display: '操作', isAllowHide: false, align: 'left', width: 80,
						 //操作列渲染为图标
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_view hand" title="查看" onclick="onView(' + rowdata.id + ')"></span>'
	                                 + '<span class="img_edit hand" title="修改" onclick="onEdit(' + rowdata.id + ')"></span>' 
	                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.id+','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            }
         ], 
        url: path+'/aboutInfo/getPages.xhtml', 
        sortName: 'aboutID',
        rownumbers:true,
        checkbox:true,
        height: '100%', 
        width:"100%",
        pageSize:10,
        //顶部图标按钮栏
		toolbar: 
			{ 
			items: [
                { text: '新增', click: onAdd, iconClass: 'icon_add' },
                { line: true },
                { text: '批量删除', click: deleteUser, iconClass: 'icon_delete' },
                { line: true },
                { text: '导入', click: importUser, iconClass: 'icon_import' },
                { line: true },
                { text: '导出当前页', click: exportUser, iconClass: 'icon_export' },
                { line: true },
                { text: '导出所有', click: exportUser2, iconClass: 'icon_export' }
            ]
        }
        });
	  
		//监听查询框的回车事件
		$("#searchInput").keydown(function(event){
			if(event.keyCode==13){
				searchHandler();
			}
		})
	}
	
	
	//添加
	function onAdd() {
		var diag = new top.Dialog();
		diag.Title = "新增";
// 		diag.ShowMaxButton=true;
// 		diag.ShowMinButton=true;
		diag.Width=800;
		diag.Height=400;
		diag.OKEvent = function(){
			var modelObj = diag.innerFrame.contentWindow.beforeAjaxHander();
			if(modelObj){
				$.post(path+"/aboutInfo/saveAboutInfo.xhtml",
						modelObj,
						function(result){
							 top.Dialog.alert(result.msg);
							 grid.loadData();//加载数据
							 diag.close();
						},"json");
				
				};
			}
			
		diag.CancelEvent = function(){
			diag.close();
			};
		diag.URL = path+"/aboutInfo/add.xhtml";
		diag.ShowButtonRow=true;
		diag.show();
	}
	
	//批量删除
	function deleteUser() {
		top.Dialog.alert("向后台发送ajax请求来批量删除。见JAVA版或.NET版演示。");
	}
	
	//导入
	function importUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	//导出
	function exportUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//导出所有
	function exportUser2() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//查看
	function onView(rowid){
		alert("选择的记录Id是:" + rowid );
		top.Dialog.open({URL:path+"/sample_html/layout/user-management-content2.html",Title:"查看",Width:500,Height:330}); 
	}
	
	//修改
	function onEdit(rowid){
		var diag = new top.Dialog();
		diag.Title = "编辑";
// 		diag.ShowMaxButton=true;
// 		diag.ShowMinButton=true;
		diag.Width=800;
		diag.Height=400;
		diag.OKEvent = function(){
			var modelObj = diag.innerFrame.contentWindow.beforeAjaxHander();
			if(modelObj){
				$.post(path+"/aboutInfo/saveAboutInfo.xhtml",
						modelObj,
						function(result){
							 top.Dialog.alert(result.msg);
							 grid.loadData();//加载数据
							 diag.close();
						},"json");
				
				};
			}
			
		diag.CancelEvent = function(){
// 			alert("点击了取消");
			diag.close();
			};
		diag.URL = path+"/aboutInfo/edit.xhtml?rowid="+rowid;
		diag.ShowButtonRow=true;
		diag.show();
	}
	
	//删除
	function onDelete(rowid,rowidx){
		top.Dialog.confirm("确定要删除该记录吗？",function(){
		  	top.Dialog.alert("向后台发送ajax请求来删除。见JAVA版或.NET版演示。");
		});
	}
	
	function customHeightSet(contentHeight){
		$(".cusBoxContent").height(contentHeight-55)
	}
	//查询
	function searchHandler(){
		var query = $("#queryForm").formToArray(); 
		
		var modelObj = query;
	    grid.setOptions({ params : modelObj});
	    //页号重置为1
	    grid.setNewPage(1);
	    grid.loadData();//加载数据
	}
	//获取行数据
	function getRowData(rowid){
		var rowData = grid.getRow(rowid);
		return rowData;
	}

	//重置查询
	function resetSearch(){
		$("#queryForm")[0].reset();
// 	   searchHandler();
	}
</script>	
</body>
</html>