package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.OrderDao;
import com.xj.vo.Order;

public class OrderService {

private OrderDao Odao=new OrderDao();
	
	public List<Order> QueryAllOrder(){
		return Odao.QueryAllOrder();
	}
	
	public Order QueryOrder(String id){
		return Odao.QueryOrderByID(id);
	}
	
	public void InsertOrder(Order a){
		Odao.InsertOrder(a);
	}
	
	public void DeleteOrder(String id){
		Odao.DeleteOrder(id);
	}
	
	public void UpdateOrder(Order a){
		Odao.UpdateOrder(a);
	}
}
