package com.supporthero.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SupportHero {


	public static void main(String[] args){
		System.out.println("***** Welcome to Support Hero *****");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String userName = null;
		String password = null;
		try {
			System.out.println("***** Enter Username ******");
			userName = br1.readLine();
			System.out.println("***** Enter Password ******");
			password = br2.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name or password!");
			System.exit(1);
		}

		if(CommonUtils.getProperty("username").equalsIgnoreCase(userName) && CommonUtils.getProperty("password").equals(password)) {
			System.out.println("Login Successful..");
		} else {
			System.out.println("You entered incorrect username or password. Application will quit.");
			System.exit(0);
		}

		new Menu(null);

	}

}
