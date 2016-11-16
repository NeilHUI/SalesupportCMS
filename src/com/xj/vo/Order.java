package com.xj.vo;

import java.sql.Date;

public class Order {
	private String Order_ID;
	private String Order_Name;
	private String Order_Describe;
	private Date Order_Time;
	private String User_ID;
	
	public String getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}
	public String getOrder_Name() {
		return Order_Name;
	}
	public void setOrder_Name(String order_Name) {
		Order_Name = order_Name;
	}
	public String getOrder_Describe() {
		return Order_Describe;
	}
	public void setOrder_Describe(String order_Describe) {
		Order_Describe = order_Describe;
	}
	public Date getOrder_Time() {
		return Order_Time;
	}
	public void setOrder_Time(Date order_Time) {
		Order_Time = order_Time;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	
	
	
}
