package com.coder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	public static Date stringToDate_dd_mm_yyy(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("dd/MM/yyy").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return formatDate;
	}
	public static String dateToString_DB_Format(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = formatter.format(date);  
	    //System.out.println("dateToString_DB_Format="+strDate);
	    return strDate;
		}
	public static Date stringToDateFormat_dd_mm_yyyy(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return formatDate;
	}
	
	public static Date stringToTime(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("hh:mm:ss").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return formatDate;
	}
	public static String dateToString_dd_MMMM_yyyy(Date date){
    SimpleDateFormat	formatter = new SimpleDateFormat("dd MMMM yyyy");  
    String strDate = formatter.format(date);  
    return strDate;
	}
	public static String dateToString_YYYY(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
		}
	public static String dateToStringFormat_dd_mm_yyyy(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
		}
	public static String dateToDayAM_PM(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm aa");
		String formattedDate = dateFormat.format(date).toString();
		return formattedDate;
	}
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
	public static long dateDiff(Date d1,Date d2) throws ParseException{
		
		long diff = d1.getTime() - d2.getTime();
		      Long day= diff / (1000 * 60 * 60 * 24);
		      return day;
		
		}
	public static Date subDays(int day,Date date) 
    {
		System.out.println("RentDate="+date);
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		Date date2=calendar.getTime();
		System.out.println("AfterAdd="+date2);
		return date2;
	   
    }
	public static Date subDays(int day) 
    {
		
		Calendar calendar = Calendar.getInstance(); 
		
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		Date date2=calendar.getTime();
		System.out.println("AfterAdd="+date2);
		return date2;
	   
    }

}
