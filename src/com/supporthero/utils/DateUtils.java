package com.supporthero.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.supporthero.exception.InvalidInputException;

public class DateUtils {

	/*
	 * Helper method to validate data in file
	 * 
	 * @param fileInputString
	 *            string from file that needs validation
	 * */
	public static boolean checkDate(String fileInputString) {
		boolean isDate = true;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar retval=new GregorianCalendar();
		try {
			retval.setTime(sdf.parse(fileInputString));
		} catch (ParseException e) {
			isDate = false;
		}
		return isDate;
	}


	/*
	 * Helper method to validate working day based on input
	 * 
	 * @param fileInputString
	 *            string from file that needs validation
	 * */
	public static boolean checkValidateWorkingDay(String date,String personName) {
		boolean validateWorkingDay = true;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar retval=new GregorianCalendar();
		try {
			retval.setTime(sdf.parse(date));
		} catch (ParseException e) {
			validateWorkingDay = false;
		}
		if(retval.get(Calendar.DAY_OF_WEEK)==1){
			System.out.println("Its Sunday. Cannot assign duty for "+personName);
			validateWorkingDay = false;
		} 
		return validateWorkingDay;
	}


	/*
	 * Returns current date
	 *
	 */
	public static String getTodayDate()
	{
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		return sdf.format(date);
	}

	/*
	 * checks if mentioned date is US Holiday
	 */

	public static boolean checkUSHolidays(String date){
		boolean checkUSHoliday = false;
		try{
			HashMap<String,String> holidayList = USHolidays.getUSHolidayList(Integer.parseInt(date.substring(0,4)));
			Iterator it = holidayList.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				if(pair.getKey().equals(date)){
					System.out.println("Cannot schedule duty on "+pair.getValue());
					checkUSHoliday = true;
					break;
				}
			}
		} catch (NumberFormatException e){
			e.printStackTrace();
			System.out.println("Invalid date entered.");
			System.exit(1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Unexpected error occured. Program will exit");
		}
		return checkUSHoliday;

	}
}
