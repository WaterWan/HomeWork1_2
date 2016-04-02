package homework_2016_3_10;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * How many days is from a day before to today my own way
 * 
 * @author 151250137
 *
 */
public class Homework3_1 {
	// get now time
	public Calendar calendar = new GregorianCalendar();
	public int nowYear = calendar.get(Calendar.YEAR);
	// month in calender starts from 0 
	public int nowMonth = calendar.get(Calendar.MONTH) + 1;
	public int nowDate = calendar.get(Calendar.DATE);
	public static int MAX_MONTH = 12;
	
	public static void main(String[] args) {
		int interval = 0;
		Homework3_1 h = new Homework3_1();
		System.out.println("Please enter a time before " + h.nowYear + "." + h.nowMonth + "." + h.nowDate);
		// get the time we need
		Scanner s = new Scanner(System.in);
		int beforeYear, beforeMonth, beforeDate;
		System.out.println("Year:");
		beforeYear = s.nextInt();
		System.out.println("Month:");
		beforeMonth = s.nextInt();
		System.out.println("Date:");
		beforeDate = s.nextInt();
		s.close();
		interval = h.calculateDays(beforeYear, beforeMonth, beforeDate);
		System.out.println("¼ä¸ô" + interval + "Ìì");
	}
	
	/**
	 * tell how many days between two dates
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public int calculateDays(int year, int month, int date){
		int day = 0;
		// the date before
		while (year < nowYear || (year == nowYear && month < nowMonth) 
				|| (year == nowYear && month == nowMonth && date < nowDate)) {
			day ++;
			if (date == maxDayInAMonth(year, month)) {
				date = 1;
				month ++;
			} else {
				date ++;
			}
			
			if (month > MAX_MONTH) {
				month = 1;
				year ++;
			}
		}
		return day;
	}

	/**
	 * tell how many days in a month
	 * @param year
	 * @param month
	 * @return
	 */
	private int maxDayInAMonth(int year, int month) {
		switch (month) {
		case 1:
			return 31;
		case 2:
			if (isLeapYear(year)) {
				return 29;
			}else{
				return 28;
			}
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		}
		return 0;
	}

	/**
	 * tell whether a year is a leap year
	 * @param year
	 * @return
	 */
	private boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 ==0 ) {
			return true;
		}else{
			return false;
		}
	}

}
