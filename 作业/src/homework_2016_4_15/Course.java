package homework_2016_4_15;

import java.util.List;

public class Course {

	
	
	public static void functionAdd(String classInfo) {
		List<String> courses = ScheduleFile.readFile();
		int count = 0;
		for (String s : courses) {
			if (s.equals(classInfo)) {
				System.out.println("存在重复课程！");
				count ++;
			}
		}
		if (count == 0) {
			ScheduleFile.writeFile(classInfo);
			System.out.println("已添加到文件中");
		}
		
	}



	
	
}
