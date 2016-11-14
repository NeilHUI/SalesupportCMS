package com.xj.dao;

import java.util.List;

import com.xj.vo.Admin;

public interface IAdminDao {

	public List<Admin> QueryAllAdmin();

	public Admin QueryAdminByID(int id);

	public void InsertAdmin(Admin A);

	public void DeleteAdmin(int id);

	public void UpdateAdmin(Admin A);
}
