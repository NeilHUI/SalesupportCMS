package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.StudentDao;
import com.xj.vo.Student;

public class StudentService {
	private StudentDao stuDao = new StudentDao();
	
	public List<Student> queryAllStu() {
		return stuDao.queryAllStu();
	}

	public Student queryStuById(String id) {
		return stuDao.queryStuById(id);
	}

	public void insertStu(Student s) {
		stuDao.insertStu(s);
	}

	public void delStu(String id) {
		stuDao.delStu(id);
	}

	public void updateStu(Student s) {
		stuDao.updateStu(s);
	}
}
