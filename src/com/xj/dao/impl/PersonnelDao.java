package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IPersonnel;
import com.xj.util.DBUtil;
import com.xj.vo.Personnel;


public class PersonnelDao implements IPersonnel {

	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	
	@Override
	public List<Personnel> QueryAllPersonnel() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from Personnel";
		rs=util.query(sql, null);
		List<Personnel> list=new ArrayList<Personnel>();
		try {
			while(rs.next()){
				Personnel p=new Personnel();
				p.setP_ID(rs.getString("p_ID"));
				p.setP_Name(rs.getString("p_Name"));
				p.setP_Pass(rs.getString("P_Pass"));
				p.setP_Score(rs.getDouble("p_Score"));
				p.setInGroup(rs.getString("P_InGroup"));				
				list.add(p);
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
	public Personnel QueryPersonnelByID(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from Personnel where P_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Personnel p=new Personnel();
		try {
			while(rs.next()){								
				p.setP_Name(rs.getString("p_Name"));
				p.setP_Pass(rs.getString("p_Pass"));
				p.setP_Score(rs.getDouble("p_Score"));
				p.setInGroup(rs.getString("P_InGroup"));	
				p.setP_ID(rs.getString("p_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return p;
	}

	@Override
	public void InsertPersonnel(Personnel p) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into Personnel values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getP_ID());
		params.add(p.getP_Name());
		params.add(p.getP_Pass());
		params.add(p.getP_Score());
		params.add(p.getInGroup());
		
		util.update(sql, params);
		util.close();
	}

	@Override
	public void DeletePersonnel(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from Personnel where P_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	@Override
	public void UpdatePersonnel(Personnel p) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update Personnel set P_Name=?,P_Pass=?,P_InGroup=?,P_Score=? where P_ID=?";
		List<Object> params=new ArrayList<Object>();	
		params.add(p.getP_Name());
		params.add(p.getP_Pass());
		params.add(p.getP_Score());
		params.add(p.getInGroup());
		params.add(p.getP_ID());
		util.update(sql, params);
		util.close();
	}

}
