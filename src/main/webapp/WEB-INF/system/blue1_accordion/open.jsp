<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<jsp:include page="/manage/accordion/framework_inc.jsp" flush="false" />
<!--框架必需end-->


<script>
	 $(function(){
		$(".navIcon").jomino();
	});
	function customHeightSet(contentHeight){
		$("#scrollContent").height(contentHeight);
	}
</script>
<!--动画方式入场效果end-->
</head>
<body>
<div id="scrollContent">
	<table width="100%" height="90%">
		<tr><td class="ali02 ver02">
			<div  style="width:800px;margin:0 auto;">
			<table class="ali01 ver01">
				<tr height="146">
					<td width="260">
						<div class="navIcon" onclick="top.Dialog.alert('个人中心')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/01.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">个人中心</div>
								<div class="navIcon_right_con">
									个人基础信息设置<br />
									手机短信提醒设置<br />
									更改密码
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td width="260">
						<div class="navIcon" onclick="top.Dialog.alert('个人收藏夹')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/02.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">个人收藏夹</div>
								<div class="navIcon_right_con">
									查看曾经加入到收藏夹中的数据
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td width="260">
						<div class="navIcon" onclick="top.Dialog.alert('高级搜索')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/03.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">高级搜索</div>
								<div class="navIcon_right_con">
									可搜索整个系统的数据<br />
									可选择多种过滤条件
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
				</tr>
				<tr height="146">
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('文档管理')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/04.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">文档管理</div>
								<div class="navIcon_right_con">
									保存了自己的文档附件和别人转发的文档
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('帮助中心')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/05.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">帮助中心</div>
								<div class="navIcon_right_con">
									系统使用常见问题<br />
									用户手册<br />
									系统更新日志等
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('个人存储空间')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/06.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">个人存储空间</div>
								<div class="navIcon_right_con">
									每个用户在系统中有100M的存储空间。在这里可进行管理
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
				</tr>
				<tr height="146">
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('附件管理')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/07.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">附件管理</div>
								<div class="navIcon_right_con">
									保存了自己上传的附件<br />
									可进行下载、删除等操作
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('通知消息')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/08.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">通知消息</div>
								<div class="navIcon_right_con">
									系统发送的消息<br />
									其他用户发送的消息
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
					<td>
						<div class="navIcon" onclick="top.Dialog.alert('回收站')" style="display:none;">
							<div class="navIcon_left"><img src="<%=path%>/libs/icons/png/09.png"/></div>
							<div class="navIcon_right">
								<div class="navIcon_right_title">回收站</div>
								<div class="navIcon_right_con">
									保存了曾经删除的数据和文档资料等
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</td>
				</tr>
			</table>
			</div>
		</td></tr>
	</table>
</div>
</body>
</html>