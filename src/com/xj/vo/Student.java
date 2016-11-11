package com.xj.vo;

import java.util.List;

public class Student {
	private String id;
	private String name;
	private int age;
	private String sex;
	private String hobby;
	private String grade;
	private String descr;
	private List<String> hobbyArr;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<String> getHobbyArr() {
		return hobbyArr;
	}

	public void setHobbyArr(List<String> hobbyArr) {
		this.hobbyArr = hobbyArr;
	}
	
	
}
