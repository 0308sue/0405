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
	
	public StudentManager() throws IOException, ClassNotFoundException { // ���� ==> arr
		dir =new File("src\\com\\exam01");
		file = new File(dir, "student.txt");
		if(!file.exists()) { //������ ������
			file.createNewFile();// ���� ���� ����
			return;
		}
		//���� ����
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		list =(ArrayList<Student>)ois.readObject();
		ois.close();
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void showMenu() {
		System.out.println("�����ϼ��� ...");
		System.out.println("1.������ �Է�");
		System.out.println("2.��ü����");
		System.out.println("3.�л�ã��");
		System.out.println("4.����/����");
		System.out.println("���� >>");
	}
	
	public void inputData() {
			System.out.println("�л� �̸�,�а�,�й�,������� �Է��ϼ���.(�Է��� , �� �����ϰ� ����� x)");
			String student = sc.nextLine();
			String arr[]=student.split(",");
				String name = arr[0];
				String deapartment = arr[1];
				int studentnumber = Integer.parseInt(arr[2]);
				double score = Double.parseDouble(arr[3]);
				
				list.add(new Student(name, deapartment,studentnumber,score)); // �Է¹��� ������ ����Ʈ�� ����
	}
	
	public void viewData() {
		for(Student s : list) {
			System.out.println(s);
		}
	}
	
	public void searchData() {
			System.out.println("�л� �̸� �Է� >>");
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
				System.out.println("ã�� �л� ����");
			}
	}
	
	public void saveData() throws IOException, ClassNotFoundException {
		dir =new File("src\\com\\exam01");
		file = new File(dir, "student.txt");
		if(!file.exists()) { //������ ������
			file.createNewFile();// ���� ���� ����
			return;
		}
		//���� ����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(list);
		
		System.out.println("����");
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
			default:System.out.println("�Է¿���");
			
			}
		}
	}

}