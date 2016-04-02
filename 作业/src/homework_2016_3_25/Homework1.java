package homework_2016_3_25;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose that a list of names are given
 * Some of the names are only one character
 * The system will ask you to return a string,which is made of names split by ','
 * The list doesn't contain names which are only one character
 * The first character of each name should be capital
 * Input:List("neal","s","stu","j","rich","bob")
 * Output: "Neal,Stu,Rich,Bob"
 * use Imperative paradigm and Functional paradigm to realize it separately
 * @author 151250137
 * 2016.3.25
 * 
 * Imperative paradigm
 */
public class Homework1 {

	public static void main(String[] args) {
		// initialize the input
		List<String> input = new ArrayList();
		input.add("neal");
		input.add("s");
		input.add("stu");
		input.add("j");
		input.add("rich");
		input.add("bob");
		// transform to capital
		String output = "";
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).length() == 1 || input.get(i).length() == 0) {
				continue;
			}
			output += toCapital(input.get(i));
			output += ",";
		}
		// There is a useless ','
		if (output.length() == 0) {
			System.out.println(output);
		}else{
			output = output.substring(0, output.length() - 1);
			System.out.println(output);
		}
	}

	/**
	 * change the first character into the capital one
	 * @param string 
	 * @return
	 */
	private static String toCapital(String string) {
		char[] temp = string.toCharArray();
        temp[0] -= 32;
        return String.valueOf(temp);
	}
}
