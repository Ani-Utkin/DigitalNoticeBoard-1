package com.ualbany.digitalnoticeboard.utils;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DnbADateFormat extends DateFormat  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final List<? extends DateFormat> DATE_FORMATS = Arrays.asList(
	        new SimpleDateFormat("dd-MM-yyyy"),
	        new SimpleDateFormat("mm/dd/yyyy"));

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date parse(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
