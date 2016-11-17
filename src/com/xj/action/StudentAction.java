package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xj.dao.service.StudentService;
import com.xj.vo.Student;

public class StudentAction {
	private StudentService stuService = new StudentService();
	private List<Student> list = new ArrayList<Student>();
	private Student s = new Student();
	
	//²éÑ¯È«²¿ 
	public String queryAll() throws Exception {
		
		list = stuService.queryAllStu();
		
		return "listStudent";
	}
	
	public String add() throws Exception {
		s.setId(UUID.randomUUID().toString());
		List<String> hobbyArr = s.getHobbyArr();
		StringBuffer sb = new StringBuffer();
		for(String a : hobbyArr) {
			sb.append(a + ",");
		}
		String hobby = sb.toString();
		hobby = hobby.substring(0, hobby.length()-1);
		s.setHobby(hobby);
		stuService.insertStu(s);
		return queryAll();
	}
	
	public String preUpdate() throws Exception {
		s = stuService.queryStuById(s.getId());
		String[] arr = s.getHobby().split(",");
		List<String> hobbyArr = new ArrayList<String>();
		for(String a : arr) {
			hobbyArr.add(a);
		}
		s.setHobbyArr(hobbyArr);
		return "update";
	}
	
	public String update() throws Exception {
		List<String> hobbyArr = s.getHobbyArr();
		StringBuffer sb = new StringBuffer();
		for(String a : hobbyArr) {
			sb.append(a + ",");
		}
		String hobby = sb.toString();
		hobby = hobby.substring(0, hobby.length()-1);
		s.setHobby(hobby);
		stuService.updateStu(s);
		return queryAll();
	}
	
	public String delete() throws Exception {
		stuService.delStu(s.getId());
		return queryAll();
	}
	
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}
	
	
}
