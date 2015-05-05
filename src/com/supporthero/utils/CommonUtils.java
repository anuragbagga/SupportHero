package com.supporthero.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.supporthero.exception.ExceptionInfo;
import com.supporthero.exception.SystemException;


public class CommonUtils {

	private static Properties commonProperty = new Properties();
	private static FileReader fileReader;

	static {
		try {

			InputStream is =Thread.currentThread().getContextClassLoader() 
					.getResourceAsStream("supporthero.properties");
			commonProperty.load(is);
		} catch (IOException ioe) {
			raiseSytemException(Constants.ERRCODE_IO_EXCEPTION, ioe);
		} catch (Exception e) {
			raiseSytemException(Constants.ERRCODE_EXCEPTION, e);
		}
	}


	/**
	 * @param property
	 *            property to read from property value.
	 * @return value corresponding to the property
	 */
	public static String getProperty(String property) {
		return commonProperty.getProperty(property);
	}

	/**
	 * This method handles exception at System level and throws SystemException
	 * 
	 * @param messageKey
	 *            String
	 * @param stackTrace
	 *            String
	 * @param logLevel
	 *            String
	 * @param throwable
	 *            Throwable
	 * @throws SystemException
	 */


	public static void raiseSytemException(String messageKey,
			Exception exception) throws SystemException {
		ExceptionInfo exceptionInfo = new ExceptionInfo();
		exceptionInfo.setCode(messageKey);
		exceptionInfo.setStackTrace(getExceptionStackTraceAsString(exception));
		throw new SystemException(exceptionInfo, exception);
	}


	/**
	 * This methods sends the stack trace in string format
	 * 
	 * @param exception
	 *            Exception
	 * @return String
	 */
	public static String getExceptionStackTraceAsString(Exception exception) {
		return exception.toString() + "\n"
				+ Arrays.asList(exception.getStackTrace()).toString();
	}


	public static ConcurrentHashMap loadRoster() {
		BufferedReader bufferedReader;
		ConcurrentHashMap<String,String> hm = new ConcurrentHashMap<String,String>();
		try {
			// Loading sample roster for demo purpose
			fileReader = new FileReader("../InputFile/roster.txt");
			bufferedReader = new BufferedReader(fileReader);
			String currentLine = null;
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] array = currentLine.split(",");
				System.out.println(array[0]+":"+array[1]);
				// Checks for valid date, checks Sunday and US Holiday 
				if (DateUtils.checkDate(array[0]) && DateUtils.checkValidateWorkingDay(array[0], array[1]) && !(DateUtils.checkUSHolidays(array[0]))) {
					hm.put(array[0], array[1]);
				} 
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return hm;
	}

	public static String todaySupportHero(ConcurrentHashMap<String,String> roster){
		String name = null;
		String todayDate = DateUtils.getTodayDate();
		try {
			for (ConcurrentHashMap.Entry<String, String> entry: roster.entrySet()) {
				if(todayDate.equals(entry.getKey())){
					name = (String) entry.getValue();
					break;
				}
			}
		}catch(Exception e){

			System.out.println("Roster not loaded. Please load the roster by pressing 1 in main menu.");

		}
		return name;
	}

	/* Displays schedule or  US holidays in ascending order.
	 * Using a TreeMap for displaying elements in sorted order
	 * 
	 */

	public static void displaySupportSchedule(Map<String,String> roster){
		try {
			Map<String, String> treeMap = new TreeMap<String, String>(roster);
			for (Map.Entry<String, String> entry: treeMap.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());	
			}
		}catch(Exception e){
			System.out.println("Roster not loaded. Please load the roster by pressing 1 in main menu.");
		}
	}
	
	/* Add a Support hero on a given date.
	 * Cannot add another support hero if already added
	 * 
	 */

	public static ConcurrentHashMap addSupportHero(ConcurrentHashMap<String,String> roster,String date,String name){
		try {
			boolean flag=false;
			if(!roster.isEmpty()){
				Iterator<String> it1 = roster.keySet().iterator();
				while(it1.hasNext()){
					String key = it1.next();
					if(date.equals(key)){
						System.out.println((String) roster.get(key)+"already assigned on this date. Cannot add. Please delete duty and add again");
						flag=true;
						break;
					}
				}
				if(!flag){
					System.out.println(name+" added to support duty");
					roster.put(date, name);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Roster not loaded. Please load the roster by pressing 1 in main menu.");
		}
		return roster;
	}

	
	/* Removes Support hero on a given date.
	 * Cannot add another support hero if already added
	 * 
	 */
	public static ConcurrentHashMap<String,String> removeSupportHero(ConcurrentHashMap<String,String> roster,String date){
		boolean flag=false;
		try {
			if(!roster.isEmpty()){
				for (ConcurrentHashMap.Entry<String, String> entry: roster.entrySet()) {
					if(date.equals(entry.getKey())){
						System.out.println((String) entry.getValue()+"is removed for support duty on "+entry.getKey());
						roster.remove(date);
						flag=true;
						break;
					}  
				}
				if(!flag){
					System.out.println("No Matching support duty found on date "+date+". Please check again");
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Roster not loaded. Please load the roster by pressing 1 in main menu.");
		}
		return roster;
	}

}
