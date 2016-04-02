package homework_2016_3_10;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {


	public static void main(String[] args) {
		ArrayList<String> string1 = new ArrayList<>();
		ArrayList<String> string2 = new ArrayList<>();
		
		string1.add("123");
		string1.add("aaa");
		System.out.println(string1);
		string2.add("111");
		System.out.println(string2);
		string1.addAll(string2);
		System.out.println(string1);
		
		

			
	}

	
}
