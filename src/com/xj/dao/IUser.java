package com.xj.dao;

import java.util.List;

import com.xj.vo.User;

public interface IUser {
	public List<User> QueryAllUser();
	
	public User QueryUserByID(String id);
	
	public void InsertUser(User u);
	
	public void DeleteUser(String id);
	
	public void UpdateUser(User u);
	
	public boolean valuser(User u);
}
