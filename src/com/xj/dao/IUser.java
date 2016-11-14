package com.xj.dao;

import java.util.List;

import com.xj.vo.User;

public interface IUser {
	public List<User> QueryAllUser();
	
	public User QueryUserByID(int id);
	
	public void InsertUser(User u);
	
	public void DeleteUser(int id);
	
	public void UpdateUser(User u);
}
