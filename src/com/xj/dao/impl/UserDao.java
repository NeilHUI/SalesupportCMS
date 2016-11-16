package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IUser;
import com.xj.util.DBUtil;
import com.xj.vo.User;

public class UserDao implements IUser {
	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	
	@Override
	public List<User> QueryAllUser() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from UserTable";
		rs=util.query(sql, null);
		List<User> list=new ArrayList<User>();
		try {
			while(rs.next()){
				User a=new User();
				a.setUser_ID(rs.getString("User_ID"));
				a.setUser_Name(rs.getString("User_Name"));
				a.setUser_Pass(rs.getString("User_Pass"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return list;
	}

	@Override
	public User QueryUserByID(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from UserTable where User_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		User a=new User();
		try {
			while(rs.next()){				
				a.setUser_Name(rs.getString("User_Name"));
				a.setUser_Pass(rs.getString("User_Pass"));
				a.setUser_ID(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return a;
	}

	@Override
	public void InsertUser(User A) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into UserTable values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(A.getUser_ID());
		params.add(A.getUser_Name());
		params.add(A.getUser_Pass());
		util.update(sql, params);
		util.close();
	}

	@Override
	public void DeleteUser(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from UserTable where User_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	@Override
	public void UpdateUser(User u) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update UserTable set User_Name=?,User_Pass=? where User_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(u.getUser_Name());
		params.add(u.getUser_Pass());
		params.add(u.getUser_ID());
		util.update(sql, params);
		util.close();
	}

}
