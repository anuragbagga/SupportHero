package com.supporthero.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Menu {

	BufferedReader br;
	int selectedOption;
	private ConcurrentHashMap roster;

	public Menu(ConcurrentHashMap roster) {
		this.roster=roster;
		showMainMenu(this.roster);
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			selectedOption = Integer.parseInt(br.readLine());
			switch (selectedOption) {
			case 1:
				showSubMenuOptions(1);
				break;
			case 2:
				showSubMenuOptions(2);
				break;
			case 3:
				showSubMenuOptions(3);
				break;
			case 4:
				showSubMenuOptions(4);
				break;
			case 5:
				showSubMenuOptions(5);
				break;
			case 6:
				showSubMenuOptions(6);
				break;
			case 7:
				showSubMenuOptions(7);
				break;
			case 8:
				quitProgram();
				break;
			}
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your input." + ioe);
			System.exit(1);
		}
	}

	public void showMainMenu(ConcurrentHashMap roster) {
		System.out.println("");
		System.out.println("Main Menu");
		System.out.println("---------------------------");
		System.out.println("1. Load Roster from input file");
		System.out.println("2. Today Support Hero");
		System.out.println("3. View Roster for Support Heros");
		System.out.println("4. Add Duty");
		System.out.println("5. Delete Duty");
		System.out.println("6. List of Holidays for current year");
		System.out.println("7. Exit the program");
		System.out.println("----------------------------");
		System.out.println("");
		System.out.print("Please select an option from 1-7");
		System.out.println("");
		System.out.println("");
	}

	public void showSubMenuOptions(int mainMenuChoice) {
		switch (mainMenuChoice) {
		case 1:
			System.out.println("");
			System.out.println("Loading Roster....");
			System.out.println("---------------------------");
			roster = CommonUtils.loadRoster();
			System.out.println("Roster Loaded....");
			new Menu(roster);
			
			System.out.println("");
			break;
		case 2:
			System.out.println("");
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			System.out.println("Today Support Hero is:"+CommonUtils.todaySupportHero(roster));
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			new Menu(roster);
			break;

		case 3:
			System.out.println("");
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			System.out.println("Listing schedule till now");
			CommonUtils.displaySupportSchedule(roster);
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			new Menu(roster);
			break;
		case 4:
			System.out.println("");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String name = null;
			String date = null;
			try {
				System.out.println("***** Enter Name ******");
				name = br1.readLine();
				System.out.println("***** Enter Date in yyyy-MM-dd format ******");
				date = br2.readLine();
				boolean validateDate = DateUtils.checkValidateWorkingDay(date, name);
				boolean holidayCheck = DateUtils.checkUSHolidays(date);

				if(!validateDate){
					new Menu(roster);
				}  else {
					if(!holidayCheck){
						roster = CommonUtils.addSupportHero(roster, date, name);
					}
				}
			} catch (IOException ioe) {
				System.out.println("Invalid Input. Please enter menu option again.");
				new Menu(roster);
			} 
			new Menu(roster);
			break;
		case 5:
			System.out.println("");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			String sname = null;
			String sdate = null;
			try {
				System.out.println("*****This function will delete duty for person on particular date ******");
				System.out.println("***** Enter date for which duty needs to be deleted ******");
				sdate = br3.readLine().trim();
				boolean validateDate = DateUtils.checkValidateWorkingDay(sdate, sname);
				boolean holidayCheck = DateUtils.checkUSHolidays(sdate);
				if(!validateDate){
					new Menu(roster);
				}  else {
					if(!holidayCheck){
						roster = CommonUtils.removeSupportHero(roster, sdate);
					}
				}

			} catch (IOException ioe) {
				System.out.println("Invalid Input. Please enter menu option again.");
				new Menu(roster);
			} 
			new Menu(roster);
			break;		

		case 6:
			BufferedReader br7 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("***** Enter year to see US Holidays ******");
			String calyear;
			try {
				calyear = br7.readLine().trim();
				HashMap<String,String> usholidays = USHolidays.getUSHolidayList(Integer.parseInt(calyear));
				CommonUtils.displaySupportSchedule(usholidays);
				new Menu(roster);
			} catch (IOException e) {
				System.out.println("Invalid Input. Please enter menu option again.");
				System.exit(1);
			}

		default :
			System.out.println("You have quit the application");
		}

	}

	public void quitProgram() {
		System.out.println("You have quit the program");
		System.exit(1);
	}


}
