var zTree_Menu = null;
	var setting = {
		view: {
			fontCss: getFontCss,
			showLine: false,
			selectedMulti: false,
			dblClickExpand: false
		},
		callback: {
			beforeClick:beforeClick,
			onClick: onClick
		}
	};
	
	$(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
		
		
		 $("#searchKey").keydown(function(event){
		 	if(event.keyCode==13){
				findNode();
			}
		 })
	})
	
	//每次刷新时保持上次打开的
	function showContent(){
	}
	//每次点击切换状态和样式
	function beforeClick(treeId, treeNode) {
			//第一级点击项添加选中样式
			if (treeNode.level === 0) {
				//第一级移除选中样式
				$("#"+treeId).find("a").each(function(){
					if($(this).hasClass("cur")){
						$(this).removeClass("cur");
					}
				})
				
				var a = $("#" + treeNode.tId + "_a");
				a.addClass("cur");
			
				//单击展开或收缩
				if(treeNode.open){
					zTree_Menu.expandNode(treeNode,false);
					var a = $("#" + treeNode.tId + "_a");
					a.removeClass("cur");
					a.removeClass("curSelectedNode");
				}
				else{
					zTree_Menu.expandAll(false);
					zTree_Menu.expandNode(treeNode);
				}
			}
			else{
				zTree_Menu.expandNode(treeNode);
			}
			
			
		}
		
	function onClick(e,treeId, treeNode){
		if (treeNode.link!=null) {
			tabAddHandler(treeNode.id,treeNode.name,treeNode.link);
		}
	}
	

	function  showAll(){
		zTree_Menu.expandAll(true);
	}
	function  hideAll(){
		zTree_Menu.expandAll(false);
		jQuery.jCookie('leftTreeNodeId',"false");
	}
	function findNode(){
		var value = $.trim($("#searchKey").val());
		if(value!=""){
			getNodesByParamFuzzy('name', value)
		}
	}
	 //根据某一条件查找节点 模糊查询
    function getNodesByParamFuzzy(key, value, parentNode){
        var nodes = zTree_Menu.getNodesByParamFuzzy(key, value, parentNode);  
        //取消之前的高亮显示
        highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
        //高亮显示
        highlightNodes(zTree_Menu, nodes, true);
        zTree_Menu.highlightNodeList = nodes;
        //选中第一个
        if(null != nodes && nodes.length > 0){
            zTree_Menu.expandAll(false);
			var pNode=nodes[0].getParentNode()
			zTree_Menu.expandNode(pNode,true);
			zTree_Menu.expandNode(nodes[0],true);
        }
    }
	
	//根据某一条件查找节点 精确查询
    function getNodesByParam(key, value, parentNode){
        var nodes = zTree_Menu.getNodesByParam(key, value, parentNode);  
        //取消之前的高亮显示
        highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
        //高亮显示
        highlightNodes(zTree_Menu, nodes, true);
        zTree_Menu.highlightNodeList = nodes;
        //选中第一个
        if(null != nodes && nodes.length > 0){
           
			var pNode=nodes[0].getParentNode()
			if(!pNode.open){
				 zTree_Menu.expandAll(false);
				 zTree_Menu.expandNode(pNode,true);
			}
			//zTree_Menu.expandNode(nodes[0],true);
        }
    }
    
    //高亮显示
    function highlightNodes(zTree, nodes, highlight) {
        if(null == nodes)  return;
		for( var i = 0, l = nodes.length; i < l; i++) {
			nodes[i].highlight = highlight;
			zTree.updateNode(nodes[i]);
		}
	}
	function getFontCss(treeId, node){
	    return (!!node.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	}
	//返回首页的处理
	function homeHandler(){
		zTree_Menu.expandAll(false);
	}
