package com.sanjos30.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	/**
	 * Prints the current date in the specified format. For example, when dateformat
	 * = yyy-MM-dd hh:mm:ss.sss Output would be 2018-08-13 05:20:20.020
	 * 
	 * @param date
	 *            format
	 * @return
	 */
	public static String returnCurrentDateAsStr(String format) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);
		String strDate = dateFormat.format(date);
		return strDate;
	}

	/**
	 * For example:
	 * 
	 * date1 = 2018-08-13 05:20:20.020 date2 = 2018-08-13 06:20:20.020
	 * 
	 * This function returns 1
	 * 
	 * @param date1
	 *            - start date
	 * @param date2
	 *            - stop date
	 * @return difference in hourse
	 */
	public static int hoursDifference(Date date1, Date date2) {
		long milliSecDiff = date1.getTime() - date2.getTime();
		final int MILLI_TO_HOUR = 1000 * 60 * 60;
		return (int) (milliSecDiff) / MILLI_TO_HOUR;
	}

	/**
	 * 
	 * date1 = 2018-08-13 05:20:20.020 date2 = 2018-08-13 06:20:20.020
	 * 
	 * This function returns = 1*60*60*1000
	 * 
	 * @param inputDateTime
	 * @param format
	 * @return the difference in milliseconds
	 * 
	 */
	public static long differenceFromCurrentDateTimeStrFormat(String inputDateTime, SimpleDateFormat format) {

		String currentDateTime = getCurrentTimeStampStringFormat();

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(inputDateTime);
			d2 = format.parse(currentDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long hours = hoursDifference(d2, d1);

		return hours;
	}

	/**
	 * This function is used to refer when you have to calculate days, minutes or
	 * hours from a given milli sec difference.
	 * 
	 * @param diff
	 */

	public static void printTimeDiffInHours(long diff) {

		long days = diff / (1000 * 60 * 60 * 24);
		long hours = diff / (1000 * 60 * 60);
		long minutes = diff / (1000 * 60);
		long seconds = diff / 1000;

		System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds);
	}

	/**
	 * 2018-08-13 05:20:20.020
	 * 
	 * @return current time stamp in String format yyy-MM-dd hh:mm:ss.sss
	 */
	public static String getCurrentTimeStampStringFormat() {
		return new SimpleDateFormat("yyy-MM-dd hh:mm:ss.sss").format(new Date());
	}

	/**
	 * For example: input = 20-01-2014 output = false
	 * 
	 * input = 2018-08-13 05:20:20.020 output = true
	 * 
	 * @param inDate
	 * @return boolean
	 */
	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * input = 20-01-2014 output = true
	 * 
	 * input = 20-01-2014 output = true
	 * 
	 * @param inDate
	 * @return boolean
	 */
	public static boolean isValidDate(String inDate, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(isValidDate("2018-08-13 05:20:20.020"));
		System.out.println(isValidDate("20-01-2014", "dd-MM-yyyy"));
	}

}
