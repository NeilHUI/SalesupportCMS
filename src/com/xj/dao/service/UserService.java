package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.UserDao;
import com.xj.vo.User;

public class UserService {

private UserDao Udao=new UserDao();
	
	public List<User> QueryAllUser(){
		return Udao.QueryAllUser();
	}
	
	public User QueryByID(String id){
		return Udao.QueryUserByID(id);
	}
	
	public void InsertUser(User a){
		Udao.InsertUser(a);
	}
	
	public void DeleteUser(String id){
		Udao.DeleteUser(id);
	}
	
	public void UpdateUser(User a){
		Udao.UpdateUser(a);
	}
	public boolean valuser(User u){
		return Udao.valuser(u);
	};
}
