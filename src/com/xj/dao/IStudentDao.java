package com.xj.dao;

import java.util.List;

import com.xj.vo.Student;

public interface IStudentDao {
	public List<Student> queryAllStu();
	
	public Student queryStuById(String id);
	
	public void insertStu(Student s);
	
	public void delStu(String id);
	
	public void updateStu(Student s);
}
