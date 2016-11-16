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
		sql="select * from RepairTable";
		rs=util.query(sql, null);
		List<Repair> list=new ArrayList<Repair>();
		try {
			while(rs.next()){
				Repair a=new Repair();
				a.setRepair_ID(rs.getString("Repair_ID"));
				a.setRepair_ISY(rs.getInt("Repair_ISY"));
				a.setRepair_StartT(rs.getTimestamp("Repair_StartT"));
				a.setRepair_EndT(rs.getTimestamp("Repair_EndT"));
				a.setOrder_ID(rs.getString("Order_ID"));
				a.setP_ID(rs.getString("P_ID"));
				a.setRepair_State(rs.getString("Repair_State"));
				a.setRepair_Odertime(rs.getTimestamp("Repair_Odertime"));
				a.setRepair_SN(rs.getString("repair_SN"));
				a.setRepair_Adress(rs.getString("repair_Adress"));
				a.setRepair_Des(rs.getString("repair_Des"));
				a.setRepair_Tel(rs.getString("repair_Tel"));
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
	public Repair QueryRepairByID(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from RepairTable where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Repair a=new Repair();
		try {
			while(rs.next()){	
				a.setRepair_ID(id);
				a.setRepair_ISY(rs.getInt("repair_ISY"));
				a.setRepair_StartT(rs.getTimestamp("repair_StartT"));
				a.setRepair_EndT(rs.getTimestamp("repair_EndT"));
				a.setOrder_ID(rs.getString("order_ID"));
				a.setP_ID(rs.getString("p_ID"));
				a.setRepair_State(rs.getString("repair_State"));
				a.setRepair_Odertime(rs.getTimestamp("Repair_Odertime"));
				a.setRepair_SN(rs.getString("repair_SN"));
				a.setRepair_Adress(rs.getString("repair_Adress"));
				a.setRepair_Des(rs.getString("repair_Des"));
				a.setRepair_Tel(rs.getString("repair_Tel"));
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
		sql="insert into RepairTable values(?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(r.getRepair_ID());
		params.add(r.getRepair_ISY());
		params.add(r.getRepair_StartT());
		params.add(r.getRepair_EndT());
		params.add(r.getOrder_ID());
		params.add(r.getP_ID());
		params.add(r.getRepair_State());
		params.add(r.getRepair_Odertime());
		params.add(r.getRepair_Tel());
		params.add(r.getRepair_Adress());
		params.add(r.getRepair_SN());
		params.add(r.getRepair_Des());
		util.update(sql, params);
		util.close();
	}
	@Override
	public void DeleteRepair(String id) {
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
		sql="update RepairTable set Repair_ISY=?,Repair_StartT=?,Repair_EndT=?,Order_ID=?,P_Id=?,Repair_State=?,Repair_Odertime=?,Repair_Tel=?,Repair_Adress=?,Repair_SN=?,Repair_Des where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		
		params.add(r.getRepair_ISY());
		params.add(r.getRepair_StartT());
		params.add(r.getRepair_EndT());
		params.add(r.getOrder_ID());
		params.add(r.getP_ID());
		params.add(r.getRepair_State());
		params.add(r.getRepair_Odertime());
		params.add(r.getRepair_Tel());
		params.add(r.getRepair_Adress());
		params.add(r.getRepair_SN());
		params.add(r.getRepair_Des());
		
		params.add(r.getRepair_ID());
		util.update(sql, params);
		util.close();
	}
}
