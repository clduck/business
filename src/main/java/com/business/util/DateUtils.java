package com.business.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils {

	private static Log logger = LogFactory.getLog(DateUtils.class);
	/**
	 *  时间格式化成字符串
	 *  @time : 2012-1-21 
	 *  @author :cl
	 *  @description : 
	 *  @return : String
	 *
	 */
	public static String dateFormatStr(Date date,String formateStr){
		DateFormat formate = new SimpleDateFormat(formateStr);
		return  formate.format(date);
	}
	/**
	 * 字符串格式化成时间
	 *  @time : 2012-1-21 
	 *  @author :cl
	 *  @description : 
	 *  @return : Date
	 *
	 */
	public static Date strFormateDate(String dateStr,String formateStr){
		DateFormat formate = new SimpleDateFormat(formateStr);
		Date date = null;
		try {
			date = formate.parse(dateStr);
		} catch (ParseException e) {
			logger.error("字符串格式化时间失败： " + e.getMessage());
		}
		return date;
	}
	public static void main(String[] args) {
		//System.setProperty("user.timezone", "GMT+08");
		System.out.println(DateUtils.dateFormatStr(new Date(), "yyyy年MM月dd日 HH:mm:ss"));
	}
}
 