package com.business.util.property;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateEditor extends PropertyEditorSupport {

	@Override
	/**
	 * text是表单传入的数据内容
	 */
	public void setAsText(String text) {
		Date value = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		try {
			value = sdf.parse(text);
		} catch (ParseException e1) {
			sdf.applyPattern("MM/dd/yyyy");
			try {
				value = sdf.parse(text);
			} catch (ParseException e2) {
				value = null;
			}
		}
		// 这一步将转换好的数据写入到对象映射的属性中
		setValue(value);
	}
}
