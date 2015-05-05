package com.supporthero.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class USHolidays {

	public static HashMap<String,String> listofUSHolidays = new HashMap<String,String>() ;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


	public static HashMap<String,String> getUSHolidayList(int year){
		//New Year
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar retval=new GregorianCalendar();
		retval.set(year, 1, 1);
		int nX = retval.get(Calendar.DAY_OF_WEEK);
		switch(nX)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"01"+"-02",Constants.NEW_YEAR_HOLIDAY);
			break;
		case 1 : // Monday
		case 2 : // Tuesday
		case 3 : // Wednesday
		case 4 : // Thrusday
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"12"+"-31",Constants.NEW_YEAR_HOLIDAY);
			break;
		default :
			// Saturday, then observe on friday of previous year
			listofUSHolidays.put(--year+"-"+"12"+"-31",Constants.NEW_YEAR_HOLIDAY);
			break;

		}
		// Third Monday in January MartinLutherKing

		int nMonth = 1; // January
		Date dtD;

		retval.set(year, 1, 1);
		int nX1 = retval.get(Calendar.DAY_OF_WEEK);
		switch(nX1)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"01"+"-16",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		case 1 : // Monday
			listofUSHolidays.put(year+"-"+"01"+"-15",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		case 2 : // Tuesday
			listofUSHolidays.put(year+"-"+"01"+"-21",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		case 3 : // Wednesday
			listofUSHolidays.put(year+"-"+"01"+"-20",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		case 4 : // Thrusday
			listofUSHolidays.put(year+"-"+"01"+"-19",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"01"+"-18",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		default : // Saturday
			listofUSHolidays.put(year+"-"+"01"+"-17",Constants.MRTN_LTHR_KNG_HOLIDAY);
			break;
		}
		// Third Monday in February is Presidents day

		retval.set(year, 2, 1);
		int nX2 = retval.get(Calendar.DAY_OF_WEEK);

		switch(nX2)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"02"+"-16",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		case 1 : // Monday
			listofUSHolidays.put(year+"-"+"02"+"-15",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		case 2 : // Tuesday
			listofUSHolidays.put(year+"-"+"02"+"-21",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		case 3 : // Wednesday
			listofUSHolidays.put(year+"-"+"02"+"-20",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		case 4 : // Thrusday
			listofUSHolidays.put(year+"-"+"02"+"-19",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"02"+"-18",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		default : // Saturday
			listofUSHolidays.put(year+"-"+"02"+"-17",Constants.PRESIDENTS_DAY_HOLIDAY);
			break;
		}
		//Memorial Day
		retval.set(year, 5, 31); // May

		int nX3 = retval.get(Calendar.DAY_OF_WEEK);

		switch(nX3)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"05"+"-25",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		case 1 : // Monday
			listofUSHolidays.put(year+"-"+"05"+"-31",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		case 2 : // Tuesday
			listofUSHolidays.put(year+"-"+"05"+"-30",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		case 3 : // Wednesday
			listofUSHolidays.put(year+"-"+"05"+"-29",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		case 4 : // Thrusday
			listofUSHolidays.put(year+"-"+"05"+"-28",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"05"+"-27",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		default : // Saturday
			listofUSHolidays.put(year+"-"+"05"+"-26",Constants.MEMORIAL_DAY_HOLIDAY);
			break;
		}

		// Independence Day
		retval.set(year, 7, 4); // 4th July
		int nX4 = retval.get(Calendar.DAY_OF_WEEK);
		switch(nX4)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"07"+"-05",Constants.INDEPENDENCE_DAY_HOLIDAY);
			break;

		case 1 : // Monday
		case 2 : // Tuesday
		case 3 : // Wednesday
		case 4 : // Thrusday
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"07"+"-04",Constants.INDEPENDENCE_DAY_HOLIDAY);
			break;

		default :
			// Saturday
			listofUSHolidays.put(year+"-"+"07"+"-03",Constants.INDEPENDENCE_DAY_HOLIDAY);
			break;

		}



		// The first Monday in September
		retval.set(year, 9, 1); // Labor Day

		int nX5 = retval.get(Calendar.DAY_OF_WEEK);

		switch(nX5)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"09"+"-02",Constants.LABOR_DAY_HOLIDAY);
			break;

		case 1 : // Monday
			listofUSHolidays.put(year+"-"+"09"+"-07",Constants.LABOR_DAY_HOLIDAY);
			break;

		case 2 : // Tuesday
			listofUSHolidays.put(year+"-"+"09"+"-06",Constants.LABOR_DAY_HOLIDAY);
			break;

		case 3 : // Wednesday
			listofUSHolidays.put(year+"-"+"09"+"-05",Constants.LABOR_DAY_HOLIDAY);
			break;

		case 4 : // Thrusday
			listofUSHolidays.put(year+"-"+"09"+"-04",Constants.LABOR_DAY_HOLIDAY);
			break;

		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"09"+"-03",Constants.LABOR_DAY_HOLIDAY);
			break;

		default : // Saturday
			listofUSHolidays.put(year+"-"+"09"+"-02",Constants.LABOR_DAY_HOLIDAY);
			break;

		}


		// Adding Thanks Holiday
		listofUSHolidays.put(year+"-"+"10"+"-31",Constants.HALLOWEEN_HOLIDAY);

		
		
		retval.set(year, 11, 1); //  November

		int nX6 = retval.get(Calendar.DAY_OF_WEEK);

		switch(nX6)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"11"+"-26",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;
		case 1 : // Monday
			listofUSHolidays.put(year+"-"+"11"+"-25",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		case 2 : // Tuesday
			listofUSHolidays.put(year+"-"+"11"+"-24",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		case 3 : // Wednesday
			listofUSHolidays.put(year+"-"+"11"+"-23",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		case 4 : // Thrusday
			listofUSHolidays.put(year+"-"+"11"+"-22",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"11"+"-28",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		default : // Saturday
			listofUSHolidays.put(year+"-"+"11"+"-27",Constants.THANKSGIVINING_DAY_HOLIDAY);
			break;

		}
		
		
		retval.set(year, 12, 25); //  Christmas Holiday Observed. Day before or after Christmas

		int nX7 = retval.get(Calendar.DAY_OF_WEEK);

		switch(nX7)
		{
		case 0 : // Sunday
			listofUSHolidays.put(year+"-"+"12"+"-26",Constants.CHRISTMAS_HOLIDAY);
			break;

		case 1 : // Monday
		case 2 : // Tuesday
		case 3 : // Wednesday
		case 4 : // Thrusday
		case 5 : // Friday
			listofUSHolidays.put(year+"-"+"12"+"-25",Constants.CHRISTMAS_HOLIDAY);
			break;

		default : // Saturday
			listofUSHolidays.put(year+"-"+"12"+"-24",Constants.CHRISTMAS_HOLIDAY);
			break;
		}
		
		listofUSHolidays.put(year+"-"+"12"+"-25",Constants.CHRISTMAS_HOLIDAY);

		return listofUSHolidays;

	}


//	public static void main(String[] args){
//		HashMap map =USHolidayList(2015);
//		 Iterator it = map.entrySet().iterator();
//		 while (it.hasNext()) {
//		        Map.Entry pair = (Map.Entry)it.next();
//		        System.out.println(pair.getKey() + " = " + pair.getValue());
//		       // it.remove(); // avoids a ConcurrentModificationException
//		    }
//	}
}



