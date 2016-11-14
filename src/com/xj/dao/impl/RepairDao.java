package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IRepair;
import com.xj.util.DBUtil;
import com.xj.vo.Repair;

public class RepairDao implements IRepair {

	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	@Override
	public List<Repair> QueryAllRepair() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from Repair_Table";
		rs=util.query(sql, null);
		List<Repair> list=new ArrayList<Repair>();
		try {
			while(rs.next()){
				Repair a=new Repair();
				a.setRepair_ID(rs.getInt("Repair_ID"));
				a.setRepair_ISY(rs.getInt("repair_ISY"));
				a.setRepair_StartT(rs.getString("repair_StartT"));
				a.setRepair_EndT(rs.getString("repair_EndT"));
				a.setOrder_ID(rs.getInt("order_ID"));
				a.setP_ID(rs.getInt("p_ID"));
				a.setRepair_State(rs.getString("repair_State"));
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
	public Repair QueryRepairByID(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from RepairTable where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Repair a=new Repair();
		try {
			while(rs.next()){				
				a.setRepair_ISY(rs.getInt("repair_ISY"));
				a.setRepair_StartT(rs.getString("repair_StartT"));
				a.setRepair_EndT(rs.getString("repair_EndT"));
				a.setOrder_ID(rs.getInt("order_ID"));
				a.setP_ID(rs.getInt("p_ID"));
				a.setRepair_State(rs.getString("repair_State"));
				a.setRepair_ID(id);
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
	public void InsertRepair(Repair r) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into RepairTable values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(r.getRepair_ID());
		params.add(r.getRepair_ISY());
		params.add(r.getRepair_StartT());
		params.add(r.getRepair_EndT());
		params.add(r.getOrder_ID());
		params.add(r.getP_ID());
		params.add(r.getRepair_State());
		util.update(sql, params);
		util.close();
	}
	@Override
	public void DeleteRepair(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from RepairTable where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}
	@Override
	public void UpdateRepair(Repair r) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update RepairTable set Repair_ISY=?,Repair_StartT=?,Repair_EndT=?,Order_ID=?,P_Id=?,Repair_State=? where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		
		params.add(r.getRepair_ISY());
		params.add(r.getRepair_StartT());
		params.add(r.getRepair_EndT());
		params.add(r.getOrder_ID());
		params.add(r.getP_ID());
		params.add(r.getRepair_State());
		params.add(r.getRepair_ID());
		util.update(sql, params);
		util.close();
	}
}
