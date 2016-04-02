package homework_2016_3_25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
 * Functional paradigm
 */
public class Homework2 {
	public static void main(String[] args) {
		// initialize the input
		List<String> input = new ArrayList();
		input.add("neal");
		input.add("s");
		input.add("stu");
		input.add("j");
		input.add("rich");
		input.add("bob");
		
		
		List<String> output = 
		input.stream().
				filter(i -> i.length() > 1).
				map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length())).
				collect(Collectors.toList());
		
		System.out.println(output);
	}
	
}
