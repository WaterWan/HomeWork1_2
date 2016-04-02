package homework_2016_3_29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Homework1 {
	/**
	 * this arraylist records the information of courses
	 */
	public List<String> course = new ArrayList<>();

	public Scanner s = new Scanner(System.in);
	
	

	/**
	 * create a new curriculum schedule
	 */
	public void createCurriculumSchedule() {
		course.add("星期四；三、四节；计算与软件工程；仙2-407；");
	}

	/**
	 * put the information of courses into the file
	 */
	public void writeFile() {
		try {
			File CurriculumSchedule = new File("src/homework_2016_3_29/CurriculumSchedule.txt");
			FileWriter fr = new FileWriter(CurriculumSchedule);
			BufferedWriter bw = new BufferedWriter(fr);
			for (int i = 0; i < course.size(); i++) {
				bw.write(course.get(i));
				bw.write('\n');
//				bw.flush();
			}
			
			bw.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * read the file first
	 */
	public void readFile() {
		
		try {
			File CurriculumSchedule = new File("src/homework_2016_3_29/CurriculumSchedule.txt");
			FileReader fr = new FileReader(CurriculumSchedule);
			BufferedReader br = new BufferedReader(fr);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				course.add(temp);
//				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * determine whether the user finishes the work
	 * @param order the user's input
	 * @return
	 */
	public boolean isFinished(String order) {
		if (order.equals("0")) {
			System.out.println("程序结束！");
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * use the order to use different function
	 */
	public void getOrder(){
		String order = s.nextLine();
		while (!isFinished(order)) {
			if (order.startsWith("Add")) {
				functionAdd(order);
//				System.out.println(course);

			} else if (order.startsWith("Remove")) {
				functionRemove(order);
//				System.out.println(course);
//				System.out.println("Remove no problem!");
			} else if (order.startsWith("Update")) {
				functionUpdate(order);
//				System.out.println("Update no problem!");
			} else if (order.startsWith("Find")) {
				functionFind(order);
//				System.out.println("Find no problem!");
			} else if (order.equals("Show")) {
				functionShow();
//				System.out.println("Show no problem!");
			} else {
				sendWrongMessage();
			}
			order = s.nextLine();
		}
	}
	
	/**
	 * deal with show
	 * @param order
	 */
	public void functionShow() {
//		String courseInfo = order.split("Show ")[1];
//		String courseDay = courseInfo.split("；")[0];
//		String courseTime = courseInfo.split("；")[1];
		/**
		 * this is a strange way to sort
		 * first day is most important
		 * second time is less important
		 * so these two elements are at the beginning
		 * we suppose that a student has 1000 class a week at most 
		 * and the last three numbers are used to find the record
		 * by the time they first added in the table
		 */
		List<Integer> courseIndex = new ArrayList<>();
		for (int i = 0; i < course.size(); i++) {
			courseIndex.add(dayOfClass(course.get(i).split("；")[0]) 
					+ timeOfClass(course.get(i).split("；")[1]) 
					+ i);
		}
		Collections.sort(courseIndex);
		for (int i = 0; i < courseIndex.size(); i++) {
			System.out.println(course.get(courseIndex.get(i) % 1000));
		}
	}
	
	public int dayOfClass(String weekday) {
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
		case "星期天":
			return 70000;
		default:
			break;
		}
		return 0;
	}
	
	public int timeOfClass(String classTime){
		switch (classTime) {
		case "一，二节":
			return 1000;
		case "三，四节":
			return 2000;
		case "五，六节":
			return 3000;
		case "七，八节":
			return 4000;
		case "九，十，十一节":
			return 5000;
		}
		return 0;
	}



	/**
	 * find the course information
	 * @param order
	 */
	public void functionFind(String order) {
		String courseInfo = order.split("Find ")[1];
		String courseDay = courseInfo.split("；")[0];
		String courseTime = courseInfo.split("；")[1];
		String index = courseDay + "；" + courseTime + "；";
		for (int i = 0; i < course.size(); i++) {
			if (this.course.get(i).startsWith(index)) {
				System.out.println(this.course.get(i).split(index)[1]);
			}
		}
	}

	/**
	 * update the course information
	 * @param order
	 */
	public void functionUpdate(String order) {
		String courseInfo = order.split("Update ")[1];
		String courseDay = courseInfo.split("；")[0];
		String courseTime = courseInfo.split("；")[1];
		String index = courseDay + "；" + courseTime;
		for (int i = 0; i < course.size(); i++) {
			if (this.course.get(i).startsWith(index)) {
				this.course.remove(i);
				this.course.add(i, courseInfo);
				System.out.println("已更新文件");
			}
		}
		writeFile();
	}

	/**
	 * deal with remove
	 * @param order
	 */
	public void functionRemove(String order) {
		String courseInfo = order.split("Remove ")[1];
		for (int i = 0; i < course.size(); i++) {

//			System.out.println(courseInfo);
			if (this.course.get(i).equals(courseInfo)) {
				this.course.remove(i);
				System.out.println("已从文件中删除");
			}
		}
		writeFile();
	}

	/**
	 * deal with add
	 * @param order
	 */
	public void functionAdd(String order) {
		String courseInfo = order.split("Add ")[1];
		String courseDay = courseInfo.split("；")[0];
		String courseTime = courseInfo.split("；")[1];
		String index = courseDay + "；" + courseTime;
		int count = 0;
		for (int i = 0; i < course.size(); i++) {
			if (this.course.get(i).startsWith(index)) {
				count ++;
			}
		}
		if (count == 0) {
			course.add(courseInfo);
			writeFile();
			System.out.println("已添加到文件中");
		} else {
			count = 0;
			System.out.println("课程重复！");
		}

	}

	/**
	 * tell the user that he made some mistakes and how to correct them
	 */
	public void sendWrongMessage(){
		System.out.println("对不起，您输入的内容有误！");
		sendTips();
	}
	
	/**
	 * tell the user the correct way to use this software
	 */
	public void sendTips(){
		System.out.println("请按照标准输入命令！");
		System.out.println("增加课程请按照以下格式：");
		System.out.println("Add 星期X；M，N节；课程名；教室位置；（其中X，M，N均为中文汉字，标点符号为中文半角）");
		System.out.println("删除课程请按照以下格式：");
		System.out.println("Remove 星期X；M，N节；课程名；教室位置；（其中X，M，N均为中文汉字，标点符号为中文半角）");
		System.out.println("更改课程请按照以下格式：");
		System.out.println("Update 星期X；M，N节；课程名；教室位置；（其中X，M，N均为中文汉字，标点符号为中文半角）");
		System.out.println("查找课程请按照以下格式：");
		System.out.println("Find 星期X；M，N节；（其中X，M，N均为中文汉字，标点符号为中文半角）");
		System.out.println("显示所有课程请按照以下格式：");
		System.out.println("Show");
		System.out.println("结束本程序请按照以下格式：");
		System.out.println(0);
	}

	public static void main(String[] args) {
	
		Homework1 h = new Homework1();

		// start the curriculum schedule
//		h.createCurriculumSchedule();
		h.readFile();
//		System.out.println(h.course); 
		h.sendTips(); 
		h.getOrder();
		h.s.close();
	}
}
