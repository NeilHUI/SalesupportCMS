package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IOrderDao;
import com.xj.util.DBUtil;
import com.xj.vo.Order;

public class OrderDao implements IOrderDao{

	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	
	@Override
	public List<Order> QueryAllOrder() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from OrderTable";
		rs=util.query(sql, null);
		List<Order> list=new ArrayList<Order>();
		try {
			while(rs.next()){
				Order a=new Order();
				a.setOrder_ID(rs.getString("Order_ID"));
				a.setOrder_Name(rs.getString("Order_Name"));
				a.setOrder_Describe(rs.getString("order_Describe"));
				a.setOrder_Time(rs.getDate("order_Time"));
				a.setUser_ID(rs.getString("User_ID"));
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
	public Order QueryOrderByID(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from OrderTable where Order_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Order a=new Order();
		try {
			while(rs.next()){				
				a.setOrder_Name(rs.getString("Order_Name"));
				a.setOrder_Describe(rs.getString("order_Describe"));
				a.setOrder_Time(rs.getDate("order_Time"));
				a.setUser_ID(rs.getString("user_ID"));
				a.setOrder_ID(id);
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
	public void InsertOrder(Order o) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into OrderTable values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(o.getOrder_ID());
		params.add(o.getOrder_Name());
		params.add(o.getOrder_Describe());
		params.add(o.getOrder_Time());
		params.add(o.getUser_ID());
		util.update(sql, params);
		util.close();
	}

	@Override
	public void DeleteOrder(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from OrderTable where Order_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	@Override
	public void UpdateOrder(Order o) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update OrderTable set Order_Name=?,Order_Describe=?,Order_Time=?,User_ID=? where Order_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(o.getOrder_Name());
		params.add(o.getOrder_Describe());
		params.add(o.getOrder_Time());
		params.add(o.getUser_ID());
		params.add(o.getOrder_ID());
		util.update(sql, params);
		util.close();
	}

}
