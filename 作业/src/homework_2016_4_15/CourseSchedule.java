package homework_2016_4_15;

import java.util.List;

/**
 * This class shows the whole CourseSchedule
 * @author Water
 *
 */
public class CourseSchedule {
	// TODO
	//此处写排序
	List<String> courses = ScheduleFile.readFile();
	
	public static int dayOfClass(String weekday) {
		switch (weekday) {
		case "星期一":
			return 10000;
		case "星期二":
			return 20000;
		case "星期三":
			return 30000;
		case "星期四":
			return 40000;
		case "星期五":
			return 50000;
		case "星期六":
			return 60000;
		case "星期日":
			return 70000;
		default:
			break;
		}
		return 0;
	}
	
	public static int timeOfClass(String classTime){
		switch (classTime) {
		case "一、二节":
			return 1000;
		case "三、四节":
			return 2000;
		case "五、六节":
			return 3000;
		case "七、八节":
			return 4000;
		case "九、十、十一节":
			return 5000;
		}
		return 0;
	}
}
