package homework_2016_3_1;

import java.util.Scanner;

public class Homework4 {
	public static void main(String[] args) {
		System.out.println("请输入一个介于0-100的整数");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		Homework4 h = new Homework4();
		for (int i = 1; i <= n; i++) {
			sum += h.square(i);
		}
		System.out.println("1到" + n + "的平方和为" + sum);
		s.close();
	}
	
	public int square(int a){
		return a*a;
	}
}
