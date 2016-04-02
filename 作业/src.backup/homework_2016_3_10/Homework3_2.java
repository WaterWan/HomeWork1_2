package homework_2016_3_10;

import java.util.Calendar;
import java.util.Scanner;

/**
 * How many days is from a day before to today
 * use java api
 * @author 151250137
 *
 */
public class Homework3_2 {
	public static void main(String[] args) {
		int year, month, date;
		Scanner s = new Scanner(System.in);
		System.out.println("Year:");
		year = s.nextInt();
		System.out.println("Month");
		// This is because month in java is begin from 0
		month = s.nextInt() - 1;
		System.out.println("Date");
		date = s.nextInt();
		Calendar now = Calendar.getInstance();
		Calendar oneDay = Calendar.getInstance();
		// I set the hour, minute and second seriously
		oneDay.set(year, month, date, 0, 0, 0);
		s.close();
		// use second to calculate the days
		long nowTime = now.getTimeInMillis();
		long oneDayTime = oneDay.getTimeInMillis();
		// the type of 'interval' is interesting
		long interval = (long)(nowTime - oneDayTime)/(1000*3600*24);
		if (nowTime - oneDayTime < 0) {
			System.out.println("Sorry, wrong date!");
		}
		System.out.println("¼ä¸ô" + interval + "Ìì");
	}
}
