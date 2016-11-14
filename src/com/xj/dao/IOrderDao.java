package com.xj.dao;

import java.util.List;

import com.xj.vo.Order;

public interface IOrderDao {
	public List<Order> QueryAllOrder();

	public Order QueryOrderByID(int id);

	public void InsertOrder(Order A);

	public void DeleteOrder(int id);

	public void UpdateOrder(Order A);
}
