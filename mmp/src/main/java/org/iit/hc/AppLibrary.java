package org.iit.hc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppLibrary {
	
	public static String selectDate(int days,String pattern)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		return sdf.format(d);
	}
	public void readXLS()
	{
		
	}
	public void readXLSX()
	{
		
	}


}
