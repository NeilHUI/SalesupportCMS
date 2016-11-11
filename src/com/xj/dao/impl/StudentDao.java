package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IStudentDao;
import com.xj.util.DBUtil;
import com.xj.vo.Student;

public class StudentDao implements IStudentDao {
	
	private DBUtil util = DBUtil.getInstance();
	private String sql;
	private ResultSet rs;
	
	@Override
	public List<Student> queryAllStu() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql = "select * from test";
		rs = util.query(sql, null);
		List<Student> list = new ArrayList<Student>();
		try {
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getString("student_id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setSex(rs.getString("sex"));
				s.setHobby(rs.getString("hobby"));
				s.setGrade(rs.getString("grade"));
				s.setDescr(rs.getString("descr"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	@Override
	public Student queryStuById(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql = "select * from test where student_id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		rs = util.query(sql, param);
		Student s = new Student();
		try {
			while(rs.next()) {
				s.setId(rs.getString("student_id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setSex(rs.getString("sex"));
				s.setHobby(rs.getString("hobby"));
				s.setGrade(rs.getString("grade"));
				s.setDescr(rs.getString("descr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return s;
	}

	@Override
	public void insertStu(Student s) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql = "insert into test values(?, ?, ?, ?, ?, ?, ?)";
		List<Object> param = new ArrayList<Object>();
		param.add(s.getId());
		param.add(s.getName());
		param.add(s.getAge());
		param.add(s.getSex());
		param.add(s.getHobby());
		param.add(s.getGrade());
		param.add(s.getDescr());
		util.update(sql, param);
		util.close();
	}

	@Override
	public void delStu(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql = "delete from student where student_id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		util.update(sql, param);
		util.close();
	}

	@Override
	public void updateStu(Student s) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql = "update test set name=?, age=?, sex=?, hobby=?, grade=?, descr=? where student_id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(s.getName());
		param.add(s.getAge());
		param.add(s.getSex());
		param.add(s.getHobby());
		param.add(s.getGrade());
		param.add(s.getDescr());
		param.add(s.getId());
		util.update(sql, param);
		util.close();
	}
	
}
