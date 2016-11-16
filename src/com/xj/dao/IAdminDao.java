package com.xj.dao;

import java.util.List;

import com.xj.vo.Admin;

public interface IAdminDao {

	public List<Admin> QueryAllAdmin();

	public Admin QueryAdminByName(String name);

	public void InsertAdmin(Admin A);

	public void DeleteAdmin(String id);

	public void UpdateAdmin(Admin A);
}
