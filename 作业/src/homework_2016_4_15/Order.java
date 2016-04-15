package homework_2016_4_15;

import java.util.List;

/**
 * This class deals with order
 * @author Water
 *
 */
public class Order {
	public void useOrder() {
		/*
		 * For example
		 * order : Add 星期四；三，四节；计算与软件工程；仙2-407；
		 * command : Add
		 * classInfo : 星期四；三，四节；计算与软件工程；仙2-407；
		 */

		String order = ScheduleConsole.getOrder();
		String command = order.split(" ")[0];
		String classInfo = null;
		if (!command.equals("Show")) {
			classInfo = order.split(" ")[1];
		}
		
		List<String> courses = ScheduleFile.readFile();

		switch (command) {
		case "Add":
			Course.functionAdd(classInfo);
			break;
		case "Remove":
			Course.functionRemove(classInfo);
			break;
		case "Update":
			Course.functionUpdate(classInfo);
			break;
		case "Find":
			Course.functionFind(classInfo);
			break;
		case "Show":
			Course.functionShow();
			break;

		default:
			break;
		}
		
	}
}
