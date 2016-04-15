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
	
	public static void writeFile(List<String> course) {
		try {
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, false);	
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < course.size(); i++) {
				bw.write(course.get(i));
				bw.write('\n');
//				bw.flush();
			}
			
			bw.close();
			fw.close();
			} catch (Exception e) {

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
//				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return course;
	}
	
	
}
