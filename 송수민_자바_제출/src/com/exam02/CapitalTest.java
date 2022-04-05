package com.exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CapitalTest {

		private HashMap<String, String> hm = new HashMap<String, String>();
		static Scanner sc = new Scanner(System.in);
		private File dir, file;
		
		public CapitalTest() {//������ �о Map �߰�
			dir = new File("src\\\\com\\\\exam02");
			file = new File(dir, "capital.txt");
		
			try {
					if(!file.exists()) { //������ ���ٸ�
							file.createNewFile();//���� ����
							return; //����
					}
					//������ �ִٸ�
					Scanner scanner = new Scanner(file); //���� �б�
					//�ʿ� �߰�
					while(scanner.hasNext()) {
						String key = scanner.next(); //����
						String value = scanner.next() ;// ����
						hm.put(key, value);// �ʿ� �߰�
					}
					System.out.println(hm);
					scanner.close();
			} catch (IOException e) {
					e.printStackTrace();
			} 
		}
		public static void showMenu() {
			System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
			System.out.println("1. �Է�, 2.����, 3. �������� �� ���� ");
			System.out.println("���� >>");
		}
		public void input() {  //���� �Է�
	 		while(true) {
	 			System.out.println("���� :" + hm.size() +" �� ����� ���� ����");
	 			System.out.println("���� �� ���� �Է�(���� x)>>>");
	 			String nara = CapitalTest.sc.next(); //����
	 			if(nara.equalsIgnoreCase("x")) break ; // ����
	 			if(hm.containsKey(nara)) {
	 				System.out.println("�̹� �Է��� �����Դϴ�.");
	 				continue;
	 			}
	 			String sudo = CapitalTest.sc.next();
	 			hm.put(nara, sudo);
	 		}
		}
		public void quiz() {
			  //Ű���� ���ϱ�
			 Set<String> set =  hm.keySet(); //Ű���� ���ϱ�
			 //���� Ű�� set �� �迭�� ���  ==>����
			 Object[] arr =  set.toArray();
			  while(true) {
				  int r =(int)(Math.random()*hm.size());
				
				 String country =(String)arr[r]; //������ ������ ����
				// String result = map.get(country); //����
				 
				  //���� ����
				 System.out.println(country  +" ������ ? (���� x) >>");
				 String dap = CapitalTest.sc.next();
				 if(dap.equalsIgnoreCase("x")) break;
				 if(hm.get(country).equals(dap)) { //if(result.equals(dap))
					 System.out.println("����!!!");
				 }else {
					 System.out.println("Ʋ�Ƚ��ϴ�.");
				 }
			  } //while
		}
		public void save() {//���� ���Ϸ� ���� �� ����
			try {
				FileWriter fw = new FileWriter(file);
				Set<String> set=  hm.keySet();
				Iterator< String> it = set.iterator();
				while(it.hasNext()) {
					String key = it.next(); //����
					String value =hm.get(key); //����
					fw.write(key +"  ");
					fw.write(value+"\n");
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("����");
			System.exit(0);
		}

		public static void main(String[] args) {
			CapitalTest app = new CapitalTest();
			
			while(true) {
				CapitalTest.showMenu();
				int choice = CapitalTest.sc.nextInt();
				switch(choice) {
					case 1: app.input(); break;
					case 2: app.quiz(); break;
					case 3: app.save(); break;
					default:System.out.println("�Է¿���");
				}
			}

		}

	}

