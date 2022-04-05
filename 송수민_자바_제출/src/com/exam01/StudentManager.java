package com.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManager {
	private ArrayList<Student> list = new ArrayList<Student>();
	File dir, file;
	
	public StudentManager() throws IOException, ClassNotFoundException { // 파일 ==> arr
		dir =new File("src\\com\\exam01");
		file = new File(dir, "student.txt");
		if(!file.exists()) { //파일이 없을때
			file.createNewFile();// 파일 새로 만듬
			return;
		}
		//파일 있음
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		list =(ArrayList<Student>)ois.readObject();
		ois.close();
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void showMenu() {
		System.out.println("선택하세요 ...");
		System.out.println("1.데이터 입력");
		System.out.println("2.전체보기");
		System.out.println("3.학생찾기");
		System.out.println("4.저장/종료");
		System.out.println("선택 >>");
	}
	
	public void inputData() {
			System.out.println("학생 이름,학과,학번,학점평균 입력하세요.(입력은 , 로 구분하고 종료는 x)");
			String student = sc.nextLine();
			String arr[]=student.split(",");
				String name = arr[0];
				String deapartment = arr[1];
				int studentnumber = Integer.parseInt(arr[2]);
				double score = Double.parseDouble(arr[3]);
				
				list.add(new Student(name, deapartment,studentnumber,score)); // 입력받은 내용을 리스트에 저장
	}
	
	public void viewData() {
		for(Student s : list) {
			System.out.println(s);
		}
	}
	
	public void searchData() {
			System.out.println("학생 이름 입력 >>");
			String name = sc.nextLine();
			boolean flag = false;
			Iterator <Student> it = list.iterator();
			while(it.hasNext()) {
				Student s=it.next();
				if(s.getName().equals(name)) {
					flag = true;
					System.out.println(s);
					break;
					
			}		
		}
		if(flag == false) {
				System.out.println("찾는 학생 없음");
			}
	}
	
	public void saveData() throws IOException, ClassNotFoundException {
		dir =new File("src\\com\\exam01");
		file = new File(dir, "student.txt");
		if(!file.exists()) { //파일이 없을때
			file.createNewFile();// 파일 새로 만듬
			return;
		}
		//파일 있음
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(list);
		
		System.out.println("종료");
		System.exit(0);
		
		
	}
	

	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		StudentManager sm = new StudentManager();
		while(true) {
			StudentManager.showMenu();
			int choice = StudentManager.sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:sm.inputData();break;
			case 2:sm.viewData();break;
			case 3:sm.searchData();break;
			case 4:sm.saveData();
			default:System.out.println("입력오류");
			
			}
		}
	}

}