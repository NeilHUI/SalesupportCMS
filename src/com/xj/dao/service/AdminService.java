package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.AdminDao;
import com.xj.vo.Admin;

public class AdminService {
	private AdminDao Adao=new AdminDao();
	
	public List<Admin> QueryAllAdmin(){
		return Adao.QueryAllAdmin();
	}
	
	public Admin QueryAdmin(int id){
		return Adao.QueryAdminByID(id);
	}
	
	public void InsertAdmin(Admin a){
		Adao.InsertAdmin(a);
	}
	
	public void DeleteAdmin(int id){
		Adao.DeleteAdmin(id);
	}
	
	public void UpdateAdmin(Admin a){
		Adao.UpdateAdmin(a);
	}

}
