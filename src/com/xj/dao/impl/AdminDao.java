package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IAdminDao;
import com.xj.util.DBUtil;
import com.xj.vo.Admin;

public class AdminDao implements IAdminDao {

	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	
	@Override
	public List<Admin> QueryAllAdmin() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from AdminTable";
		rs=util.query(sql, null);
		List<Admin> list=new ArrayList<Admin>();
		try {
			while(rs.next()){
				Admin a=new Admin();
				a.setAdmin_ID(rs.getInt("Admin_ID"));
				a.setAdmin_Name(rs.getString("admin_Name"));
				a.setAdmin_Pass(rs.getString("Admin_Pass"));
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
	public Admin QueryAdminByID(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from AdminTable where Admin_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Admin a=new Admin();
		try {
			while(rs.next()){				
				a.setAdmin_Name(rs.getString("Admin_Name"));
				a.setAdmin_Pass(rs.getString("Admin_Pass"));
				a.setAdmin_ID(id);
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
	public void InsertAdmin(Admin A) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into AdminTable values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(A.getAdmin_ID());
		params.add(A.getAdmin_Name());
		params.add(A.getAdmin_Pass());
		util.update(sql, params);
		util.close();
	}

	@Override
	public void DeleteAdmin(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from AdminTable where Admin_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	@Override
	public void UpdateAdmin(Admin A) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update AdminTable set Admin_Name=?,Admin_Pass=? where Admin_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(A.getAdmin_Name());
		params.add(A.getAdmin_Pass());
		params.add(A.getAdmin_ID());
		util.update(sql, params);
		util.close();
	}

}
