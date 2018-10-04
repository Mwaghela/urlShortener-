package com.restApi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilMaster {
	public static Date convertStringToDate(String strDate) {
		if (strDate == null || strDate.equalsIgnoreCase(Constants.EMPTY_STRING)) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		return date;
	}
}
