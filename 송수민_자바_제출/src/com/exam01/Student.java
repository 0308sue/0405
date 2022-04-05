package com.exam01;

import java.io.Serializable;

public class Student  implements Serializable{
	private String name;
	private String department;
	private int studentnumber;
	private double score;
	
	



	public Student(String name, String deapartment, int studentnumber, double score) {
		this.name = name;
		this.department = deapartment;
		this.studentnumber = studentnumber;
		this.score = score;
		
	}



	public String getName() {
		return name;
	}



	public String getDepartment() {
		return department;
	}



	public int getStudentnumber() {
		return studentnumber;
	}



	public double getScore() {
		return score;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public void setStudentnumber(int studentnumber) {
		this.studentnumber = studentnumber;
	}



	public void setScore(double score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "[이름 =" + name + ", "
				+ "학과 =" + department + ", "
				+ "학번 =" + studentnumber + ", "
				+ "학점 =" + score + "]";
	}

}


