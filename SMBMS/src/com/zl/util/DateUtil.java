package com.zl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static String parseDate(Date date){
		return sdf.format(date);
	}
	/**
	 * ���ַ���תΪ����
	 * @param dateString
	 * @return
	 */
	public static Date parseString(String dateString){
		Date resDate = null;
		try {
			resDate = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resDate;
	}
}
