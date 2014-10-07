<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>表单验证</title>

<!--框架必需start -->
<jsp:include page="/manage/accordion/framework_inc.jsp" flush="false" />
<!--框架必需end -->

</head>
<body>
 <div class="box1" panelWidth="800">
    <fieldset>
      <legend>新增信息</legend>
   <form id="addFrom" method="post" >
	 <table class="tableStyle" formMode="line">
		<tr>
			<th colspan="4">表单填写</th>
		</tr>
		<tr>
			<td width="15%">企业名称：</td>
			<td>
				<input type="text" name="aboutName" id="aboutName" class="validate[required]" /><span class="star">*</span>
			</td>
		    <td width="15%">是否显示：</td>
			<td>
				<div style="width:120px;">
					<input type="radio" id="viewFlag-1" name="viewFlag" class="validate[required] radio"  value="1"/><label for="viewFlag-1" class="hand">是</label>
					<input type="radio" id="viewFlag-2" name="viewFlag" class="validate[required] radio" value="2"/><label for="viewFlag-2" class="hand">否</label> <span class="star">*</span>
				</div>
			</td>
		</tr>
		<tr>
			<td>单选下拉框：</td>
			<td>
				<select id="clickNumber" name="clickNumber" class="validate[required]" prompt="请选择"  data='{"list":[{"value":"1","key":"1"},{"value":"2","key":"2"}]}'></select><span class="star">*</span>
			</td>
			<td>创建时间：</td>
			<td>
				<input id="addTime" name="addTime" type="text" class="date validate[required,custom[date]]"/><span class="star">*</span>
			</td>
		</tr>
		<tr>
			<td>公司简介：</td>
			<td colspan="3" >
				<textarea id="content" name="content" watermark="请填写公司简介" maxNum="150" style="width:600px;height:100px;"></textarea>
			</td>
		</tr>
	 </table>
  </form>
 </fieldset>
  <div class="height_15"></div>
 </div>

<script type="text/javascript">
	//表单验证
	function beforeAjaxHander(){
		var valid = $("#addFrom").validationEngine({returnIsValid: true});
		if(valid){
			var modelObj = $("#addFrom").formToArray(); 
			return modelObj;
		}
	}
</script>

</body>
</html>