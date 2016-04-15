package homework_2016_4_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class control the file.
 * @author Water
 *
 */
public class ScheduleFile {
	public static String fileName = "src/homework_2016_4_15/CurriculumSchedule.txt";
	
	public static void writeFile(String s) {
		try {
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, true);	
//			fw.write("星期四；三，四节；计算与软件工程；仙2-407；");
			fw.write(s);
			fw.write('\n');
			fw.close();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static List<String> readFile() {
		List<String> course = new ArrayList<>();
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				course.add(temp);
				System.out.println(temp); // TODO: 测试用代码
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return course;
	}
	
	
}
