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
		
		public CapitalTest() {//파일을 읽어서 Map 추가
			dir = new File("src\\\\com\\\\exam02");
			file = new File(dir, "capital.txt");
		
			try {
					if(!file.exists()) { //파일이 없다면
							file.createNewFile();//파일 생성
							return; //종료
					}
					//파일이 있다면
					Scanner scanner = new Scanner(file); //파일 읽기
					//맵에 추가
					while(scanner.hasNext()) {
						String key = scanner.next(); //나라
						String value = scanner.next() ;// 수도
						hm.put(key, value);// 맵에 추가
					}
					System.out.println(hm);
					scanner.close();
			} catch (IOException e) {
					e.printStackTrace();
			} 
		}
		public static void showMenu() {
			System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
			System.out.println("1. 입력, 2.퀴즈, 3. 파일저장 및 종료 ");
			System.out.println("선택 >>");
		}
		public void input() {  //문제 입력
	 		while(true) {
	 			System.out.println("현재 :" + hm.size() +" 개 나라와 수도 있음");
	 			System.out.println("나라 와 수도 입력(종료 x)>>>");
	 			String nara = CapitalTest.sc.next(); //나라
	 			if(nara.equalsIgnoreCase("x")) break ; // 종료
	 			if(hm.containsKey(nara)) {
	 				System.out.println("이미 입력한 나라입니다.");
	 				continue;
	 			}
	 			String sudo = CapitalTest.sc.next();
	 			hm.put(nara, sudo);
	 		}
		}
		public void quiz() {
			  //키값만 구하기
			 Set<String> set =  hm.keySet(); //키값만 구하기
			 //구한 키값 set 을 배열에 담기  ==>순서
			 Object[] arr =  set.toArray();
			  while(true) {
				  int r =(int)(Math.random()*hm.size());
				
				 String country =(String)arr[r]; //문제로 출제될 나라
				// String result = map.get(country); //정답
				 
				  //문제 출제
				 System.out.println(country  +" 수도는 ? (종료 x) >>");
				 String dap = CapitalTest.sc.next();
				 if(dap.equalsIgnoreCase("x")) break;
				 if(hm.get(country).equals(dap)) { //if(result.equals(dap))
					 System.out.println("정답!!!");
				 }else {
					 System.out.println("틀렸습니다.");
				 }
			  } //while
		}
		public void save() {//맵을 파일로 저장 후 종료
			try {
				FileWriter fw = new FileWriter(file);
				Set<String> set=  hm.keySet();
				Iterator< String> it = set.iterator();
				while(it.hasNext()) {
					String key = it.next(); //나라
					String value =hm.get(key); //수도
					fw.write(key +"  ");
					fw.write(value+"\n");
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("종료");
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
					default:System.out.println("입력오류");
				}
			}

		}

	}

