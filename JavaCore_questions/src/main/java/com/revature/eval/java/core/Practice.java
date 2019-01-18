package com.revature.eval.java.core;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		System.out.println(getGigasecondDate(LocalDate.of(1967, Month.MARCH, 1)));		
		
		
	}
	
	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public static Temporal getGigasecondDate(Temporal given) {
		// we're given a birthday
		
		// we want to return that birthday + 10^9 sec
		
		// given LocalDate
		
		// returning LocalDateTime
		
		// how many days in 10^9 seconds?
		// 60 sec in a min, 60 min in an hour, 24 hours in a day
		double daysgiga = (Math.pow(10, 9))/60/60/24;
		// get remaining seconds
		int remainingsec = (int) ((Math.pow(10, 9))%(60*60*24));
		
		// now that we have gigadays, we want to add it to the given birthday
		// using plusDays method
		
		// first we need to create LocalDate obj out of given
		
		// parse given to create LocalDate
		String[] bd = given.toString().split("-");
		// get year
		int year = Integer.parseInt(bd[0]);
		// month
		int month = Integer.parseInt(bd[1]);
		// day
		int day = Integer.parseInt(bd[2]);
		// create localdate
		LocalDate ld = LocalDate.of(year, month, day);
		
		// add days to get gigasecond localdate
		LocalDate gigald = ld.plusDays((long)(Math.pow(10, 9))/(60*60*24));
		
		// now create new localdate string out of gigald
		// parse given to create LocalDate
		System.out.println(gigald);
		String[] gbd = gigald.toString().split("-");
		// get year
		int gyear = Integer.parseInt(gbd[0]);
		// month
		int gmonth = Integer.parseInt(gbd[1]);
		// day
		int gday = Integer.parseInt(gbd[2]);
		// create localdate
		LocalDate gld = LocalDate.of(gyear, gmonth, gday);
		
		// now we want to create a localdatetime obj w/ remainingsec
		// must first convert remainingsec to hours, minutes and sec
		int hours = remainingsec/3600;
		int minutes = (remainingsec%3600)/60;
		int sec = ((remainingsec%3600)%60);
		
		LocalDateTime ldt = LocalDateTime.of(gyear, gmonth, gday, hours, minutes, sec);
		
		return ldt;
	}

}
				
