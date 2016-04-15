package homework_2016_4_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
	
	/**
	 * when order starts with add 
	 * this function will be used
	 * @param classInfo 
	 * the information of the class
	 */	
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
			courses.add(classInfo);
			ScheduleFile.writeFile(courses);
			System.out.println("已添加到文件中");
		}
	}

	public static void functionRemove(String classInfo) {
		List<String> courses = ScheduleFile.readFile();
		for (int i = 0; i < courses.size(); i++) {

//			System.out.println(courseInfo);
			if (courses.get(i).equals(classInfo)) {
				courses.remove(i);
				System.out.println("已从文件删除");
			}
		}
		ScheduleFile.writeFile(courses);
	}

	public static void functionUpdate(String classInfo) {
		List<String> courses = ScheduleFile.readFile();
		String courseDay = classInfo.split("；")[0];
		String courseTime = classInfo.split("；")[1];
		String index = courseDay + "；" + courseTime;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).startsWith(index)) {
				courses.remove(i);
				courses.add(i, classInfo);
				System.out.println("已更新文件");
			}
		}
		ScheduleFile.writeFile(courses);
	}

	public static void functionFind(String classInfo) {
		List<String> courses = ScheduleFile.readFile();
		String courseDay = classInfo.split("；")[0];
		String courseTime = classInfo.split("；")[1];
		String index = courseDay + "；" + courseTime + "；";
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).startsWith(index)) {
				System.out.println(courses.get(i).split(index)[1]);
			}
		}
		
	}

	public static void functionShow() {
		List<String> courses = ScheduleFile.readFile();
		List<Integer> courseIndex = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			courseIndex.add(CourseSchedule.dayOfClass(courses.get(i).split("；")[0]) 
					+ CourseSchedule.timeOfClass(courses.get(i).split("；")[1]) 
					+ i);
		}
		Collections.sort(courseIndex);
		for (int i = 0; i < courseIndex.size(); i++) {
			System.out.println(courses.get(courseIndex.get(i) % 1000));
		}
	}



	
	
}
