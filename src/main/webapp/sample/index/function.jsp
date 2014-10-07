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
</head>
<body>
<div class="box2" panelTitle="固有方法">
	<table class="tableStyle" >
			<tr><th>函数名</td><th>描述</td><th>应用场景</td></tr>
			<tr>
			<td>function initComplete(){}函数</td>
			<td>如果页面中有这个函数，当框架所有组件渲染结束后，后台会调用当前页面initComplete()函数</td>
			<td>示例中随处可见该方法，例如树组件的所有示例。具体用法见开发手册的“使用框架必备知识”章节</td>
			</tr>
			
			<tr>
			<td>function customHeightSet(){}函数</td>
			<td>如果页面中有这个函数，每当浏览器尺寸发生变化时，后台都会调用一下当前页面customHeightSet()函数</td>
			<td>“常用情景模板”中大部分示例都使用了这个方法，在该函数中取得滚动内容区域的高度，根据此值来设置其他容器的高度，来实现容器的高度自适应页面高度</td>
			</tr>
			
			
			<tr>
			<td>$("#scrollContent").height()</td>
			<td>用于取得滚动内容区域的高度，在customHeightSet()中调用可随时取得该区域真实高度。</td>
			<td>同上</td>
			</tr>
			
			<tr>
			<td>resetHeight()</td>
			<td>调用该方法会重新计算并设置滚动区域高度。当固定区域高度发生变化时可以调用它来重设高度。</td>
			<td>在盒子模型内部实现机制中，盒子收缩时会调用该方法，重新计算并设置滚动区域高度</td>
			</tr>
			
			<tr>
			<td>showProgressBar(title,type)</td>
			<td>该方法用于开启进度条，参数<br/>
			title:标题<br/>
			type:进度条类型，默认为simple:简洁型进度条，设置为"normal"则会变成弹窗型进度条
			</td>
			<td>各框架主页点击左侧导航时调用。注意，如果无法加载新页面则进度窗口就无法关闭，所以在使用前要预先判断链接是否设置了地址。见各导航页面。</td>
			</tr>
			
			<tr>
			<td>closeProgress()</td>
			<td>该方法用于关闭进度条窗口</td>
			<td>每当页面加载完毕后内部会调用该方法来关闭进度条</td>
			</tr>
			
			<tr>
			<td>fullScrennHander(state,hideNav)</td>
			<td>框架开放的全屏函数，参数：<br/>
			state:通过true和false表示是开启全屏还是关闭全屏<br/>
			hideNav:通过true和false表示全屏时是否隐藏导航区域
			</td>
			<td>无</td>
			</tr>
			
			<tr>
			<td>changeFont(num)</td>
			<td>更改字体大小</td>
			<td>每个主页顶部更改文字大中小会内部调用</td>
			</tr>
			
			<tr>
			<td>enableTooltips()</td>
			<td>重新渲染一次title提示，用于动态添加或改变title的情况</td>
			<td>“提示类组件>>鼠标提示”中动态添加和修改title时用到</td>
			</tr>
			
			<tr>
			<td>render()</td>
			<td>重新渲染组件，要调用该方法必须是一个jquery对象，用法为XXX. render()
			</td>
			<td>大部分表单元素和table都有该方法。用于动态新增组件或动态改变组件的属性。</td>
			</tr>
			
			<tr>
			<td>iframeHeight(iframeId)</td>
			<td>该方法用于让iframe自适应高度</td>
			<td>具体用法见开发手册的“使用框架必备知识”章节</td>
			</tr>
			
			<tr>
			<td>winScrollContent(弹窗ID)</td>
			<td>该方法用于设置弹窗内容滚动区域</td>
			<td>“table表格>>弹窗中的表格”中用到</td>
			</tr>
			
			<tr>
			<td>getPosition(value,array)</td>
			<td>获得数组值的索引</td>
			<td>内部在实现单选下拉框组件时用到</td>
			</tr>
			
			<tr>
			<td>jQuery.jCookie()</td>
			<td>用户创建、读取、删除cookie</td>
			<td>具体用法见开发手册的“使用框架必备知识”章节</td>
			</tr>
			
			<tr>
			<td>JSON.parse()</td>
			<td>将JSON格式的字符串转成JSON对象。注意字符串键值都需要加双引号</td>
			<td>对表单元素设置data赋值时，内部引擎都会把该值取出后转为JSON对象</td>
			</tr>
			
			<tr>
			<td>JSON.stringify()</td>
			<td>将JSON对象转为JSON格式的字符串</td>
			<td>“grid表格>>表格动态操作”获取表格的JSON数据对象后转成字符串后用alert打出</td>
			</tr>
		</table>
</div>
<div class="box2" panelTitle="公共变量">
	<table class="tableStyle" >
			<tr><th>变量名</td><th>描述</td><th>应用场景</td></tr>
			<tr>
			<td>broswerFlag</td>
			<td>得到当前浏览器标识，有 IE6、IE7、IE8、IE9、Firefox、Opera、Safari、Other</td>
			<td>该变量已经在页面初始化时有framework引擎赋值，以后直接使用即可</td>
			</tr>
			
			<tr>
			<td>themeColor</td>
			<td>得到当前主题颜色</td>
			<td>自定义日期控件用到，用于设置控件皮肤与框架当前风格匹配</td>
			</tr>
			
			<tr>
			<td>fixHeight</td>
			<td>得到当前固定区域高度总和</td>
			<td>内部用到</td>
			</tr>
			
		</table>
</div>

</body>
</html>