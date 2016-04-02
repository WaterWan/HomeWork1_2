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
		course.add("�����ģ������Ľڣ�������������̣���2-407��");
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
			System.out.println("���������");
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
//		String courseDay = courseInfo.split("��")[0];
//		String courseTime = courseInfo.split("��")[1];
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
			courseIndex.add(dayOfClass(course.get(i).split("��")[0]) 
					+ timeOfClass(course.get(i).split("��")[1]) 
					+ i);
		}
		Collections.sort(courseIndex);
		for (int i = 0; i < courseIndex.size(); i++) {
			System.out.println(course.get(courseIndex.get(i) % 1000));
		}
	}
	
	public int dayOfClass(String weekday) {
		switch (weekday) {
		case "����һ":
			return 10000;
		case "���ڶ�":
			return 20000;
		case "������":
			return 30000;
		case "������":
			return 40000;
		case "������":
			return 50000;
		case "������":
			return 60000;
		case "������":
			return 70000;
		default:
			break;
		}
		return 0;
	}
	
	public int timeOfClass(String classTime){
		switch (classTime) {
		case "һ������":
			return 1000;
		case "�����Ľ�":
			return 2000;
		case "�壬����":
			return 3000;
		case "�ߣ��˽�":
			return 4000;
		case "�ţ�ʮ��ʮһ��":
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
		String courseDay = courseInfo.split("��")[0];
		String courseTime = courseInfo.split("��")[1];
		String index = courseDay + "��" + courseTime + "��";
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
		String courseDay = courseInfo.split("��")[0];
		String courseTime = courseInfo.split("��")[1];
		String index = courseDay + "��" + courseTime;
		for (int i = 0; i < course.size(); i++) {
			if (this.course.get(i).startsWith(index)) {
				this.course.remove(i);
				this.course.add(i, courseInfo);
				System.out.println("�Ѹ����ļ�");
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
				System.out.println("�Ѵ��ļ���ɾ��");
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
		String courseDay = courseInfo.split("��")[0];
		String courseTime = courseInfo.split("��")[1];
		String index = courseDay + "��" + courseTime;
		int count = 0;
		for (int i = 0; i < course.size(); i++) {
			if (this.course.get(i).startsWith(index)) {
				count ++;
			}
		}
		if (count == 0) {
			course.add(courseInfo);
			writeFile();
			System.out.println("����ӵ��ļ���");
		} else {
			count = 0;
			System.out.println("�γ��ظ���");
		}

	}

	/**
	 * tell the user that he made some mistakes and how to correct them
	 */
	public void sendWrongMessage(){
		System.out.println("�Բ������������������");
		sendTips();
	}
	
	/**
	 * tell the user the correct way to use this software
	 */
	public void sendTips(){
		System.out.println("�밴�ձ�׼�������");
		System.out.println("���ӿγ��밴�����¸�ʽ��");
		System.out.println("Add ����X��M��N�ڣ��γ���������λ�ã�������X��M��N��Ϊ���ĺ��֣�������Ϊ���İ�ǣ�");
		System.out.println("ɾ���γ��밴�����¸�ʽ��");
		System.out.println("Remove ����X��M��N�ڣ��γ���������λ�ã�������X��M��N��Ϊ���ĺ��֣�������Ϊ���İ�ǣ�");
		System.out.println("���Ŀγ��밴�����¸�ʽ��");
		System.out.println("Update ����X��M��N�ڣ��γ���������λ�ã�������X��M��N��Ϊ���ĺ��֣�������Ϊ���İ�ǣ�");
		System.out.println("���ҿγ��밴�����¸�ʽ��");
		System.out.println("Find ����X��M��N�ڣ�������X��M��N��Ϊ���ĺ��֣�������Ϊ���İ�ǣ�");
		System.out.println("��ʾ���пγ��밴�����¸�ʽ��");
		System.out.println("Show");
		System.out.println("�����������밴�����¸�ʽ��");
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
