package homework_2016_3_10;

import java.util.Scanner;
/**
 * whether a year is a leap year
 * @author 151250137
 *
 */
public class Homework1 {

	public static void main(String[] args) {
		System.out.print("��������ݣ�");
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();
		if ((year % 4 == 0&& year % 100 != 0) || year % 400 ==0 ) {
			System.out.println(year + "��Ϊ����");
		}else{
			System.out.println(year + "�겻������");
		}
		s.close();
	}

}
