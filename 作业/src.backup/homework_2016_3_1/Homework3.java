package homework_2016_3_1;

public class Homework3 {
	public static void main(String[] args) {
		Homework3 h = new Homework3(); 
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += h.square(i);
		}
		System.out.println("1到100的和为" + sum);
	}
	
	public int square(int a){
		return a*a;
	}
}
