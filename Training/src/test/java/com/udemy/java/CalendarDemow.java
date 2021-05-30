package com.udemy.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date=new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf=new SimpleDateFormat("M/d/yyyy");
		
		String todayDate = sdf.format(date);
		System.out.println(todayDate);
		
		
		///////////////// Calendar Class have more methods than Date Class//////
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.AM_PM));
		System.out.println(cal.get(Calendar.MINUTE));
		
	}

}
